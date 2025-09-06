class Minesweeper {
    
    //public String[] playerArray = {};
    
    private static Dialogue dialogue = new Dialogue();

    public static void main(String [] args) {
    
        //Since we do not learn try-catch, assume all inputs are valid inputs
        initialize();

        ClientArray.updateClientArray();
        ClientArray.printArray();

        while (true) {
            askForCoords();

            if (CoordArray.getFlag() == true) {
                FogArray.flagTile(CoordArray.getX(), CoordArray.getY());
                
            } else if (!FogArray.isFlagged(CoordArray.getX(), CoordArray.getY())) {
                if (!SolutionArray.isTileSafe(CoordArray.getX(), CoordArray.getY())) {loseGame();}
                FogArray.updateAllTile(CoordArray.getX(), CoordArray.getY());
                if (isGameWon()) {winGame();}
            }
            
            ClientArray.updateClientArray();
            ClientArray.printArray();
            CoordArray.setFlag(false);
        }
    }

    private static void initialize() {
        FogArray.generate();
        dialogue.welcome();

        while (true) {
            askForCoords();
            if (CoordArray.getFlag() == true) {
                FogArray.flagTile(CoordArray.getX(), CoordArray.getY());
                ClientArray.updateClientArray();
                ClientArray.printArray();
                CoordArray.setFlag(false);
            } else {
                SolutionArray.generateSolutionArray(CoordArray.getX(), CoordArray.getY());
                FogArray.updateAllTile(CoordArray.getX(), CoordArray.getY());
                break;
            }
        }
        
    }

    private static void askForCoords() {
        String unformattedCoords = dialogue.getInput();
        grabCoords(unformattedCoords);
    }

    public static void grabCoords(String coordString) {
        if (coordString.substring(0, 1).toLowerCase().equals("f")) {
            CoordArray.setFlag(true);
        }

        String[] coordSet = coordString.replace("(", "").replace(")", "").replace(" ", "").replace("f", "").split(",");
        CoordArray.setX(Integer.parseInt(coordSet[0]));
        CoordArray.setY(Integer.parseInt(coordSet[1]));
    }

    public static Boolean isGameWon() {
        int progressCounter = 0;

        for (int i = 0; i < Config.maxBoardSize; i++) {
            for (int j = 0; j < Config.maxBoardSize; j++) {
                if(FogArray.isUncovered(i, j) || !SolutionArray.isTileSafe(i, j)) {
                    progressCounter++;
                }
            }
        }

        return (progressCounter == (Config.maxBoardSize * Config.maxBoardSize));
    }

    public static void winGame() {
        dialogue.gameWon();
        System.exit(0);
    }
    
    public static void loseGame() {
        SolutionArray.printArray();
        dialogue.gameLost();
        System.exit(0);
    }

 
}