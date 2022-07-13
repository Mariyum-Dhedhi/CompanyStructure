import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee implements Lead{

    public ArrayList<SoftwareEngineer> team;

    public TechnicalLead(String name) throws Exception {
        super(name);
        super.setBaseSalary(super.getBaseSalary() * 1.3);
        super.setHeadcount(4);
        this.team = new ArrayList<SoftwareEngineer>();
    }

    @Override
    public boolean hasHeadCount(){
        if (team.size() < super.getHeadcount()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer e){
        if (hasHeadCount()){
            team.add(e);
            e.setManager(this); // Technical Lead -> Manager -> Software Engineer
            return true;
        }
        else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        if (e.getManager().equals(this) && e.getCodeAccess()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean requestBonus(Employee e, double bonus){
        BusinessLead businessLead= (BusinessLead) super.getAccountantSupport().getManager();
        if (businessLead.approveBonus(e, bonus)){
            return true;
        } else {
            return false;
        }
    }
    public String getTeamStatus(){
        if (team.size() == 0){
            return super.employeeStatus() + " and no direct reports";
        }
        else{
            String teamStatus = "";
            for (int i = 0;i < team.size();i++){
                teamStatus+=("    "+ team.get(i).employeeStatus()+ "\n");
            }
            return super.employeeStatus() + " and is managing: \n" +teamStatus;
        }
    }



}
