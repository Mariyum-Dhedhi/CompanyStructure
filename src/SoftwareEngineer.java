public class SoftwareEngineer extends TechnicalEmployee{

    private boolean codeAccess;

    public SoftwareEngineer(String name) throws Exception {
        super(name);
        setCodeAccess(true);
    }

    public boolean getCodeAccess() {
        return codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return super.getCheckIns();
    }

    public boolean checkInCode() throws NullPointerException{
        TechnicalLead manager =(TechnicalLead) this.getManager();
        if (manager.approveCheckIn(this)) {
            super.CheckIn();
            return true;
        }
        else {
            codeAccess = false;
            throw new NullPointerException("No such Software Engineer exists! Check team status for available software Engineers");
        }
    }

}
