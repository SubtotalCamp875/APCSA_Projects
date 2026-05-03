
/** Documentations:
 * Array Fills - https://www.w3schools.com/java/ref_arrays_fill.asp
 * Double Brakcets - https://www.geeksforgeeks.org/java/double-brace-initialization-java/
 * String strip() - https://www.geeksforgeeks.org/java/java-string-class-strip-method-with-examples/
 * 
 * Switch case - https://www.w3schools.com/java/java_switch.asp
 * Try Catch - https://www.w3schools.com/java/java_try_catch.asp
 * Break and Continue - https://www.w3schools.com/java/java_break.asp
 * 
 * Terminal Color - https://codehs.com/tutorial/andy/ansi-colors
 * Thread sleep - https://www.geeksforgeeks.org/java/thread-sleep-method-in-java-with-examples/
 */

package Battleship;

import java.util.Scanner;


public class Main
{
    private static Scanner scanner;
    
    
    private static void init() {
        scanner = new Scanner(System.in);
    }
    
    
    public static void main(String[] args) {
        init();
        
        GUI.warning();
        GUI.lineBreak();
        GUI.lineBreak();
        
        GUI.welcome();
        GUI.lineBreak();
        
        while (true) {
            GUI.mainMenu();
            int option = promptOption();
                
            if (option == 1) {
                Play.start();
                
            } else if (option == 2) {
                Settings.start();
                
            } else if (option == 3) {
                GUI.exit();
                return;
            }
        }
    }
    
    
    private static int promptOption() {
        while (true) {
            String option = scanner.nextLine();
            if (option.equals("1")
                || option.equals("2")
                || option.equals("3")) {
                return Integer.parseInt(option);
            }
            
            GUI.invalidSyntax();
        }
    }
}