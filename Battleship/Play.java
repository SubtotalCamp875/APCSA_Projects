package Battleship;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Thread;


public class Play {
    private static Scanner scanner;
    private static ArrayList<Board> players;
    private static ArrayList<String[]> lineup;
    
    
    private static void init() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
        lineup  = Configs.getLineup();
    }
    
    
    // starts the game
    public static void start() {
        init();
        
        createPlayerBoards();
        sleep();
        createPlayerShips();
        
        sleep();
        GUI.pageBreak();
        GUI.printCreateSuccess();
        GUI.lineBreak();
        sleep();
        
        // main loop
        Board winner = gameLoop();
        
        GUI.congrats(winner.getName());
        GUI.printScore(winner.getScore());
        GUI.lineBreak();
        printStats();
        GUI.continueSyntax();
        scanner.nextLine();
    }
    
    
    /**
     * prints extra stats at the end of each game
     */
    private static void printStats() {
        int totalTurns = 0;
        for (Board player: players) {
            totalTurns += player.getScore();
        }
        
        GUI.printTotalTurns(totalTurns);
    }
    
    
    /**
     * contains all logic for the main turn based gameplay
     * @return - the winning board object at the end of the game
     */
    private static Board gameLoop() {
        int turn = -1;
        int nextTurn;
        while (true) {
            GUI.turnBreak();
            
            // picks next person that can attack
            Board attacker;
            while (true) {
                turn = (turn + 1) % players.size();
                attacker = players.get(turn);
                
                if (attacker.isGameOver()) {
                    continue;
                }
                break;
            }
            
            // picks next person that can defend
            nextTurn = turn;
            Board defender;
            while (true) {
                nextTurn = (nextTurn + 1) % players.size();
                defender = players.get(nextTurn);
                
                if (defender.isGameOver()) {
                    continue;
                
                // game over when no other players can be chosen as a defender
                } else if (defender == attacker) {
                    return attacker;
                }
                break;
            }
            
            // prints board
            GUI.printAttacking(attacker, defender);
            sleep();
            defender.sunkShips();
            sleep();
            defender.printAttackBoard();
            
            // fires at the coords
            GUI.askCoords();
            int[] coordinate = promptCoordinate(attacker, defender);
            boolean isHit = defender.fire(coordinate[Configs.ROW], coordinate[Configs.COL]);
            attacker.increaseScore();
            
            // prints results
            sleep();
            GUI.printHitResult(isHit);
            sleep();
            defender.sunkShips();
            sleep();
            defender.printAttackBoard();
            
            GUI.loading();
            sleep(Configs.getLoadTime());
        }
    }
    
    
    /**
     * get player names and inits boards
     */
    private static void createPlayerBoards() {
        int botCount = 0;
        GUI.lineBreak();
        
        GUI.botName();
        for (int i = 0; i < Configs.getPlayerCount(); i++) {
            GUI.askPlayerName(i + 1);
            
            String name = scanner.nextLine().strip();
            boolean isBot = false;
            
            if (name.equals("")) {
                name = Configs.DEFAULT_PLAYER_NAME;
            } else if (name.toLowerCase().equals("bot")) {
                botCount++;
                name = Configs.DEFAULT_BOT_NAME + " " + botCount;
                isBot = true;
            }
            
            players.add(new Board(Configs.getBoardSizeY(), Configs.getBoardSizeX(), name, isBot));
        }
    }
    

    /**
     * asks the user to place down the ships
     */
    private static void createPlayerShips() {
        // runs the code for every player
        for (Board player: players) {
            GUI.pageBreak();
            GUI.printStartPlacingShip(player.getName());
            GUI.lineBreak();
            
            // runs the code for every ship the player has to place
            for (String[] shipTemplate: lineup) {
                promptPlaceShip(player, shipTemplate);
            }
            
            sleep();
        }
    }
    
    
    /**
     * asks the player for inputs until the ship is successfully placed on the board
     * @param player - the board object that the ships will be placed on
     * @param shipTemplate - the important infomation that is needed to create a ship
     */
    private static void promptPlaceShip(Board player, String[] shipTemplate) {
        // gets user inputs
        boolean isHorizontal = true;
        
        while (true) {
            int nameIndex = 0;
            int sizeIndex = 2;
            int alternateIndex = 3;
            int[] coordinate;
        
            // asks the player for coordinates
            player.printShipBoard();
            sleep();
            GUI.askShipPlacement(shipTemplate[nameIndex], 
            Integer.parseInt(shipTemplate[sizeIndex]));
            
            coordinate = promptCoordinate(player);
            isHorizontal = promptToggleHorizontal(isHorizontal, player.getIsBot());
            sleep();
            
            // creates ship object
            int size = Integer.parseInt(shipTemplate[sizeIndex]);
            int gridRow = coordinate[Configs.ROW];
            int gridCol = coordinate[Configs.COL];
            boolean isAlternate = shipTemplate[alternateIndex].equals("alternate");
            boolean hasShipAdded = player.addShip(
                size, gridRow, gridCol, isHorizontal, isAlternate);
        
            // checks if all inputs are valid and ship is added
            if (gridRow == -1 && gridCol == -1 || !hasShipAdded) {
                GUI.lineBreak();
                GUI.invalidPlacement();
                continue;
            }
            break;
        }
    }
    
    
    /**
     * asks the user if they want to toggle rotation
     * @param isHorizontal - the starting rotation
     * @param isBot - whether or not to automate the step with bot logic
     * @return the final rotation
     */
    private static boolean promptToggleHorizontal(boolean isHorizontal, boolean isBot) {
        GUI.printIsHorizontalState(isHorizontal);
        GUI.toggleHorizontal(isHorizontal);
        
        // bot input
        if (isBot) {
            boolean toggle = (int) (Math.random() * 2) == 0;
            GUI.botToggle(toggle);
            if (toggle) {
                isHorizontal = !isHorizontal;
                GUI.printIsHorizontalState(isHorizontal);
            }
            return isHorizontal;
        }
        
        // player input
        while (true) {
            String input = scanner.nextLine();
            input = input.replace(" ", "").replace(",", "")
                .replace("(", "").replace(")", "").toUpperCase();
            
            if (input.equals("")) {
                return isHorizontal;
            } else if (input.equals("T")) {
                GUI.printIsHorizontalState(!isHorizontal);
                return !isHorizontal;
            } else {
                GUI.invalidSyntax();
            }
        }
    }
    
    private static int[] promptCoordinate(Board player) {
        return promptCoordinate(player, player);
    }
    
    /**
     * asks the user or bot to enter a coordinate
     * @param attacker - checks if the attacker is a bot or player
     * @param defender - the board that is used to determind whether input is valid or not
     * @return the valid coordinate selected
     */
    private static int[] promptCoordinate(Board attacker, Board defender) {
        // bot inputs
        if (attacker.getIsBot()) {
            int[] coord = Bot.selectTile(defender);
            sleep();
            GUI.botSelectedTile(Configs.ALPHABETS[coord[Configs.ROW]], coord[Configs.COL]);
            sleep();
            return coord;
        }
        
        // user inputs
        while (true) {
            String input = scanner.nextLine();
            input = input.replace(" ", "").replace(",", "")
                .replace("(", "").replace(")", "").toUpperCase();
            
            // error testing syntax
            if (!isValidInputCoord(input)) {
                GUI.invalidSyntax();
                continue;
            }
            
            // creates coord variables
            int gridRow = letterToNumber(input.substring(0, 1));
            int gridCol = Integer.parseInt(input.substring(1));
            
            // error testing the tile itself
            if (!defender.isValidCoord(gridRow, gridCol)) {
                GUI.invalidTile();
                continue;
            }
            
            return new int[] {gridRow, gridCol};
        }
    }
    
    
    /**
     * tests the user input with conditions
     * @param input - a string representing the user inputed coordinate
     * @return whether or not the input can be converted into proper numbers
     */
    private static boolean isValidInputCoord(String input) {
        return (
            input.length() >= 2 
            && input.length() <= 3
            && isLetter(input.substring(0, 1))
            && isNumber(input.substring(1))
            && letterToNumber(input.substring(0, 1)) < Configs.getBoardSizeY()
            && Integer.parseInt(input.substring(1)) < Configs.getBoardSizeX()
        );
    }
    
    
    /**
     * converts letters to their order of appreance in the alphabet, not char
     * @param letter - single character string
     * @return the number equivalent of the letter, or -1 if not found
     */
    private static int letterToNumber(String letter) {
        for (int i = 0; i < Configs.ALPHABETS.length; i++) {
            if (letter.equals(Configs.ALPHABETS[i])) {
                return i;
            }
        }
        return -1;
    }
    
    
    private static boolean isLetter(String value) {
        return letterToNumber(value) != -1;
    }
    
    
    private static boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    private static void sleep() {
        sleep(Configs.getWaitTime());
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