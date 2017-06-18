package eltc.model;

import domain.Configuration;
import domain.Country;
import domain.Organization;
import domain.Student;
import domain.User;
import java.util.List;

public interface Model {

    <T> void addObject(T obj) throws EltcException;

    <T> void removeObjectFromSession(T obj) throws EltcException;

    <T> T getObject(int id, Class cl) throws EltcException;

    Configuration getConfiguration(String key) throws EltcException;

    void turnOnTestMode() throws EltcException;

    void turnOffTestMode() throws EltcException;

    <T> List<T> getObjectsSafelyDeleted(Object obj) throws EltcException;

    <T> List<T> getObjectsSafelyDeletedFromTo(int start, int limit, Object obj) throws EltcException;
    
     <T> List<T> getObjectsSafelyDeletedFromTo(int start, int limit, Object obj, String orderBy) throws EltcException;

    <T>List<T> findObjects(int start, int limit, T findObject) throws EltcException;

    <T> int getSizeFindObjects(T findObject) throws EltcException;

    <T> void modifyObject(T obj) throws EltcException;

    <T> void removeObject(T obj) throws EltcException;

    int getObjectsSize(Class cl) throws EltcException;

    public int getObjectsSizeSafelyDeleted(Object obj) throws EltcException;

    User getUserByLogin(String login) throws EltcException;
}
