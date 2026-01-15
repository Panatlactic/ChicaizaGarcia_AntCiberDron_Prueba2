package cgConsoleApp;

import cgDataAccess.cgInterfaces.cgIEntomologo;
import cgUtility.cgTool;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class cgEntomologo implements cgIEntomologo {

   
    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_BLUE = "\u001B[34m";
    private static final String COLOR_YELLOW = "\u001B[33m";
    private static final String COLOR_GREEN = "\u001B[32m";

  
    protected static final String RUTA_ANT_NEST = "cgStorage/cgDataLake/AntNest.txt";
    protected static final String RUTA_ANT_FOOD = "cgStorage/cgDataLake/AntFood.txt";
    
    // Rutas para archivos de salida (datos procesados)
    protected static final String RUTA_HORMIGAS_PROCESADAS = "cgStorage/cgDataLake/HormigasProcesadas.txt";
    protected static final String RUTA_ALIMENTOS_PROCESADOS = "cgStorage/cgDataLake/AlimentosProcesados.txt";

    // Tipos válidos de hormigas (solo HReina es válida)
    protected static final Set<String> TIPOS_HORMIGA_VALIDOS = new HashSet<>(Arrays.asList(
        "HReina"
    ));

    // Tipos válidos de alimentos (solo Nectarívoros es válido)
    protected static final Set<String> TIPOS_ALIMENTO_VALIDOS = new HashSet<>(Arrays.asList(
        "Nectarívoros"
    ));

    /**
     * Extrae y procesa los datos de hormigas desde el archivo AntNest.txt
     * Muestra en azul los datos válidos y en rojo los inválidos
     * @return Lista de tipos de hormigas válidos encontrados
     */
    @Override
    public List<String> cgEtlAntNest() {
        List<String> hormigasValidas = new ArrayList<>();
        List<String> todosLosDatos = new ArrayList<>();

        System.out.println("\n" + COLOR_YELLOW + "[+] Hormigas" + COLOR_RESET);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ANT_NEST))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Separar por comas y procesar cada elemento
                String[] elementos = linea.split(",");
                for (String elemento : elementos) {
                    String elementoLimpio = elemento.trim();
                    if (!elementoLimpio.isEmpty()) {
                        todosLosDatos.add(elementoLimpio);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(COLOR_RED + "Error al leer el archivo: " + e.getMessage() + COLOR_RESET);
            return hormigasValidas;
        }

        // Procesar y mostrar cada dato con el spinner
        for (String dato : todosLosDatos) {
            cgTool.gjShowSpinner();
            
            boolean esValido = TIPOS_HORMIGA_VALIDOS.contains(dato);
            
            if (esValido) {
                System.out.println("| " + COLOR_BLUE + dato + COLOR_RESET);
                hormigasValidas.add(dato);
            } else {
                System.out.println("| " + COLOR_RED + dato + COLOR_RESET);
            }
        }

        return hormigasValidas;
    }

    /**
     * Extrae y procesa los datos de alimentos desde el archivo AntFood.txt
     * Muestra en azul los datos válidos y en rojo los inválidos
     * @return Lista de tipos de alimentos válidos encontrados
     */
    @Override
    public List<String> cgEtlAntFood() {
        List<String> alimentosValidos = new ArrayList<>();
        List<String> todosLosDatos = new ArrayList<>();

        System.out.println("\n" + COLOR_YELLOW + "[+] Alimentos" + COLOR_RESET);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ANT_FOOD))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Separar por guiones y procesar cada elemento
                String[] elementos = linea.split("-");
                for (String elemento : elementos) {
                    String elementoLimpio = elemento.trim();
                    if (!elementoLimpio.isEmpty()) {
                        todosLosDatos.add(elementoLimpio);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(COLOR_RED + "Error al leer el archivo: " + e.getMessage() + COLOR_RESET);
            return alimentosValidos;
        }

        // Procesar y mostrar cada dato con el spinner de espera
        for (String dato : todosLosDatos) {
            cgTool.gjShowWaiting();
            
            boolean esValido = TIPOS_ALIMENTO_VALIDOS.contains(dato);
            
            if (esValido) {
                System.out.println(" " + COLOR_BLUE + dato + COLOR_RESET);
                alimentosValidos.add(dato);
            } else {
                System.out.println(" " + COLOR_RED + dato + COLOR_RESET);
            }
        }

        return alimentosValidos;
    }

    /**
     * Guarda la lista de hormigas válidas en un archivo de texto
     * @param hormigas Lista de hormigas a guardar
     * @return true si se guardó correctamente
     */
    protected boolean guardarHormigasEnArchivo(List<String> hormigas) {
        System.out.println("\n" + COLOR_YELLOW + "[+] Guardando hormigas en archivo..." + COLOR_RESET);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_HORMIGAS_PROCESADAS))) {
            for (String hormiga : hormigas) {
                writer.write(hormiga);
                writer.newLine();
            }
            System.out.println(COLOR_GREEN + " Hormigas guardadas en: " + RUTA_HORMIGAS_PROCESADAS + COLOR_RESET);
            return true;
        } catch (IOException e) {
            System.out.println(COLOR_RED + " Error al guardar hormigas: " + e.getMessage() + COLOR_RESET);
            return false;
        }
    }

    /**
     * Guarda la lista de alimentos válidos en un archivo de texto
     * @param alimentos Lista de alimentos a guardar
     * @return true si se guardó correctamente
     */
    protected boolean guardarAlimentosEnArchivo(List<String> alimentos) {
        System.out.println("\n" + COLOR_YELLOW + "[+] Guardando alimentos en archivo..." + COLOR_RESET);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ALIMENTOS_PROCESADOS))) {
            for (String alimento : alimentos) {
                writer.write(alimento);
                writer.newLine();
            }
            System.out.println(COLOR_GREEN + " Alimentos guardados en: " + RUTA_ALIMENTOS_PROCESADOS + COLOR_RESET);
            return true;
        } catch (IOException e) {
            System.out.println(COLOR_RED + " Error al guardar alimentos: " + e.getMessage() + COLOR_RESET);
            return false;
        }
    }

    /**
     * Lee las hormigas procesadas desde el archivo
     * @return Lista de hormigas leídas del archivo
     */
    protected List<String> leerHormigasProcesadas() {
        List<String> hormigas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_HORMIGAS_PROCESADAS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    hormigas.add(linea.trim());
                }
            }
        } catch (IOException e) {
            System.out.println(COLOR_RED + " Error al leer hormigas procesadas: " + e.getMessage() + COLOR_RESET);
        }
        return hormigas;
    }

    /**
     * Lee los alimentos procesados desde el archivo
     * @return Lista de alimentos leídos del archivo
     */
    protected List<String> leerAlimentosProcesados() {
        List<String> alimentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(RUTA_ALIMENTOS_PROCESADOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    alimentos.add(linea.trim());
                }
            }
        } catch (IOException e) {
            System.out.println(COLOR_RED + " Error al leer alimentos procesados: " + e.getMessage() + COLOR_RESET);
        }
        return alimentos;
    }
    
    /**
     * Alimenta una hormiga con un alimento
     * Entomólogo Normal prepara SIN genoma
     * @param hormiga La hormiga a alimentar
     * @param alimento El alimento
     * @return La hormiga después de comer
     */
    @Override
    public Object alimentarAnt(Object hormiga, Object alimento) {
        System.out.println(COLOR_YELLOW + "\n========================================");
        System.out.println("   ALIMENTANDO HORMIGA (NORMAL)");
        System.out.println("========================================" + COLOR_RESET);
        
        if (hormiga instanceof cgHormiga && alimento instanceof cgAlimento) {
            cgHormiga h = (cgHormiga) hormiga;
            cgAlimento a = (cgAlimento) alimento;
            
            // Preparar sin genoma
            cgAlimento alimentoPreparado = (cgAlimento) cgPreparar(a);
            
            // Alimentar
            if (h instanceof cgHLarva) {
                return ((cgHLarva) h).cgComer(alimentoPreparado);
            }
            h.comer(alimentoPreparado);
            return h;
        }
        return hormiga;
    }
    
    /**
     * Prepara un alimento SIN genoma (entomólogo normal)
     * @param alimento El alimento a preparar
     * @return El alimento preparado sin genoma
     */
    @Override
    public Object cgPreparar(Object alimento) {
        System.out.println(COLOR_YELLOW + "\n[NORMAL] Preparando alimento SIN genoma..." + COLOR_RESET);
        
        if (alimento instanceof cgAlimento) {
            cgAlimento a = (cgAlimento) alimento;
            // Sin genoma
            a.setGenoma(null);
            System.out.println(COLOR_GREEN + "[OK] Preparado: " + a.toString() + COLOR_RESET);
            return a;
        }
        return alimento;
    }
}
