public class RegularFareStrategy  implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        return (1.0 * distance) + (0.25 * duration);
    }
}