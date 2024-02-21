package bank;

import security.Encryptor;
import security.Encrypted;
import security.Message;
import security.key.BankPublicKey;
import security.key.BankSymmetricKey;

public class MobileApp {

    private String randomUniqueStringGen(){
        return Encryptor.randomUniqueStringGen();
    }
    private final String AppId = randomUniqueStringGen();
    public String getAppId() {
        return AppId;
    }

    String id, password;
    public MobileApp(String id, String password){
        this.id = id;
        this.password = password;
    }

    private BankSymmetricKey symmetricKey;
    public Encrypted<BankSymmetricKey> sendSymKey(BankPublicKey publickey){
        //TODO: Problem 1.3
        if (publickey != null) {
            symmetricKey = new BankSymmetricKey(randomUniqueStringGen());
            return new Encrypted<>(symmetricKey, publickey);
        }
        return null;
    }

    public Encrypted<Message> deposit(int amount){
        //TODO: Problem 1.3
        Message deposit = new Message("deposit", id, password, amount);
        if (amount>0) {
            return new Encrypted<>(deposit, symmetricKey);
        }
        return null;
    }

    public Encrypted<Message> withdraw(int amount){
        //TODO: Problem 1.3
        Message withdraw = new Message("withdraw", id, password, amount);

        if (amount>0) {
            return new Encrypted<>(withdraw, symmetricKey);
        }
        return null;
    }

    public boolean processResponse(Encrypted<Boolean> obj){
        //TODO: Problem 1.3
        if (obj != null) {
            if (obj.decrypt(symmetricKey) != null) {
                return obj.decrypt(symmetricKey);
            }
        }
        return false;
    }
}

