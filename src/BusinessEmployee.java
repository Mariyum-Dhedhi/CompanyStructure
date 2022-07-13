public abstract class BusinessEmployee extends Employee{

    private double bonusBudget;


    public BusinessEmployee(String name) throws Exception {
        super(name, 50000.0);
    }

    public double getBonusBudget() {
        return bonusBudget;
    }

    public void setBonusBudget(double budgetBonus) {
        this.bonusBudget = budgetBonus;
    }

    @Override
    public String employeeStatus() {
        return this.toString()
                + " with a budget of "
                + getBonusBudget();
    }

}
