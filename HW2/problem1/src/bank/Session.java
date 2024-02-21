package bank;

public class Session {

    private String sessionKey;
    private Bank bank;
    private boolean valid;

    Session(String sessionKey,Bank bank){
        this.sessionKey = sessionKey;
        this.bank = bank;
        valid = true;
    }

    public void validOff() {
        this.valid = false;
    }
    public boolean deposit(int amount) {
        //TODO: Problem 1.2
        if (this.valid == false) { return false; }
        return bank.deposit(this.sessionKey, amount);
    }

    public boolean withdraw(int amount) {
        //TODO: Problem 1.2
        if (this.valid == false) { return false;}
        return bank.withdraw(this.sessionKey, amount);
    }

    public boolean transfer(String targetId, int amount) {
        //TODO: Problem 1.2
        if (this.valid == false) { return false; }
        return bank.transfer(this.sessionKey, targetId, amount);
    }

}
