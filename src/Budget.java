//Weston Culpepper
//02/16/2025
//003
//This class creates a budget object using other classes as attributes


import java.util.ArrayList;


public class Budget {
    //variables
    private ArrayList<BudgetCategory> categories;
    private double totalAllocated;
    private double totalIncome;


    //No-args constructor
    public Budget() {
        categories = new ArrayList<>();
        totalAllocated = 0.0;
        totalIncome = 0.0;
    }


    //returns the amount of the budget that can be allocated (income - allocated)
    public double getAllocationBalance() {
        return getTotalIncome() - getTotalAllocated();
    }


    //getters and setters to encapsulate private fields
    public double getTotalAllocated() {
        return totalAllocated;
    }

    public void setTotalAllocated(double totalAllocated) {
        this.totalAllocated = totalAllocated;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }


    //ArrayList methods
    public ArrayList<BudgetCategory> getBudgetCategories() {
        return categories;
    }

    public void setBudgetCategory(int index, BudgetCategory x) {
        this.categories.set(index, x);
    }

    public int getBudgetCategoriesSize() {
        return categories.size();
    }

    public BudgetCategory getBudgetCategory(int index) {
        return categories.get(index);
    }

    public void addBudgetCategory(BudgetCategory category) {
        categories.add(category);
    }

    public BudgetCategory removeBudgetCategory(int index) {
        return categories.remove(index);
    }


    //toString to return the object information is string format
    @Override
    public String toString() {
        return this.categories + System.lineSeparator() + this.totalAllocated + System.lineSeparator() + this.totalIncome;
    }
}
