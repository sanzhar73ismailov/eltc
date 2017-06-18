package eltc.model;

import domain.Email;
import domain.Student;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Test {
    public static void main(String[] args) {
          StringBuffer value = new StringBuffer("123456");
          System.out.println("value = " + value.length());
          value.delete(0, 6);
          System.out.println("value = " + value.length());
          
          
    }
    public static void main444(String[] args) throws EltcException, ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException {

        Model model = ModelImpl.getInstance();
        Student st =model.getObject(1484000, Student.class);
        System.out.println("st = " + st.getId() + ", " +st.getLastNameEn());
        //Set emails = st.getEmails();
        Set emails = new HashSet();
        System.out.println("emails = " + emails);
        for(Object email : emails){
            System.out.println("email = " + ((Email)email).getEmail());
        }
//        for (int i = 0; i < 10; i++) {
//            Sex st = model.getObject(0, Sex.class);
//            System.out.println("st = " + st);
//            Thread.sleep(1000);
//        }
        //        System.out.println(ServletUtilMethods.getJavaNamesFromSQLNames("user12345_6"));
        // System.out.println(org.hibernate.Hibernate.);

//        String[] arr = "dadasdsad".split("_");
//        System.out.println("" + arr.length);


    }

    static void unicode() {
        String st = "&#239;&#238;&#235";


        // System.out.println("" + new String);
        char c = '\u043f';
        System.out.println("=" + c);
        System.out.println("=" + '\u00ef');
        System.out.println("=" + ((int) 'п'));
    }

    static void readBookStore() {
        try {
            File xmlFile = new File("bookstore.xml");
            System.out.println("" + xmlFile.exists());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            System.out.println("Root name: " + doc.getDocumentElement().getNodeValue());
            Element el = doc.getDocumentElement();
            NodeList nodeList = el.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node elCh = nodeList.item(i);
                if (elCh.getNodeType() == Element.ELEMENT_NODE) {
                    System.out.println(i + ". elCh = " + elCh.getNodeName());
                    NodeList nodeListCh = elCh.getChildNodes();
                    for (int j = 0; j < nodeListCh.getLength(); j++) {
                        elCh = nodeListCh.item(j);
                        if (elCh.getNodeType() == Element.ELEMENT_NODE) {
                            System.out.println(j + "     .      elCh = " + elCh.getNodeName());
                        }
                    }
                    //System.out.println(i + ". elCh = " + elCh.getNodeType());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void readXml() {
        try {

            File fXmlFile = new File("newXMLDocument.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("staff");


            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
