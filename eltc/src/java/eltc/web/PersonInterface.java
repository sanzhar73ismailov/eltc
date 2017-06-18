/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import java.util.Date;

/**
 *
 * @author sanzhar.ismailov
 */
public interface PersonInterface {

    Integer getId();

    String getLastNameRu();

    void setLastNameRu(String lastNameRu);

    String getFirstNameRu();

    void setFirstNameRu(String firstNameRu);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    String getPatronicNameRu();

    void setPatronicNameRu(String patronicNameRu);
}
