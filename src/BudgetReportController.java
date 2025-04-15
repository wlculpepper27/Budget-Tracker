import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class BudgetReportController {
    @FXML
    Label lblMessage;
    Client client = null;
    @FXML
    Button btnClose;
    @FXML
    TextArea txtReport;
    private int reportType;

    /**
     *
     * @param client
     * @param rptType
     */
    public void initData(Client client, int rptType) {
        String sOutput = "";
        reportType = rptType;
        this.client = client;
        if (rptType == 0) {
            //####
            //sOutput should be assigned a string containing the formated budget
            //allocation information (no transaction data).
            lblMessage.setText("Budget Allocation Report");
            txtReport.setText(sOutput);
        }
        else {
            //####
            //sOutput should be assigned a string containing the full budget report
            //including the budget allocations and all the transactions grouped by
            //category with the balance of each category.
            lblMessage.setText("Full Budget Report");
            txtReport.setText(client.getBudgetReport() + "\n\n" + client.getTransactionReport());
        }
        //I am changing to a non-proportional font so that columns line up.
        txtReport.setStyle("-fx-font-family: Consolas");
        txtReport.setEditable(false);

    }

    @FXML
    protected void onBtnCloseClick() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
