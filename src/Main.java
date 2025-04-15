//Weston Culpepper
//02/16/2025
//003
//This is the main class used to run the program, instantiate objects for use, and test functionality of methods and objects

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Client client2 = new Client();
        client2.loadClientFile(new File("C:\\Users\\aveng\\IdeaProjects\\major-program-1-budgettracker-wlculpepper27\\budgetdataV3.txt"));
        client2.saveClientFile(new File("Output.txt"));
        System.out.println(client2.getBudgetReport());
        System.out.println(client2.getTransactionReport());
    }
}