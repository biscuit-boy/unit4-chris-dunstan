public class Die {
    private int value = 0;

    public Die(){
        roll();
    }

    public void roll(){
        value = (int) (6*Math.random()) + 1;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int x){
        value = x;
    }

    public String toString(){
        return "" + value;
    }
}
