public class SurgeFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distance, double duration) {
        return (2 * (1.0 * distance)) + (2 * (0.25 * duration));
    }
}