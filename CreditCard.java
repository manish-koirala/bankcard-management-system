
/**
 * A class that attempts to model a credit card which is a subclass of BankCard.
 *
 * @author (Manish Koirala)
 * @version (9th Jan 2023)
 */
public class CreditCard extends BankCard
{
    private int CVC;
    private double creditLimit;
    private double interestRate;
    private String expireDate;
    private int gracePeriod;
    private boolean isGranted;
    
    /*
     * The constructor for CreditCard class has eight parameters. The parameters balanceAmount: double, cardID:double,
     * bankAccount: String and issuerBank : String are passed to the superclass constructor. The setClientName method of the 
     * superclass is passed the parameter clientName:String. Finally, the other parameters i.e. interestRate:double ,
     * expireDate: String are initialized to their corresponding arguments and the isGranted instance variable is initialized
     * to false.
     */
    public CreditCard(int cardID, String clientName, String issuerBank, String bankAccount, double balanceAmount, int CVC, double interestRate, String expireDate)
    {
        super(balanceAmount, cardID, bankAccount, issuerBank);
        super.setClientName(clientName);
        this.CVC = CVC;
        this.interestRate = interestRate;
        this.expireDate = expireDate;
        this.isGranted = false;
    }
    
    // An accessor method which returns the value of CVC instance variable.
    public int getCVC()
    {
        return this.CVC;
    }
    
    // An accessor method which returns the value of interestRate instance variable.
    public double getInterestRate()
    {
        return this.interestRate;
    }
    
    // An accessor method which returns the value of isGranted instance variable.
    public boolean getIsGranted()
    {
        return this.isGranted;
    }
    
    // An accessor method which returns the value of expireDate instance variable.
    public String getExpireDate()
    {
        return this.expireDate;
    }
    
    // An accessor method which returns the value of gracePeriod instance variable.
    public int getGracePeriod()
    {
        return this.gracePeriod;
    }
    
    // An accessor method which returns the value of creditLimit instance variable.
    public double getCreditLimit()
    {
        return this.creditLimit;
    }
    
    /*
     * A method which models setting a new credit limit only if the new credit limit passed to the method is less or equal to
     * 2.5 times the balanceAmount. The method accepts two parameters newCreditLimit and newGracePeriod and sets the corresponding
     * instance variable's values equal to these if the condition is met. It also sets instance variable isGranted to true.
     */
    public void setCredit (double newCreditLimit, int newGracePeriod)
    {
        double balanceAmount = super.getBalanceAmount();
        if (newCreditLimit <= 2.5*balanceAmount) {
            // grant credit
            this.creditLimit = newCreditLimit;
            this.gracePeriod = newGracePeriod;
            this.isGranted = true;
        }
        else {
            // say credit cannot be issued.
            System.out.println("Sorry ! The credit cannot be issued.");
        }
    }
    
    // A method which represents canceling a credit card. It sets the CVC, creditLimit and gracePeriod to zero and isGranted to false.
    public void cancelCreditCard()
    {
        this.CVC = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
    }
    
    // A method to display the available information of Credit Card.
    public void displayInfo()
    {
        if (this.isGranted == true) {
            super.displayInfo();
            System.out.println("Credit Limit: "+ getCreditLimit());
            System.out.println("Grace Period: "+ getGracePeriod());
        }
        else {
            System.out.println("Credit has not been granted.");
        }
    }
}
