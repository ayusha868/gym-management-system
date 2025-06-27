
public abstract class GymMember
{
    //members attributes that store personal details and gym related infirmation
    protected int id; 
    protected String name;
    protected String location;
    protected String phone;
    protected String gender;
    protected String email;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    private boolean activeStatus;
    private boolean deactiveMembership;
    //Constructor to initialize a gym member with personal details and membership information
    public GymMember(int id,String name,String location,String phone,String email,String gender,String DOB,String membershipStartDate)
    {
        this.id = id;  //this.id refers to the instance variable and id refers to the parameter being passed in 
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;//initializes attendance to 0 when a new member joins
        this.loyaltyPoints = 0.0;//initializes loyalty points to 0 when a new member joins
        this.activeStatus = false;//membership is intially inactive
    }
    //Accessor methods (getters) to retrieve the values of the attributes
    public int getId()
    {
        return id;//Return member's ID
    }
    public String getName()
    {
        return name;
    }
    public String getLocation()
    {
        return location;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getEmail()
    {
        return email;
    }
    public String getGender()
    {
        return gender;
    }
    public String getDOB()
    {
        return DOB;
    }
    public String getMembershipStartDate()
    {
        return membershipStartDate;
    }
    public int getAttendance()
    {
        return attendance;
    }
    public double getLoyaltyPoints()
    {
        return loyaltyPoints;
    }
    public boolean getActiveStatus()
    {
        return activeStatus;
    }
    public void deactivateMembership() {
        this.activeStatus = false; 
    }
    public void activateMembership() {
        this.activeStatus = true; 
    }
    public boolean isActiveStatus() {
    return activeStatus;
}
    public abstract void markAttendance();
    
    public void activeMembership()
    {
        if(!activeStatus){//to check id member is not already active if condition is applied
            activeStatus = true;//Active membership
            System.out.println("Membership activated.");//print message indicating activation
        }
    }
    //Method to deactivate the membership of the member
    public void deactivateMembefrship(){
        if(activeStatus)//If the member is currently active
        {
            activeStatus = false;//Deavtivate membership
            System.out.println("Membership deactivated.");//printing message indicating deactivation
        }
        else{
            System.out.println("your membership is already deactivated");//to notify if the membership is already deactivated
        }
    }
    //method to reset a members details
    public void resetMember()
    {
        activeStatus = false;//Deactivating the membership
        attendance = 0;//Resetting attendane to 0
        loyaltyPoints = 0.0;//Resetting loyalty points to 0
        System.out.println("Member reset successfully.");//notify that the members detail has been reset
    }
    //method to display the detail of a member
    public void display()
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " +phone);
        System.out.println("Email: " + email);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership start date: " + membershipStartDate);
        System.out.println("Aatten dance:" + loyaltyPoints);
        System.out.println("Active Status: "+ activeStatus);
    }
}