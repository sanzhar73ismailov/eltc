/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import eltc.model.EltcException;
import eltc.util.DateValidator;
import eltc.util.EmailValidator;

/**
 *
 * @author sanzhar.ismailov
 */
public class FormChecker {

    private List<CheckedField> listOfFields = new ArrayList<CheckedField>();
    //private String textOfMessages;
    private Map<String, String> messageMap = new HashMap<String, String>();
    final String REQUIRED_YES = "reqTrue";
    final String REQUIRED_NO = "reqFalse";
    final String TYPE_NUMBER_INT = "typeNumberInt";
    final String TYPE_NUMBER_DOUBLE = "typeNumberDouble";
    final String TYPE_TEXT = "typeText";
    final String TYPE_EMAIL = "typeEmail";
    final String TYPE_DATE = "typeDate";
    final String TYPE_DICTIONARY = "typeDic";
    ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages");

    public FormChecker(String requiredFields, HttpServletRequest request) throws EltcException {
        parseStringsToFillListFields(requiredFields, request);
        fillMessages();
    }

    private void parseStringsToFillListFields(String requiredFields, HttpServletRequest request) throws EltcException {
        System.out.println("<<<<<<<" + requiredFields + ">>>>>>>>>>>>>");

        if (requiredFields == null) {
            throw new EltcException("requiredFields не передались из формы");
        }

        String[] stringArray = requiredFields.split("\\^");

        for (String string : stringArray) {
            String[] keyVal = string.split(":");

            String nameVal = keyVal[0];
            String isRequiredVal = keyVal[1];
            String typeVal = keyVal[2];

            if (!messageMap.containsKey(nameVal)) {
                messageMap.put(nameVal, null);
            } else {
                throw new EltcException("Such key already exists!");
            }

            CheckedField checkField = new CheckedField();

            checkField.setName(nameVal);
            if (isRequiredVal.equals(REQUIRED_YES)) {
                checkField.setIsRequired(true);
            } else if (isRequiredVal.equals(REQUIRED_NO)) {
                checkField.setIsRequired(false);
            } else {
                throw new EltcException("required must be reqTrue or reqFalse");
            }
            if (typeVal.equals(TYPE_TEXT)) {
                checkField.setTypeField(TypeField.TEXT);
            } else if (typeVal.equals(TYPE_NUMBER_INT)) {
                checkField.setTypeField(TypeField.INT);
            } else if (typeVal.equals(TYPE_NUMBER_DOUBLE)) {
                checkField.setTypeField(TypeField.DOUBLE);
            } else if (typeVal.equals(TYPE_DATE)) {
                checkField.setTypeField(TypeField.DATE);
            } else if (typeVal.equals(TYPE_EMAIL)) {
                checkField.setTypeField(TypeField.EMAIL);
            } else if (typeVal.equals(TYPE_DICTIONARY)) {
                checkField.setTypeField(TypeField.DICTIONARY);
            } else {
                throw new EltcException(String.format("typeField must be typeNumberInt or typeText or typeEmail or typeDate but you have %s-%s-%s ",
                        nameVal, isRequiredVal, typeVal));
            }

            if (request.getParameter(nameVal) == null || request.getParameter(nameVal).trim().isEmpty()) {
                checkField.setEmpty(true);
            } else {
                checkField.setEmpty(false);
                checkField.setValue(request.getParameter(nameVal).trim());
            }




            this.listOfFields.add(checkField);
        }
    }

    private void fillMessages() {
        //StringBuilder strBuilder = new StringBuilder();

        for (CheckedField checkedField : listOfFields) {
            String nameField = checkedField.getName();
            String messageTemp = null;

            if (checkedField.isIsRequired()) {
                if (checkedField.isEmpty()) {
                    if (checkedField.getTypeField() == TypeField.DICTIONARY) {
                        messageTemp = resourceBundle.getString("must_select_element_from_list");
                    } else {
                        messageTemp = resourceBundle.getString("this_fiels_required");
                    }
                } else {
                    messageTemp = checkFormat(checkedField, nameField);
                }
            } else if (!checkedField.isEmpty()) {
                messageTemp = checkFormat(checkedField, nameField);
            }
            putToMessageMap(nameField, messageTemp);
        }

    }

    public boolean isHasErrorMessage() {
        for (String val : messageMap.values()) {
            if (val != null) {
                return true;
            }
        }
        return false;
    }

    private void putToMessageMap(String key, String value) {
        if (messageMap.containsKey(key)) {
            if (messageMap.get(key) == null) {
                messageMap.put(key, value);
            } else {
                String oldValue = messageMap.get(key);
                messageMap.put(key, oldValue + "<br/>" + value);
            }
        } else {
            throw new IllegalArgumentException(String.format("Key -%s- must be already available", key));
        }
    }

    private String checkFormat(CheckedField checkedField, String nameField) {
        String toReturn = null;
        if (checkedField.getTypeField() == TypeField.DATE) {
            DateValidator dateValidator = new DateValidator();
            if (!dateValidator.isThisDateValid(checkedField.getValue(), "dd/MM/yyyy")
                    && !dateValidator.isThisDateValid(checkedField.getValue(), "dd.MM.yyyy")
                    && !dateValidator.isThisDateValid(checkedField.getValue(), "dd-MM-yyyy")
                    && !dateValidator.isThisDateValid(checkedField.getValue(), "dd,MM,yyyy")) {
                toReturn = resourceBundle.getString("wrong_date_format") + " "
                        + resourceBundle.getString("your_variant") +": " + checkedField.getValue();

            }
        } else if (checkedField.getTypeField() == TypeField.EMAIL) {
            EmailValidator emailValidator = new EmailValidator();
            if (!emailValidator.validate(checkedField.getValue())) {
                toReturn = resourceBundle.getString("wrong_email_format")
                        + ": " + checkedField.getValue();
            }
        } else if (checkedField.getTypeField() == TypeField.INT) {
            try {
                Integer.parseInt(checkedField.getValue());
            } catch (NumberFormatException ex) {
                toReturn = resourceBundle.getString("wrong_int_number_format")
                        + ": " + checkedField.getValue();
            }


        } else if (checkedField.getTypeField() == TypeField.DOUBLE) {
            try {
                Double.parseDouble(checkedField.getValue());
            } catch (NumberFormatException ex) {
                toReturn = resourceBundle.getString("wrong_float_number_format")
                        + ": " + checkedField.getValue();
            }
        } else if (checkedField.getTypeField() == TypeField.DICTIONARY) {
            try {
                Integer.parseInt(checkedField.getValue());
            } catch (NumberFormatException ex) {
                toReturn = resourceBundle.getString("must_select_element_from_list");
            }
        }
        return toReturn;
    }

    public Map<String, String> getMessageMap() {
        System.out.println("messageMap = " + messageMap);
        return messageMap;
    }
}

enum TypeField {

    TEXT, INT, DOUBLE, DATE, EMAIL, DICTIONARY;
}

class CheckedField {

    private String name;
    private boolean empty;
    private boolean isRequired;
    private TypeField typeField;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isIsRequired() {
        return isRequired;
    }

    public void setIsRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public TypeField getTypeField() {
        return typeField;
    }

    public void setTypeField(TypeField typeField) {
        this.typeField = typeField;
    }
}
