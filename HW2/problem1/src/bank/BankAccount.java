package bank;

import bank.event.*;

class BankAccount {
    private Event[] events = new Event[maxEvents];
    final static int maxEvents = 100;

    private int eventNum = 0;
    private String id;
    private String password;
    private int balance;

    BankAccount(String id, String password, int balance) {
        //TODO: Problem 1.1
        this.id = id;
        this.password = password;
        this.balance = balance;
    }

    boolean authenticate(String password) {
        //TODO: Problem 1.1
        if ( password.equals(this.password)) { return true; }
        return false;
    }

    void deposit(int amount) {
        //TODO: Problem 1.1
        this.balance += amount;
        events[eventNum] = new DepositEvent();
        eventNum ++;
    }

    boolean withdraw(int amount) {
        //TODO: Problem 1.1
        if (balance < amount) { return false;}
        balance -= amount;
        events[eventNum] = new WithdrawEvent();
        eventNum ++;

        return true;
    }

    void receive(int amount) {
        //TODO: Problem 1.1
        balance += amount;
        events[eventNum] = new ReceiveEvent();
        eventNum ++;
    }

    boolean send(int amount) {
        //TODO: Problem 1.1
        if (balance < amount) { return false; }
        balance -= amount;
        events[eventNum] = new SendEvent();
        eventNum ++;

        return true;
    }

    Event[] getEvents() {
        Event[] temp = new Event[eventNum];
        for (int i=0; i<eventNum; i++) {
            temp[i] = events[i];
        }
        return temp;
    }

    int getBalance() {
        return this.balance;
    }

}
