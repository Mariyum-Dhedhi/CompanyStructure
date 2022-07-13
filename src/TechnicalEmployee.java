public abstract class TechnicalEmployee extends Employee{

    private int checkIns;

    public TechnicalEmployee(String name) throws Exception {
        super(name, 75000.0);
        this.checkIns = 0;
    }

    @Override
    public String employeeStatus() {
        return super.toString()
                + " has " + this.checkIns
                + " successful checkIns";
    }

    public void CheckIn() {
        checkIns ++;
    }

    public int getCheckIns() {
        return this.checkIns;
    }
}
