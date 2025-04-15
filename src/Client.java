//Weston Culpepper
//02/16/2025
//003
//This class is used to create a client object for the budget


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    //variables
    private String firstName;
    private String lastName;
    private Contact contact;
    private Budget budget;
    private Tracker tracker;


    //No-args constructor
    public Client(){
        firstName = null;
        lastName = null;
        contact = new Contact();
        budget = new Budget();
        tracker = new Tracker();
    }


    //Args constructor
    public Client(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        contact = new Contact();
        budget = new Budget();
        tracker = new Tracker();
    }


    //getters and setters to encapsulate private fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Tracker getTracker() {
        return tracker;
    }

    public void setTracker(Tracker tracker) {
        this.tracker = tracker;
    }


    //other accessors and mutators
    public void loadClientFile(File filename){
        try(Scanner scan = new Scanner(filename)){
            //System.out.println("DEBUG: Reading input file...");

            if (!scan.hasNextLine()) {
                System.out.println("ERROR: Missing first name");
                return;
            }
            if (!scan.hasNextLine()) return;
            this.firstName = scan.nextLine().trim();
            //System.out.println("DEBUG: First Name = " + this.firstName);

            if (!scan.hasNextLine()) {
                System.out.println("ERROR: Missing last name");
                return;
            }
            if (!scan.hasNextLine()) return;
            this.lastName = scan.nextLine().trim();
            //System.out.println("DEBUG: lastName = " + this.lastName);

            if (!scan.hasNextLine()) return;
            String address = scan.nextLine().trim();
            //System.out.println("DEBUG: address  = " + address);

            if (!scan.hasNextLine()) return;
            String number = scan.nextLine().trim();
            //System.out.println("DEBUG: number  = " + number);

            if (!scan.hasNextLine()) return;
            String email = scan.nextLine().trim();
            //System.out.println("DEBUG: email  = " + email);
            //System.out.println("DEBUG: Address = " + address);
            //System.out.println("DEBUG: Number = " + number);
            //System.out.println("DEBUG: Email = " + email);

            this.contact = new Contact(address, number, email);
            this.tracker = new Tracker();
            this.budget = new Budget();
            ArrayList<Transaction> transactions = new ArrayList<>();
            ArrayList<BudgetCategory> categories = new ArrayList<>();

            while(scan.hasNextDouble()){

                String[] line = scan.nextLine().split(" ");
                double amount = Double.parseDouble(line[0]);//scan.nextDouble();


                if (!scan.hasNextInt()) { // Check if the next value is an integer

                }

                int type = Integer.parseInt(line[1]);;//scan.nextInt();
                scan.nextLine();

                if (!scan.hasNextLine()) ;
                String catName = scan.nextLine().trim();

                if (!scan.hasNextLine()) ;
                String description = scan.nextLine().trim();



                if (type == 1) {
                    budget.setTotalIncome(budget.getTotalIncome() + amount);

                } else if (type == 0) {
                    budget.setTotalAllocated(budget.getTotalAllocated() + amount);

                }

                categories.add(new BudgetCategory(catName, description, amount, type));
                transactions.add(new Transaction(catName, "No date", amount, description));
            }
//            while (scan.hasNextLine()) {
//                String category = scan.nextLine().trim();
//                System.out.println("DEBUG: Reading Category: " + category);
//
//                while (scan.hasNext()) {
//                    String category = scan.nextLine().trim();
//
//                    if (!scan.hasNext()) break;
//                    String date = scan.next().trim();
//
//                    if (!scan.hasNextDouble()) break;
//                    double amount = scan.nextDouble();
//                    scan.nextLine();
//
//                    if (!scan.hasNextLine()) break;
//                    String description = scan.nextLine().trim();
//
//                    System.out.println("DEBUG: Transaction - Category: " + category + ", Date: " + date + ", Amount: " + amount + ", Description: " + description);
//
//                    transactions.add(new Transaction(category, date, amount, description));
//                }
//            }

            for (Transaction t : transactions) {
                this.tracker.addTransaction(t);
            }
            for (BudgetCategory b : categories) {
                this.budget.addBudgetCategory(b);
            }
            //scan.close();
        }
        catch(java.io.FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void saveClientFile(File filename){

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(this.toString() + "\n");

            if (this.contact != null) {
                writer.write(this.contact.toString() + "\n");
            }

            if (this.budget != null) {
                writer.write(this.budget.toString() + "\n");
            }

            if (this.tracker != null) {
                for (Transaction transaction : this.tracker.getTransaction()) {
                    writer.write(transaction.toString() + "\n");
                }
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public String getBudgetReport(){
        if (budget == null) {
            return "No budget information available.";
        }
        StringBuilder report = new StringBuilder();
        System.out.println("\n");
        report.append(firstName).append(" ").append(lastName).append("'s ");//.append("Budget Report");
        report.append("Contact Info: ").append("\n").append(contact.toString()).append("\n\n");

        report.append("Spending:\n");
        report.append(String.format("%-20s %-15s\n", "Category", "Amount"));
        report.append("-----------------------------------\n");

        double spending = 0;
        for (BudgetCategory category : budget.getBudgetCategories()) {
            report.append(String.format("%-20s $%-15.2f\n", category.getCatName(), category.getAmount()));
            spending += category.getAmount();
        }

        report.append("-----------------------------------\n");
        report.append(String.format("%-20s $%-15.2f\n\n", "Total Spending:", spending));


        report.append("Income Sources:\n");
        report.append(String.format("%-20s %-15s\n", "Source", "Amount"));
        report.append("-----------------------------------\n");

        double totalIncome = budget.getTotalIncome();
        report.append(String.format("%-20s $%-15.2f\n", "Total Income:", totalIncome));


        double balance = totalIncome - spending;
        report.append("\nBalance: ").append(String.format("$%.2f", balance)).append("\n");

        return report.toString();
    }

    public String getTransactionReport() {
        if (this.tracker == null) {
            return firstName + " " + lastName + "'s Transaction Report\nNo transactions available.\n";
        }
        StringBuilder report = new StringBuilder();

        report.append(firstName).append(" ").append(lastName).append("'s ").append("Transaction Report\n");
        report.append("Current Balance: $").append(tracker.getBalance()).append("\n");
        report.append("Transactions:\n");


        for (Transaction transaction : tracker.getTransaction()) {
            report.append(" - Category: ").append(transaction.getCategory()).append("\n");
            report.append("   Date: ").append(transaction.getDate()).append("\n");
            report.append("   Amount: $").append(transaction.getAmount()).append("\n");
            report.append("   Description: ").append(transaction.getDescription()).append("\n\n");
        }

        return report.toString();
    }

        //public String getTransactionReport() {
//        StringBuilder report = new StringBuilder();
//        report.append("Transaction Report for ").append(firstName).append(" ").append(lastName).append("\n\n");
//
//        String currentCategory = "";
//        double totalSpent = 0, categoryBudget = 0;
//
//        for (Transaction transaction : tracker.getTransaction()) {
//            // If the category changes, print the previous category's remaining balance
//            if (!transaction.getCategory().equals(currentCategory)) {
//                if (!currentCategory.isEmpty()) {
//                    report.append("---------------------------------------------------\n");
//                    report.append(String.format("Remaining Balance for %s: %.2f\n\n", currentCategory, categoryBudget - totalSpent));
//                }
//
//                // Start a new category
//                currentCategory = transaction.getCategory();
//                totalSpent = 0;
//                categoryBudget = 0; // Reset for new category
//
//                // Find the budget for this category using a simple loop
//                for (BudgetCategory b : this.budget.getBudgetCategories()) {
//                    if (b.getCatName().equalsIgnoreCase(currentCategory)) {
//                        categoryBudget = b.getAmount();
//                        break; // Stop searching once found
//                    }
//                }
//
//                report.append("Category: ").append(currentCategory).append("\n");
//                report.append("---------------------------------------------------\n");
//                report.append(String.format("%-10s %-10s %s\n", "Date", "Amount", "Description"));
//                report.append("---------------------------------------------------\n");
//            }
//
//            // Print transaction details
//            report.append(String.format("%-10s %-10.2f %s\n", transaction.getDate(), transaction.getAmount(), transaction.getDescription()));
//            totalSpent += transaction.getAmount();
//        }
//
//        // Print the last category's remaining balance
//        report.append("---------------------------------------------------\n");
//        report.append(String.format("Remaining Balance for %s: %.2f\n\n", currentCategory, categoryBudget - totalSpent));
//
//        return report.toString();
//    }

    //toString to return the object information is string format
    @Override
    public String toString(){
        return this.firstName + System.lineSeparator() + this.lastName + System.lineSeparator() ; //this.contact + "\n" + this.budget + "\n" + this.tracker;
    }

}