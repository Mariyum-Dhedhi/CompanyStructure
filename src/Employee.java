//SoftwareEngineer  -> Manages -> TechnicalLead -> Functionality -> Accountant -> Manages -> BusinessLead

public abstract class Employee {

    private double baseSalary;
    private String name;
    private final int employeeID;
    private static int countEmployeeID = 0;

    private Employee manager; //Employee's object representing Employee's manager


    private int headcount;
    public Accountant accountantSupport;

    public Employee(String name, double baseSalary) throws Exception{
        countEmployeeID++;
        this.employeeID = countEmployeeID;
        setName(name);
        setBaseSalary(baseSalary);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) throws Exception {
        if (name.length() >= 3) {
            this.name = name;
        }
        else
        {throw new Exception("Invalid Name - less than 3 characters");}
    }

    public int getEmployeeID() {
        return this.employeeID;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    protected void setBaseSalary(double baseSalary) throws Exception {
        if(baseSalary > 0) {
            this.baseSalary = baseSalary;
        }
        else
        {
            throw new Exception("Invalid Base Salary - cannot be less than 0");
        }
    }

    public Employee getManager(){
        return this.manager;
    }

    public void setManager(Employee manager){
        this.manager = manager;
    }

    public boolean equals(Employee otherID){
        return this.getEmployeeID() == otherID.getEmployeeID(); //Will turn "true" only when the statement is true
    }

    public String toString(){
        return getEmployeeID()
                + " "
                + getName();
    }
    public abstract String employeeStatus();

    public int getHeadcount() {
        return headcount;
    }

    protected void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

}
