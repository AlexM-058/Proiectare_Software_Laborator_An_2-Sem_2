package lab_5.advanced;

public class NewIntCalculator extends ACalculator {
    public NewIntCalculator() {
        super();
    }

    public NewIntCalculator(Integer state) {
        super(state);
    }

    public NewIntCalculator add(Integer value) {
        state = (Integer) state + value;
        return this;
    }

    public NewIntCalculator subtract(Integer value) {
        state = (Integer) state - value;
        return this;
    }

    public NewIntCalculator multiply(Integer value) {
        state = (Integer) state * value;
        return this;
    }

    @Override
    public Object result() {
        return super.result();
    }

    @Override
    public void init() {
        state = 0;
    }
}
