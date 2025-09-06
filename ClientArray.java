class ClientArray {
    private static int maxBoardSize = Config.maxBoardSize;
    private static String fogSyntax = Config.fogSyntax;
    private static String[][] clientArray = new String[maxBoardSize][maxBoardSize];
    
    public ClientArray() {}

    public static void updateClientArray() {
        for (int i = 0; i < maxBoardSize; i++) {
            for (int j = 0; j < maxBoardSize; j++) {
                if (FogArray.isUncovered(i, j)) {
                    clientArray[i][j] = SolutionArray.getValue(i, j);
                } else if (FogArray.isFlagged(i, j)) {
                    clientArray[i][j] = Config.flagSyntax;
                } else {
                    clientArray[i][j] = fogSyntax;
                }
            }
        }
    }

    public static void printArray() {

        for (int y = maxBoardSize-1; y >= 0; y--) {
            System.out.print(Config.coordLabelColor + "[" + y + "]\t" + Config.resetColor);
            for (int x = 0; x < maxBoardSize; x++) {
                System.out.print(getColor(x, y) + clientArray[x][y] + "\t" + Config.resetColor);
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
        if (clientArray[x][y] == fogSyntax) {return Config.clientFogColor;}
        else if (clientArray[x][y] == Config.voidSyntax) {return Config.clientVoidColor;}
        else if (clientArray[x][y] == Config.flagSyntax) {return Config.clientFlagColor;}
        else if (clientArray[x][y].equals("1")) {return Config.clientOne;}
        else if (clientArray[x][y].equals("2")) {return Config.clientTwo;}
        else if (clientArray[x][y].equals("3")) {return Config.clientThree;}
        else {return Config.clientLargeNumber;}
    }
}