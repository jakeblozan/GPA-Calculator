import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

/**
 * Calculates weighted or unweighted GPA
 * 
 * @author (Jake Blozan) 
 * @version (3/2/17)
 */
public class Calculator
{
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the GPA calculator!");
        System.out.println("Please make sure you've filled out the grade form");
        String input = "";
        while (input != "weighted" || input != "unweighted") {
            System.out.println("Would you like to calculate your weighted or unweighted GPA?");
            input = scan.next();
            if (input.equals("weighted") || input.equals("unweighted")) {
                System.out.println("Nice. Fetching data...");
                break;
            }
            else {
                System.out.println("What the... please try again and use a valid input");
            }
        }
        
    }
}
