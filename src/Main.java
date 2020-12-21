import RabinMiller.RabinMillerTest;

public class Main {

    public static void main(String[] args) {

        MyRandom.MyRandom rand = new MyRandom.MyRandom();
// создали четыре юзера (поменять имена)
        KeyExchange.User Jim = new KeyExchange.User();
        KeyExchange.User Tanya = new KeyExchange.User();
        KeyExchange.User Tick = new KeyExchange.User();
        KeyExchange.User Kris = new KeyExchange.User();
// создали четыре обмена
        KeyExchange.Exchange exchange1 = new KeyExchange.Exchange(rand, Jim, Tanya);
        exchange1.exchangeKeys();
        KeyExchange.Exchange exchange2 = new KeyExchange.Exchange(rand, Jim, Tick);
        exchange2.exchangeKeys();
        KeyExchange.Exchange exchange3 = new KeyExchange.Exchange(rand, Tanya, Tick);
        exchange3.exchangeKeys();
        KeyExchange.Exchange exchange4 = new KeyExchange.Exchange(rand, Tanya, Kris);
        exchange4.exchangeKeys();




    }

}
