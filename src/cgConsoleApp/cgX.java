package cgConsoleApp;

/**
 * Genoma X - Asexual
 */
public class cgX extends cgGenoma {
    
    public cgX() {
        this.tipo = "X";
    }
    
    @Override
    public String obtenerGenoma() {
        return "X - Asexual";
    }
}
