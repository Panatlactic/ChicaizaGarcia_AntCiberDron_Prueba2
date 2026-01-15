package cgConsoleApp;

/**
 * Clase que representa una Hormiga Reina
 * Caso de estudio: HReina + Nectarívoros = superReproductora
 */
public class cgHReina extends cgHormiga {
    
    private boolean fertilidadAlta;
    private boolean superHabilidadActiva;
    
    private static final String COLOR_MAGENTA = "\u001B[35m";
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_GREEN = "\u001B[32m";
    
    public cgHReina() {
        super();
        this.idTipo = "HReina";
        this.fertilidadAlta = false;
        this.superHabilidadActiva = false;
    }
    
    public cgHReina(Integer id) {
        super(id, "HReina", "Hembra", "VIVE");
        this.fertilidadAlta = false;
        this.superHabilidadActiva = false;
    }
    
    /**
     * SuperHabilidad: Super Reproductora
     * Se activa cuando HReina come Nectarívoros con genoma
     */
    public void superReproductora() {
        if (superHabilidadActiva) {
            System.out.println(COLOR_MAGENTA + "\n╔══════════════════════════════════════════════════╗");
            System.out.println("║        * SUPERHABILIDAD ACTIVADA *               ║");
            System.out.println("║                                                   ║");
            System.out.println("║            >>> SUPER REPRODUCTORA <<<             ║");
            System.out.println("║                                                   ║");
            System.out.println("║   La Reina puede reproducirse a gran velocidad   ║");
            System.out.println("║   Fertilidad: MÁXIMA                              ║");
            System.out.println("╚══════════════════════════════════════════════════╝" + COLOR_RESET);
            this.fertilidadAlta = true;
        } else {
            System.out.println("  [SuperHabilidad no disponible - requiere Nectarívoros]");
        }
    }
    
    @Override
    protected void verificarSuperHabilidad(cgAlimento alimento) {
        // Caso de estudio: HReina + Nectarívoros = superReproductora
        if (alimento.cgGetTipo().equals("Nectarívoros") && alimento.tieneGenoma()) {
            System.out.println(COLOR_GREEN + "\n  [*] Caso de estudio detectado: HReina + Nectarivoros" + COLOR_RESET);
            this.superHabilidadActiva = true;
            superReproductora();
        }
    }
    
    // Getters y Setters
    public boolean isFertilidadAlta() {
        return fertilidadAlta;
    }
    
    public void setFertilidadAlta(boolean fertilidadAlta) {
        this.fertilidadAlta = fertilidadAlta;
    }
    
    public boolean isSuperHabilidadActiva() {
        return superHabilidadActiva;
    }
    
    @Override
    public String toString() {
        return "HReina [id=" + idHormiga + ", sexo=" + idSexo + ", estado=" + estado + 
               ", fertilidadAlta=" + fertilidadAlta + ", superHabilidad=" + superHabilidadActiva + "]";
    }
}
