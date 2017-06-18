package eltc.web.showBean.stringObjects;

public class BooleanObject extends AbstractObject{

    @Override
    public String getStringFromObject(Object object) {
        return ((Boolean) object).booleanValue() == true ? "Да" : "Нет";
    }

}
