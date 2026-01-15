package cgDataAccess.cgDAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cgDataAccess.cgDTOs.cgHormigaDTO;
import cgDataAccess.cgDTOs.cgViewHormigaDTO;
import cgDataAccess.cgHelpers.cgDataHelperSQLiteDAO;
import cgInfrastructure.cgAppException;

public class cgHormigaDAO extends cgDataHelperSQLiteDAO <cgHormigaDTO> {
    public cgHormigaDAO () throws cgAppException {
        super(cgHormigaDTO.class, "cgHormiga", "IdHormiga");
    }

    public List<cgViewHormigaDTO> CEreadAllVwHormiga () throws cgAppException {
        cgViewHormigaDTO dto;
        List <cgViewHormigaDTO> lst = new ArrayList<>();
        String query = " SELECT IdHormiga, "
                     + " Tipo, "
                     + " Sexo, "
                     + " EstadoHormiga, "
                     + " Nombre, "
                     + " Descripcion, "
                     + " Estado, "
                     + " FechaCreacion, "
                     + " FechaModifica "
                     + " FROM CEvwHormiga";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                dto = new cgViewHormigaDTO(rs.getInt(1),
                                           rs.getString(2),
                                           rs.getString(3),
                                           rs.getString(4),
                                           rs.getString(5),
                                           rs.getString(6),
                                           rs.getString(7),
                                           rs.getString(8),
                                           rs.getString(9),
                                           rs.getString(10),
                                           rs.getString(11));
                lst.add(dto);
            }
        } catch (SQLException e) {
            throw new cgAppException("Ups...problemas a la vista", e, getClass(), "getCEvwHormiga()");
        }
        return lst;
    }

}
