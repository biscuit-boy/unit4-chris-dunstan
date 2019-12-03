public class DieClient {
    public static void main(String[] args) {
        Die die1 = new Die();
        Die die2 = new Die();

        double total = 0;

        int temp = 0;

        for (int i = 0; i < 100; ++i){
            die1.setValue(0);
            die2.setValue(1);

            temp = 0;

            while (die1.getValue() != die2.getValue()){
                ++temp;
                die1.roll();
                die2.roll();
            }

            total += temp;
        }

        System.out.println(total/100.0);

    }
}
