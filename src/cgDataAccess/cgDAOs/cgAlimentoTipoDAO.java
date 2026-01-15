package cgDataAccess.cgDAOs;

import cgDataAccess.cgDTOs.cgAlimentoTipoDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgAlimentoTipoDAO extends cgDataHelperSQLiteDAO <cgAlimentoTipoDTO> {
    public cgAlimentoTipoDAO () throws cgAppException {
        super(cgAlimentoTipoDTO.class, "cgAlimentoTipo", "IdAlimentoTipo");
    }
}
