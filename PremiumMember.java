public class PremiumMember extends GymMember
{
    //final means it cant be hanged once initialized
    private final double premiumCharge = 5000;
    private String personalTrainer;//instance variable to store the personal trainers name
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //Constructor to initialize a Premiummember object with the given details
    public PremiumMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate,String personalTrainer)
    {
        //Calling the parent class (GymMember) constructor by using super to initialize
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.personalTrainer = personalTrainer;//setting personal traoner name
        //Initializing payment and discount related fields
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
//Accessor methods (getters) to retrieve the values of the attribute
public double getPremiumCharge()
{
    return premiumCharge;
}
public String getPersonalTrainer()
{
    return personalTrainer;
}
public boolean isFullPayment()
{
    return isFullPayment;
}
public double getPaidAmount()
{
    return paidAmount;
}
public double getDiscountAmount()
{
    return discountAmount;
}
//method to mark attendance and reward loyalty points
@Override
public void markAttendance()
{
    attendance++;//Increment attendance count by 1
    loyaltyPoints += 10;//Add 10 loyalty points for each attendance
}
//methods to pay the due amount
public String payDueAmount(double amount)
{
    //check is payment is already full
     if(isFullPayment)
     {
         return"payment is already complete.";
     }
     //Add the given amount to the total paidamount
     this.paidAmount += paidAmount;
     //Checking if the paid amount exceeds the premium charge
     if(this.paidAmount > premiumCharge)
     {
         return"the amount exceeds the premium charge."; 
     }
     if(this.paidAmount == premiumCharge)
     {
         isFullPayment = true;
     }
     //Calculating the remaining amount that still needs to be paid
     double  remainingAmount = premiumCharge - paidAmount;
     return"Payment is successful.Remaining amount: "+remainingAmount;
}
public String calculateDiscount()
{
    //check if full payment is made before applying discount
    if(isFullPayment)
    {
        //Calculate 10% discount of the premium charge
        discountAmount = premiumCharge * 0.1;
        return "Discount calculated successfully.Discount amount:" + discountAmount;
        
    }
    else
    {
        return "Payment is not full.No discount is applicable.";//If the payment is not full no discount is applied
    }
}
//method to revert the PremiumMember to its initial state
public void revertPremiumMember()
{
    //Calling the resetMember() method from the parent class to reset common attributes
    super.resetMember();
    //Reset the PremiumMember
    this.personalTrainer = "";  //Clear rhe personal to default values
    this.isFullPayment = false;  //Set full payment status to false
    this.paidAmount = 0;  //Set paid amount to zero
    this.discountAmount = 0;  //Set discount amount to zero
    
}
//Method to display all details of the PremiumMember
@Override
public void display()
{
    //Calling the display() method from the parent class to display common attributes
    super.display();
    //Display PremiumMember
    System.out.println("Personal Trainer: " + personalTrainer);
    System.out.println("Paid Amount: " + paidAmount);
    System.out.println("Full Payment: " + isFullPayment);
    
    //Calculating the remaining amount to be paid
    double remainingAmount = premiumCharge - paidAmount;
    System.out.println("Remaining Amount: " + remainingAmount);
    
    //If the payment is full, display the discount amount
    if(isFullPayment)
    {
        System.out.println("Discount: " + discountAmount);
    }
}
}