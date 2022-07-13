import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee implements Lead{

    public ArrayList<Accountant> team;


    public BusinessLead(String name) throws Exception {
        super(name);
        super.setBaseSalary(super.getBaseSalary() * 2);
        super.setHeadcount(10);
        this.team=new ArrayList<Accountant>();
    }

    @Override
    public boolean hasHeadCount(){
        if(this.team.size() < super.getHeadcount()){
            return true;
        } else {
            return false;
        }
    }


    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            team.add(e);
            e.setManager(this);
            super.setBonusBudget(getBonusBudget() + (e.getBaseSalary() * 1.1) );
            e.supportTeam(supportTeam);
            supportTeam.accountantSupport=e;
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean requestBonus(Employee e, double bonus) {
        if (bonus<=getBonusBudget()){
            super.setBonusBudget(getBonusBudget()-bonus);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getTeamStatus() {
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;

        }
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (int i=0;i<team.size();i++){
            if((team.get(i).getTeamSupported()).equals(e.getManager()) && team.get(i).approveBonus(bonus)) {
                team.get(i).setBonusBudget(team.get(i).getBonusBudget() - bonus);
                return true;
            }
        }
        return false;
    }


}
