public class Coin {
    private String face = "null";

    public Coin(){
        flip();
    }

    public void flip(){
        int val = (int) Math.round(Math.random());

        if (val == 0){
            face = "heads";
        }

        else{
            face = "tails";
        }
    }

    public String toString(){
        return face;
    }
}
