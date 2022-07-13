public class Accountant extends BusinessEmployee{

    private TechnicalLead teamSupported;

    public Accountant(String name) throws Exception {
        super(name);
        super.setBonusBudget(0);
    }

    public TechnicalLead getTeamSupported(){
        return teamSupported;
    }

    public void supportTeam(TechnicalLead lead){
        this.teamSupported=lead;
        for (int i=0; i<lead.team.size(); i++){
            this.setBonusBudget(getBonusBudget() + lead.team.get(i).getBaseSalary() * 0.1 );
        }
    }

    public boolean approveBonus(double bonus) {
        if (this.getTeamSupported() != null) {
            if (bonus <= getBonusBudget()) {
                return true;
            } else {
                return false;
            }
        } else
        {
            return false;
        }
    }

    public String employeeStatus(){
        return super.toString() +" with a budget of "
                + getBonusBudget() +" is supporting "
                + this.getTeamSupported();
    }
}
