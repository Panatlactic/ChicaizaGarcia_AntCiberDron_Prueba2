package cgDataAccess.cgDAOs;

import cgDataAccess.cgDTOs.cgEstadoHormigaDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgEstadoHormigaDAO extends cgDataHelperSQLiteDAO <cgEstadoHormigaDTO>{
    public cgEstadoHormigaDAO () throws cgAppException {
        super(cgEstadoHormigaDTO.class, "cgEstadoHormiga", "IdEstadoHormiga");
    }
}
