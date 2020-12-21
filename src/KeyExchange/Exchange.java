package KeyExchange;
import MyRandom.MyRandom;
import RabinMiller.RabinMillerTest;

public class Exchange {

    private int g = 0, p = 0, privateKey1 = 0, privateKey2 = 0;
    private final User user1, user2;
    MyRandom rand;

    public Exchange (MyRandom rand, User user1, User user2){
        this.user1 = user1;
        this.user2 = user2;
        this.rand = rand;
        setRandomNbs();
    }

    private void setRandomNbs(){
        RabinMillerTest test = new RabinMillerTest();
        while (!test.probablyPrime(p)){
            p = rand.generateRandomNb() % 500;
        }

        while (g == 0){
            g = rand.generateRandomNb() % 10;
        }

        while (privateKey1 == 0){
            privateKey1 = rand.generateRandomNb() % 10;
        }

        while (privateKey2 == 0){
            privateKey2 = rand.generateRandomNb() % 10;
        }

        user1.setVariables(g, p, privateKey1);
        user2.setVariables(g, p, privateKey2);

    }

    public void exchangeKeys(){
        user1.exchange(user2);
        System.out.println("---Новый обмен---");
        System.out.println("p = "+ p +"; g = "+ g +"; приватный ключ пользователя 1 = "+ privateKey1 +"; приватный ключ пользователя 2 = "+ privateKey2);
        System.out.println("Общий ключ пользователя 1 = " + user1.getSharedKey());
        System.out.println("Общий ключ пользователя 2 = " + user2.getSharedKey());
        System.out.println();

    }


}
