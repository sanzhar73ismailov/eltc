package eltc.web.pageNavig;

import eltc.model.EltcException;

public interface FindAble {

    Object getFindObject() throws EltcException;
    boolean isFindNecessary();
    String getForFindUrlString();
    
}
