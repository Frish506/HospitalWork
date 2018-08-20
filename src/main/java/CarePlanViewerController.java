import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CarePlanViewerController implements Initializable {
    @FXML
    ImageView backgroundImage = new ImageView();
    @FXML
    Text summaryText = new Text();
    @FXML
    Text activeProblemsText = new Text();
    @FXML
    Text medicationsText = new Text();
    @FXML
    Text socialText = new Text();
    @FXML
    Text medicalTeamText = new Text();
    @FXML
    Text homeSettingText = new Text();
    @FXML
    Text supportText = new Text();
    @FXML
    Text functionalText = new Text();
    @FXML
    Text advanceText = new Text();
    @FXML
    Text equipmentText = new Text();
    @FXML
    Text medicationManagementText = new Text();
    @FXML
    Text emergencyText = new Text();
    @FXML
    Text dietText = new Text();
    @FXML
    Text excerciseText = new Text();
    @FXML
    Text schedulingText = new Text();

    CarePlan thePlan = CarePlan.getInstance();

    public void initialize(URL url, ResourceBundle rb) {
        takePlan();
        summaryText.setFont(Font.font("System", FontWeight.BOLD, 16));
        homeSettingText.setStroke(Color.VIOLET);
    }

    public void takePlan() {
        summaryText.setText(thePlan.getSummary());
        activeProblemsText.setText(makeList(thePlan.getActiveProblems()));
        medicationsText.setText(makeList(thePlan.getMedications()));
        socialText.setText(thePlan.getSocialHistory());
        medicalTeamText.setText(makeList(thePlan.getMedicalTeam()));
        homeSettingText.setText(thePlan.getHomeSetting());
        supportText.setText(makeList(thePlan.getSupportSystem()));
        functionalText.setText(makeList(thePlan.getFunctionalSummary()));
        advanceText.setText(thePlan.getAdvanceDirectives());
//        equipmentText.setText(makeList(thePlan.getEquipmentAtHome())); TODO I need to figure this out
        medicationManagementText.setText(makeList(thePlan.getMedicationManagement()));
        emergencyText.setText(thePlan.getEmergencyPlan());
        dietText.setText(thePlan.getDiet());
        excerciseText.setText(thePlan.getExercise());
        schedulingText.setText(thePlan.getScheduling());
    }

    public String makeList(ArrayList<String> allThings) {
        String sampleText = "";
        for(int i = 0; i<allThings.size(); i++) {
            sampleText = sampleText + allThings.get(i) + "\n";
        }
        return sampleText;
    }
}
