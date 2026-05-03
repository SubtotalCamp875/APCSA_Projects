package Battleship;

public class Ship {
    private String name;
    private int[][] coordinates;
    private int size;
    private int health;
    
    /**
     * @param name - name of the ship
     * @param size - length / health of the ship
     * @param row - the y coordinate the ship will originally be placed on
     * @param col - the x coordinate the ship will originally be placed on
     * @param isHorizontal - the rotation of the ship
     */
    public Ship(String name, int size, int row, int col, boolean isHorizontal) {
        this.name = name;
        this.size = size;
        this.health = size;
        this.coordinates = new int[size][2];
        
        // adds the coordinates of each ship tile
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                coordinates[i] = new int[] {row, col + i};
            } else {
                coordinates[i] = new int[] {row + i, col};
            }
        }
    }
    
    
    public String getName() {
        return name;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getMaxHealth() {
        return size;
    }
    
    public int getHealth() {
        return health;
    }
    
    public void setHealth(int value) {
        health = value;
    }
    
    public void decrementHealth() {
        health -= 1;
    }
    
    public void decrementHealth(int amount) {
        health -= amount;
    }
    
    public int[][] getCoordinates() {
        return coordinates;
    }
}