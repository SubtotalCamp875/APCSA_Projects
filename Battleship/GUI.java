package Battleship;

import java.lang.Thread;
import java.util.ArrayList;

public class GUI {
    // breaks
    public static void lineBreak() {
        System.out.println();
    }
    
    public static void pageBreak() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    public static void turnBreak() {
        System.out.println("\n\n=====================================\n\n");
    }
    
    // syntax
    public static void invalidPlacement() {
        System.out.print("You can not place the ship there, please try again: ");
    }
    
    public static void invalidTile() {
        System.out.print("You can not select that tile, please try again: ");
    }
    
    public static void invalidLength() {
        System.out.print("The ship can not be longer than the board, please try again: ");
    }
    
    public static void invalidSyntax() {
        System.out.print("Invalid Syntax, please try again: ");
    }
    
    public static void backSyntax() {
        System.out.println("Enter \"back\" to go to the previous question!");
    }
    
    public static void continueSyntax() {
        System.out.println("Press " + Color.GREEN + "[Enter]" + Color.RESET + " to continue");
    }
    
    public static void loading() {
        typeWriter("Preparing next turn, please wait...");
    }
    
    public static void clearSuccess() {
        typeWriter("Successfully Cleared!\n");
    }
    
    public static void resetSuccess() {
        typeWriter("Successfully Reseted!\n");
    }
    
    public static void botName() {
        typeWriter("To play against AI, type \"bot\" for the name\n");
    }
    
    public static void invalidLineupWarning() {
        typeWriter(Color.RED + "There must be at least 1 ship in the lineup!\n" + Color.RESET);
    }
    
    public static void warnSizeLimitReached() {
        typeWriter(Color.RED + "Your lineup takes up more than half the board, you can not add any more ships\n" + Color.RESET);
    }
    
    public static void warning() {
        System.out.println(Color.RED);
        System.out.println("========================================");
        System.out.println("Warning: For optimal viewing experience,"); 
        System.out.println("    please set the console to dark mode");
        System.out.println("    and enter full screen");
        System.out.println("========================================");
        System.out.println(Color.RESET);
    }
    
    // menus
    public static void welcome() {
        System.out.println(Color.RESET);
        System.out.println();
        System.out.println(" ▄▄▌ ▐ ▄▌▄▄▄ .▄▄▌   ▄▄·       • ▌ ▄ ·. ▄▄▄ .  ▄▄▄▄▄        ");
        System.out.println(" ██· █▌▐█▀▄.▀·██•  ▐█ ▌▪ ▄█▀▄ ·██ ▐███▪▀▄.▀·  •██   ▄█▀▄   ");
        System.out.println(" ██▪▐█▐▐▌▐▀▀▪▄██▪  ██ ▄▄▐█▌.▐▌▐█ ▌▐▌▐█·▐▀▀▪▄   ▐█.▪▐█▌.▐▌  ");
        System.out.println(" ▐█▌██▐█▌▐█▄▄▌▐█▌▐▌▐███▌▐█▌.▐▌██ ██▌▐█▌▐█▄▄▌   ▐█▌·▐█▌.▐▌  ");
        System.out.println("  ▀▀▀▀ ▀▪ ▀▀▀ .▀▀▀ ·▀▀▀  ▀█▄▀▪▀▀  █▪▀▀▀ ▀▀▀    ▀▀▀  ▀█▄▀▪  ");
        System.out.println();
        System.out.println();
        System.out.println(" ▄▄▄▄    ▄▄▄     ▄▄▄█████▓▄▄▄█████▓ ██▓    ▓█████   ██████  ██░ ██  ██▓ ██▓███   ▐██▌ ");
        System.out.println("▓█████▄ ▒████▄   ▓  ██▒ ▓▒▓  ██▒ ▓▒▓██▒    ▓█   ▀ ▒██    ▒ ▓██░ ██▒▓██▒▓██░  ██▒ ▐██▌ ");
        System.out.println("▒██▒ ▄██▒██  ▀█▄ ▒ ▓██░ ▒░▒ ▓██░ ▒░▒██░    ▒███   ░ ▓██▄   ▒██▀▀██░▒██▒▓██░ ██▓▒ ▐██▌ ");
        System.out.println("▒██░█▀  ░██▄▄▄▄██░ ▓██▓ ░ ░ ▓██▓ ░ ▒██░    ▒▓█  ▄   ▒   ██▒░▓█ ░██ ░██░▒██▄█▓▒ ▒ ▓██▒ ");
        System.out.println("░▓█  ▀█▓ ▓█   ▓██▒ ▒██▒ ░   ▒██▒ ░ ░██████▒░▒████▒▒██████▒▒░▓█▒░██▓░██░▒██▒ ░  ░ ▒▄▄  ");
        System.out.println("░▒▓███▀▒ ▒▒   ▓▒█░ ▒ ░░     ▒ ░░   ░ ▒░▓  ░░░ ▒░ ░▒ ▒▓▒ ▒ ░ ▒ ░░▒░▒░▓  ▒▓▒░ ░  ░ ░▀▀▒ ");
        System.out.println("▒░▒   ░   ▒   ▒▒ ░   ░        ░    ░ ░ ▒  ░ ░ ░  ░░ ░▒  ░ ░ ▒ ░▒░ ░ ▒ ░░▒ ░      ░  ░ ");
        System.out.println(" ░    ░   ░   ▒    ░        ░        ░ ░      ░   ░  ░  ░   ░  ░░ ░ ▒ ░░░           ░ ");
        System.out.println(" ░            ░  ░                     ░  ░   ░  ░      ░   ░  ░  ░ ░            ░    ");
        System.out.println("      ░                                                                               ");
        System.out.println();
        System.out.println();
    }
    
    public static void mainMenu() {
        typeWriter(Color.PURPLE + "\n\nMain Menu " + Color.RESET);
        typeWriter("\n=========\n");
        typeWriter(Color.PURPLE + "1.)" + Color.RESET + " Play\n");
        typeWriter(Color.PURPLE + "2.)" + Color.RESET + " Settings\n");
        typeWriter(Color.PURPLE + "3.)" + Color.RESET + " Exit\n");
        System.out.print("What would you like to do? ");
    }
    
    public static void settingsMenu() {
        typeWriter(Color.YELLOW + "\n\nSettings" + Color.RESET);
        typeWriter("\n=========\n");
        typeWriter(Color.YELLOW + "1.) " + Color.RESET + "Player Count = " + Color.CYAN + Configs.getPlayerCount() + Color.RESET + "\n");
        typeWriter(Color.YELLOW + "2.) " + Color.RESET + "Board Size X = " + Color.CYAN + (Configs.getBoardSizeX() - 1) + Color.RESET + "\n");
        typeWriter(Color.YELLOW + "3.) " + Color.RESET + "Board Size Y = " + Color.CYAN + (Configs.getBoardSizeY() - 1) + Color.RESET + "\n");
        typeWriter(Color.YELLOW + "4.) " + Color.RESET + "Type Writer Speed = " + Color.CYAN + Configs.getTypingTime() + Color.RESET + "\n");
        typeWriter(Color.YELLOW + "5.) " + Color.RESET + "Wait Time = " + Color.CYAN + Configs.getWaitTime() + Color.RESET + "\n");
        typeWriter(Color.YELLOW + "6.) " + Color.RESET + "Turn Load Time = " + Color.CYAN + Configs.getLoadTime() + Color.RESET + "\n");
        typeWriter(Color.YELLOW + "7.) " + Color.RESET + "Change Ship Lineup\n");
        typeWriter(Color.YELLOW + "8.) " + Color.RESET + "Save\n");

        typeWriter("What would you like to change? ");
    }
    
    public static void lineupMenu() {
        typeWriter(Color.GREEN + "\nOptions" + Color.RESET);
        typeWriter("\n=========\n");
        typeWriter(Color.GREEN + "1.) " + Color.RESET + "Clear Lineup\n");
        typeWriter(Color.GREEN + "2.) " + Color.RESET + "Add Ship\n");
        typeWriter(Color.GREEN + "3.) " + Color.RESET + "Reset to Default\n");
        typeWriter(Color.GREEN + "4.) " + Color.RESET + "Done\n");

        typeWriter("What would you like to do? ");
    }
    
    // settings
    public static void millisecondConversion() {
        typeWriter(Color.PURPLE + "Note: 1000 millisecond = 1 second\n" + Color.RESET);
    }
    public static void askUpdatePlayerCount() {
        typeWriter("Enter a value for " + Color.CYAN + "Player Count" + Color.RESET + " (Min = 2): ");
    }
    public static void askUpdateBoardSizeX() {
        typeWriter("Enter a value for " + Color.CYAN + "Board Size X" + Color.RESET + " (Min = 5, Max = 26): ");
    }
    public static void askUpdateBoardSizeY() {
        typeWriter("Enter a value for " + Color.CYAN + "Board Size Y" + Color.RESET + " (Min = 5, Max = 26): ");
    }
    public static void askUpdateTypingTime() {
        typeWriter("Enter a value for " + Color.CYAN + "Typing Time" + Color.RESET + " in milliseconds (Min = 0): ");
    }
    public static void askUpdateWaitTime() {
        typeWriter("Enter a value for " + Color.CYAN + "Wait Time" + Color.RESET + " in milliseconds (Min = 0): ");
    }
    public static void askUpdateLoadTime() {
        typeWriter("Enter a value for " + Color.CYAN + "Load Time" + Color.RESET + " in milliseconds (Min = 0): ");
    }
    
    // lineups
    public static void askShipName() {
        typeWriter("What is the ships name? ");
    }
    public static void askShipSymbol() {
        typeWriter("What is the ships symbol (single character)? ");
    }
    public static void askShipSize() {
        typeWriter("How long is the ship? ");
    }
    
    // play
    public static void askPlayerName(int number) {
        typeWriter(Color.YELLOW + "Player " + number + Color.RESET + ", what is your name? ");
    }
    
    public static void printStartPlacingShip(String name) {
        typeWriter(Color.YELLOW + name + Color.RESET + ", please start placing your ships now.\n");
        typeWriter("All other players, look away!\n");
    }
    
    public static void askShipPlacement(String shipName, int size) {
        typeWriter("Where would you like your " + Color.PURPLE + shipName + " (" + size + ")" + Color.RESET + "? ");
    }
    
    public static void toggleHorizontal(boolean isHorizontal) {
        typeWriter("Press " + Color.GREEN + "[Enter]" + Color.RESET + " to continue OR type " + Color.GREEN + "[T]" + Color.RESET + " to toggle: ");
    }
    
    public static void printIsHorizontalState(boolean isHorizontal) {
        if (isHorizontal) {
            typeWriter("Current Rotation:" + Color.YELLOW + " Horizontal\n" + Color.RESET);
        } else {
            typeWriter("Current Rotation:" + Color.YELLOW + " Vertical\n" + Color.RESET);
        }
    }
    
    public static void printCreateSuccess() {
        System.out.println(Color.GREEN);
        System.out.println("All players has successfully place all their ships.");
        System.out.print("May the battles commence!");
        System.out.print(Color.RESET);
    }
    
    public static void printAttacking(Board attacker, Board defender) {
        printAttacking(attacker.getName(), defender.getName());
    }
    
    public static void printAttacking(String attacker, String defender) {
        typeWriter(Color.YELLOW + attacker + Color.RESET + ", it is now your turn. You are attacking " + Color.YELLOW + defender + Color.RESET + "\n");
    }
    
    public static void askCoords() {
        typeWriter("Enter a coordinate to attack: ");
    }
    
    public static void botSelectedTile(String row, int col) {
        typeWriter("The Bot selected " + Color.RED + row + col + Color.RESET + "\n");
    }
    
    public static void botToggle(boolean toggle) {
        if (toggle) {
            typeWriter("T\n");
        } else {
            typeWriter("\n");
        }
    }
    
    public static void printHitResult(Boolean isHit) {
        if (isHit) {
            typeWriter(Color.GREEN + "DICRECT HIT!\n" + Color.RESET);
        } else {
            typeWriter(Color.RED + "You did not hit a ship...\n" + Color.RESET);
        }
    }
    
    public static void printSunkShip(String name) {
        typeWriter(Color.PURPLE + name + Color.RESET + " has been sunk!\n");
    }
    
    public static void printNoShipsSunk() {
        typeWriter(Color.PURPLE + "You have not sunk any ships\n" + Color.RESET);
    }
    
    public static void printScore(int score) {
        System.out.println("Your score is: " + Color.GREEN + score + Color.RESET);
    }
    
    public static void printTotalTurns(int turns) {
        System.out.println("Total turns played: " + Color.PURPLE + turns + Color.RESET);
    }
    
    public static void congrats(String winner) {
        System.out.println("There are no other players left...");
        System.out.println(Color.GREEN + "Congrats " + winner.toUpperCase() + ", you are the last captain standing!" + Color.RESET);
    }   
    
    public static void exit() {
        System.out.println();
        System.out.println();
        System.out.println("░▀▀█▀▀░▒█░▒█░█▀▀▄░▒█▄░▒█░▒█░▄▀░▒█▀▀▀█░░░▒█▀▀▀░▒█▀▀▀█░▒█▀▀▄░░");
        System.out.println("░░▒█░░░▒█▀▀█▒█▄▄█░▒█▒█▒█░▒█▀▄░░░▀▀▀▄▄░░░▒█▀▀░░▒█░░▒█░▒█▄▄▀░░");
        System.out.println("░░▒█░░░▒█░▒█▒█░▒█░▒█░░▀█░▒█░▒█░▒█▄▄▄█░░░▒█░░░░▒█▄▄▄█░▒█░▒█░░");
        System.out.println();
        System.out.println("░▒█▀▀█░▒█░░░░█▀▀▄░▒█░░▒█░▀█▀░▒█▄░▒█░▒█▀▀█░░");
        System.out.println("░▒█▄▄█░▒█░░░▒█▄▄█░▒▀▄▄▄▀░▒█░░▒█▒█▒█░▒█░▄▄░░");
        System.out.println("░▒█░░░░▒█▄▄█▒█░▒█░░░▒█░░░▄█▄░▒█░░▀█░▒█▄▄▀░░");


    }
    
    // arrays
    public static void printArray(Board board, String[][] arr) {
        lineBreak();
        printTitle(arr);
            
        // body
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // left boarder
                if (j == 0) {
                    System.out.print(Configs.BOARD_LEFT + " ");
                    System.out.print(Color.PURPLE + arr[i][j] + Color.RESET);
                }
                
                // print tiles
                // is ship is hit but not sunk
                else if (arr[i][j] == Configs.HIT && board.getShipHealth(i, j) > 0) {
                    System.out.print(Color.YELLOW + arr[i][j] + Color.RESET);   
                
                // if ship is sunk
                } else if (arr[i][j] == Configs.HIT && board.getShipHealth(i, j) == 0) {
                    System.out.print(Color.GREEN + arr[i][j] + Color.RESET);
                
                // if miss
                } else if (arr[i][j] == Configs.MISS) {
                    System.out.print(Color.RED + arr[i][j] + Color.RESET);
                
                // empty tile
                } else {
                    System.out.print(Color.RESET + arr[i][j]);
                }
                
                
                // vertical spacing
                if (j >= 10) {
                    System.out.print(" ");
                }
                System.out.print(Configs.SPACE);
            }
            System.out.println();
            type();
            horizontalBreak(arr);
            type();
        }
        
        lineBreak();
    }
    
    private static void printTitle(String[][] arr) {
        titleBreak(arr);
        type();
        System.out.print(Configs.BOARD_LEFT);
        
        for (int i = 0; i < arr[0].length; i++) {
            if (i == 0) {
                System.out.print(" ");
            }
            System.out.print(Color.CYAN + arr[0][i]);
            System.out.print(Configs.SPACE);
        }
        
        System.out.println();
        type();
        titleBreak(arr);
        type();
    }
    
    private static void titleBreak(String[][] arr) {
        System.out.print(Configs.BOARD_LEFT);
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print(Configs.HEADING_SPACE);
            if (i >= 10) {
                System.out.print(Configs.SINGLE_HEADING_SPACE);
            }
        }
        System.out.println();
    }
    
    private static void horizontalBreak(String[][] arr) {
        System.out.print(Configs.BOARD_LEFT);
        for (int i = 0; i < arr[0].length; i++) {
            System.out.print(Configs.HORIZONTAL_SPACE);
            if (i >= 10) {
                System.out.print(Configs.SINGLE_HORIZONTAL_SPACE);
            }
        }
        System.out.println();
    }
    
    public static void printCurrentLineup() {
        ArrayList<String[]> lineup = Configs.getLineup();
        
        typeWriter(Color.GREEN + "\n\nCurrent Lineup: \n" + Color.RESET);
        for (String[] ship: lineup) {
            typeWriter(Color.PURPLE + ship[Configs.NAME_INDEX] 
                + " (" + ship[Configs.SYMBOL_INDEX] + ")" + Color.RESET 
                + " of size " + Color.BLUE + ship[Configs.SIZE_INDEX] + Color.RESET 
                + "\n");
        }
    }
    
    // typing
    public static void typeWriter(String words) {
        for (int i = 0; i < words.length(); i++) {
            type();
            System.out.print(words.substring(i, i + 1));
        }
    }
    
    private static void type() {
        sleep(Configs.getTypingTime());
    }
    
    private static void sleep(int milli) {
        // 1000 milli = 1 sec
        try {
            Thread.sleep(milli);
        } 
        catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}