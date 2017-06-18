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
public interface DictionaryInterface {

    public Integer getId();

    public void setId(Integer id);

    public String getName();

    public void setName(String name);

    public String getUser();

    public void setUser(String user);

    public Date getInsertDatetime();

    public void setInsertDatetime(Date insertDatetime);
}
