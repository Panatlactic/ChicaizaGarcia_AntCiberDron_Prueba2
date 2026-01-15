package cgConsoleApp;

/**
 * Clase abstracta que representa un Alimento
 */
public abstract class cgAlimento {
    
    protected String cgTipo;
    protected cgGenoma genoma;
    
    public cgAlimento() {}
    
    public cgAlimento(String tipo) {
        this.cgTipo = tipo;
        this.genoma = null;
    }
    
    public cgAlimento(String tipo, cgGenoma genoma) {
        this.cgTipo = tipo;
        this.genoma = genoma;
    }
    
    /**
     * Obtiene el tipo de alimento
     * @return El tipo de alimento
     */
    public String cgGetTipo() {
        return cgTipo;
    }
    
    public void setCgTipo(String tipo) {
        this.cgTipo = tipo;
    }
    
    public cgGenoma getGenoma() {
        return genoma;
    }
    
    public void setGenoma(cgGenoma genoma) {
        this.genoma = genoma;
    }
    
    /**
     * Verifica si el alimento tiene genoma
     * @return true si tiene genoma, false si no
     */
    public boolean tieneGenoma() {
        return genoma != null;
    }
    
    @Override
    public String toString() {
        if (tieneGenoma()) {
            return "[ Preparado ]-( " + cgTipo + " + " + genoma.getTipo() + " )-";
        } else {
            return "[ Preparado ]-( " + cgTipo + " )-";
        }
    }
}
