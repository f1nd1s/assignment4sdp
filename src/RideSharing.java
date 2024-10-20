import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RideSharing {
    public static void main(String[] args) {
        Map<String, FareStrategy> fares = new HashMap<>();
        FareStrategy fare;
        double distance;
        int duration;
        int rideHour;

        fares.put("Discount", new DiscountFareStrategy());
        fares.put("Premium", new PremiumFareStrategy());
        fares.put("Regular", new RegularFareStrategy());
        fares.put("Surge", new SurgeFareStrategy());

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Ride Sharing.");

        while (true) {
            try {
                System.out.print("Enter your ride hour (0-23): ");
                rideHour = Integer.parseInt(sc.nextLine());

                if (rideHour < 0 || rideHour > 23) {
                    System.out.println("Invalid hour. Please enter a value between 0 and 23.");
                    continue;
                }

                if (rideHour >= 7 && rideHour <= 10 || rideHour >= 17 && rideHour <= 20) {
                    System.out.println("Peak hours detected. Applying Surge pricing.");
                    fare = fares.get("Surge");
                } else {
                    System.out.print("What is your tariff? (Regular, Premium, Discount): ");
                    String fareChoice = sc.nextLine().trim();

                    if (!fares.containsKey(fareChoice)) {
                        System.out.println("Invalid tariff. Please try again.");
                        continue;
                    }
                    fare = fares.get(fareChoice);
                }

                RideContext rideContext = new RideContext(fare);

                System.out.print("Enter your distance (km): ");
                distance = Double.parseDouble(sc.nextLine());

                System.out.print("Enter your duration (min): ");
                duration = Integer.parseInt(sc.nextLine());

                double totalFare = rideContext.calculateFare(distance, duration);
                System.out.printf("The fare for your ride is: $%.2f%n", totalFare);

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter numeric values.");
            }

            System.out.print("Do you want to continue? (Yes/No): ");
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("no")) {
                break;
            }
        }

        sc.close();
        System.out.println("Thank you for using the Ride Sharing.");
    }
}