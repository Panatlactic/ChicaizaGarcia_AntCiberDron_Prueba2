package cgDataAccess.cgDAOs;

import cgDataAccess.cgDTOs.cgGenomaDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgGenomaDAO extends cgDataHelperSQLiteDAO <cgGenomaDTO>{
    public cgGenomaDAO () throws cgAppException {
        super(cgGenomaDTO.class, "cgGenoma", "IdGenoma");
    }
}
