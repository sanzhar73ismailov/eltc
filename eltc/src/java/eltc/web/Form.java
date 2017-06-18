/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import eltc.model.EltcException;
import domain.*;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author user
 */
public class Form {

    public static Form createNewForm() {
        Form me = null;
        //me =  new Form("Student");
        // me = new Form("Manager");
        // me = new Form("City");
        //me = new Form("Contract");
        //me = new Form("CourseOfficial");
        //   me = new Form("CourseOfficialPrice");
        //  me = new Form("CourseSpecialization");
        //    me = new Form("HrManager");
       // me = new Form("Organization");
        //me = new Form("OrganizationHrManager");
         //me = new Form("Timetable");
        //me = new Form("TimetableStudent");
        // me = new Form("TrainerCertificate");
       // me = new Form("TrainerPassedCourse");
//        me = new Form("TrainerSpecialization");
        //me = new Form("TypeOwnership");
         me = new Form("VendorAgreement");
        //me = new Form("Auditory");
        return me;
    }

    public static void main(String[] args) {
        System.setProperty("http.proxyHost", "rt.elsi.kz");
        System.setProperty("http.proxyPort", "8080");


        Form me = createNewForm();
        //   me.printList();
        System.out.println(me.form);
        //     me.printForWebString();
        //System.out.println(me.getScriptRequeiredHiddens());

        // me.printSetMethodsForJSP();
        //  me.printSetMethodsForTEST();

//        for (ColumnProperty col : me.listInputs) {
//            System.out.println(col.getName()+"=");
//        }
    }
    final String PATTERN_HiddienEntity = "<input type='hidden' name='entity' value='${param.entity}'>\n";
    final String PATTERN_HiddienPageTitle = "<input type='hidden' name='pageTitle' value='${pageTitle}'>\n";
    final String PATTERN_InputText = "<tr><td>"
            + "<label for='%5$s'>%1$s</label>"
            + "</td>%n<td>"
            + "<input%2$s%3$s%4$s id='%5$s' type='text' name='%5$s'%6$s size='%7$d' value='%8$s'/>"
            + "%n<div class='errorMessage'>${messageMap.%5$s}</div>"
            + "</td></tr>%n";
    final String PATTERN_InputSubmitButton = String.format("<tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>", SIZE_FOR_BUTTONS);
    final String PATTERN_InputResetButton = String.format("<td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>", SIZE_FOR_BUTTONS);
    final String PATTERN_FORM_START = "<form id='%1$s' method='post' name='%1$s' action='save' charset='utf-8'>%n";
    final static int SIZE_FOR_INPUT_TEXT = 40;
    final static int SIZE_FOR_BUTTONS = 150;
    private String name;
    private String tableName;
    private Class typeOfDomainClass;
    private List<ColumnProperty> listInputs = new ArrayList<ColumnProperty>();
    private String form;
    private ResourceBundle rsBundle = ResourceBundle.getBundle("resources/messages", Locale.getDefault());
    Object bean;
    HttpServlet servlet;

    public Form(String name) {
        try {
            this.name = name;
            // this.request = request;
            //this.servlet = servlet;
            createListInputs();
            createForm();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EltcException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createListInputs() {
        try {

            String fullPath = "xml_entity";
            File xmlFile = new File(String.format(fullPath + "/%s.hbm.xml", name));
            System.out.println("file exists: " + xmlFile.exists());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = null;
            doc = dBuilder.parse(xmlFile);
//            System.out.println("XmlEncoding(): " + doc.getXmlEncoding());
//            System.out.println("InputEncoding: " + doc.getInputEncoding());

            doc.getDocumentElement().normalize();
            Node classNode = doc.getElementsByTagName("class").item(0);
            this.tableName = classNode.getNodeName();
            this.typeOfDomainClass = Class.forName(((Element) classNode).getAttribute("name"));
            bean = typeOfDomainClass.newInstance();
            NodeList listOfProperty = classNode.getChildNodes();
            ColumnProperty column = null;
            for (int i = 0; i < listOfProperty.getLength(); i++) {
                if (listOfProperty.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element propElement = (Element) listOfProperty.item(i);
                    column = new ColumnProperty();

                    if (propElement.getNodeName().equals("set")) {
                        continue;
                    }
                    if (propElement.getNodeName().equals("many-to-one")) {
                        column.setIsForeignKey(true);
                        Class cl = Class.forName(propElement.getAttribute("class"));
                        column.setForeignClass(cl);
                    } else if (propElement.getNodeName().equals("id")) {
                        column.setIsPrimaryKey(true);
                    }
                    column.setName(propElement.getAttribute("name"));
                    column.setType(propElement.getAttribute("type"));
                    column.setTypeAsClass(parseTypeOfClass(column.getType()));

                    NodeList nodeListOfProperty = listOfProperty.item(i).getChildNodes();
                    for (int j = 0; j < nodeListOfProperty.getLength(); j++) {
                        if (nodeListOfProperty.item(j).getNodeType() == Node.ELEMENT_NODE) {
                            Element columnElement = (Element) nodeListOfProperty.item(j);
                            if (columnElement.getNodeName().equals("column")) {
                                column.setColumnName(columnElement.getAttribute("name"));
//                                column.setIsForeignKey(columnElement.getAttribute("not-null").equals("true") ? true : false);
                                column.setIsNotNull(columnElement.getAttribute("not-null").equals("true") ? true : false);
                                if (columnElement.hasAttribute("length")) {
                                    column.setLength(Integer.parseInt(columnElement.getAttribute("length")));
                                }else{
                                    column.setLength(255);
                                }

                                NodeList commentNodeList = columnElement.getElementsByTagName("comment");
                                if (commentNodeList.getLength() > 0) {
                                }

                            }
                        }
                    }
                    listInputs.add(column);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void printList() {
        for (ColumnProperty columnProperty : listInputs) {
            System.out.println("columnProperty = " + columnProperty);
        }
    }

    private void createForm() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, EltcException {

        String required;
        String requiredStyle;
        String maxlength;
        String readonly;
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(String.format(PATTERN_FORM_START, name, "POST"));
        strBuilder.append(PATTERN_HiddienEntity);
        strBuilder.append(PATTERN_HiddienPageTitle);

        strBuilder.append("<table>\n");
        for (ColumnProperty columnProperty : listInputs) {

            if (columnProperty.getName().equals("user") || columnProperty.getName().equals("insertDatetime")) {
                continue;
            }
            Method beanMethod = toKnowMethod(columnProperty.getName());

            required = columnProperty.isIsNotNull() ? " required='required' class='inpReq'" : "";
            requiredStyle = columnProperty.isIsNotNull() ? "" : "";
            maxlength = columnProperty.getType().equals("string") ? String.format(" maxlength='%d'", columnProperty.getLength()) : "";
            readonly = columnProperty.isIsPrimaryKey() ? " readonly='readonly'" : "";
            if (columnProperty.isIsForeignKey()) {
                Class cl = columnProperty.getForeignClass();
                if (cl.equals(domain.Sex.class)) {
                    List<Sex> arrayList = new ArrayList<Sex>();
                    Sex maleS = new Sex("муж.");
                    maleS.setId(1);
                    Sex femaleS = new Sex("жен.");
                    femaleS.setId(2);
                    arrayList.add(maleS);
                    arrayList.add(femaleS);
                    strBuilder.append(String.format("<tr><td>%1$s</td><td>Муж.<input type='radio' name='sex'/>Жен.<input type='radio' name='sex'/>%n",
                            "<fmt:message key='sex'/>"));
                } else {
                    String PATTERN_SELECT = "<tr><td><label for='%s'>%s</label></td>\n"
                            + "<td>\n"
                            + "<select %s name='%s' id='%s'>\n"
                            + "<option value=''><fmt:message key='not_selected'/></option>\n"
                            + "<c:forEach items='${%s}' var='item'>\n"
                            + "<option value='${item.id}' <c:if test='${item.id==bean.%s.id}'>selected='selected'</c:if> >${item.name}</option>\n"
                            + "</c:forEach>\n"
                            + "</select>\n"
                            + "<div class='errorMessage'>${messageMap.%s}</div>\n"
                            + "</td></tr>\n";

                    String selectStr = String.format(PATTERN_SELECT,
                            columnProperty.getName(),
                            "<fmt:message key='" + columnProperty.getName() + "'/>",
                            required,
                            columnProperty.getName(),
                            columnProperty.getName(),
                            columnProperty.getName() + "s",
                            columnProperty.getName(),
                            columnProperty.getName());



                    strBuilder.append(selectStr);
                }

                continue;
            }
            strBuilder.append(String.format(
                    PATTERN_InputText,
                    //rsBundle.getString(columnProperty.getName()),
                    "<fmt:message key='" + columnProperty.getName() + "'/>",
                    requiredStyle,
                    required,
                    maxlength,
                    columnProperty.getName(),
                    readonly,
                    SIZE_FOR_INPUT_TEXT,
                    "${bean." + columnProperty.getName() + "}"));
        }
        strBuilder.append(PATTERN_InputSubmitButton + "\n");
        strBuilder.append(PATTERN_InputResetButton + "\n");
        strBuilder.append("</table>\n");
        strBuilder.append(getScriptRequeiredHiddens());
        strBuilder.append("</form>\n");
        form = new String(strBuilder);
    }

    public Method toKnowMethod(String property) {
        Method[] met = domain.Student.class.getMethods();
        for (Method method : met) {
            if (!method.getName().startsWith("get")) {
                continue;
            }
            property = property.substring(0, 1).toUpperCase() + property.substring(1, property.length());
            if (method.getName().contains(property)) {
                return method;
            }
        }
        return null;

    }

    public void printSetMethodsForJSP() {
        System.out.println("<<<<<< printSetMethodsForJSP >>>>>>>>>>>");
        System.out.printf("%1$s bean = new %1$s();%n", name);
        for (ColumnProperty columnProperty : listInputs) {
            if (columnProperty.getName().equals("id")) {
                System.out.println("  if (!request.getParameter(\"id\").isEmpty()) {\n"
                        + "            bean.setId(Integer.valueOf(request.getParameter(\"id\")));\n"
                        + "        }");
                continue;
            } else if (columnProperty.getName().equals("user")) {
                System.out.println("bean.setUser(getCurrentUserLogin(request));");
                continue;
            } else if (columnProperty.getName().equals("insertDatetime")) {
                System.out.println("bean.setInsertDatetime(new Date());");
                continue;
            } else if (columnProperty.isIsForeignKey()) {
                System.out.println("");
                System.out.printf("%s %s = null;%n", makeFirstLetterBig(columnProperty.getName()), columnProperty.getName());
                System.out.printf("int %1$sId = Integer.valueOf(request.getParameter(\"%1$s\"));%n", columnProperty.getName());
                System.out.printf("%s = model.getObject(%s, %s.class);%n", columnProperty.getName(), columnProperty.getName() + "Id", makeFirstLetterBig(columnProperty.getName()));
                System.out.printf("bean.set%s(%s);%n", makeFirstLetterBig(columnProperty.getName()), columnProperty.getName());
                System.out.println("");
                continue;
            } else if (columnProperty.getName().startsWith("date")) {
                System.out.println("bean.set" + makeFirstLetterBig(columnProperty.getName())
                        + "(getDateFromString("
                        + String.format("request.getParameter(\"%s\"))", columnProperty.getName()) + ");");
                continue;
            }
            System.out.println("bean.set" + makeFirstLetterBig(columnProperty.getName())
                    + "(getNullifEmpty("
                    + String.format("request.getParameter(\"%s\"))", columnProperty.getName()) + ");");
        }
        System.out.println("  return bean;");
    }

    public void printSetMethodsForTEST() {
        System.out.println("");
        System.out.println("<<<<<< printSetMethodsForTEST >>>>>>>>>>>");
        System.out.printf("%1$s bean = new %1$s();%n", name);
        System.out.println("String ext = \"_\" + getCount();");
        for (ColumnProperty columnProperty : listInputs) {
            if (columnProperty.getName().equals("id")) {
                System.out.println("bean.setId(null);");
                continue;
            } else if (columnProperty.getName().equals("user")) {
                System.out.println("bean.setUser(\"test_user\");");
                continue;
            } else if (columnProperty.getName().equals("insertDatetime")) {
                System.out.println("bean.setInsertDatetime(new Date());");
                continue;
            } else if (columnProperty.isIsForeignKey()) {
                System.out.println("");
                System.out.printf("%s %s = new %1$s();%n", makeFirstLetterBig(columnProperty.getName()), columnProperty.getName());
                System.out.printf("%s.setId(%s);%n", columnProperty.getName(), "getRandomMaxLimit(3)");
                System.out.printf("bean.set%s(%s);%n", makeFirstLetterBig(columnProperty.getName()), columnProperty.getName());
                System.out.println("");
                continue;
            } else if (columnProperty.getName().startsWith("date")) {
                System.out.printf("bean.set%s(getRandomDate());%n", makeFirstLetterBig(columnProperty.getName()));
                continue;
            }

            System.out.println("bean.set" + makeFirstLetterBig(columnProperty.getName())
                    + "("
                    + String.format("\"%s\"+ext", columnProperty.getName()) + ");");
        }
        System.out.println("  return bean;");
    }

    public String getForm() {
        return form;
    }

    private String makeFirstLetterBig(String str) {
        str = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
        return str;
    }

    public String getScriptRequeiredHiddens() {
        String pattern = "<input type='hidden' name='required' value='%s'/>%n";
        StringBuilder sb = new StringBuilder();
        sb.append("<%=");
        List<ColumnProperty> listNew = new ArrayList<ColumnProperty>();
        for (ColumnProperty columnProperty : listInputs) {
            if (columnProperty.getName().equalsIgnoreCase("id")
                    || columnProperty.getName().equalsIgnoreCase("user")
                    || columnProperty.getName().equalsIgnoreCase("insertDatetime")) {
                continue;
            }
            listNew.add(columnProperty);
        }

        for (int i = 0; i < listNew.size(); i++) {
            ColumnProperty columnProperty = listNew.get(i);
            sb.append("\"");
            sb.append(columnProperty.getName());
            if (columnProperty.isIsNotNull()) {
                sb.append(":reqTrue");
            } else {
                sb.append(":reqFalse");
            }
         
            if (columnProperty.isIsForeignKey()) {
                sb.append(":typeDic");
            } else if (columnProperty.getName().toLowerCase().contains("email")) {
                sb.append(":typeEmail");
            } else if (columnProperty.getTypeAsClass() == Integer.class) {
                sb.append(":typeNumberInt");
            } else if (columnProperty.getTypeAsClass() == Double.class) {
                sb.append(":typeNumberDouble");
            } else if (columnProperty.getTypeAsClass() == Date.class) {
                sb.append(":typeDate");
            } else {
                sb.append(":typeText");
            }
            if (i < (listNew.size() - 1)) {
                sb.append("^\" + \n");
            } else {
                sb.append("\"");
            }
        }
        sb.append("%>");
        return String.format(pattern, sb.toString());
    }

    private Class parseTypeOfClass(String type) {

        if (type.equalsIgnoreCase("java.lang.Float")) {
            return Double.class;
        } else if (type.equalsIgnoreCase("java.lang.Integer")) {
            return Integer.class;
        } else if (type.equalsIgnoreCase("int")) {
            return Integer.class;
        } else if (type.equalsIgnoreCase("string")) {
            return String.class;
        } else if (type.equalsIgnoreCase("timestamp")) {
            return Date.class;
        } else if (type.equalsIgnoreCase("date")) {
            return Date.class;
        }
        return Object.class;
    }

    public void printForWebString() {
        System.out.printf("%1$s bean = (%1$s) obj;%n", name);
        for (ColumnProperty columnProperty : listInputs) {
            //map.put(rb.getString("id"), getAsString(student.getId()));
            System.out.println(String.format("map.put(rb.getString(\"%s\"), getAsString(bean.get%s()));",
                    columnProperty.getName(),
                    makeFirstLetterBig(columnProperty.getName())));
        }
    }
}
