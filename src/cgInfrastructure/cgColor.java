package cgInfrastructure;

public class cgColor {
    // Reset
    public static final String CE_RESET = "\033[0m";       // Text Reset

    // Regular Colors
    public static final String CE_BLACK = "\033[0;30m";   // BLACK
    public static final String CE_RED = "\033[0;31m";     // RED
    public static final String CE_GREEN = "\033[0;32m";   // GREEN
    public static final String CE_YELLOW = "\033[0;33m";  // YELLOW
    public static final String CE_BLUE = "\033[0;34m";    // BLUE
    public static final String CE_PURPLE = "\033[0;35m";  // PURPLE
    public static final String CE_CYAN = "\033[0;36m";    // CYAN
    public static final String CE_WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String CE_BOLD_BLACK = "\033[1;30m";  // BLACK
    public static final String CE_BOLD_RED = "\033[1;31m";    // RED
    public static final String CE_BOLD_GREEN = "\033[1;32m";  // GREEN
    public static final String CE_BOLD_YELLOW = "\033[1;33m"; // YELLOW
    public static final String CE_BOLD_BLUE = "\033[1;34m";   // BLUE
    public static final String CE_BOLD_PURPLE = "\033[1;35m"; // PURPLE
    public static final String CE_BOLD_CYAN = "\033[1;36m";   // CYAN
    public static final String CE_BOLD_WHITE = "\033[1;37m";  // WHITE

    // Underline
    public static final String CE_UNDERLINED_BLACK = "\033[4;30m";  // BLACK
    public static final String CE_UNDERLINED_RED = "\033[4;31m";    // RED
    public static final String CE_UNDERLINED_GREEN = "\033[4;32m";  // GREEN
    public static final String CE_UNDERLINED_YELLOW = "\033[4;33m"; // YELLOW
    public static final String CE_UNDERLINED_BLUE = "\033[4;34m";   // BLUE
    public static final String CE_UNDERLINED_PURPLE = "\033[4;35m"; // PURPLE
    public static final String CE_UNDERLINED_CYAN = "\033[4;36m";   // CYAN
    public static final String CE_UNDERLINED_WHITE = "\033[4;37m";  // WHITE

    // Background
    public static final String CE_BACKGROUND_BLACK = "\033[40m";  // BLACK
    public static final String CE_BACKGROUND_RED = "\033[41m";    // RED
    public static final String CE_BACKGROUND_GREEN = "\033[42m";  // GREEN
    public static final String CE_BACKGROUND_YELLOW = "\033[43m"; // YELLOW
    public static final String CE_BACKGROUND_BLUE = "\033[44m";   // BLUE
    public static final String CE_BACKGROUND_PURPLE = "\033[45m"; // PURPLE
    public static final String CE_BACKGROUND_CYAN = "\033[46m";   // CYAN
    public static final String CE_BACKGROUND_WHITE = "\033[47m";  // WHITE

    // High Intensity
    public static final String CE_BRIGHT_BLACK = "\033[0;90m";  // BLACK
    public static final String CE_BRIGHT_RED = "\033[0;91m";    // RED
    public static final String CE_BRIGHT_GREEN = "\033[0;92m";  // GREEN
    public static final String CE_BRIGHT_YELLOW = "\033[0;93m"; // YELLOW
    public static final String CE_BRIGHT_BLUE = "\033[0;94m";   // BLUE
    public static final String CE_BRIGHT_PURPLE = "\033[0;95m"; // PURPLE
    public static final String CE_BRIGHT_CYAN = "\033[0;96m";   // CYAN
    public static final String CE_BRIGHT_WHITE = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String CE_BOLD_BRIGHT_BLACK = "\033[1;90m"; // BLACK
    public static final String CE_BOLD_BRIGHT_RED = "\033[1;91m";   // RED
    public static final String CE_BOLD_BRIGHT_GREEN = "\033[1;92m"; // GREEN
    public static final String CE_BOLD_BRIGHT_YELLOW = "\033[1;93m";// YELLOW
    public static final String CE_BOLD_BRIGHT_BLUE = "\033[1;94m";  // BLUE
    public static final String CE_BOLD_BRIGHT_PURPLE = "\033[1;95m";// PURPLE
    public static final String CE_BOLD_BRIGHT_CYAN = "\033[1;96m";  // CYAN
    public static final String CE_BOLD_BRIGHT_WHITE = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String CE_BACKGROUND_BRIGHT_BLACK = "\033[0;100m";// BLACK
    public static final String CE_BACKGROUND_BRIGHT_RED = "\033[0;101m";// RED
    public static final String CE_BACKGROUND_BRIGHT_GREEN = "\033[0;102m";// GREEN
    public static final String CE_BACKGROUND_BRIGHT_YELLOW = "\033[0;103m";// YELLOW
    public static final String CE_BACKGROUND_BRIGHT_BLUE = "\033[0;104m";// BLUE
    public static final String CE_BACKGROUND_BRIGHT_PURPLE = "\033[0;105m"; // PURPLE
    public static final String CE_BACKGROUND_BRIGHT_CYAN = "\033[0;106m";  // CYAN
    public static final String CE_BACKGROUND_BRIGHT_WHITE = "\033[0;107m";   // WHITE

    private cgColor() {}
    
    /**
     * Clears the console screen
     */
   public static void CEclearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
