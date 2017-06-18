package eltc.web.pageNavig.download;

import eltc.model.EltcException;
import eltc.web.pageNavig.EntityEnum;
import static eltc.web.pageNavig.EntityEnum.CONTRACT;

public class FabricaDownload {

    public static Download createDownLoad(EntityEnum entity, Object bean, String typeOfFile) throws EltcException {
        Download download = null;

        switch (entity) {
            case CONTRACT:
                download = new ContractDownload(bean, typeOfFile);
                break;
            case HR_MANAGER:
                download = new HrManagerDownload(bean, typeOfFile);
                break;
            case VENDOR_AGREEMENT:
                download = new VendorAgreementDownload(bean, typeOfFile);
                break;
            case MANAGER:
                download = new ManagerDownload(bean, typeOfFile);
                break;
            case TRAINER:
                download = new TrainerDownload(bean, typeOfFile);
                break;
            default:
                throw new EltcException("Unknown type of file: " + typeOfFile);
        }


        return download;




    }
}
