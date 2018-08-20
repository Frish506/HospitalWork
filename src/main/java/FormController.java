import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class FormController implements Initializable{

    @FXML
    Button logoutButton = new Button();

    @FXML
    Label clock = new Label();

    @FXML
    ImageView logo = new ImageView();


    @FXML
    TabPane wholeTab = new TabPane();

    //The Tabs
    @FXML
    Tab generalInfoTab = new Tab();
    @FXML
    Tab summaryStatementTab = new Tab();
    @FXML
    Tab activeProblemsTab = new Tab();
    @FXML
    Tab medicationTab = new Tab();
    @FXML
    Tab functionalTab = new Tab();
    @FXML
    Tab medicalTeamTab = new Tab();
    @FXML
    Tab homeSettingTab = new Tab();
    @FXML
    Tab emergencyPlanTab = new Tab();


    //Tab 1's Objects
    @FXML
    TextField nameEntry = new TextField();
    @FXML
    TextField addressEntry = new TextField();
    @FXML
    TextField phoneEntry = new TextField();
    @FXML
    DatePicker DOBEntry = new DatePicker();
    @FXML
    TextField SSIEntry = new TextField();


    @FXML
    TextArea summaryStatement = new TextArea();
    @FXML
    TextArea socialHistory = new TextArea();


    @FXML
    Accordion allProblems = new Accordion();
    @FXML
    Button deleteProblemButton = new Button();
    @FXML
    Button addProblemButton = new Button();
    @FXML
    TextField problem1 = new TextField();
    @FXML
    TextField diet = new TextField();
    @FXML
    TextArea excercise = new TextArea();
    @FXML
    TextField scheduling = new TextField();


    @FXML
    Accordion allMedications = new Accordion();
    @FXML
    Button addMedicationButton = new Button();
    @FXML
    Button deleteMedicationButton = new Button();
    @FXML
    TextField medication1 = new TextField();
    @FXML
    TextField primaryPharmacy = new TextField();
    @FXML
    TextField secondaryPharmacy = new TextField();
    @FXML
    TextField medicationsManager = new TextField();
    @FXML
    TextField pillPlanner = new TextField();


    @FXML
    TextField mobility = new TextField();
    @FXML
    TextField transfers = new TextField();
    @FXML
    TextField toileting= new TextField();
    @FXML
    TextField personalHygiene = new TextField();
    @FXML
    TextField meals = new TextField();
    @FXML
    TextField shopping = new TextField();
    @FXML
    TextField housecleaning = new TextField();
    @FXML
    TextField finances = new TextField();
    @FXML
    TextField transportation = new TextField();


    @FXML
    Accordion allDoctors = new Accordion();
    @FXML
    Button addDoctorButton = new Button();
    @FXML
    Button deleteDoctorButton = new Button();
    @FXML
    TextField doctor1 = new TextField();


    @FXML
    Accordion allSupport = new Accordion();
    @FXML
    Button deleteSupportButton = new Button();
    @FXML
    Button addSupportButton = new Button();
    @FXML
    TextField support1 = new TextField();
    @FXML
    TextArea homeSetting = new TextArea();

    @FXML
    TextArea emergencyPlan = new TextArea();
    @FXML
    TextArea advancedDirectives = new TextArea();
    @FXML
    TextField resuscitationStatus = new TextField();
    @FXML
    TextField dpoaName = new TextField();
    @FXML
    TextField dpoaPhone = new TextField();
    @FXML
    TextField alternateName = new TextField();
    @FXML
    TextField alternatePhone = new TextField();

    @FXML
    Button next1 = new Button();
    @FXML
    Button next2 = new Button();
    @FXML
    Button next3 = new Button();
    @FXML
    Button next4 = new Button();
    @FXML
    Button next5 = new Button();
    @FXML
    Button next6 = new Button();
    @FXML
    Button next7 = new Button();
    @FXML
    Button finish = new Button();

    private Patient currPatient; //the patient being created

    private CarePlan currPlan = CarePlan.getInstance();

    private int minute; // minute for clock
    private int hour; // hour for clock

    public void initialize(URL url, ResourceBundle rb) {//run at the start of the app


        Timeline clockPlayer = new Timeline(new KeyFrame(Duration.ZERO, e ->{
            String am;
            Calendar cal = Calendar.getInstance();
            minute = cal.get(Calendar.MINUTE);

            hour = cal.get(Calendar.HOUR_OF_DAY);

            if(hour>12){//makes this not a 24 hour clock
                hour = hour -12;
                am = "PM";
            }
            else{
                if(hour==0){
                    hour = 12;//so that it displays 12 at night rather than 0 at night
                }
                am = "AM";
            }
            if(minute<10){
                clock.setText(hour +":0"+minute+ " " + am);
            }
            else {
                clock.setText(hour + ":" + minute + " " + am);
            }
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clockPlayer.setCycleCount(Animation.INDEFINITE);
        clockPlayer.play();
    }

    //Used to check all information in Tab 1 is correct before moving over to tab 2
    public void checkTab1() {
        boolean allSet = true;
        if(nameEntry.getText() == null || nameEntry.getText().isEmpty()) { //Checks if name is filled
            allSet = false;
        }
        if(addressEntry.getText() == null || addressEntry.getText().isEmpty()) {
            allSet = false;
        }
    }

    //Used to check general tab that doesn't
    public boolean checkTab(Parent checker) { //TODO Create this by cycling through all the text fields
       boolean allSet = true;
       List<Node> theChildren = checker.getChildrenUnmodifiable();
       ArrayList<TextInputControl> texts = new ArrayList<>();
       for(Node potentialText : theChildren) { //filters out all of the objects in the tab that ARENT'T text fields, then put the text fields in a separate arraylist
           if(potentialText.getClass().toString().equals("class javafx.scene.control.TextField") || potentialText.getClass().toString().equals("class javafx.scene.control.TextArea")) { //TODO figure out the date entry thing
               texts.add((TextInputControl) potentialText);
           }
       }
       for(TextInputControl userInput : texts) { //cycles through each text field- if it is empty then it does not allow the user to proceed
           if(userInput.getText() == null || userInput.getText().isEmpty()) {
               String prompt = userInput.getPromptText();
               userInput.setStyle("-fx-text-fill: red;");
               userInput.setText("Not Filled!");
               userInput.setOnMouseEntered(new EventHandler<MouseEvent>() {
                   @Override
                   public void handle(MouseEvent event) {
                       userInput.setStyle("-fx-text-fill: gray;");
                       userInput.setText("");
                       userInput.setPromptText(prompt);
                   }
               });

               allSet = false;
           }
       }
       return allSet;
    }

    public void button1() {
        boolean unlockSocial = checkTab(next1.getParent());
        if(unlockSocial) {
            summaryStatementTab.setDisable(false);
            wholeTab.getSelectionModel().select(1);
        }
    }

    public void button2() {
        if(checkTab(next2.getParent())) {
            activeProblemsTab.setDisable(false);
            wholeTab.getSelectionModel().select(2);
        }
    }

    public void button3() {
        if(!(problem1.getText() == null || problem1.getText().isEmpty())) {
            if(checkTab(next3.getParent())) {
                medicationTab.setDisable(false);
                wholeTab.getSelectionModel().select(3);
            }
        }
    }

    public void button4() {
        System.out.println("yeet");
        if(!(medication1.getText() == null || medication1.getText().isEmpty())) {
            System.out.println("Med1 Filled");
     //       if(checkTab(next3.getParent())) {
                System.out.println("yee");
                functionalTab.setDisable(false);
                wholeTab.getSelectionModel().select(4);
       //     }
        }
    }

    public void button5() {
        if (checkTab(next5.getParent())) {
            System.out.println("Button5");
            medicalTeamTab.setDisable(false);
            wholeTab.getSelectionModel().select(5);
        }
    }

    public void button6() {
        if(!(doctor1.getText() == null || doctor1.getText().isEmpty())) {
            homeSettingTab.setDisable(false);
            wholeTab.getSelectionModel().select(6);

        }
    }

    public void button7() {
        if(!(support1.getText() == null || support1.getText().isEmpty())) {
            if(checkTab(next7.getParent())) {
                emergencyPlanTab.setDisable(false);
                wholeTab.getSelectionModel().select(7);
            }
        }
    }

    //Next block of code is for the Active Problems tab
    int problemCount = 3;
    public void addNewProblem() { //Adds another fillable problem for the problem tab
        problemCount++;
        deleteProblemButton.setDisable(false);

        TextField newText = new TextField();
        newText.setMaxWidth(300);
        newText.setMaxHeight(50);

        newText.setFont(Font.font("System", FontWeight.NORMAL, 15));

        AnchorPane newAnchor = new AnchorPane(newText);
        newAnchor.setMinWidth(300);
        newAnchor.setMinHeight(50);
        newAnchor.setMaxWidth(440);
        newAnchor.setMaxHeight(50);


        TitledPane newPane = new TitledPane("Problem " + problemCount, newAnchor);
        newPane.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newPane.setMaxHeight(Region.USE_COMPUTED_SIZE);

        allProblems.getPanes().add(newPane);
    }

    public void deleteProblem() { //Removes last problem
        if(problemCount > 1) {
            allProblems.getPanes().remove(problemCount - 1);
            problemCount--;
        }
        if(problemCount == 1) {
            deleteProblemButton.setDisable(true);
        }
    }

    //Medications Tab functions

    int medicationCount = 3;
    public void addMedication() {
        medicationCount++;
        deleteMedicationButton.setDisable(false);

        TextField newMed = new TextField();
        newMed.setMinWidth(Region.USE_COMPUTED_SIZE);
        newMed.setMinHeight(Region.USE_COMPUTED_SIZE);
        newMed.setPrefWidth(300);
        newMed.setPrefHeight(50);
        newMed.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newMed.setMaxHeight(Region.USE_COMPUTED_SIZE);
        newMed.setFont(Font.font("System", FontWeight.NORMAL, 15));

        AnchorPane newAnchor = new AnchorPane(newMed);
        newAnchor.setMinWidth(300);
        newAnchor.setMaxHeight(50);
        newAnchor.setPrefWidth(300);
        newAnchor.setPrefHeight(50);
        newAnchor.setMaxHeight(Region.USE_COMPUTED_SIZE);
        newAnchor.setMaxHeight(Region.USE_COMPUTED_SIZE);

        TitledPane newPane = new TitledPane("Medication " + medicationCount, newAnchor);
        newPane.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newPane.setMaxHeight(Region.USE_COMPUTED_SIZE);

        allMedications.getPanes().add(newPane);
    }

    public void deleteMedication() {
        if(medicationCount > 1) {
            allMedications.getPanes().remove(medicationCount - 1);
            medicationCount--;
        }
        if(medicationCount == 1) {
            deleteMedicationButton.setDisable(true);
        }
    }

    int doctorCount = 3;
    public void addDoctor() {
        doctorCount++;
        deleteDoctorButton.setDisable(false);

        TextField newDoctor = new TextField();
        newDoctor.setMinWidth(Region.USE_COMPUTED_SIZE);
        newDoctor.setMinHeight(Region.USE_COMPUTED_SIZE);
        newDoctor.setPrefWidth(600);
        newDoctor.setPrefHeight(50);
        newDoctor.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newDoctor.setMaxHeight(Region.USE_COMPUTED_SIZE);
        newDoctor.setFont(Font.font("System", FontWeight.NORMAL, 23));

        AnchorPane newAnchor = new AnchorPane(newDoctor);
        newAnchor.setMinWidth(600);
        newAnchor.setMaxHeight(50);
        newAnchor.setPrefWidth(600);
        newAnchor.setPrefHeight(50);
        newAnchor.setMaxHeight(Region.USE_COMPUTED_SIZE);
        newAnchor.setMaxHeight(Region.USE_COMPUTED_SIZE);

        TitledPane newPane = new TitledPane("Doctor " + doctorCount, newAnchor);
        newPane.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newPane.setMaxHeight(Region.USE_COMPUTED_SIZE);

        allDoctors.getPanes().add(newPane);
    }

    public void deleteDoctor() {
        if(doctorCount > 1) {
            allDoctors.getPanes().remove(doctorCount - 1);
            doctorCount--;
        }
        if(doctorCount == 1) {
            deleteDoctorButton.setDisable(true);
        }
    }

    int supportCount = 3;
    public void addSupport() {
        supportCount++;
        deleteSupportButton.setDisable(false);

        TextField newSupport = new TextField();
        newSupport.setMinWidth(Region.USE_COMPUTED_SIZE);
        newSupport.setMinHeight(Region.USE_COMPUTED_SIZE);
        newSupport.setPrefWidth(600);
        newSupport.setPrefHeight(50);
        newSupport.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newSupport.setMaxHeight(Region.USE_COMPUTED_SIZE);
        newSupport.setFont(Font.font("System", FontWeight.NORMAL, 23));

        AnchorPane newAnchor = new AnchorPane(newSupport);
        newAnchor.setMinWidth(600);
        newAnchor.setMaxHeight(50);
        newAnchor.setPrefWidth(600);
        newAnchor.setPrefHeight(50);
        newAnchor.setMaxHeight(Region.USE_COMPUTED_SIZE);
        newAnchor.setMaxHeight(Region.USE_COMPUTED_SIZE);

        TitledPane newPane = new TitledPane("Support " + supportCount, newAnchor);
        newPane.setMaxWidth(Region.USE_COMPUTED_SIZE);
        newPane.setMaxHeight(Region.USE_COMPUTED_SIZE);

        allSupport.getPanes().add(newPane);
    }

    public void deleteSupport() {
        if(supportCount > 1) {
            allSupport.getPanes().remove(supportCount - 1);
            supportCount--;
        }
        if(supportCount == 1) {
            deleteSupportButton.setDisable(true);
        }
    }

    public void setCurrPlan() throws Exception{
        currPlan.setName(nameEntry.getText());
        currPlan.setAddress(addressEntry.getText());
        currPlan.setPhoneNumber(phoneEntry.getText());
        currPlan.setDOB("TEMP"); //TODO This
        currPlan.setSSI(SSIEntry.getText());

        currPlan.setSummary(summaryStatement.getText());
        currPlan.setSocialHistory(socialHistory.getText());

        ArrayList<String> problemsList = new ArrayList<>();
        for(int i = 0; i<problemCount; i++) {
            AnchorPane temp = (AnchorPane)allProblems.getPanes().get(i).getContent();
            TextField tempField = ((TextField) temp.getChildren().get(0));
            problemsList.add(tempField.getText());
        }
        currPlan.setActiveProblems(problemsList);
        currPlan.setDiet(diet.getText());
        currPlan.setExercise(excercise.getText());
        currPlan.setScheduling(scheduling.getText());


        ArrayList<String> medicationsList = new ArrayList<>();
        for (int i = 0; i < medicationCount; i++) {
            AnchorPane temp = (AnchorPane) allMedications.getPanes().get(i).getContent();
            TextField tempField = ((TextField) temp.getChildren().get(0));
            medicationsList.add(tempField.getText());
        }
        currPlan.setMedications(medicationsList);

        ArrayList<String> medManage = new ArrayList<>();
        medManage.add(primaryPharmacy.getText());
        medManage.add(secondaryPharmacy.getText());
        medManage.add(medicationsManager.getText());
        medManage.add(pillPlanner.getText());
        currPlan.setMedicationManagement(medManage);

        ArrayList<String> functional = new ArrayList<>();
        functional.add(mobility.getText());
        functional.add(transfers.getText());
        functional.add(toileting.getText());
        functional.add(personalHygiene.getText());
        functional.add(meals.getText());
        functional.add(shopping.getText());
        functional.add(housecleaning.getText());
        functional.add(finances.getText());
        functional.add(transportation.getText());
        currPlan.setFunctionalSummary(functional);

        ArrayList<String> doctorsList = new ArrayList<>();
        for (int i = 0; i < doctorCount; i++) {
            AnchorPane temp = (AnchorPane) allDoctors.getPanes().get(i).getContent();
            TextField tempField = ((TextField) temp.getChildren().get(0));
            doctorsList.add(tempField.getText());
        }
        currPlan.setMedicalTeam(doctorsList);

        currPlan.setHomeSetting(homeSetting.getText());
        ArrayList<String> supportsList = new ArrayList<>();
        for (int i = 0; i < supportCount; i++) {
            AnchorPane temp = (AnchorPane) allSupport.getPanes().get(i).getContent();
            TextField tempField = ((TextField) temp.getChildren().get(0));
            supportsList.add(tempField.getText());
        }
        currPlan.setSupportSystem(supportsList);

        currPlan.setEmergencyPlan(emergencyPlan.getText());
        currPlan.setAdvanceDirectives(advancedDirectives.getText());
        currPlan.setResuscitationStatus(resuscitationStatus.getText());
        ArrayList<String> DPOA = new ArrayList<>();
        DPOA.add(dpoaName.getText());
        DPOA.add(dpoaPhone.getText());
        DPOA.add(alternateName.getText());
        DPOA.add(alternatePhone.getText());

        Parent planViewScreen = FXMLLoader.load(getClass().getResource("FXMLFiles/CarePlanViewer.fxml"));
        StagesClass.planViewScene = new Scene(planViewScreen, 691, 892);
        StagesClass.mainStage.setScene(StagesClass.planViewScene);
    }

}