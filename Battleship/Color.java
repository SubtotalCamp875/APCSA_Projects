package Battleship;

public class Color {
    public static final String ESC = "\u001B";
    public static final String RESET   = ESC + "[0m";
    
    public static final String BOLD    = ESC + "[1m";
     
    public static final String BLACK    = BOLD + ESC + "[30m";
    public static final String RED	    = BOLD + ESC + "[31m";
    public static final String GREEN    = BOLD + ESC + "[32m";
    public static final String YELLOW   = BOLD + ESC + "[33m";
    public static final String BLUE     = BOLD + ESC + "[34m";
    public static final String PURPLE   = BOLD + ESC + "[35m";
    public static final String CYAN     = BOLD + ESC + "[36m";
    public static final String WHITE    = BOLD + ESC + "[37m";
    public static final String BLACK_BG     = ESC + "[40m";
    public static final String RED_BG	    = ESC + "[41m";
    public static final String GREEN_BG     = ESC + "[42m";
    public static final String YELLOW_BG    = ESC + "[43m";
    public static final String BLUE_BG	    = ESC + "[44m";
    public static final String PURPLE_BG    = ESC + "[45m";
    public static final String CYAN_BG	    = ESC + "[46m";
    public static final String WHITE_BG     = ESC + "[47m";
}