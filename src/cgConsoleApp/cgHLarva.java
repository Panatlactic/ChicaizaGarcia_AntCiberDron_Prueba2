package cgConsoleApp;

import cgDataAccess.cgDTOs.cgHormigaDTO;

/**
 * Clase que representa una Hormiga Larva
 * La larva al comer se transforma en su tipo de hormiga
 */
public class cgHLarva extends cgHormiga {
    
    private static final String COLOR_CYAN = "\u001B[36m";
    private static final String COLOR_RESET = "\u001B[0m";
    
    public cgHLarva() {
        super();
        this.idTipo = "HLarva";
        this.idSexo = "Indefinido";
    }
    
    public cgHLarva(Integer id) {
        super(id, "HLarva", "Indefinido", "VIVE");
    }
    
    /**
     * Obtiene los datos de la larva como DTO
     * @return cgHormigaDTO con los datos de la larva
     */
    public cgHormigaDTO cgGetLarvaId(Integer id) {
        cgHormigaDTO dto = new cgHormigaDTO();
        dto.setIdHormiga(id);
        dto.setNombre("Larva " + id);
        dto.setDescripcion("Hormiga en estado larva");
        return dto;
    }
    
    /**
     * La larva come un alimento y puede transformarse
     * @param alimento El alimento a comer
     * @return La hormiga transformada (puede ser cgHReina u otra)
     */
    public cgHormiga cgComer(cgAlimento alimento) {
        System.out.println(COLOR_CYAN + "\n[LARVA] Procesando alimentación..." + COLOR_RESET);
        
        boolean vive = this.comer(alimento);
        
        if (vive && alimento.tieneGenoma()) {
            // Si tiene genoma y el alimento es Nectarívoros, se transforma en HReina
            if (alimento.cgGetTipo().equals("Nectarívoros")) {
                System.out.println(COLOR_CYAN + "[TRANSFORMACIÓN] Larva -> HReina" + COLOR_RESET);
                cgHReina reina = new cgHReina(this.idHormiga);
                reina.setIdSexo(this.idSexo);
                reina.setEstado(this.estado);
                return reina;
            }
        }
        
        return this; // Si no se transforma, sigue siendo larva
    }
    
    @Override
    protected void verificarSuperHabilidad(cgAlimento alimento) {
        // Las larvas no tienen superhabilidad
        System.out.println("  [Larva no tiene superhabilidad]");
    }
}
