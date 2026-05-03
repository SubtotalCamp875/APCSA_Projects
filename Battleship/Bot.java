package Battleship;

import java.util.ArrayList;

public class Bot {
    private static int[] nullCoord = {-1, -1};
    
    
    /**
     * @param board - the board that the bot is basing the calculations off
     * @return the coordinates the bot decides to fire at
     */
    public static int[] selectTile(Board board) {
        // continuation logic if there is a hit but not sunk ship
        for (int row = 1; row < Configs.getBoardSizeY(); row++) {
            for (int col = 1; col < Configs.getBoardSizeX(); col++) {
                if (board.isFloatingShip(row, col)) {
                    return searchAll(board, row, col);
                }
            }
        }
        
        // picks any empty tile
        return selectRandomTile(board);
    }
    
    
    /**
     * @param board - the board that the bot is basing the calculations off
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return coordinates if the bot can continue attacking a found ship
     *     else return the nullCoord value
     */
    private static int[] searchAll(Board board, int row, int col) {
        int [] result;
        
        // does logic if ship is extending horizontally
        result = searchHoriz(board, row, col);
        if (result != nullCoord) {
            return result;
        }
        
        // does logic if ship is extending vertical
        result = searchVert(board, row, col);
        if (result != nullCoord) {
            return result;
        }
        
        // selects random empty tile around current tile
        ArrayList<int[]> validCoords = getSurroundingEmpty(board, row, col);
        int randomIndex = (int) (Math.random() * validCoords.size());
        int[] randomTile = validCoords.get(randomIndex);
        
        return new int[] {randomTile[Configs.ROW], randomTile[Configs.COL]};
    }
    
    
    /**
     * @param board - the board that the bot is basing the calculations off
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return an arraylist of coordinates around the target that can be attacked
     */
    private static ArrayList<int[]> getSurroundingEmpty(Board board, int row, int col) {
        ArrayList<int[]> validCoords = new ArrayList<>();
        
        if (board.isValidCoord(row - 1, col)) {
            validCoords.add(new int[] {row - 1, col});
        }
        if (board.isValidCoord(row + 1, col)) {
            validCoords.add(new int[] {row + 1, col});
        }
        if (board.isValidCoord(row, col - 1)) {
            validCoords.add(new int[] {row, col - 1});
        }
        if (board.isValidCoord(row, col + 1)) {
            validCoords.add(new int[] {row, col + 1});
        }
        
        return validCoords;
    }
    
    
    /**
     * logic if ship is horizontal with 2+ tiles marked
     * @param board - the board that the bot is basing the calculations off
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return the coordinates if the ship can continue to be attacked horizontally
     *     else return the nullCoord value
     */
    private static int[] searchHoriz(Board board, int row, int col) {
        int step = 0;
        boolean extendHoriz = false;
        
        do {
            int nextCol = col + 1;
            
            // makes sure the next step is in bounds
            if (nextCol >= Configs.getBoardSizeX() && step == 0) {
                return nullCoord;
                
            // fires at opposite side if next step is out of bounds and ship is horizontal 
            } else if (nextCol >= Configs.getBoardSizeX() && step > 0) {
                if (board.isValidCoord(row, col - (step + 1))) {
                    return new int[] {row, col - (step + 1)};
                }
                return nullCoord;
            }
            
            
            // checks if next tile is hit but not sunk
            extendHoriz = board.isFloatingShip(row, nextCol);
            if (extendHoriz) {
                col++;
                step++;
                
            // fires at next tile if it is empty
            } else if (step > 0 && board.isValidCoord(row, nextCol)) {
                return new int[] {row, nextCol};
                
            // fires at the opposite side
            } else if (step > 0 && board.isValidCoord(row, col - (step + 1))) {
                return new int[] {row, col - (step + 1)};
            }
        } while (extendHoriz);
        
        return nullCoord;
    }
    
    
    /**
     * logic if ship is vertically with 2+ tiles marked
     * @param board - the board that the bot is basing the calculations off
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return the coordinates if the ship can continue to be attacked vertically
     *     else return the nullCoord value
     */
    private static int[] searchVert(Board board, int row, int col) {
        int step = 0;
        boolean extendVert = false;
        
        do {
            int nextRow = row + 1;
            
            // makes sure the next step is in bounds
            if (nextRow >= Configs.getBoardSizeY() && step == 0) {
                return nullCoord;
                
            // fires at opposite side if next step is out of bounds and ship is horizontal 
            } else if (nextRow >= Configs.getBoardSizeY() && step > 0) {
                if (board.isValidCoord(row - (step + 1), col)) {
                    return new int[] {row - (step + 1), col};
                }
                return nullCoord;
            }
            
            
            // checks if next tile is hit but not sunk
            extendVert = board.isFloatingShip(nextRow, col);
            if (extendVert) {
                row++;
                step++;
                
            // fires at next tile if it is empty
            } else if (step > 0 && board.isValidCoord(nextRow, col)) {
                return new int[] {nextRow, col};
                
            // fires at the opposite side
            } else if (step > 0 && board.isValidCoord(row - (step + 1), col)) {
                return new int[] {row - (step + 1), col};
            }
        } while (extendVert);
        
        return nullCoord;
    }
    
    
    /**
     * @param board - the board that the bot is basing the calculations off
     * @return a random empty tile
     */
    public static int[] selectRandomTile(Board board) {
        while (true) {
            int row = (int) (Math.random() * Configs.getBoardSizeY() - 1) + 1;
            int col = (int) (Math.random() * Configs.getBoardSizeX() - 1) + 1;
            
            if (!board.isValidCoord(row, col)) {
                continue;
            }
            return new int[] {row, col};
        }
    }
}