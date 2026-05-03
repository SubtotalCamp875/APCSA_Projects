package Battleship;

import java.util.ArrayList;

public class Database {
    private ArrayList<Ship> database;
    
    
    public Database() {
        database = new ArrayList<Ship>();
    }
    
    
    /**
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return the ship object that is sitting on the target coordinate
     */
    private Ship findShip(int row, int col) {
        for (Ship ship: database) {
            int[][] coordinates = ship.getCoordinates();
            
            for (int[] coord: coordinates) {
                if (coord[Configs.ROW] == row && coord[Configs.COL] == col) {
                    return ship;
                }
            }
        }
        return null;
    }
    
    
    /**
     * finds and fire at the ship at the given coordinate
     * @param row - the y value being checked
     * @param col - the x value being checked
     */
    public void fire(int row, int col) {
        Ship ship = this.findShip(row, col);
        if (ship != null) {
            ship.decrementHealth();
        }
    }
    

    /**
     * outputs to the terminal the name and size of all ships that has been sunk
     */
    public void sunkShips() {
        int sunkCount = 0;
        for (Ship ship: database) {
            if (ship.getHealth() == 0) {
                sunkCount++;
                String name = ship.getName();
                GUI.printSunkShip(name);
            } 
        }
        if (sunkCount == 0) {
            GUI.printNoShipsSunk();
        }
    }
    
    
    /**
     * determinds the default symbol based on the size of the ship
     * @param size - the size of the ship
     * @param isAlternate - whether to use the alternate naming or not
     * @return single character string
     */
    public static String getSymbol(int size, boolean isAlternate) {
        if (size > Configs.NAMES.length) {
            return Configs.DEFAULT_SHIP_SYMBOL;
        }
        
        if (!isAlternate) {
            return Configs.NAMES[size][Configs.SYMBOL_INDEX];
        }
        return Configs.ALT_NAMES[size][Configs.SYMBOL_INDEX];
    }
    
    
    /**
     * determinds the default ship name based on the size of the ship
     * @param size - the size of the ship
     * @param isAlternate - whether to use the alternate naming or not
     * @return name of the ship
     */
    public static String getName(int size, boolean isAlternate) {
        if (size > Configs.NAMES.length) {
            return "Ship of size " + size;
        }
        
        if (!isAlternate) {
            return Configs.NAMES[size][Configs.NAME_INDEX];
        }
        return Configs.ALT_NAMES[size][Configs.NAME_INDEX];
    }
    
    
    /**
     * @param row - the y value being checked
     * @param col - the x value being checked
     * @return the number of tiles the ship is occupying that has not been hit
     */
    public int getShipHealth(int row, int col) {
        Ship ship = findShip(row, col);
        if (ship == null) { 
            return -1;
        }
        
        return ship.getHealth();
    }
    
    
    /**
     * @return whether or not every ship is sunk in this database
     */
    public boolean isGameOver() {
        for (Ship ship: database) {
            if (ship.getHealth() > 0) {
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * adds a ship into the database
     * @param ship - the ship object that is added
     */
    public void addShip(Ship ship) {
        database.add(ship);
    }
    
    
    /**
     * @param index - the position the ship is stored
     * @return the ship object that is retrieved
     */
    public Ship getShip(int index) {
        return database.get(index);
    }
}