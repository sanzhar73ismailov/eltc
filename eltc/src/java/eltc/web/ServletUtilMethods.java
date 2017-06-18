package eltc.web;

import domain.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import eltc.util.Configurator;
import eltc.util.DbConnection;
import eltc.web.createBeans.AbstractCreateBean;
import eltc.web.pageNavig.EntityEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class ServletUtilMethods {

    public static void getTrnslationOfColumns(String table) {
        try {
            Connection con = DbConnection.getConnection("information_schema");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select COLUMN_NAME, COLUMN_COMMENT FROM COLUMNS where TABLE_SCHEMA='eltc' "
                    + "AND TABLE_NAME='" + table + "' ORDER BY ORDINAL_POSITION");

            while (rs.next()) {
                String key = rs.getString(1);
                String value = rs.getString(2);
                if (key.equals("id")
                        || key.equals("name")
                        || key.equals("user")
                        || key.equals("insert_datetime")) {
                    continue;
                }

                String[] parts = key.split("_");
                String newKey = getJavaNamesFromSQLNames(key);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServletUtilMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getJavaNamesFromSQLNames(String oldValue) {
        if (!oldValue.contains("_")) {
            return oldValue;
        }
        StringBuffer strBuffer = new StringBuffer();
        String[] parts = oldValue.split("_");
        for (int i = 0; i < parts.length; i++) {
            if (i == 0) {
                strBuffer.append(parts[i]);
            } else {
                strBuffer.append(getNameWithBigFirstLetter(parts[i]));
            }
        }
        return strBuffer.toString();
    }

    public static ResourceBundle getBundleOfProject() {
        return ResourceBundle.getBundle(Configurator.RESOURSE_MESS);
    }

    public static String getTranString(String key) {
        String value = getBundleOfProject().getString(key);
        if (value == null) {
            value = key + " not translated";
            throw new NullPointerException("Нет такого значения в " + Configurator.RESOURSE_MESS);
        }
        return value;
    }

    public static String getTranString(EntityEnum entEnum) {
        return getTranString(entEnum.toString().toLowerCase());
    }

    public static boolean isEmptyOneOfField(String... args) {
        for (String value : args) {
            if (value == null || value.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static DateFormat getSimpleDateFormat() {
        return new SimpleDateFormat("dd/MM/yyyy");
    }

    public static Date getDateFromString(String dateInString) {
        dateInString = dateInString.trim();
        Date date = null;
        if (dateInString.length() == 8) {
            dateInString = String.format(
                    "%s.%s.%s",
                    dateInString.substring(0, 2),
                    dateInString.substring(2, 4),
                    dateInString.substring(4));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        dateInString = dateInString.replace('.', '/').replace(';', '/').replace(',', '.').replace('-', '/');
        //System.out.println("dateInString=" + dateInString);
        try {
            date = sdf.parse(dateInString);
        } catch (ParseException ex) {
            return null;
        }

        return date;
    }

    public static String getStringFromDate(Date date) throws ParseException {
        return getSimpleDateFormat().format(date);
    }
    
    
    public static String getStringFromDateNoSeparation(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        return sdf.format(date);
    }

    public static void main(String[] args) throws ParseException {
        //System.out.println("getCount()=" + getCount());
        // printSQLAlterAddDeletedColumn();
        System.out.println("escapeXml()=" + escapeXml(null));
//        int num = 0;
//        while (num++ < 100) {
//            System.out.println("count,, = " + getCount());
//
//        }
//        Student st = createStudent();
//        System.out.println("st = " + st);

//        System.out.println(Locale.getDefault());
//        String d = "15122001";
//        Date myDate = getDateFromString(d);
//        System.out.println("myDate = " + myDate);
        //System.out.println(getSimpleDateFormat().format(new Date()));
    }

    public static String getNameWithBigFirstLetter(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        value = value.trim();
        String toReturn = (value.substring(0, 1).toUpperCase() + value.substring(1, value.length()).toLowerCase());
        return toReturn;

    }

    public void printAllHeaders(HttpServletRequest request) {
        System.out.println("\r\n <<<<<<<<<< Headers:");
        Enumeration<String> en1 = request.getHeaderNames();
        while (en1.hasMoreElements()) {
            String el = en1.nextElement();
            System.out.println(el + ": " + request.getHeader(el));
        }
        System.out.println(">>>>>>>>>>>>>>>>\r\n");
        System.out.println("\r\n");
    }

    public static long getCount() {
        return getCount("C:\\temp\\NetBeansProjects\\eltc_s\\eltc\\util\\count.txt");
    }

    public static long getCount(String strFileName) {
        long toReturn = 0;
        //String strFileName = "C:\\temp\\NetBeansProjects\\eltc_s\\eltc\\util\\count.txt";
        //String strFileName = "..\\..\resources\\count.txt";
        File file = new File(strFileName);
        // System.out.println("************\nfile="+file.getAbsoluteFile());
        // System.out.println("" + file.exists());
        FileReader fr = null;
        BufferedReader bufReader = null;
        FileWriter fw = null;
        // BufferedWriter bufWr = null;
        long count = 0;
        try {
            fr = new FileReader(file);
            bufReader = new BufferedReader(fr);
            String line = bufReader.readLine();
            count = Long.parseLong(line);
            toReturn = count;
            count++;


            fw = new FileWriter(file);
            fw.write(count + "");
            fw.flush();


        } catch (IOException ex) {
            Logger.getLogger(ServletUtilMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ServletUtilMethods.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServletUtilMethods.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (bufReader != null) {
                    bufReader.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(ServletUtilMethods.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return toReturn;
    }

//    public static Student createStudent() {
//        throw new UnsupportedOperationException();
//    }
//
//    public static Manager createManager() {
//        throw new UnsupportedOperationException();
//    }
//
//    public static Object createTrainer() {
//        throw new UnsupportedOperationException();
//    }
    public static String getHash(String str) {
        MessageDigest md5;
        StringBuffer hexString = new StringBuffer();

        try {
            md5 = MessageDigest.getInstance("md5");
            md5.reset();
            md5.update(str.getBytes());
            byte messageDigest[] = md5.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                // hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
                hexString.append(Integer.toString((messageDigest[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            return e.toString();
        }
        return hexString.toString();
    }
@Deprecated
    public static Object createRegistration() {
        Registration bean = new Registration();
        String ext = "_" + getCount();


        bean.setName("Имя" + ext);
        bean.setLogin("логин" + ext);

        bean.setPassword1("pass" + ext);
        bean.setPassword2("pass" + ext);
        bean.setPasswordGeneral(Configurator.PASS_GENERAL);
        bean.setEmail1("email" + ext + "@dd.com");
        bean.setEmail2("email" + ext + "@dd.com");
        return bean;
    }

    public static Date getRandomDate() {
        String day = ((int) (Math.random() * 28) + 1) + "";
        String month = ((int) (Math.random() * 12) + 1) + "";
        String year = ((int) (Math.random() * 40) + 1950) + "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");

        Date date = ServletUtilMethods.getDateFromString(
                (day.length() == 1 ? ("0" + day) : day)
                + "-" + (month.length() == 1 ? ("0" + month) : month)
                + "-" + year);
        return date;
    }

    public static String getCurrentUserLogin(HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute(Configurator.USER_SESSION);
        if (user == null) {
            return "test_user";
        }
        return user.getLogin();
    }

    public static int getRandomMaxLimit(int upLimit) {
        return ((int) (Math.random() * upLimit) + 1);
    }

    public static void printSQLAlterAddDeletedColumn() {
        String[][] vals = {
            {"student", "microsoft_login"},
            {"contract", "pdf_file"},
            {"course", "additional_info"},
            {"course_official", "course_id"},
            {"course_official_price", "currency_id"},
            {"hr_manager", "photo_file"},
            {"manager", "is_actual"},
            {"organization", "account_euro"},
            {"timetable", "auditory_id"},
            {"timetable_student", "price_fact"},
            {"trainer", "photo_file"}
        };

        for (String[] strings : vals) {
            String tableName = strings[0];
            String afterColumn = strings[1];

//            System.out.printf("alter table %1$s add deleted tinyint(1) after %2$s;\n"
//                    + "update %1$s set deleted=0;\n"
//                    + "alter table %1$s modify deleted tinyint(1) unsigned not null;\n"
//                    + "commit;\n\n"
//                    , tableName, afterColumn);

            System.out.printf(
                    "alter table %1$s modify deleted tinyint(1) unsigned not null default 0;\n"
                    + "commit;\n\n", tableName);


        }

    }

    public static <T> List<T> getSortedListFromSet(Set<T> unsortedSet, Comparator comparator) {
        List<T> list = new ArrayList(unsortedSet);
        Collections.sort(list, comparator);
        return list;
    }

    public static String escapeXml(String value) {
        return org.apache.commons.lang3.StringEscapeUtils.escapeXml(value);
    }

    public static String escapeHtml(String value) {
        return org.apache.commons.lang3.StringEscapeUtils.escapeHtml4(value);
    }

    public static <T> List getListfromSet(Set<T> set) {
        List<T> list = new ArrayList<T>();
        for (T el : set) {
            list.add(el);
        }
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        return list;
    }
    
     public static String getFilenameExtension(String fileName) {
        int pointPosition = fileName.lastIndexOf('.');
        if (pointPosition < 0) {
            return "";
        }
        return fileName.substring(pointPosition);
    }
}
