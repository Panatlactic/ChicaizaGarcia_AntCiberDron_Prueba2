package cgConsoleApp;

import cgDataAccess.cgInterfaces.cgIHormiga;

/**
 * Clase abstracta que representa una Hormiga
 * Implementa la interfaz cgIHormiga
 */
public abstract class cgHormiga implements cgIHormiga {
    
    protected Integer idHormiga;
    protected String idTipo;
    protected String idSexo;
    protected String estado;
    
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_YELLOW = "\u001B[33m";
    
    public cgHormiga() {
        this.estado = "VIVE";
    }
    
    public cgHormiga(Integer id, String tipo, String sexo, String estado) {
        this.idHormiga = id;
        this.idTipo = tipo;
        this.idSexo = sexo;
        this.estado = estado;
    }
    
    /**
     * Método para que la hormiga coma un alimento
     * La hormiga VIVE si come alimento CON genoma, MUERE si no tiene genoma
     * @param alimentoObj El alimento a comer
     * @return true si VIVE, false si MUERE
     */
    @Override
    public boolean comer(Object alimentoObj) {
        if (!(alimentoObj instanceof cgAlimento)) {
            System.out.println(COLOR_RED + "Error: No es un alimento válido" + COLOR_RESET);
            return false;
        }
        
        cgAlimento alimento = (cgAlimento) alimentoObj;
        
        System.out.println("\n" + COLOR_YELLOW + "Hormiga " + idTipo + " comiendo " + alimento.cgGetTipo() + "..." + COLOR_RESET);
        
        if (alimento.tieneGenoma()) {
            // Alimento CON genoma -> VIVE
            this.estado = "VIVE";
            
            // Cambiar sexo según el genoma
            cgGenoma genoma = alimento.getGenoma();
            if (genoma instanceof cgXX) {
                this.idSexo = "Macho";
            } else if (genoma instanceof cgXY) {
                this.idSexo = "Hembra";
            } else if (genoma instanceof cgX) {
                this.idSexo = "Asexual";
            }
            
            System.out.println(COLOR_GREEN + "[OK] La hormiga " + idTipo + " VIVE!" + COLOR_RESET);
            System.out.println("  Sexo actualizado a: " + idSexo);
            System.out.println("  " + alimento.toString());
            
            // Verificar si corresponde al caso de estudio para habilitar superHabilidad
            verificarSuperHabilidad(alimento);
            
            return true;
        } else {
            // Alimento SIN genoma -> MUERE
            this.estado = "MUERE";
            System.out.println(COLOR_RED + "[X] La hormiga " + idTipo + " MUERE (alimento sin genoma)" + COLOR_RESET);
            System.out.println("  " + alimento.toString());
            return false;
        }
    }
    
    /**
     * Método abstracto para verificar y habilitar la superhabilidad
     * @param alimento El alimento consumido
     */
    protected abstract void verificarSuperHabilidad(cgAlimento alimento);
    
    // Getters y Setters
    public Integer getIdHormiga() {
        return idHormiga;
    }
    
    public void setIdHormiga(Integer idHormiga) {
        this.idHormiga = idHormiga;
    }
    
    public String getIdTipo() {
        return idTipo;
    }
    
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }
    
    public String getIdSexo() {
        return idSexo;
    }
    
    public void setIdSexo(String idSexo) {
        this.idSexo = idSexo;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Hormiga [id=" + idHormiga + ", tipo=" + idTipo + ", sexo=" + idSexo + ", estado=" + estado + "]";
    }
}
