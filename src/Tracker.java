//Weston Culpepper
//02/16/2025
//003
//Tracker class designed to keep a tracker of all transactions made


import java.util.ArrayList;


public class Tracker {
    //variables
    private ArrayList<Transaction> transactions;
    private double balance;


    //No-args constructor
    public Tracker(){
        transactions = new ArrayList<>();
        balance = 0.0;
    }


    //getters and setters to encapsulate private fields
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //ArrayList methods
    public ArrayList<Transaction> getTransaction(){
        return transactions;
    }

    public void setTransaction(int index, Transaction x){
        this.transactions.set(index, x);
    }

    public int getTransactionsSize(){
        return transactions.size();
    }

    public Transaction getTransaction(int index){
        return transactions.get(index);
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public Transaction removeTransaction(int index){
        return transactions.remove(index);
    }


    //toString to return the object information is string format
    @Override
    public String toString() {
        return this.balance + System.lineSeparator() + this.transactions;
    }
}

