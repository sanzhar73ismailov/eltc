package eltc.web.pageNavig;

import eltc.model.EltcException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FabricaRequestMethod {

    public static HttpServletRequest getRequest(HttpServletRequest primaryRequest) throws EltcException {
        if (ServletFileUpload.isMultipartContent(primaryRequest)) {
            return new PageHttpRequest(primaryRequest);
        } else {
            return primaryRequest;
        }
    }
}
