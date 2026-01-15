package cgDataAccess.cgInterfaces;

/**
 * Interfaz para las hormigas
 */
public interface cgIHormiga {
    /**
     * Método para que la hormiga coma un alimento
     * @param alimento El alimento a comer
     * @return true si la hormiga VIVE (alimento con genoma), false si MUERE
     */
    boolean comer(Object alimento);
}
