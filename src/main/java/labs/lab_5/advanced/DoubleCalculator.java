package labs.lab_5.advanced;

public class DoubleCalculator extends ACalculator {
    public DoubleCalculator() {
        super();
    }

    public DoubleCalculator(Double state) {
        super(state);
    }

    public DoubleCalculator add(Double value) {
        state = (Double) state + value;
        return this;
    }

    public DoubleCalculator subtract(Double value) {
        state = (Double) state - value;
        return this;
    }

    public DoubleCalculator multiply(Double value) {
        state = (Double) state * value;
        return this;
    }

    public DoubleCalculator divide(Double value) {
        state = (Double) state / value;
        return this;
    }

    @Override
    public void init() {
        state = 0.0;
    }
    @Override
    public Double result() {
        Double value = (Double) state;
        if (Double.isInfinite(value) || Double.isNaN(value)) {
            return value;
        }
        return Math.round(value * 100.0) / 100.0;
    }
}
