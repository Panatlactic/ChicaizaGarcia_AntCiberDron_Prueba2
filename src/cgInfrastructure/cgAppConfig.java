package cgInfrastructure;

public abstract class cgAppConfig {

    public static final String DATABASE = "jdbc:sqlite:cgStorage/cgDataBase/hormigas.sqlite";
    public static final String ANTFOOD = "cgStorage/cgDataLake/AntFood.txt";
    public static final String ANTEST = "cgStorage/cgDataLake/AntNest.txt";
    public static final String LOGFILE  = "cgStorage/cgLogs/cgAppErrors.log";

    public static final String MSG_DEFAULT_ERROR = "Ups! Error inesperado. Por favor contacte al administrador del sistema";
    public static final String MSG_DEFAULT_CLASS = "undefined";
    public static final String MSG_DEFAULT_METHOD = "undefined";

    private cgAppConfig (){}
}
