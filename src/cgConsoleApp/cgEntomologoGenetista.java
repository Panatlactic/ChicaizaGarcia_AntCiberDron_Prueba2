package cgConsoleApp;

import java.util.Random;

/**
 * Entomólogo Genetista - Puede inyectar genomas a los alimentos
 * Prepara alimento CON genoma
 */
public class cgEntomologoGenetista extends cgEntomologo {
    
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_CYAN = "\u001B[36m";
    private static final String COLOR_MAGENTA = "\u001B[35m";
    
    public cgEntomologoGenetista() {
        super();
    }
    
    /**
     * Inyecta un genoma al alimento
     * @param genoma El genoma a inyectar
     * @return true si la inyección fue exitosa
     */
    public boolean cgInyectar(cgGenoma genoma) {
        System.out.println(COLOR_MAGENTA + "\n[GENETISTA] Inyectando genoma: " + genoma.obtenerGenoma() + COLOR_RESET);
        return true;
    }
    
    /**
     * Prepara un alimento CON genoma aleatorio (X, XX, XY)
     * @param alimento El alimento a preparar
     * @return El alimento preparado con genoma
     */
    public cgAlimento cgPreparar(cgAlimento alimento) {
        System.out.println(COLOR_CYAN + "\n╔════════════════════════════════════════╗");
        System.out.println("║   ENTOMÓLOGO GENETISTA - PREPARANDO    ║");
        System.out.println("╚════════════════════════════════════════╝" + COLOR_RESET);
        
        // Generar genoma aleatorio
        cgGenoma genomaAleatorio = generarGenomaAleatorio();
        
        // Inyectar el genoma
        cgInyectar(genomaAleatorio);
        
        // Asignar genoma al alimento
        alimento.setGenoma(genomaAleatorio);
        
        System.out.println(COLOR_GREEN + "[OK] Alimento preparado: " + alimento.toString() + COLOR_RESET);
        
        return alimento;
    }
    
    /**
     * Genera un genoma aleatorio (X, XX o XY)
     * @return Un genoma aleatorio
     */
    private cgGenoma generarGenomaAleatorio() {
        Random random = new Random();
        int opcion = random.nextInt(3);
        
        switch (opcion) {
            case 0:
                return new cgX();
            case 1:
                return new cgXX();
            case 2:
                return new cgXY();
            default:
                return new cgX();
        }
    }
    
    /**
     * Alimenta a una hormiga con un alimento preparado
     * @param hormiga La hormiga a alimentar
     * @param alimento El alimento (se preparará con genoma)
     * @return La hormiga después de comer (puede transformarse)
     */
    public cgHormiga alimentarAnt(cgHormiga hormiga, cgAlimento alimento) {
        System.out.println(COLOR_CYAN + "\n========================================");
        System.out.println("   ALIMENTANDO HORMIGA (GENETISTA)");
        System.out.println("========================================" + COLOR_RESET);
        
        // Preparar el alimento con genoma
        cgAlimento alimentoPreparado = cgPreparar(alimento);
        
        // Si es una larva, usar su método especial
        if (hormiga instanceof cgHLarva) {
            return ((cgHLarva) hormiga).cgComer(alimentoPreparado);
        }
        
        // Para otras hormigas, usar el método normal
        hormiga.comer(alimentoPreparado);
        return hormiga;
    }
}
