package cgDataAccess.cgDAOs;

import cgDataAccess.cgDTOs.cgSexoDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgSexoDAO extends cgDataHelperSQLiteDAO <cgSexoDTO>{
    public cgSexoDAO () throws cgAppException {
        super(cgSexoDTO.class, "cgSexo", "IdSexo");
    }
}
