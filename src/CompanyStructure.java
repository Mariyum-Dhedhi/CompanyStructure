public class CompanyStructure {

    public static void main(String[] args) throws Exception{
        TechnicalLead TechLead1 = new TechnicalLead("Kasey");
        SoftwareEngineer softwareEngineer1 = new SoftwareEngineer("Shammas");
        SoftwareEngineer softwareEngineer2 = new SoftwareEngineer("Zainab");
        SoftwareEngineer softwareEngineer3 = new SoftwareEngineer("Zara");
        SoftwareEngineer softwareEngineer4 = new SoftwareEngineer("Usman");
        SoftwareEngineer softwareEngineer5 = new SoftwareEngineer("Alisha");


        System.out.println("Add SE1 in TechLead1 : "+ TechLead1.addReport(softwareEngineer1));
        softwareEngineer1.checkInCode();
        softwareEngineer1.checkInCode();
        System.out.println("Add SE2 in TechLead1 : "+ TechLead1.addReport(softwareEngineer2));
        System.out.println("Add SE3 in TechLead1 : "+ TechLead1.addReport(softwareEngineer3));
        softwareEngineer3.checkInCode();
        System.out.println("Add SE4 in TechLead1 : "+ TechLead1.addReport(softwareEngineer4));
        System.out.println("Add SE5 in TechLead1 : "+ TechLead1.addReport(softwareEngineer5));

        System.out.println();
        System.out.println(TechLead1.getTeamStatus());


        TechnicalLead TechLead2 = new TechnicalLead("Mariyum");
        SoftwareEngineer softwareEngineer6 = new SoftwareEngineer("Haseeb");
        SoftwareEngineer softwareEngineer7 = new SoftwareEngineer("Unaiza");
        System.out.println("Add SE6 in TechLead2 : "+ TechLead2.addReport(softwareEngineer6));
        System.out.println("Add SE7 in TechLead2 : "+ TechLead2.addReport(softwareEngineer7));
        softwareEngineer6.checkInCode();
        softwareEngineer6.checkInCode();

        //softwareEngineer5.checkInCode(); //null pointer as this SoftwareEngineer was not added to the list
        softwareEngineer7.checkInCode();

        System.out.println();
        System.out.println(TechLead2.getTeamStatus());
        System.out.println(TechLead1.getTeamStatus());


        BusinessLead BusLead1 = new BusinessLead("Ahmed");
        Accountant accountant1 = new Accountant("Dua");
        Accountant accountant2 = new Accountant("John");
        BusLead1.addReport(accountant1, TechLead1);
        BusLead1.addReport(accountant2, TechLead2);

        System.out.println(BusLead1.getTeamStatus());

        System.out.println("Checking BusinessLead approves Bonus for " + softwareEngineer1.getName() + " : "+ TechLead1.requestBonus(softwareEngineer1, 7000));
        System.out.println("Updated Budget for " + softwareEngineer1.getName() + " : " + softwareEngineer1.getManager().getAccountantSupport().getBonusBudget() + "\n");
        System.out.println("Checking BusinessLead approved Bonus for " + softwareEngineer3.getName() + " : " + TechLead1.requestBonus(softwareEngineer3, 3000));
        System.out.println("Updated Budget for " + softwareEngineer3.getName() + " : "+ softwareEngineer3.getManager().getAccountantSupport().getBonusBudget() + "\n");

        System.out.println("Available Budget for " + softwareEngineer6.getName() + " : " + softwareEngineer6.getManager().getAccountantSupport().getBonusBudget());
        System.out.println("Checking BusinessLead approves Bonus for " + softwareEngineer6.getName() + " : "+ TechLead2.requestBonus(softwareEngineer6, 16000));
        System.out.println("Updated Budget for " + softwareEngineer6.getName() + " : " + softwareEngineer6.getManager().getAccountantSupport().getBonusBudget() + "\n");
    }
}
