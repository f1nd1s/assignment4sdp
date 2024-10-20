public class PremiumFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        return (2.0 * distance) + (0.5 * duration);
    }
}