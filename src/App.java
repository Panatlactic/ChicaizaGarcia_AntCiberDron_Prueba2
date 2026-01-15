import cgConsoleApp.*;
import cgDataAccess.cgDAOs.cgSexoDAO;
import cgDataAccess.cgDTOs.cgSexoDTO;
import cgInfrastructure.cgAppException;
import java.util.List;

public class App {
    
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_CYAN = "\u001B[36m";
    private static final String COLOR_YELLOW = "\u001B[33m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_MAGENTA = "\u001B[35m";
    
    public static void main(String[] args) {
        try {
            // Paso 1: Autenticación (usuario: patmic, clave: 123, máximo 3 intentos)
            cgAutenticacion auth = new cgAutenticacion();
            
            if (auth.solicitarAutenticacion()) {
                // Paso 2: Si la autenticación es exitosa, ejecutar ETL
                ejecutarProcesoCompleto();
            }
            // Si la autenticación falla, el sistema se cierra automáticamente
            
        } catch (Exception e) {
            System.out.println(COLOR_RED + "\n[ERROR FATAL] " + e.getMessage() + COLOR_RESET);
            System.out.println(COLOR_RED + "Causa: " + e.getClass().getSimpleName() + COLOR_RESET);
        }
    }
    
    /**
     * Ejecuta el proceso completo según el caso de estudio
     */
    private static void ejecutarProcesoCompleto() {
        try {
            // ========== FASE 1: ETL ==========
            System.out.println(COLOR_CYAN + "\n╔══════════════════════════════════════════════════╗");
            System.out.println("║           FASE 1: PROCESO ETL                    ║");
            System.out.println("╚══════════════════════════════════════════════════╝" + COLOR_RESET);
            
            cgEntomologoNormal entomologoNormal = new cgEntomologoNormal();
            entomologoNormal.ejecutarETLCompleto();
            
            // ========== FASE 2: DEMOSTRACIÓN CASO DE ESTUDIO ==========
            System.out.println(COLOR_MAGENTA + "\n╔══════════════════════════════════════════════════╗");
            System.out.println("║   FASE 2: CASO DE ESTUDIO (HReina + Nectarívoros)║");
            System.out.println("╚══════════════════════════════════════════════════╝" + COLOR_RESET);
            
            demostrarCasoEstudio();
            
            // ========== FASE 3: CONSULTA SEXOS EN BD ==========
            System.out.println(COLOR_CYAN + "\n╔══════════════════════════════════════════════════╗");
            System.out.println("║       FASE 3: CONSULTA SEXOS EN BASE DE DATOS    ║");
            System.out.println("╚══════════════════════════════════════════════════╝" + COLOR_RESET);
            
            consultarSexosBD();
            
            // ========== FIN ==========
            System.out.println(COLOR_GREEN + "\n╔══════════════════════════════════════════════════╗");
            System.out.println("║          PROGRAMA FINALIZADO EXITOSAMENTE        ║");
            System.out.println("╚══════════════════════════════════════════════════╝" + COLOR_RESET);
            
        } catch (Exception e) {
            System.out.println(COLOR_RED + "[ERROR] " + e.getMessage() + COLOR_RESET);
        }
    }
    
    /**
     * Demuestra el caso de estudio: HReina + Nectarívoros = superReproductora
     */
    private static void demostrarCasoEstudio() {
        System.out.println(COLOR_YELLOW + "\n--- CASO 1: Entomólogo GENETISTA (con genoma) ---" + COLOR_RESET);
        
        // Crear una HReina
        cgHReina reina1 = new cgHReina(1);
        System.out.println("Creada: " + reina1);
        
        // Crear alimento Nectarívoros
        cgNectar nectar1 = new cgNectar();
        
        // Entomólogo Genetista prepara CON genoma
        cgEntomologoGenetista genetista = new cgEntomologoGenetista();
        genetista.alimentarAnt(reina1, nectar1);
        
        System.out.println("\nEstado final: " + reina1);
        
        // -----------------------------------
        System.out.println(COLOR_YELLOW + "\n--- CASO 2: Entomólogo NORMAL (sin genoma) ---" + COLOR_RESET);
        
        // Crear otra HReina
        cgHReina reina2 = new cgHReina(2);
        System.out.println("Creada: " + reina2);
        
        // Crear alimento Nectarívoros
        cgNectar nectar2 = new cgNectar();
        
        // Entomólogo Normal prepara SIN genoma
        cgEntomologoNormal normal = new cgEntomologoNormal();
        normal.alimentarAnt(reina2, nectar2);
        
        System.out.println("\nEstado final: " + reina2);
        
        // -----------------------------------
        System.out.println(COLOR_YELLOW + "\n--- CASO 3: Larva se transforma en Reina ---" + COLOR_RESET);
        
        // Crear una Larva
        cgHLarva larva = new cgHLarva(3);
        System.out.println("Creada: " + larva);
        
        // Crear alimento Nectarívoros
        cgNectar nectar3 = new cgNectar();
        
        // Genetista alimenta la larva
        cgHormiga resultado = genetista.alimentarAnt(larva, nectar3);
        
        System.out.println("\nResultado de transformación: " + resultado);
    }
    
    /**
     * Consulta los sexos disponibles en la base de datos
     */
    private static void consultarSexosBD() {
        try {
            cgSexoDAO sexoDAO = new cgSexoDAO();
            List<cgSexoDTO> sexos = sexoDAO.readAll();
            
            if (sexos == null || sexos.isEmpty()) {
                System.out.println(COLOR_YELLOW + "No hay sexos registrados en la base de datos." + COLOR_RESET);
                return;
            }
            
            System.out.println(COLOR_GREEN + "\n┌────────┬─────────────┬─────────────────────────┐");
            System.out.println("│   ID   │   Nombre    │      Descripción        │");
            System.out.println("├────────┼─────────────┼─────────────────────────┤" + COLOR_RESET);
            
            for (cgSexoDTO sexo : sexos) {
                Integer idValue = sexo.getIdSexo();
                String id = String.format("%-6s", idValue != null ? idValue.toString() : "0");
                String nombre = String.format("%-11s", sexo.getNombre() != null ? sexo.getNombre() : "N/A");
                String desc = sexo.getDescripcion() != null ? sexo.getDescripcion() : "N/A";
                if (desc.length() > 23) desc = desc.substring(0, 20) + "...";
                desc = String.format("%-23s", desc);
                
                System.out.println("│ " + id + " │ " + nombre + " │ " + desc + " │");
            }
            
            System.out.println(COLOR_GREEN + "└────────┴─────────────┴─────────────────────────┘" + COLOR_RESET);
            System.out.println("\nTotal de sexos en BD: " + sexos.size());
            
        } catch (cgAppException e) {
            System.out.println(COLOR_RED + "[ERROR BD] No se pudo consultar sexos: " + e.getMessage() + COLOR_RESET);
        } catch (Exception e) {
            System.out.println(COLOR_RED + "[ERROR] " + e.getMessage() + COLOR_RESET);
        }
    }
}
