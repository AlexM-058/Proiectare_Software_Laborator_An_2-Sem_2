package lab_5;

public class AdvancedCalculator extends IntCalculator{
    public AdvancedCalculator(int state) {
        super(state);
    }
    public AdvancedCalculator devide(int a){
        state /=a;
        return this;
    }
    public AdvancedCalculator powerFor(int a){
        state = (int) Math.pow(state, a);
        return this;
    }
    public AdvancedCalculator rootFor(int a){
        state = (int) Math.pow(state, 1/a);
        return this;
    }

}
