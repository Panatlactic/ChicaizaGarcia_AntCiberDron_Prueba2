package cgConsoleApp;

import java.util.Scanner;

public class cgAutenticacion {
    
    private final String usuario = "patmic";
    private final String clave = "123";
    private final int intentos = 3;

    private static final String COLOR_RESET = "\u001B[0m";
    private static final String COLOR_RED = "\u001B[31m";
    private static final String COLOR_GREEN = "\u001B[32m";
    private static final String COLOR_YELLOW = "\u001B[33m";
    private static final String COLOR_CYAN = "\u001B[36m";

    /**
     * Solicita autenticación al usuario con máximo 3 intentos
     * @return true si las credenciales son correctas, false si se agotan los intentos
     */
    public boolean solicitarAutenticacion() {

        Scanner sc = new Scanner(System.in);
        int intentosRealizados = 0;

        System.out.println(COLOR_CYAN + "\n╔══════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE AUTENTICACIÓN       ║");
        System.out.println("╚══════════════════════════════════════╝" + COLOR_RESET);

        while (intentosRealizados < this.intentos) {
            System.out.println("\n" + COLOR_YELLOW + "Ingrese sus credenciales" + COLOR_RESET);
            System.out.print("Usuario: ");
            String usuarioIngresado = sc.nextLine();
            
            System.out.print("Clave: ");
            String claveIngresada = sc.nextLine();

            // Verificamos las credenciales
            if (usuarioIngresado.equals(this.usuario) && claveIngresada.equals(this.clave)) {
                System.out.println(COLOR_GREEN + "\n Credenciales correctas. ¡Bienvenido!" + COLOR_RESET);
                presentarDatos();
                return true;
            } else {
                intentosRealizados += 1;
                int intentosRestantes = this.intentos - intentosRealizados;
                
                System.out.println(COLOR_RED + " Credenciales incorrectas." + COLOR_RESET);
                if (intentosRestantes > 0) {
                    System.out.println(COLOR_YELLOW + "  Te quedan " + intentosRestantes + " intento(s)." + COLOR_RESET);
                }
            }
        }

        System.out.println(COLOR_RED + "\n╔══════════════════════════════════════╗");
        System.out.println("║  ACCESO DENEGADO - SISTEMA CERRADO   ║");
        System.out.println("╚══════════════════════════════════════╝" + COLOR_RESET);
        return false;
    }

    /**
     * Presenta los datos de los integrantes del equipo
     */
    public void presentarDatos() {
        System.out.println(COLOR_CYAN + "\n┌──────────────┬─────────────────────┐");
        System.out.println("│   Cédula     │       Nombre        │");
        System.out.println("├──────────────┼─────────────────────┤");
        System.out.println("│ 1756172894   │ Chicaiza Erick      │");
        System.out.println("│ 1750750018   │ Jhostin Garcia      │");
        System.out.println("└──────────────┴─────────────────────┘" + COLOR_RESET);
    }
}
