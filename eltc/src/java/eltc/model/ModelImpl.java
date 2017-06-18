package eltc.model;

import domain.City;
import domain.Configuration;
import domain.Country;
import domain.Organization;
import domain.User;
import eltc.util.HibernateUtil;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import eltc.logger.ErroLogging;
import eltc.util.Configurator;
import eltc.web.DeletableInterface;
import eltc.web.ServletUtilMethods;
import java.util.ArrayList;
import java.util.logging.Level;
import org.hibernate.Hibernate;
//import org.hibernate.event.def.DefaultFlushEntityEventListener;
import org.hibernate.exception.JDBCConnectionException;

public class ModelImpl implements Model {

    Session session;
    public static final int ALL_ROWS_NEEDED = -100;
    private static ModelImpl instance;
    public static final Logger LOGGER = Logger.getLogger(ModelImpl.class.getName());

    private ModelImpl() {
       // this.session = HibernateUtil.getSessionFactory().openSession();
    }

    private void openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
       
        //session = HibernateUtil.getSessionFactory().getCurrentSession();
        
       ///session = sessions.openSession();
        // System.out.println("session = " +session);
//        if (ses.isOpen() && ses.isConnected()) {
//            return ses;
//        } else {
//            ses = HibernateUtil.getSessionFactory().openSession();
//            return ses;
//        }

    }

    private void closeSession() {
        
       /* // сессию решил не закрывать, а то выбрасыватеся исключение com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException:
        No operations allowed after connection closed.
        if (session != null) {
            session.flush();
            session.close();
       }
               */
    }

    public static ModelImpl getInstance() {
        if (instance == null) {
            instance = new ModelImpl();
        }
        //return instance;
        return new ModelImpl();
    }

    @Override
    public <T> T getObject(int id, Class cl) throws EltcException {
        return getObject(String.valueOf(id), cl);
    }

    public <T> T getObject(String id, Class cl) throws EltcException {
        String className = cl.getSimpleName();
        int idAsInt = 0;
        boolean idNumber = false;
        try {
            idAsInt = Integer.parseInt(id);
            idNumber = true;
        } catch (NumberFormatException e) {
        }
        T obj = null;
        try {
            openSession();
            Transaction tx = session.beginTransaction();
            //DefaultFlushEntityEventListener dd = new DefaultFlushEntityEventListener();
            Query q = session.createQuery("from " + className + " as c where c.id = '" + id + "'");
            // q.setInteger("id", id);
            //obj = (T) q.uniqueResult();
            if (idNumber) {
                obj = (T) session.get(cl, idAsInt);
            } else {
                obj = (T) session.get(cl, id);
            }
            tx.commit();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Problem to get object " + cl.getSimpleName() + " from DB", e);
            // session.close();
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
        return obj;
    }

    public <T> void addObject(T bean) throws EltcException {
        Transaction tx = null;
        try {
            openSession();
            tx = session.beginTransaction();
            session.save(bean);
            tx.commit();


        } catch (ConstraintViolationException ex) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println("<<<<<<< 111\n"
                    + ex.getMessage() + "VVV"
                    + ex.getSQLException().getMessage()
                    + "\n111>>>>>>>>>");
            String sqlExceptionMessage = ex.getSQLException().getMessage();
            if (sqlExceptionMessage.startsWith("Duplicate entry")) {
                sqlExceptionMessage = createDublicateRussianMessage(sqlExceptionMessage);
            }

            LOGGER.log(Level.SEVERE, "Object " + bean.getClass().getSimpleName()
                    + " did not add from corruption integrity", ex);
            throw new EltcException("Объект не добавлен из-за нарушения "
                    + "цестности данных (дублирование уникального(ных) поля(полей), причина: <br>"
                    + sqlExceptionMessage);

        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Object " + bean.getClass().getSimpleName()
                    + " did not add from HibernateException", ex);
            throw new EltcException(ex.getMessage(), ex);
        } finally {
            closeSession();
        }
    }

    public <T> void modifyObject(T obj) throws EltcException {
        Transaction tx = null;
        if (obj == null) {
            LOGGER.log(Level.SEVERE, "Object " + obj.getClass().getSimpleName()
                    + " is not initiazied");
            throw new EltcException("Объект на инициализирован");
        }

        try {
            openSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Object " + obj.getClass().getSimpleName()
                    + " is not modofied", e);
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
    }

    public <T> void removeObject(T obj) throws EltcException {
        Transaction tx = null;
        if (obj == null) {
            throw new EltcException("Объект на инициализирован");
        }
        try {
            openSession();
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Object " + obj.getClass().getSimpleName()
                    + " is not removed", e);
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
    }

    public <T> void removeObjectFromSession(T obj) throws EltcException {
        try {
            openSession();
            session.evict(obj);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Object " + obj.getClass().getSimpleName()
                    + " is not removed from session", e);
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
    }

    public User getUserByLogin(String login) throws EltcException {
        User obj = null;
        Transaction tx = null;
        try {
            openSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("from User as c where c.login = '" + login + "'");
            obj = (User) q.uniqueResult();
            tx.commit();

        } catch (JDBCConnectionException e) {
            throw new EltcException("Нет соединения с базой данных");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "User with " + login
                    + " is not get from DB", e);
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
        return obj;
    }

    // GET OBJECTS METHODS
    public <T> List<T> getObjectsSafelyDeleted(Object obj) throws EltcException {
        return getObjectsSafelyDeletedFromTo(ALL_ROWS_NEEDED, 0, obj);
    }

    public <T> List<T> getObjectsSafelyDeletedFromTo(int start, int limit, Object obj) throws EltcException {
        return getObjectsSafelyDeletedFromTo( start,  limit,  obj,  null);
    }
    
     public <T> List<T> getObjectsSafelyDeletedFromTo(int start, int limit, Object obj, String orderBy) throws EltcException {
        List<T> beans;
        if (obj instanceof DeletableInterface) {
            beans = getNotDeletedObjectsFromTo(start, limit, obj.getClass(), orderBy);
        } else {
            beans = getObjectsFromTo(start, limit, obj.getClass(), orderBy);
        }
        return beans;
    }

    private <T> List<T> getObjectsFromTo(int start, int limit, Class cl, String orderBy) throws EltcException {
        orderBy = (orderBy == null || orderBy.trim().isEmpty()) ? "order by id" : orderBy;
        String query = "from " + cl.getSimpleName() + " " + orderBy;
        return getObjectsFromToGeneral(start, limit, cl, query);
    }

    private <T> List<T> getNotDeletedObjectsFromTo(int start, int limit, Class cl, String orderBy) throws EltcException {
        orderBy = (orderBy == null || orderBy.trim().isEmpty()) ? "order by id" : orderBy;
        String query = "from " + cl.getSimpleName() + " as c where c.deleted = '" + 0 + "'" + " " + orderBy;
        return getObjectsFromToGeneral(start, limit, cl, query);
    }

    private <T> List<T> getObjectsFromToGeneral(int start, int limit, Class cl, String query) throws EltcException {
        List<T> cList = null;
        Transaction tx = null;
        try {
            openSession();
            //session = HibernateUtil.getSessionFactory().getCurrentSession();
            int startReal = start - 1; // because we want to have records from 1 to 20 (include 1), HQL
            // wants to see 0 to 20 (0 not included)
            //session = getSession();
            tx = session.beginTransaction();
            Query q = session.createQuery(query);
            if (start != ALL_ROWS_NEEDED) {
                q.setFirstResult(startReal);
                q.setMaxResults(limit);
            }
            cList = (List<T>) q.list();
            if (cList.size() > 0) {
                Object instance = cList.get(0);
                if (instance instanceof Organization) {
                    List<Organization> listDic = (List<Organization>) cList;
                    for (Organization dicBean : listDic) {
                        Hibernate.initialize(dicBean.getTypeOwnership());
                    }
                } else if (instance instanceof City) {
                    List<City> listDic = (List<City>) cList;
                    for (City dicBean : listDic) {
                        Hibernate.initialize(dicBean.getCountry());
                    }
                }

            }
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Objects (not deleted) " + cl.getSimpleName()
                    + " is not get from DB", e);
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
        return cList;
    }

    //END GET OBJECTS METHODS
    @Override
    public int getObjectsSize(Class cl) throws EltcException {
        String query = "select count(*) from " + cl.getSimpleName();
        int count = 0;
        try {
            openSession();
            Transaction tx = session.beginTransaction();
            count = ((Long) session.createQuery(query).uniqueResult()).intValue();

        } finally {
            closeSession();
        }
        return count;
    }

    @Override
    public int getObjectsSizeSafelyDeleted(Object obj) throws EltcException {
        int count = 0;
        Transaction tx = null;
        if (obj instanceof DeletableInterface) {
            String query = "select count(*) from " + obj.getClass().getSimpleName() + " where deleted='0'";
            try {
                openSession();
                tx = session.beginTransaction();
                count = ((Long) session.createQuery(query).uniqueResult()).intValue();
                tx.commit();
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw new EltcException(e.getMessage());
            } finally {
                closeSession();
            }
            return count;
        } else {
            return getObjectsSize(obj.getClass());
        }
    }

    @Override
    public <T> List<T> findObjects(int start, int limit, T findObject) throws EltcException {
        String query = FindObjectsFabrica.createFindQueryObject(findObject).createFindQuery();
        return getObjectsFromToGeneral(start, limit, findObject.getClass(), query);
    }

    public static String createDublicateRussianMessage(String sqlExceptionMessage) {
        String keyName;
        String keyNameFromBundle;
        sqlExceptionMessage = sqlExceptionMessage.replace("Duplicate entry", "Дублирование значения");
        sqlExceptionMessage = sqlExceptionMessage.replace("for key", "для поля");
        int positionOfPredposledKavichka = sqlExceptionMessage.lastIndexOf("'", sqlExceptionMessage.length() - 2);
        int positionOfLastKavichka = sqlExceptionMessage.lastIndexOf("'", sqlExceptionMessage.length());
        keyName = sqlExceptionMessage.substring(positionOfPredposledKavichka + 1, positionOfLastKavichka);
        keyNameFromBundle = ServletUtilMethods.getJavaNamesFromSQLNames(keyName);
        sqlExceptionMessage = sqlExceptionMessage.replace(keyName, ServletUtilMethods.getTranString(keyNameFromBundle));
        return sqlExceptionMessage;
    }

    public Configuration getConfiguration(String key) throws EltcException {
        return getObject(key, Configuration.class);
    }

    public void turnOnTestMode() throws EltcException {
        Configurator.turnOnTestMode();
    }

    public void turnOffTestMode() throws EltcException {
        Configurator.turnOffTestMode();
    }

    @Override
    public <T> int getSizeFindObjects(T findObject) throws EltcException {
        Transaction tx = null;
        List<Long> list = new ArrayList<Long>();
        int count = 0;

        String query = FindObjectsFabrica.createFindQueryObject(findObject).createFindQuery();

        try {
            openSession();
            tx = session.beginTransaction();
            list = session.createQuery(query).list();
            for (int i = 0; i < list.size(); i++) {
                count++;
            }
            //count = (Long) list.get(0);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new EltcException(e.getMessage());
        } finally {
            closeSession();
        }
        return count;
    }
}
