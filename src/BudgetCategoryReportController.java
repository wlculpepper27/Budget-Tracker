import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class BudgetCategoryReportController {
    Client client = null;

    @FXML
    ComboBox<String> cmbCategory2;
    @FXML
    TextArea txtReport;
    @FXML
    Button btnClose;

    public void initData(Client client) {
        this.client = client;
        int numBudgetCategories = 0;//####write code that returns the # of budget categories
        String[] categories = new String[numBudgetCategories];

        txtReport.setStyle("-fx-font-family: Consolas");
        txtReport.setEditable(false);

        //##### Add code to copy each category name into the categories array.


        cmbCategory2.getItems().addAll(FXCollections
                .observableArrayList(categories));

    }

    /***
     * Event handler for a new comboBox selection.
     */
    @FXML
    protected void onComboClick2() {
        String selectedValue = cmbCategory2.getValue().trim();
        //####
        //Find the index of the BudgetCategory object that matches the
        //selected comboBox value -- selectedValue

        String sOutput;
        //####
        //Populate a string (sOutput) containing the transaction report for the selected category.
        //your report should include the budget amount for the category, all the
        //transactions, and the current balance.  Use String.format to get neat output.
        //txtReport.setText(sOutput);

        //You can also just create a new Client method that returns the transaction report
        //by passing it the category as a parameter.
        //txtReport.setText(client.getTransactionReport(selectedValue));



    }

    @FXML
    protected void onBtnCloseClick() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}