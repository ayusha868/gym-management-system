public class RegularMember extends GymMember
{
    
    final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade;//Instance variable to check if the member is eligible for an upgrade
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //Constructor to initialize the RegularMember object with the given details
    public RegularMember(int id,String name,String location, String phone,String email,String gender,String DOB,String membershipStartDate,String referralSource)
    {
        //Calling the parent class (GymMember) constructor to initialize common fields
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        //Initialize Regular member
        this.referralSource = referralSource;//this.referralSource refers to the instance variable and referralSource refers to the parameter being passed in 
        this.isEligibleForUpgrade = false;//Setting eligibility 
        this.plan = "basic";  //Setting the initial plan to basic
        this.removalReason = "";
        this.price = 6500;
    }
     //Accessor methods (getters) to retrieve the values of the attributes
       public boolean getEligibleForUpgrade()
       {
           return isEligibleForUpgrade;
       }
       public String getReferralSource()
       {
           return referralSource;
       }
       public String getPlan()
       {
           return plan;
       }
       public String getRemovalReason()
       {
           return removalReason;
       }
        //Method to mark attendance and check eligibility for plan upgrade
       @Override
       public void markAttendance()
       { 
           this.attendance++;
           this.loyaltyPoints +=5;
           //If attendance exceeds or equals tge attendance limit,member is eligible for an upgrade
           if(this.attendance >=attendanceLimit)
           {
               this.isEligibleForUpgrade = true;
           }
       }
       //Method to get a price of a selected plan
       public double getPlanPrice(String plan)
       {
           switch(plan)
           {
               case "basic":
                   return 6500;
                   case "standard":
                       return 12500;
                       case "deluxe":
                       return 18500;
                       default:
                           return -1;
           }
       }
       //Method to upgrade the members plan if they are eligible and the new plan is valid
       public String upgradePlan(String newPlan)
       {
           //Checking if the member is eligible for an upgrade
           if (!this.isEligibleForUpgrade)
           {
              return "Member is not eligible for upgrade"; //return message fi not eligible for upgrade
       }
       //to check if the member is alredy subscribed to the same plan
       if(this.plan.equals(newPlan))
       {
           return "Member is already registered in the " + newPlan + " plan.";
           
       }
       //Get the price for the new plan
       double newPrice = getPlanPrice(newPlan);
       //if the plan price is invalid, return an error message
       if(newPrice == -1)
       {
           return"Invallid plan selected.";
       }
       //Update the plan and price
       this.plan = newPlan;
       this.price = newPrice;
       return"plan upgraded to " + newPlan + "successfully.";
}
//Method to revert the member to their default state(for removal or deactivation)
public void revertRegularMember(String removalReason)
{
    //calling the reset member form the parent class to display common attribute
    super.resetMember();
    //Reset regularmember
    this.isEligibleForUpgrade = false;
    this.plan = "basic";
    this.price = 6500;
    this.removalReason = removalReason;
}
//Method to display all detais of the RegularMemebr
@Override
public void display()
{
    //Call the siaplay() method from ther parent class to display common attriibutes
    super.display();
    System.out.println("Plan: " + plan);
    System.out.println("Price: " +price);
    //if there is a removal reason, diaply it
    if(!removalReason.isEmpty())
    {
        System.out.println("Removal Reason: " + removalReason);
    }
}
}