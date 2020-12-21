package KeyExchange;

public class User {

    // объявление ключей
    private int g, p;
    private int privateKey;
    private long publicKey, sharedKey;

// считываем и заполняем ключи
    public void setVariables (int g, int p, int privateKey){
        this.g = g;
        this.p = p;
        this.privateKey = privateKey;
        publicKey = (long) ((Math.pow(g,privateKey)) % p);
    }

    private void setSharedKey(long foreignPublicKey){
        sharedKey = (long) ((Math.pow(foreignPublicKey,privateKey)) % p);
    }

    public void exchange(User secondUser){ // обмен ключами

        secondUser.setSharedKey(publicKey); // для 2-го юзера использовался publicKey данного юзера (для установки общего ключа)
        setSharedKey(secondUser.publicKey); // для данного юзера использовался publicKey второго юзера
    }

    public long getSharedKey(){
        return sharedKey;
    }
}
