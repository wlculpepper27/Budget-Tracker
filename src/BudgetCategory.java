//Weston Culpepper
//02/16/2025
//003
//ButgetCategory class designed to create an object that keeps track of an expense in that category


public class BudgetCategory {
    //assigning variables
    private String catName;
    private String catDescription;
    private double amount;
    private int categoryType;


    //no-args constructor
    public BudgetCategory() {
        catName = null;
        catDescription = null;
        amount = 0.0;
        categoryType = 0;
    }


    //constructor with arguments
    public BudgetCategory(String catName, String catDescription, double amount, int categoryType) {
        this.setCatName(catName);
        this.setCatDescription(catDescription);
        this.setAmount(amount);
        this.setCategoryType(categoryType);
    }


    //getters and setters to encapsulate private fields
    public String getCatName() {
        return this.catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDescription() {
        return this.catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }


    //toString to return the object information is string format
    @Override
    public String toString() {
        return this.catName + System.lineSeparator() + this.catDescription + System.lineSeparator() + this.amount + System.lineSeparator() + this.categoryType;
    }
}
