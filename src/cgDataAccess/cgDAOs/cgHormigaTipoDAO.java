package cgDataAccess.cgDAOs;

import cgDataAccess.cgDTOs.cgHormigaTipoDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgHormigaTipoDAO extends cgDataHelperSQLiteDAO <cgHormigaTipoDTO>{
    public cgHormigaTipoDAO () throws cgAppException {
        super(cgHormigaTipoDTO.class, "cgHormigaTipo", "IdHormigaTipo");
    }
}
