package lab_5.advanced;

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

    @Override
    public void init() {
        state = 0.0;
    }
    @Override
    public Double result() {
        return Math.round((Double) state * 100.0) / 100.0;
    }
}
