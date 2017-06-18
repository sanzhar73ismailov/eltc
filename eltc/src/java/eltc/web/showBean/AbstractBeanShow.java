package eltc.web.showBean;

import eltc.model.Model;
import eltc.model.ModelImpl;
import eltc.web.*;
import eltc.web.showBean.stringObjects.AbstractObject;
import java.util.*;

public abstract class AbstractBeanShow {

    protected Map<String, Object> map = new LinkedHashMap<String, Object>();
    protected ResourceBundle rb = ResourceBundle.getBundle("resources.messages");
    protected Object entity;

    protected AbstractBeanShow() {
        this(null);

    }

    public AbstractBeanShow(Object entity) {
        this.entity = entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public abstract String getAsWebString();

    protected String fromMapToWebString(Map<String, Object> map) {
        Set<Map.Entry<String, Object>> setEntries = map.entrySet();
        StringBuilder strBuilder = new StringBuilder();
        String trTdPattern = "<tr><td>%s: </td><td>%s</td></tr>";
        strBuilder.append("<table border='1'>");
        for (Map.Entry<String, Object> entry : setEntries) {
            strBuilder.append(String.format(trTdPattern, entry.getKey(), entry.getValue()));
        }
        strBuilder.append("</table>");
        return strBuilder.toString();
    }

    protected String getAsString(Object obj) {
        AbstractObject abstractObject = FactoryEntityAsString.createObjectAsString(obj);
        return abstractObject.getStringFromObject(obj);
    }

    protected <T> List<T> getSortedListFromSet(Set<T> unsortedSet, Comparator comparator) {
        return ServletUtilMethods.getSortedListFromSet(unsortedSet, comparator);
    }

    protected String getAsEditHref(int id, Object obj) {
        return getAsHref(id, obj, "edit", rb.getString("edit"));
    }

    protected String getAsViewHref(int id, Object obj) {
        return getAsHref(id, obj, "view", rb.getString("view"));
    }

    protected String getAsDownloadHref(int id, Object obj, String typeOfFile) {
        return getAsHref(id, obj, "download", rb.getString("download"), "type=" + typeOfFile);
    }

    private String getAsHref(int id, Object obj, String action, String label) {
        return getAsHref(id, obj, action, label, "");
    }

    private String getAsHref(int id, Object obj, String action, String label, String params) {
        String objName = obj.getClass().getSimpleName().toLowerCase();
        if(objName.equals("hrmanager")){
            objName = "hr_manager";
        }else if(objName.equals("vendoragreement")){
            objName = "vendor_agreement";
        }
        String str = String.format("<a href=%s?entity=%s&id=%d&%s>%s</a>", action, objName, id, params, label);
        return str;
    }
}
