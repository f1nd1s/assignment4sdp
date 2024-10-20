public class DiscountFareStrategy implements FareStrategy{
    @Override
    public double calculateFare(double distance, double duration) {
        return (0.2 * distance) + (0.2 * duration); //20% discount
    }
}