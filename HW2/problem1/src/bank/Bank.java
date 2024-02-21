package bank;

import bank.event.Event;
import security.*;
import security.key.*;

public class Bank {
    private int numAccounts = 0;
    final static int maxAccounts = 100;
    private BankAccount[] accounts = new BankAccount[maxAccounts];
    private String[] ids = new String[maxAccounts];

    public void createAccount(String id, String password) {
        createAccount(id, password, 0);
    }

    public void createAccount(String id, String password, int initBalance) {
        int accountId = numAccounts;
        accounts[accountId] = new BankAccount(id, password, initBalance);
        ids[accountId] = id;
        numAccounts+=1;
    }

    public boolean deposit(String id, String password, int amount) {
        //TODO: Problem 1.1
        BankAccount account = find(id);
        if (account == null) return false;
        if (! account.authenticate(password)) return false;
        account.deposit(amount);
        return true;

    }

    public boolean withdraw(String id, String password, int amount) {
        //TODO: Problem 1.1
        BankAccount account = find(id);
        if (account == null) return false;
        if (! account.authenticate(password)) return false;
        if(!account.withdraw(amount)) return false;
        return true;

    }

    public boolean transfer(String sourceId, String password, String targetId, int amount) {
        //TODO: Problem 1.1
        BankAccount account = find(sourceId);
        if (account == null) return false;
        if (! account.authenticate(password)) return false;
        BankAccount target = find(targetId);
        if (target == null) return false;

        if(!account.send(amount)) return false;
        target.receive(amount);
        return true;

    }

    public Event[] getEvents(String id, String password) {
        //TODO: Problem 1.1
        BankAccount account = find(id);
        if (account == null) return null;
        if (! account.authenticate(password)) return null;
        return account.getEvents();
    }

    public int getBalance(String id, String password) {
        //TODO: Problem 1.1
        BankAccount account = find(id);
        if (account == null) return -1;
        if (! account.authenticate(password)) return -1;
        return account.getBalance();
    }

    private static String randomUniqueStringGen(){
        return Encryptor.randomUniqueStringGen();
    }

    private BankAccount find(String id) {
        for (int i = 0; i < numAccounts; i++) {
            if(ids[i].equals(id)){return accounts[i];};
        }
        return null;
    }

    final static int maxSessionKey = 100;
    int numSessionKey = 0;
    String[] sessionKeyArr = new String[maxSessionKey];
    BankAccount[] bankAccountmap = new BankAccount[maxSessionKey];

    String generateSessionKey(String id, String password){
        BankAccount account = find(id);
        if(account == null || !account.authenticate(password)){
            return null;
        }
        String sessionkey = randomUniqueStringGen();
        sessionKeyArr[numSessionKey] = sessionkey;
        bankAccountmap[numSessionKey] = account;
        numSessionKey += 1;
        return sessionkey;
    }

    BankAccount getAccount(String sessionkey){
        for(int i = 0 ;i < numSessionKey; i++){
            if(sessionKeyArr[i] != null && sessionKeyArr[i].equals(sessionkey)){
                return bankAccountmap[i];
            }
        }
        return null;
    }

    boolean deposit(String sessionkey, int amount) {
        //TODO: Problem 1.2
        BankAccount account = getAccount(sessionkey);
        account.deposit(amount);
        return true;
    }

    boolean withdraw(String sessionkey, int amount) {
        //TODO: Problem 1.2
        BankAccount account = getAccount(sessionkey);
        if (!account.withdraw(amount)) { return false; }
        return true;
    }

    boolean transfer(String sessionkey, String targetId, int amount) {
        //TODO: Problem 1.2
        BankAccount account = getAccount(sessionkey);
        BankAccount target = find(targetId);
        if (!account.send(amount) || target == null) { return false; }
        target.receive(amount);
        return true;
    }

    private BankSecretKey secretKey;
    public BankPublicKey getPublicKey(){
        BankKeyPair keypair = Encryptor.publicKeyGen();
        secretKey = keypair.deckey;
        return keypair.enckey;
    }

    private BankSymmetricKey symmetricKey;

    String[] idArray = new String[10000];
    BankSymmetricKey[] symkeyArray = new BankSymmetricKey[10000];
    int indexNum = 0;

    public int getIndex(String AppId) {
        for(int i=0; i< 10000; i++) {
            if (idArray[i] == null) {
                continue;
            }
            if (idArray[i].equals(AppId)) {
                return i;
            }
        }
        return -1;
    }

    public void fetchSymKey(Encrypted<BankSymmetricKey> encryptedKey, String AppId){
        //TODO: Problem 1.3
        int i ;
        if (getIndex(AppId) == -1) { i = indexNum++; }
        else { i = getIndex(AppId); }
        idArray[i] = AppId;

        if (encryptedKey != null) {
            if (encryptedKey.decrypt(secretKey) != null) {
                symmetricKey = encryptedKey.decrypt(secretKey);
                symkeyArray[i] = symmetricKey;
            }
        }
    }

    public Encrypted<Boolean> processRequest(Encrypted<Message> messageEnc, String AppId){
        //TODO: Problem 1.3
        int i = getIndex(AppId);
        if (symkeyArray[i] == null) { return null; }
        BankSymmetricKey symmetricKey = symkeyArray[i];
        if (messageEnc==null || messageEnc.decrypt(symmetricKey)==null) { return null; }
        Message message = messageEnc.decrypt(symmetricKey);

        Boolean success;
        if (message.getRequestType().equals("deposit")) {
            success = deposit(message.getId(), message.getPassword(), message.getAmount());
        }
        else {
            success = withdraw(message.getId(), message.getPassword(), message.getAmount());
        }

        return new Encrypted<Boolean>(success, symmetricKey);
    }


}
