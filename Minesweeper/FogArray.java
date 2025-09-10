class FogArray {
    private static int maxBoardSize = Config.maxBoardSize;
    private static String fogSyntax = Config.fogSyntax;
    private static String uncoverSyntax = Config.fogUncoverSyntax;
    private static String flagSyntax = Config.flagSyntax;
    private static String[][] fogArray = new String[maxBoardSize][maxBoardSize];

    public FogArray () {}; 

    public static void generate() {
        for (int i = 0; i < maxBoardSize; i++) {
            for (int j = 0; j < maxBoardSize; j++) {
                fogArray[i][j] = fogSyntax;
            }
        }
    }

    private static Boolean CanUpdateTile(int x, int y) {
        return (!isUncovered(x, y) && SolutionArray.isTileSafe(x, y) && isNearClearedVoid(x, y) && !isFlagged(x, y));
    }

    public static void updateAllTile(int x, int y) {
        int changeCounter = 1;
        fogArray[x][y] = uncoverSyntax;

        while (changeCounter != 0) {
            changeCounter = 0;

            for (int i = 0; i < maxBoardSize; i++) {
                for (int j = 0; j < maxBoardSize; j++) {
                    if (CanUpdateTile(i, j)) {
                        uncoverTile(i, j);
                        changeCounter++;
                    }
                }
            }
        }
    }

    public static void flagTile(int x, int y) {
        if (fogArray[x][y] == fogSyntax) {
            fogArray[x][y] = flagSyntax;
        } else if (fogArray[x][y] == flagSyntax) {
            fogArray[x][y] = fogSyntax;
        }
    }

    public static Boolean isFlagged(int x, int y) {
        return (fogArray[x][y] == flagSyntax);
    }

    public static void uncoverTile(int x, int y) {
        fogArray[x][y] = uncoverSyntax;
    }

    public static Boolean isUncovered(int x, int y) {
        return (fogArray[x][y] == uncoverSyntax);
    }

    private static Boolean isNearClearedVoid(int x,int y) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (isValidCoord(x+i) && isValidCoord(y+j)) {
                    if (SolutionArray.getValue(x+i, y+j) == Config.voidSyntax && FogArray.isUncovered(x+i, y+j)) {return true;}
                }
            }
        }
        return false;
    }

    private static Boolean isValidCoord(int n) {
        if (n == -1 || n > maxBoardSize-1) {
            return false;
        }
        return true;
    }

    public static void printArray() {
        for (int y = maxBoardSize-1; y >= 0; y--) {
            System.out.print("[" + y + "]\t");
            for (int x = 0; x < maxBoardSize; x++) {
                System.out.print(fogArray[x][y] + "\t");
            }
            System.out.println("[" + y + "]\t"); 
        }

        System.out.print("\t");
        for (int x = 0; x < maxBoardSize; x++) {
            System.out.print("[" + x + "]\t");
        }
        System.out.println("");
    }
}