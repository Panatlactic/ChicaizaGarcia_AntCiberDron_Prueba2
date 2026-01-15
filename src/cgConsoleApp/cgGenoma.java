package cgConsoleApp;

/**
 * Clase abstracta que representa un Genoma
 */
public abstract class cgGenoma {
    
    protected String tipo;
    
    public cgGenoma() {}
    
    /**
     * Método abstracto para obtener el genoma
     * @return El tipo de genoma
     */
    public abstract String obtenerGenoma();
    
    public String getTipo() {
        return tipo;
    }
}
