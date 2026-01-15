package cgDataAccess.cgInterfaces;

import java.util.List;

public interface cgIEntomologo {
    // Método para extraer datos de hormigas desde el archivo AntNest.txt
    List<String> cgEtlAntNest();
    
    // Método para extraer datos de alimentos desde el archivo AntFood.txt
    List<String> cgEtlAntFood();
    
    // Método para alimentar una hormiga con un alimento
    Object alimentarAnt(Object hormiga, Object alimento);
    
    // Método para preparar un alimento
    Object cgPreparar(Object alimento);
}
