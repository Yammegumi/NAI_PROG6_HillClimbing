
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a file as argument.");
            System.exit(1);
        }

        try {
            TravelingSalesman salesman = new TravelingSalesman(args[0]);
            salesman.solveProblem();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}