import java.util.Scanner;
import static java.lang.System.out;

public class cinema_ticket {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);

        // Step 1: Movies list with availability + age requirements + prices
        String[] movies = {"Action", "Comedy", "Horror", "Romance", "Adventure"};
        boolean[] available = {true, true, false, true, true}; // availability
        int[] minAge = {16, 3, 18, 16, 3}; // age restrictions
        double[] prices = {90.0, 70.0, 120.0, 100.0, 80.0}; // ticket prices

        // Step 2: Get user info
        out.print("Enter your name: ");
        String name = input.nextLine();

        out.print("Enter your age: ");
        int age = input.nextInt();
        input.nextLine(); // consume newline

        // Step 3: Movie selection loop
        String chosen = "";
        double chosenPrice = 0;
        boolean validChoice = false;

        while (!validChoice) {
            // Show movie list
            out.println("\nMovies list:");
            for (int i = 0; i < movies.length; i++) {
                out.printf("%d. %s (%s, +%d) - Price: %.2f%n",
                        i + 1,
                        movies[i],
                        available[i] ? "Available" : "Unavailable",
                        minAge[i],
                        prices[i]);
            }

            // Ask choice
            out.print("Choose a movie by typing its name: ");
            chosen = input.nextLine();

            // Check if chosen exists
            boolean found = false;
            for (int i = 0; i < movies.length; i++) {
                if (movies[i].equalsIgnoreCase(chosen)) {
                    found = true;

                    if (!available[i]) {
                        out.println("Sorry, " + movies[i] + " is unavailable. Please choose again.");
                        break;
                    }

                    if (age < minAge[i]) {
                        out.println("Sorry, you must be at least " + minAge[i] + " to watch " + movies[i] + ".");
                        break;
                    }

                    // If available and age is okay
                    chosenPrice = prices[i];
                    validChoice = true;
                    break;
                }
            }

            if (!found) {
                out.println("That movie does not exist. Please try again.");
            }
        }

        // Step 4: Discount card
        out.print("Do you have a discount card? (yes/no): ");
        String hasDiscount = input.nextLine();

        // Step 5: Calculate final price
        if (hasDiscount.equalsIgnoreCase("yes")) {
            chosenPrice = chosenPrice * 0.5;
        }

        // Step 6: Final confirmation
        out.printf("Reservation confirmed for %s (%s). Final ticket price: %.2f%n",
                   name, chosen, chosenPrice);

        input.close();  
    }
}
