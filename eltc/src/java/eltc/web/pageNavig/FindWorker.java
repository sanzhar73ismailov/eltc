package eltc.web.pageNavig;

import domain.Email;
import domain.Organization;
import domain.Student;
import eltc.model.EltcException;
import eltc.web.ServletUtilMethods;
import java.util.Set;
import javax.servlet.ServletRequest;

public class FindWorker implements FindAble {

    private ServletRequest request;
    private static String FIND_PARAMETER_NAME = "toFind";
    private Object typeObject;
    private Object findObject;
    private String stringForFindUrl;

    public FindWorker(ServletRequest request, Object typeObject) throws EltcException {
        this.request = request;
        this.typeObject = typeObject;
        if (isFindNecessary()) {
            createFindObject();
        }
        createFindUrl();
    }

    private void createFindObject() throws EltcException {
        if (typeObject instanceof Student) {
            findObject = createStudent();
        } else if (typeObject instanceof Organization) {
            findObject = createOrganization();
        } else {
            throw new EltcException("Неизвестный поисковый объект: " + typeObject.getClass());
        }

    }

    private Object createStudent() {
        Student findObject = new Student();
        findObject.setLastNameRu(getParameterValueReturnEmptyStringIfValieIsNull("lastNameRu"));
        findObject.setFirstNameRu(getParameterValueReturnEmptyStringIfValieIsNull("firstNameRu"));
        findObject.setComments(getParameterValueReturnEmptyStringIfValieIsNull("comments"));

        String criteriaEmail = getParameterValueReturnEmptyStringIfValieIsNull("email");
        if (!criteriaEmail.isEmpty()) {
            Email email = new Email();
            email.setEmail(criteriaEmail);
            findObject.getEmails().add(email);
        }
        return findObject;
    }

    private Object createOrganization() {
        Organization findObject = new Organization();
        findObject.setName(getParameterValueReturnEmptyStringIfValieIsNull("name"));
        findObject.setRnn(getParameterValueReturnEmptyStringIfValieIsNull("rnn"));
        return findObject;
    }

    private String getParameterValueReturnEmptyStringIfValieIsNull(String parameter) {
        String value = request.getParameter(parameter);
        if (value == null) {
            return "";
        }
        return ServletUtilMethods.escapeHtml(value.toLowerCase().trim());
    }

    public Object getFindObject() throws EltcException {
        return findObject;
    }

    public boolean isFindNecessary() {
        return request.getParameter(FIND_PARAMETER_NAME) != null;
    }

    public String getForFindUrlString() {
        return stringForFindUrl;
    }

    private String createStringFindForStudent() {
        StringBuilder forToFindStringBuilder = new StringBuilder();
        //  forToFindStringBuilder.append(" javascript: sendFindForm({");
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("toFind", false));
        //   forToFindStringBuilder.append(addToJavaScriptFunctionParameter("entity", false));
        //   forToFindStringBuilder.append(addToJavaScriptFunctionParameter("page", false));
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("lastNameRu", false));
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("firstNameRu", false));
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("comments", false));
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("email", true));
        //  forToFindStringBuilder.append("});");
        return forToFindStringBuilder.toString();
    }

    private String createStringFindForOrganization() {
        StringBuilder forToFindStringBuilder = new StringBuilder();
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("toFind", false));
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("rnn", false));
        forToFindStringBuilder.append(addToJavaScriptFunctionParameter("name", true));
        return forToFindStringBuilder.toString();
    }

    private String addToJavaScriptFunctionParameter(String parameter, boolean isLastParameter) {
        StringBuilder result = new StringBuilder(parameter + ":");
        if (request.getParameter(parameter) != null) {
            result.append("'" + request.getParameter(parameter) + "'");
        } else {
            result.append("''");
        }
        if (!isLastParameter) {
            result.append(", ");
        }
        return result.toString();
    }

    private void createFindUrl() throws EltcException {
        if (typeObject instanceof Student) {
            stringForFindUrl = createStringFindForStudent();
        } else if (typeObject instanceof Organization) {
            stringForFindUrl = createStringFindForOrganization();
        } else {
            return;
        }
    }
}
