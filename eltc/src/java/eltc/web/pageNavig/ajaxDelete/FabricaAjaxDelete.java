package eltc.web.pageNavig.ajaxDelete;

import eltc.model.EltcException;
import eltc.web.pageNavig.EntityEnum;
import static eltc.web.pageNavig.EntityEnum.MANAGER;
import static eltc.web.pageNavig.EntityEnum.VENDOR_AGREEMENT;

public class FabricaAjaxDelete {

    public static AjaxDelete createAjaxDelete(EntityEnum entity, int id, String typeOfFile) throws EltcException {
        AjaxDelete ajaxDelete = null;

        switch (entity) {
            case CONTRACT:
                ajaxDelete = new ContractAjaxDelete(id, typeOfFile);
                break;
            case HR_MANAGER:
                ajaxDelete = new HrManagerAjaxDelete(id, typeOfFile);
                break;
            case VENDOR_AGREEMENT:
                ajaxDelete = new VendorAgreementAjaxDelete(id, typeOfFile);
                break;
            case MANAGER:
                ajaxDelete = new ManagerAjaxDelete(id, typeOfFile);
                break;
            case TRAINER:
                ajaxDelete = new TrainerAjaxDelete(id, typeOfFile);
                break;
            default:
                throw new EltcException("Unknown Entity");

        }

        return ajaxDelete;
    }
}
