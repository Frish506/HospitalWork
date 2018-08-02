public class Patient {
    private String name, SSI;
    private CarePlan myPlan;
    private problemPlans myProblemPlans;

    public Patient(CarePlan thePlan) {
        setMyPlan(thePlan);
        setName();
        setSSI();
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = getMyPlan().getName();
    }

    public String getSSI() {
        return SSI;
    }

    public void setSSI() {
        this.SSI = getMyPlan().getSSI();
    }

    public CarePlan getMyPlan() {
        return myPlan;
    }

    public void setMyPlan(CarePlan myPlan) {
        this.myPlan = myPlan;
    }

    public problemPlans getMyProblemPlans() {
        return myProblemPlans;
    }

    public void setMyProblemPlans(problemPlans myProblemPlans) {
        this.myProblemPlans = myProblemPlans;
    }
}
