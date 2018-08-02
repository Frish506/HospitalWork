import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
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

    //The Tabs
    @FXML
    Tab generalInfoTab = new Tab();
    @FXML
    Tab summaryStatementTab = new Tab();




    //Tab 1's Objects
    @FXML
    TextField nameEntry = new TextField();
    @FXML
    TextField addressEntry = new TextField();
    @FXML
    TextField phoneEntry = new TextField();
    @FXML
    DatePicker DOBEntry = new DatePicker(); //TODO readd this
    @FXML
    TextField SSIEntry = new TextField();
    @FXML
    Button next1 = new Button();

    private Patient currPatient; //the patient being created

    private int minute; // minute for clock
    private int hour; // hour for clock
    private int second; // second for clock

    public void initialize(URL url, ResourceBundle rb) {//run at the start of the app


        Timeline clockPlayer = new Timeline(new KeyFrame(Duration.ZERO, e ->{
            String am;
            Calendar cal = Calendar.getInstance();
            minute = cal.get(Calendar.MINUTE);

            hour = cal.get(Calendar.HOUR_OF_DAY);

            second = cal.get(Calendar.SECOND);
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
                clock.setText(hour +":0"+minute+":"+ second + " " + am);
            }
            else {
                clock.setText(hour + ":" + minute+ ":" + second + " " + am);
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
       ArrayList<TextField> texts = new ArrayList<>();
       for(Node potentialText : theChildren) { //filters out all of the objects in the tab that ARENT'T text fields, then put the text fields in a separate arraylist
           if(potentialText.getId() != null && !(potentialText.getId().equals("next1"))) { //TODO figure out the date entry thing
               texts.add((TextField) potentialText);
           }
       }
       for(TextField userInput : texts) {
           if(userInput.getText() == null || userInput.getText().isEmpty()) {
               allSet = false;
           }
       }
       return allSet;
    }

    public void button1() {
        boolean unlockSocial = checkTab(next1.getParent());
        if(unlockSocial) {
            summaryStatementTab.setDisable(false);
        }
    }


}