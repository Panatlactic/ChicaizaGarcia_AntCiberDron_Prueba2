package cgConsoleApp;

import cgDataAccess.cgDAOs.cgAlimentoPreparadoDAO;
import cgDataAccess.cgDAOs.cgHormigaTipoDAO;
import cgDataAccess.cgDTOs.cgAlimentoPreparadoDTO;
import cgDataAccess.cgDTOs.cgHormigaTipoDTO;
import cgInfrastructure.cgAppException;
import java.util.List;

public class cgEntomologoNormal extends cgEntomologo {

    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_YELLOW = "\u001B[33m";

    /**
     * Realiza la cosecha de datos de hormigas y las guarda en archivo
     */
    public void cosecharHormigas() {
        System.out.println("\n========================================");
        System.out.println("   INICIANDO COSECHA DE HORMIGAS");
        System.out.println("========================================");
        
        List<String> hormigasRecolectadas = cgEtlAntNest();
        
        // Guardar en archivo
        guardarHormigasEnArchivo(hormigasRecolectadas);
        
        System.out.println("\n----------------------------------------");
        System.out.println("Total hormigas válidas recolectadas: " + hormigasRecolectadas.size());
        System.out.println("----------------------------------------");
    }

    /**
     * Realiza la cosecha de datos de alimentos y los guarda en archivo
     */
    public void cosecharAlimentos() {
        System.out.println("\n========================================");
        System.out.println("   INICIANDO COSECHA DE ALIMENTOS");
        System.out.println("========================================");
        
        List<String> alimentosRecolectados = cgEtlAntFood();
        
        // Guardar en archivo
        guardarAlimentosEnArchivo(alimentosRecolectados);
        
        System.out.println("\n----------------------------------------");
        System.out.println("Total alimentos válidos recolectados: " + alimentosRecolectados.size());
        System.out.println("----------------------------------------");
    }

    /**
     * Realiza la cosecha completa de hormigas y alimentos
     */
    public void cosecharTodo() {
        cosecharHormigas();
        cosecharAlimentos();
    }

    /**
     * Carga masiva de hormigas desde el archivo procesado a la base de datos
     */
    public void cargarHormigasABaseDatos() {
        System.out.println("\n" + COLOR_YELLOW + "========================================" + COLOR_RESET);
        System.out.println(COLOR_YELLOW + "   CARGA MASIVA DE HORMIGAS A BD" + COLOR_RESET);
        System.out.println(COLOR_YELLOW + "========================================" + COLOR_RESET);

        List<String> hormigas = leerHormigasProcesadas();
        
        if (hormigas.isEmpty()) {
            System.out.println(COLOR_RED + " No hay hormigas para cargar. Primero ejecute la cosecha." + COLOR_RESET);
            return;
        }

        try {
            cgHormigaTipoDAO hormigaTipoDAO = new cgHormigaTipoDAO();
            int cargadas = 0;
            int contador = 1;

            for (String nombreHormiga : hormigas) {
                cgHormigaTipoDTO dto = new cgHormigaTipoDTO();
                String nombreConContador = nombreHormiga + " " + contador;
                dto.setNombre(nombreConContador);
                dto.setDescripcion("Tipo de hormiga: " + nombreHormiga);

                if (hormigaTipoDAO.create(dto)) {
                    System.out.println(COLOR_GREEN + " Cargada: " + nombreConContador + COLOR_RESET);
                    cargadas++;
                    contador++;
                }
            }

            System.out.println("\n" + COLOR_GREEN + " Carga masiva completada. Total: " + cargadas + " hormigas." + COLOR_RESET);

        } catch (cgAppException e) {
            System.out.println(COLOR_RED + " Error durante la carga: " + e.getMessage() + COLOR_RESET);
        }
    }

    /**
     * Carga masiva de alimentos desde el archivo procesado a la base de datos
     */
    public void cargarAlimentosABaseDatos() {
        System.out.println("\n" + COLOR_YELLOW + "========================================" + COLOR_RESET);
        System.out.println(COLOR_YELLOW + "   CARGA MASIVA DE ALIMENTOS A BD" + COLOR_RESET);
        System.out.println(COLOR_YELLOW + "========================================" + COLOR_RESET);

        List<String> alimentos = leerAlimentosProcesados();
        
        if (alimentos.isEmpty()) {
            System.out.println(COLOR_RED + " No hay alimentos para cargar. Primero ejecute la cosecha." + COLOR_RESET);
            return;
        }

        try {
            cgAlimentoPreparadoDAO alimentoDAO = new cgAlimentoPreparadoDAO();
            int cargados = 0;
            int contador = 1;

            for (String nombreAlimento : alimentos) {
                cgAlimentoPreparadoDTO dto = new cgAlimentoPreparadoDTO();
                String nombreConContador = nombreAlimento + " " + contador;
                dto.setNombre(nombreConContador);
                dto.setDescripcion("Alimento tipo: " + nombreAlimento);

                if (alimentoDAO.create(dto)) {
                    System.out.println(COLOR_GREEN + " Cargado: " + nombreConContador + COLOR_RESET);
                    cargados++;
                    contador++;
                }
            }

            System.out.println("\n" + COLOR_GREEN + " Carga masiva completada. Total: " + cargados + " alimentos." + COLOR_RESET);

        } catch (cgAppException e) {
            System.out.println(COLOR_RED + " Error durante la carga: " + e.getMessage() + COLOR_RESET);
        }
    }

    /**
     * Ejecuta todo el proceso ETL completo:
     * 1. Cosecha hormigas y alimentos
     * 2. Guarda en archivos
     * 3. Carga masiva a base de datos
     */
    public void ejecutarETLCompleto() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     PROCESO ETL COMPLETO             ║");
        System.out.println("╚══════════════════════════════════════╝");

        // Paso 1: Cosecha
        cosecharTodo();

        // Paso 2: Carga a BD
        cargarHormigasABaseDatos();
        cargarAlimentosABaseDatos();

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║     ETL FINALIZADO                   ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
}
