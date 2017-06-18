package eltc.web.showBean.stringObjects;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateObject extends AbstractObject {

    public String getStringFromObject(Object object) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format((Date) object);
    }
}
