package Battleship;

import java.util.Scanner;
import java.util.ArrayList;

public class Settings {
    private static Scanner scanner;
    
    
    private static void init() {
        scanner = new Scanner(System.in);
    }
    
    
    public static void start() {
        init();
        boolean warning = false;
        
        while (true) {
            if (warning) {
                GUI.invalidSyntax();
            } else {
                GUI.settingsMenu();
            }
            warning = false;
            String input = scanner.nextLine().replace(" ", "");
        
            switch (input) {
                case "1":
                    updatePlayerCount();
                    break;
                case "2":
                    updateBoardSizeX();
                    break;
                case "3":
                    updateBoardSizeY();
                    break;
                case "4":
                    updateTypingTime();
                    break;
                case "5":
                    updateWaitTime();
                    break;
                case "6":
                    updateLoadTime();
                    break;
                case "7":
                    updateLineup();
                    break;
                case "8":
                    return;
                default:
                    warning = true;
            }
        }
    }
    
    private static void updatePlayerCount() {
        GUI.askUpdatePlayerCount();
        while (true) {
            String input = scanner.nextLine();
            
            if (!isValidPlayerCount(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            Configs.setPlayerCount(Integer.parseInt(input));
            return;
        }
    }
    
    private static void updateBoardSizeX() {
        GUI.askUpdateBoardSizeX();
        while (true) {
            String input = scanner.nextLine();
            
            if (!isValidBoardSizeX(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            Configs.setBoardSizeX(Integer.parseInt(input) + 1);
            return;
        }
    }
    
    private static void updateBoardSizeY() {
        GUI.askUpdateBoardSizeY();
        while (true) {
            String input = scanner.nextLine();
            
            if (!isValidBoardSizeY(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            Configs.setBoardSizeY(Integer.parseInt(input) + 1);
            return;
        }
    }
    
    private static void updateTypingTime() {
        GUI.millisecondConversion();
        GUI.askUpdateTypingTime();
        while (true) {
            String input = scanner.nextLine();
            
            if (!isValidTypingTime(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            Configs.setTypingTime(Integer.parseInt(input));
            return;
        }
    }
    
    private static void updateWaitTime() {
        GUI.millisecondConversion();
        GUI.askUpdateWaitTime();
        while (true) {
            String input = scanner.nextLine();
            
            if (!isValidWaitTime(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            Configs.setWaitTime(Integer.parseInt(input));
            return;
        }
    }
    
    private static void updateLoadTime() {
        GUI.millisecondConversion();
        GUI.askUpdateLoadTime();
        while (true) {
            String input = scanner.nextLine();
            
            if (!isValidLoadTime(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            Configs.setLoadTime(Integer.parseInt(input));
            return;
        }
    }
    
    private static void updateLineup() {
        boolean warning = false;
        
        // gets input in the lineup menu
        while (true) {
            if (warning) {
                GUI.invalidSyntax();
            } else {
                GUI.printCurrentLineup();
                GUI.lineupMenu();
            }
            warning = false;
            
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    Configs.setLineup(new ArrayList<>());
                    GUI.clearSuccess();
                    break;
                case "2":
                    if (Configs.getLineupSize() > (Configs.getBoardSizeX() * Configs.getBoardSizeY() / 2)) {
                        GUI.warnSizeLimitReached();
                    } else {
                        lineupAddShip();  
                    }
                    break;
                case "3":
                    Configs.resetLineup();
                    GUI.resetSuccess();
                    break;
                case "4":
                    if (Configs.getLineup().size() == 0) {
                        GUI.invalidLineupWarning();
                        continue;
                    }
                    return;
                default:
                    warning = true;
            }
        }
    }
    
    private static void lineupAddShip() {
        // gets name
        GUI.askShipName();
        String shipName = scanner.nextLine();
        if (shipName.replace(" ", "").length() == 0) {
            shipName = Configs.DEFAULT_SHIP_NAME;
        }
        
        // gets symbol
        GUI.askShipSymbol();
        String shipSymbol;
        while (true) {
            shipSymbol = scanner.nextLine().replace(" ", "").toUpperCase();
            
            if (shipSymbol.length() == 0) {
                shipSymbol = Configs.DEFAULT_SHIP_SYMBOL;
            } else if (shipSymbol.length() >= 2) {
                GUI.invalidSyntax();
                continue;
            }
            break;
        }
        
        // gets size
        GUI.askShipSize();
        String shipSize;
        while (true) {
            shipSize = scanner.nextLine().replace(" ", "");
            
            // checks for numberical value
            if (!isNumber(shipSize)) {
                GUI.invalidSyntax();
                continue;
            }
            
            // checks if ship can fit on the board
            int size = Integer.parseInt(shipSize);
            if (size >= Math.max(Configs.getBoardSizeX(), Configs.getBoardSizeY())
                || size <= 0) {
                GUI.invalidLength();
                continue;
            }
            break;
        }
        
        Configs.addLineup(new String[] {shipName, shipSymbol, shipSize, "normal"});
    }
    
    
    // validations
    private static boolean isValidPlayerCount(String input) {
        if (!isNumber(input)) {
            return false;
        }
        
        int value = Integer.parseInt(input);
        if (value >= 2) {
            return true;
        }
        return false;
    }
    
    private static boolean isValidBoardSizeX(String input) {
        if (!isNumber(input)) {
            return false;
        }
        
        int value = Integer.parseInt(input);
        if (value >= 5 && value <= 26) {
            return true;
        }
        return false;
    }
    
    private static boolean isValidBoardSizeY(String input) {
        if (!isNumber(input)) {
            return false;
        }
        
        int value = Integer.parseInt(input);
        if (value >= 5 && value <= 26) {
            return true;
        }
        return false;
    }
    
    private static boolean isValidTypingTime(String input) {
        if (!isNumber(input)) {
            return false;
        }
        
        int value = Integer.parseInt(input);
        if (value >= 0) {
            return true;
        }
        return false;
    }
    
    private static boolean isValidWaitTime(String input) {
        if (!isNumber(input)) {
            return false;
        }
        
        int value = Integer.parseInt(input);
        if (value >= 0) {
            return true;
        }
        return false;
    }
    
    private static boolean isValidLoadTime(String input) {
        if (!isNumber(input)) {
            return false;
        }
        
        int value = Integer.parseInt(input);
        if (value >= 0) {
            return true;
        }
        return false;
    }
    
    
    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}