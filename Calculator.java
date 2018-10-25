import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.File;
import java.text.DecimalFormat;

/**
 * Calculates weighted or unweighted GPA.
 * 
 * @author (Jake Blozan) 
 * @version (3/2/17)
 */
public class Calculator
{
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String input = "";

        System.out.println("Welcome to the GPA calculator!");
        System.out.println("Please make sure you've filled out the grade form.\n");

        while (input != "weighted" || input != "unweighted") {
            System.out.println("Would you like to calculate your weighted or unweighted GPA?");
            input = scan.next();
            if (input.equalsIgnoreCase("weighted") || input.equalsIgnoreCase("unweighted")) {
                System.out.println("Nice. Fetching data...");
                break;
            }
            else {
                System.out.println("What the... please try again and use a valid input");
            }
        }

        Scanner dataScan = new Scanner(new File("grades.txt"));
        String data = "";
        while (dataScan.hasNext()) {
            data += dataScan.nextLine();
        }

        if (input.equalsIgnoreCase("weighted")) {
            weighted(data);
        }

        if (input.equalsIgnoreCase("unweighted")) {
            unweighted(data);
        }
        //System.out.println(data);
    }

    public static void weighted(String data) {
        ArrayList<String> classes = new ArrayList<String>();
        char[] grades = {'F', 'D', 'C', 'B', 'A'};
        String line = "";
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) != ';') {
                line += data.charAt(i);
            }
            else {
                //System.out.println(line);
                classes.add(line);
                line = "";
            }
        }
        classes.remove(0);
        double sum = 0;
        for (int i = 0; i < classes.size(); i++) {
            int spot = classes.get(i).indexOf(":");
            char grade = classes.get(i).charAt(spot + 1);
            for (int q = 0; q < 5; q++) {
                if (grade == grades[q]) {
                    sum += q;
                }
            }
            if (classes.get(i).charAt(spot + 2) == '.') {
                sum++;
            }
        }
        double gpa = sum / classes.size();
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Your weighted GPA is: " + numberFormat.format(gpa));
        
        //System.out.println(sum);
        //System.out.println(classes.size());
        
        //System.out.println(Arrays.toString(classes.toArray()));
        //System.out.println(classes.get(0));
    }

    public static void unweighted(String data) {
        ArrayList<String> classes = new ArrayList<String>();
        char[] grades = {'F', 'D', 'C', 'B', 'A'};
        String line = "";
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) != ';') {
                line += data.charAt(i);
            }
            else {
                //System.out.println(line);
                classes.add(line);
                line = "";
            }
        }
        classes.remove(0);
        double sum = 0;
        for (int i = 0; i < classes.size(); i++) {
            int spot = classes.get(i).indexOf(":");
            char grade = classes.get(i).charAt(spot + 1);
            for (int q = 0; q < 5; q++) {
                if (grade == grades[q]) {
                    sum += q;
                }
            }
        }
        double gpa = sum / classes.size();
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Your unweighted GPA is: " + numberFormat.format(gpa));
        
        //DEBUG
        //System.out.println(sum);
        //System.out.println(classes.size());
        
        //System.out.println(Arrays.toString(classes.toArray()));
        //System.out.println(classes.get(0));
    }
}
