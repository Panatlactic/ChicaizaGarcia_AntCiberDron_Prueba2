package cgUtility;

public class cgTool {

    public static final String GJ_COLOR_RESET  = "\u001B[0m";
    public static final String GJ_COLOR_RED    = "\u001B[31m";
    public static final String GJ_COLOR_BLUE   = "\u001B[34m";

    /**
     * 
     * 
     */
    public static void gjShowSpinner() {
        int gjIndex;
        String gjColor = GJ_COLOR_BLUE; 
        String gjAnimation = "|/-\\"; 
        
        for (int gjI = 0; gjI <= 100; gjI++) {
            gjIndex = gjI % gjAnimation.length();
            System.out.print("\r" + gjColor + gjAnimation.charAt(gjIndex) + " " + gjI + "%" + GJ_COLOR_RESET);
            try {
                Thread.sleep(1); 
            } catch (InterruptedException gjException) {
                System.out.println(gjException.getMessage());
            }
        }
    }

    /**
     * 
     * 
     * 
     */
    public static void gjShowWaiting() {
        String gjColor = GJ_COLOR_RED;
        String[] gjAnimation = {"o0o", "0o0", "o0o", "0o0"}; // Ida y vuelta
        
        for (int gjI = 0; gjI <= 100; gjI++) {
            int gjIndex = gjI % gjAnimation.length;
            System.out.print("\r" + gjColor + gjAnimation[gjIndex] + " " + gjI + "%" + GJ_COLOR_RESET);
            try {
                Thread.sleep(1); 
            } catch (InterruptedException gjException) {
                System.out.println(gjException.getMessage());
            }
        }
    }
}