/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * @author sanzhar.ismailov
 */
public class TldFunctions {

    public static String urlEncode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, "UTF-8");
    }
}
