public class CoinTester {
    public static void main(String[] args) {
        Coin coin = new Coin();

        double numHeads = 0;

        for (int i = 0; i < 10; ++i){
            System.out.println(coin.toString());
            coin.flip();

            if (coin.toString().equals("heads")){
                ++numHeads;
            }
        }

        System.out.println(numHeads/10.0);
    }
}
