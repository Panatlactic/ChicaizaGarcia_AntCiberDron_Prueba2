package cgDataAccess.cgInterfaces;

import java.util.List;

import cgInfrastructure.cgAppException;

public interface cgIDAO <T> {

    List <T> readAll()            throws cgAppException;
    T       readBy (Integer id)  throws cgAppException;
    boolean create (T entity)    throws cgAppException;
    boolean update (T entity)    throws cgAppException;
    boolean delete (Integer id)  throws cgAppException;
    Integer getMaxReg()          throws cgAppException;

}
