import java.util.ArrayList;

public class CarePlan {

    private String summary;
    private String name, address, phoneNumber, DOB, SSI;
    private ArrayList<String> activeProblems; //TODO potentially initialize?
    private ArrayList<String> medications;
    private String socialHistory;
    private ArrayList<String> medicalTeam;
    private String homeSetting;
    private ArrayList<String> supportSystem;
    private ArrayList<String> functionalSummary;
    private ArrayList<String> advanceDirectives;
    private ArrayList<String> equipmentAtHome;
    private ArrayList<String> medicationManagement;
    private String emergencyPlan;
    private String diet;
    private String exercise;
    private String scheduling;

    public ArrayList<String> errors;

    public CarePlan() {

    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSSI() {
        return SSI;
    }

    public void setSSI(String SSI) {
        if(!(SSI.length() == 11)) { //checks if SSI was input properly
            errors.add("SSI");
        }
        else if(errors.contains("SSI")) { //if SSI was input properly and it had previously not been, removes the issue
            errors.remove("SSI");
        }
        this.SSI = SSI;
    }

    public ArrayList<String> getActiveProblems() {
        return activeProblems;
    }

    public void setActiveProblems(ArrayList<String> activeProblems) {
        this.activeProblems = activeProblems;
    }

    public ArrayList<String> getMedications() {
        return medications;
    }

    public void setMedications(ArrayList<String> medications) {
        this.medications = medications;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public ArrayList<String> getMedicalTeam() {
        return medicalTeam;
    }

    public void setMedicalTeam(ArrayList<String> medicalTeam) {
        this.medicalTeam = medicalTeam;
    }

    public String getHomeSetting() {
        return homeSetting;
    }

    public void setHomeSetting(String homeSetting) {
        this.homeSetting = homeSetting;
    }

    public ArrayList<String> getSupportSystem() {
        return supportSystem;
    }

    public void setSupportSystem(ArrayList<String> supportSystem) {
        this.supportSystem = supportSystem;
    }

    public ArrayList<String> getFunctionalSummary() {
        return functionalSummary;
    }

    public void setFunctionalSummary(ArrayList<String> functionalSummary) {
        this.functionalSummary = functionalSummary;
    }

    public ArrayList<String> getAdvanceDirectives() {
        return advanceDirectives;
    }

    public void setAdvanceDirectives(ArrayList<String> advanceDirectives) {
        this.advanceDirectives = advanceDirectives;
    }

    public ArrayList<String> getEquipmentAtHome() {
        return equipmentAtHome;
    }

    public void setEquipmentAtHome(ArrayList<String> equipmentAtHome) {
        this.equipmentAtHome = equipmentAtHome;
    }

    public ArrayList<String> getMedicationManagement() {
        return medicationManagement;
    }

    public void setMedicationManagement(ArrayList<String> medicationManagement) {
        this.medicationManagement = medicationManagement;
    }

    public String getEmergencyPlan() {
        return emergencyPlan;
    }

    public void setEmergencyPlan(String emergencyPlan) {
        this.emergencyPlan = emergencyPlan;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getScheduling() {
        return scheduling;
    }

    public void setScheduling(String scheduling) {
        this.scheduling = scheduling;
    }
}
