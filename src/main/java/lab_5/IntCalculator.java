package lab_5;

public class IntCalculator {
    protected int state ;
    IntCalculator(int state){
        this.state = state;
    }
    public  IntCalculator add(int a){
        this.state +=a;
        return this;
    }
    public IntCalculator substract(int a){
        this.state -=a;
        return this;
    }
    public IntCalculator multiply(int a){
        this.state *=a;
        return this;
    }
    public int result(){
        return state;
    }
    public IntCalculator clear(){
        this.state = 0;
        return this;
    }

}
