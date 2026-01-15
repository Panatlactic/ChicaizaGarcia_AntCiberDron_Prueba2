package cgInfrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class cgAppException extends Exception{

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    public cgAppException(String ce_showMsg) {
        super((ce_showMsg == null || ce_showMsg.isBlank())? cgAppConfig.MSG_DEFAULT_ERROR : ce_showMsg);
        CEsaveLogFile(null, null, null);
    }

    public cgAppException(String ce_showMsg, Exception ce_e, Class<?> ce_clase, String ce_metodo) {
        super((ce_showMsg == null || ce_showMsg.isBlank())? cgAppConfig.MSG_DEFAULT_ERROR : ce_showMsg);
        CEsaveLogFile(ce_e.getMessage(), ce_clase, ce_metodo);
    }

    private void CEsaveLogFile(String ce_logMsg, Class<?> ce_clase, String ce_metodo) {
        String ce_timestamp  = LocalDateTime.now().format(FORMATTER);
        String ce_className  = (ce_clase == null) ? cgAppConfig.MSG_DEFAULT_CLASS : ce_clase.getSimpleName();
        String ce_methodName = (ce_metodo == null) ? cgAppConfig.MSG_DEFAULT_METHOD : ce_metodo;

        ce_logMsg = (ce_logMsg == null || ce_logMsg.isBlank())? cgAppConfig.MSG_DEFAULT_ERROR : ce_logMsg;
        ce_logMsg = String.format("-> SHOW : %s \n-- LOG : %s | %s.%s | %s", getMessage(),ce_timestamp,
                                    ce_className, ce_methodName, ce_logMsg);

        try (PrintWriter writer = new PrintWriter(new FileWriter(cgAppConfig.LOGFILE, true))) {
            System.err.println(cgColor.CE_BLUE  + ce_logMsg);
            writer.println(ce_logMsg);
        } catch (Exception e) {
            System.err.println(cgColor.CE_RED  + "[AppException.saveLogFile] ❱ " + e.getMessage());
        }finally {
            System.out.println(cgColor.CE_RESET);
        }
    }
    
}
