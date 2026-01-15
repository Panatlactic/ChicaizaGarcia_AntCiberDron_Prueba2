package cgConsoleApp;

/**
 * Clase que representa el alimento Néctar (Nectarívoros)
 * Caso de estudio: Nectarívoros
 */
public class cgNectar extends cgAlimento {
    
    public cgNectar() {
        super("Nectarívoros");
    }
    
    public cgNectar(cgGenoma genoma) {
        super("Nectarívoros", genoma);
    }
    
    @Override
    public String cgGetTipo() {
        return "Nectarívoros";
    }
}
