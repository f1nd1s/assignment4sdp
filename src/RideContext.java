public class RideContext {
    private FareStrategy fareStrategy;
    private static final double MINIMUM_FARE = 5.0;

    public RideContext(FareStrategy strategy) {
        this.fareStrategy = strategy;
    }

    public void setFareStrategy(FareStrategy strategy) {
        this.fareStrategy = strategy;
    }

    public void selectStrategyBasedOnTime(int hour) {
        if (hour >= 7 && hour <= 10 || hour >= 17 && hour <= 20) {
            setFareStrategy(new SurgeFareStrategy());
        } else {
            setFareStrategy(new RegularFareStrategy());
        }
    }

    public double calculateFare(double distance, double duration) {
        if (distance < 0 || duration < 0) {
            throw new IllegalArgumentException("Distance and duration must be non-negative.");
        }

        double fare = fareStrategy.calculateFare(distance, duration);
        return Math.max(fare, MINIMUM_FARE);
    }
}