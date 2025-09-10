import java.util.Scanner;

public class Dialogue {
    Scanner scanner = new Scanner(System.in);

    public void welcome() {
        System.out.println(ConsoleColors.GREEN + "Welcome to Minesweeper!" + ConsoleColors.R);
    }

    public String getInput() {
        System.out.print("Please enter a set of coordinates: ");
        return scanner.nextLine();
    }

    public void gameWon() {
        System.out.println(ConsoleColors.GREEN + "Congrats! You beat the game!" + ConsoleColors.R);
    }

    public void gameLost() {
        System.out.println(ConsoleColors.RED + "You clicked on a mine tile and lost the game!" +  ConsoleColors.R);
    }
}
