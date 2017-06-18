package eltc.web.pageNavig;

import eltc.model.EltcException;
import eltc.util.Configurator;
import static eltc.web.pageNavig.EntityEnum.CONTRACT;
import eltc.web.pageNavig.download.Download;
import eltc.web.pageNavig.download.FabricaDownload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class PageDownloadFile extends AbstractPageNavigator {

    public PageDownloadFile(EntityEnum entity, HttpServletRequest request, HttpServletResponse response) throws EltcException {
        super(entity, request, response);
    }

    @Override
    void doSomething() throws EltcException {
        toBeForwarded = false;
        response.setContentType("application/octet-stream");

        Object bean = null;

        FileInputStream fileIn = null;
        ServletOutputStream out = null;
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            bean = model.getObject(id, entity.getClassOfElements());
            Download downLoadObj = FabricaDownload.createDownLoad(entity, bean, request.getParameter("type"));
            String fileName = downLoadObj.getFileName();
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            System.out.println("fileName = " + fileName);


            File file = new File(Configurator.getUploadDir() + File.separator + fileName);
            fileIn = new FileInputStream(file);
            out = response.getOutputStream();
            byte[] buffer = new byte[4096];
            //copy binary contect to output stream
            int length = 0;
            while ((length = fileIn.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        } catch (Exception ex) {
            throw new EltcException(ex.getMessage(), ex);
        } finally {
            try {
                if (fileIn != null) {
                    fileIn.close();
                }
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException ex) {
                throw new EltcException(ex.getMessage(), ex);
            }
        }
    }

    @Override
    void setPageTitlePattern() throws EltcException {
    }
}
