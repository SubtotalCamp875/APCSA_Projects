package Battleship;

import java.util.ArrayList;

public class Configs {
    // player and indexes constants
    public static String DEFAULT_BOT_NAME = "Bot";
    public static String DEFAULT_PLAYER_NAME = "Player";
    public static String[] ALPHABETS = {" ", "A","B","C","D","E","F","G",
        "H","I","J","K","L", "M","N","O","P","Q","R","S","T","U","V","W",
        "X","Y","Z"};
    public static int DEFAULT_PLAYER_COUNT = 2;
    public static final int ROW = 0;
    public static final int COL = 1;
    
    // board defaults
    public static int DEFAULT_SIZE_X = 11;
    public static int DEFAULT_SIZE_Y = 11;
    public static final String EMPTY = "-";
    public static final String SPACE                    = Color.BLUE + " | "    + Color.RESET;
    public static final String HORIZONTAL_SPACE         = Color.BLUE + "----"   + Color.RESET;
    public static final String HEADING_SPACE            = Color.BLUE + "===="   + Color.RESET;
    public static final String SINGLE_SPACE             = Color.BLUE + " "      + Color.RESET;
    public static final String SINGLE_HORIZONTAL_SPACE  = Color.BLUE + "-"      + Color.RESET;
    public static final String SINGLE_HEADING_SPACE     = Color.BLUE + "="      + Color.RESET;
    public static final String BOARD_LEFT               = Color.BLUE + "["      + Color.RESET;
    public static final String BOARD_RIGHT              = Color.BLUE + " ]"     + Color.RESET;
    public static final String HIT  = "𓊝";
    public static final String MISS = "M";
    
    // ship constants
    public static final int NAME_INDEX      = 0;
    public static final int SYMBOL_INDEX    = 1;
    public static final int SIZE_INDEX      = 2;
    public static final String DEFAULT_SHIP_NAME     = "Ship";
    public static final String DEFAULT_SHIP_SYMBOL   = "N";
    public static final String[] DEFAULT_SHIP   = {DEFAULT_SHIP_NAME, DEFAULT_SHIP_SYMBOL};
    public static final String[][] NAMES = {
        DEFAULT_SHIP, 
        DEFAULT_SHIP, 
        {"Patrol", "P"}, 
        {"Submarine", "S"}, 
        {"Battleship", "B"}, 
        {"Carrier", "C"}, 
    };
    public static final String[][] ALT_NAMES = {
        DEFAULT_SHIP, 
        DEFAULT_SHIP, 
        DEFAULT_SHIP, 
        {"Destoryer", "D"}, 
        DEFAULT_SHIP, 
        DEFAULT_SHIP, 
    };
    private static final ArrayList<String[]> DEFAULT_LINEUP = new ArrayList<>() {{
        add(new String[] {NAMES[2][NAME_INDEX], NAMES[2][SYMBOL_INDEX], "2", "normal"}); 
        add(new String[] {NAMES[3][NAME_INDEX], NAMES[3][SYMBOL_INDEX], "3", "normal"});
        add(new String[] {ALT_NAMES[3][NAME_INDEX], ALT_NAMES[3][SYMBOL_INDEX], "3", "alternate"});
        add(new String[] {NAMES[4][NAME_INDEX], NAMES[4][SYMBOL_INDEX], "4", "normal"});
        add(new String[] {NAMES[5][NAME_INDEX], NAMES[5][SYMBOL_INDEX], "5", "normal"});
    }};
    
    // time defaults
    //public static final int DEFAULT_TYPE_TIME = 4;
    //public static final int DEFAULT_WAIT_TIME = 1000;
    //public static final int DEFAULT_LOAD_TIME = 5000;
    public static final int DEFAULT_TYPE_TIME = 0;
    public static final int DEFAULT_WAIT_TIME = 0;
    public static final int DEFAULT_LOAD_TIME = 0;

    
    // non constant variables
    private static int playerCount  = Configs.DEFAULT_PLAYER_COUNT;
    private static int boardSizeX   = Configs.DEFAULT_SIZE_X;
    private static int boardSizeY   = Configs.DEFAULT_SIZE_Y;
    private static int typingTime   = Configs.DEFAULT_TYPE_TIME;
    private static int waitTime     = Configs.DEFAULT_WAIT_TIME;
    private static int loadTime     = Configs.DEFAULT_LOAD_TIME;
    private static ArrayList<String[]> lineup = Configs.DEFAULT_LINEUP;
    
    public static int getPlayerCount() {
        return playerCount;
    };
    
    public static int getBoardSizeX() {
        return boardSizeX;
    };
    
    public static int getBoardSizeY() {
        return boardSizeY;
    };
    
    public static int getTypingTime() {
        return typingTime;
    };
    
    public static int getWaitTime() {
        return waitTime;
    };
    
    public static int getLoadTime() {
        return loadTime;
    };
    
    public static int getLineupSize() {
        int total = 0;
        for (String[] ship: lineup) {
            total = Integer.parseInt(ship[SIZE_INDEX]);
        }
        return total;
    };
    
    public static ArrayList<String[]> getLineup() {
        return lineup;
    };
    
    
    public static void setPlayerCount(int value) {
        playerCount = value;
    };
    
    public static void setBoardSizeX(int value) {
        boardSizeX = value;
    };
    
    public static void setBoardSizeY(int value) {
        boardSizeY = value;
    };
    
    public static void setTypingTime(int value) {
        typingTime = value;
    };
    
    public static void setWaitTime(int value) {
        waitTime = value;
    };
    
    public static void setLoadTime(int value) {
        loadTime = value;
    };
    
    public static void setLineup(ArrayList<String[]> field) {
        lineup = field;
    };
    
    public static void addLineup(String[] ship) {
        lineup.add(ship);
    };
    
    public static void resetLineup() {
        lineup = DEFAULT_LINEUP;
    };
    
}