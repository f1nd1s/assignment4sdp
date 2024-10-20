public class RideContext {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.0;

    public RideContext(FareStrategy strategy) {
        this.fareStrategy = strategy;
    }

    public double calculateFare(double distance, double duration) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance and duration must be non-negative.");
        }

        double fare = fareStrategy.calculateFare(distance, duration);
        return Math.max(fare, MINIMUM_FARE);
    }
}