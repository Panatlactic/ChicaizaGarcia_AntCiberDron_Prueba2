package cgDataAccess.cgDAOs;

import cgDataAccess.cgDTOs.cgAlimentoPreparadoDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgAlimentoPreparadoDAO extends cgDataHelperSQLiteDAO <cgAlimentoPreparadoDTO> {
    public cgAlimentoPreparadoDAO () throws cgAppException {
        super(cgAlimentoPreparadoDTO.class, "cgAlimentoPreparado", "IdAlimentoPreparado");
    }
}
