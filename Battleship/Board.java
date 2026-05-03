package Battleship;

import java.util.Arrays;

public class Board {
    private Database database;
    private String[][] shipBoard;
    private String[][] attackBoard;
    private String playerName;
    private boolean isBot;
    private int score;
    
    
    public Board() {
        this(Configs.DEFAULT_SIZE_Y, Configs.DEFAULT_SIZE_X, Configs.DEFAULT_PLAYER_NAME, false);
    }
    
    public Board(String name) {
        this(Configs.DEFAULT_SIZE_Y, Configs.DEFAULT_SIZE_X, name, false);
    }
    
    /**
     * @param rows - the y size of the board
     * @param cols - the x size of the board
     * @param name - the name of the player / bot
     * @param type - whether the board is a bot (true) or not (false)
     */
    public Board(int rows, int cols, String name, boolean type) { 
        // init variables
        database =  new Database();
        shipBoard = new String[rows][cols];
        attackBoard = new String[rows][cols];
        playerName = name;
        isBot = type;
        score = 0;
        
        // set board to the empty character
        for (String[] row: shipBoard) {
            Arrays.fill(row, Configs.EMPTY);
        }
        for (String[] row: attackBoard) {
            Arrays.fill(row, Configs.EMPTY);
        }
        
        // fills in coordinates
        for (int i = 0; i < attackBoard[Configs.ROW].length; i++) {
            attackBoard[0][i] = Integer.toString(i);
        }
        for (int i = 1; i < attackBoard.length; i++) {
            attackBoard[i][0] = Configs.ALPHABETS[i];
        }
        
        for (int i = 0; i < shipBoard[Configs.ROW].length; i++) {
            shipBoard[0][i] = Integer.toString(i);
        }
        for (int i = 1; i < shipBoard.length; i++) {
            shipBoard[i][0] = Configs.ALPHABETS[i];
        }
    }
    
    
    /**
     * adds a ship starting at the inputted coordinates then builds to the right or down depending on rotation
     * @param size - the length of the ship
     * @param row - the starting placement position in rows
     * @param col - the starting placement position in cols
     * @param isHorizontal - if the ship is placed horizontally
     * @param isAlternate - if the name is secondary
     * @return whether or not the ship is successfully placed
     */
    public boolean addShip(int size, int row, int col, boolean isHorizontal, boolean isAlternate) {
        int width = 1;
        int height = size;
        
        if (isHorizontal) {
            width = size;
            height = 1;
        }
        
        // tests min values for out of bounds
        if (row <= 0 || col <= 0 || size < 1) {
            return false;
            
        // makes sure the entire length of ship fits within the board length
        } else if ((row + height) > shipBoard.length 
                || (col + width) > shipBoard[0].length) {
            return false;
        }
        
        // makes sure the all the tiles are empty
        for (int i = 0; i < size; i++) {
            if (isHorizontal && shipBoard[row][col + i] != Configs.EMPTY) {
                return false;
            } else if (!isHorizontal && shipBoard[row + i][col] != Configs.EMPTY) {
                return false;
            }
        }
        
        // picks the right symbol depending on boat length
        String symbol = Database.getSymbol(size, isAlternate);
        String name = Database.getName(size, isAlternate);
        
        // places ship onto the board
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                shipBoard[row][col + i] = symbol;
            } else {
                shipBoard[row + i][col] = symbol;
            }
        }
        
        // adds the ship into the database
        Ship ship = new Ship(name, size, row, col, isHorizontal);
        database.addShip(ship);
        
        // everything ran successfully
        return true;
    }
    
    
    /**
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return whether or not the fire was successfull
     */
    public boolean fire(int row, int col) {
        // updates board based on hit / miss
        if (shipBoard[row][col] == Configs.EMPTY) {
            attackBoard[row][col] = Configs.MISS;
            return false;
            
        } else {
            shipBoard[row][col] = shipBoard[row][col].toLowerCase();
            attackBoard[row][col] = Configs.HIT;
            // register the hit in the ships database
            database.fire(row, col);
            return true;
        }
    }
    
    
    /**
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return whether or not the tile is in bounds and empty
     */
    public boolean isValidCoord(int row, int col) {
        // tests input for bounds and repeats
        return (
            row > 0 
            && row < shipBoard.length 
            && col > 0 
            && col < shipBoard.length
            && attackBoard[row][col] == Configs.EMPTY
        );
    }
    
    /**
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return whether or not the ship is revealed but not sunk
     */
    public boolean isFloatingShip(int row, int col) {
        return (
            database.getShipHealth(row, col) > 0
            && attackBoard[row][col] == Configs.HIT
        );
    }
    
    // calls into the sunkShip method in database
    public void sunkShips() {
        database.sunkShips();
    }
    
    public void increaseScore() {
        score++;
    }
    
    public boolean isGameOver() {
        return database.isGameOver();
    }
    
    public void printAttackBoard() {
        GUI.printArray(this, attackBoard);
    }
    
    public void printShipBoard() {
        GUI.printArray(this, shipBoard);
    }
    
    public int getScore() {
        return score;
    }
    
    public boolean getIsBot() {
        return isBot;
    }
    
    public String getName() {
        return playerName;
    }
    
    public int getShipHealth(int row, int col) {
        return database.getShipHealth(row, col);
    }
}