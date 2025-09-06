import java.util.Random;

public class SolutionArray {
    private static int maxBoardSize = Config.maxBoardSize;
    private static int maxMineCount = Config.maxMineCount;
    private static String mineSyntax = Config.solutionMineSyntax;
    private static String voidSyntax = Config.voidSyntax;
    private static String[][] solutionArray = new String[maxBoardSize][maxBoardSize];
    private static Random random = new Random();
    

    public SolutionArray() {}

    public static void generateSolutionArray(int x, int y) {
        while (true) {
            resetSolutionArray();
            placeMines();

            for (int i = 0; i < maxBoardSize; i++) {
                for (int j = 0; j < maxBoardSize; j++) {
                    String tileValue = countSurroundingTile(i, j);

                    solutionArray[i][j] = tileValue;
                }
            }

            if (solutionArray[x][y] == voidSyntax) {
                break;
            }
        }  
    }

    private static void resetSolutionArray() {
        for (int i = 0; i < maxBoardSize; i++) {
            for (int j = 0; j < maxBoardSize; j++) {
                solutionArray[i][j] = " ";
            }
        }
    }

    private static void placeMines() {
        int counter = 0;

        while (counter < maxMineCount) {
            int x = random.nextInt(maxBoardSize);
            int y = random.nextInt(maxBoardSize);
            if (solutionArray[x][y] != mineSyntax) {
                solutionArray[x][y] = mineSyntax;
                counter++;
            }
        }
    }

    private static String countSurroundingTile(int x, int y) {
        int counter = 0;

        if (solutionArray[x][y] == mineSyntax) {
            return mineSyntax;
        }

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (isValidCoord(x+i) && isValidCoord(y+j)) {
                    if (solutionArray[x+i][y+j] == mineSyntax) {counter++;}
                }
            }
        }
        
        if (counter == 0) {
            return voidSyntax;
        }
        return Integer.toString(counter);
    }

    private static Boolean isValidCoord(int n) {
        if (n == -1 || n > maxBoardSize-1) {
            return false;
        }
        return true;
    }

    public static Boolean isTileSafe(int x, int y) {
        if (solutionArray[x][y] == mineSyntax) {
            return false;
        }
        return true;
    }

    public static Boolean isTileVoid(int x, int y) {
        if (solutionArray[x][y] == voidSyntax) {
            return true;
        }
        return false;
    }
    
    public static Boolean isTileNumber(int x, int y) {
        if (!isTileVoid(x, y) && isTileSafe(x, y)) {
            return true;
        }
        return false;
    }

    public static String getValue(int x, int y) {
        return solutionArray[x][y];
    }
    
    public static void printArray() {

        for (int y = maxBoardSize-1; y >= 0; y--) {
            System.out.print(Config.coordLabelColor + "[" + y + "]\t" + Config.resetColor);
            for (int x = 0; x < maxBoardSize; x++) {
                System.out.print(getColor(x, y) + solutionArray[x][y] + "\t" + Config.resetColor);
            }
            System.out.println(Config.coordLabelColor + "[" + y + "]\t" + Config.resetColor); 
        }

        System.out.print("\t");
        for (int x = 0; x < maxBoardSize; x++) {
            System.out.print(Config.coordLabelColor + "[" + x + "]\t" + Config.resetColor);
        }
        System.out.println("");
    }

    private static String getColor(int x, int y) {
        if (solutionArray[x][y] == Config.fogSyntax) {return Config.clientFogColor;}
        else if (solutionArray[x][y] == Config.voidSyntax) {return Config.clientVoidColor;}
        else if (solutionArray[x][y] == Config.solutionMineSyntax) {return Config.clientMineColor;}
        else if (solutionArray[x][y].equals("1")) {return Config.clientOne;}
        else if (solutionArray[x][y].equals("2")) {return Config.clientTwo;}
        else if (solutionArray[x][y].equals("3")) {return Config.clientThree;}
        else {return Config.clientLargeNumber;}
    }
}