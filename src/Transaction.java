//Weston Culpepper
//02/16/2025
//003
//Transaction class designed to create an object that keeps track of transactions


public class Transaction {
    //assigning variables
    private String category;
    private String date;
    private double amount;
    private String description;


    //no-args constructor
    public Transaction() {
        category = null;
        date = null;
        amount = 0.0;
        description = null;
    }


    //constructor with arguments
    public Transaction(String category, String date, double amount, String description) {
        this.setCategory(category);
        this.setDate(date);
        this.setAmount(amount);
        this.setDescription(description);
    }


    //getters and setters to encapsulate private fields
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    //toString to return the object information is string format
    @Override
    public String toString() {
        return this.category + System.lineSeparator() + this.date + System.lineSeparator() + this.amount + System.lineSeparator() + this.description;
    }
}
