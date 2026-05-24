package labs.lab_5.advanced;

public abstract class ACalculator {
    protected Object state;

    protected ACalculator() {
        init();
    }

    protected ACalculator(Object state) {
        this.state = state;
    }

    public Object result() {
        return state;
    }

    public ACalculator clear() {
        init();
        return this;
    }

    public abstract void init();
}
