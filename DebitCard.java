
/**
 * A class that attempts to model a debit card which has been inherited from the BankCard class.
 *
 * @author (Manish Koirala)
 * @version (9th Jan 2023)
 */
public class DebitCard extends BankCard
{
    private int PIN;
    private int withdraw_Amount;
    private String dateOfWithdraw;
    private boolean hasWithdrawn;
    
    /*
     * The constructor for DebitCard accepts six paramaters which are balanceAmount, cardID, bankAccoutn,
     * issuerBank and PIN. A call is made to the supercalss constructor with four parameters and a setter method setclientName().
     * Also, PIN number is assigned with the corresponding parameter values and hasWithdrawn is set to false.
     */
    public DebitCard(double balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName, int PIN)
    {
        super(balanceAmount, cardID, bankAccount, issuerBank);
        super.setClientName(clientName);
        this.PIN = PIN;
        this.hasWithdrawn = false;
    }
    
    // An accessor method which returns the value of instance variable PIN.
    public int getPIN(){
        return this.PIN;
    }
    
    // An accessor method which returns the value of instance variable withdraw_Amount.
    public int getWithDrawAmount(){
        return this.withdraw_Amount;
    }
    
    // An accessor method which returns the value of instance variable hasWithdrawn.
    public boolean getHasWithdrawn(){
        return this.hasWithdrawn;
    }
    
    // An accessor method which returns the value of instance variable dateOfWithdraw.
    public String getDateOfWithdraw(){
        return this.dateOfWithdraw;
    }
    
    // A mutator method is used to set the value of the instance variable withdraw_Amount.
    public void setWithdrawAmount(int withdraw_Amount)
    {
        this.withdraw_Amount = withdraw_Amount;
    }
    
    /*A method which models withdrawing money from the bankAccount. It takes three parameters:
    * withdraw_Amount: int, dateOfWithdraw:String, PIN:int
    * If the balanceAmount is sufficient for withdraw and entered PIN is correct, then the method deducts the withdraw money
    * from the balanceAmount and sets the new balanceAmount. It also sets the hasWithdrawn instance variable to true once
    * the money is withdrawn and sets the value of dataOfWithdraw to its corresponding parameter.
    */
    public void withdraw(int withdraw_Amount, String dateOfWithdraw, int PIN)
    {
        double balanceAmount = super.getBalanceAmount();
        if (this.PIN == PIN && withdraw_Amount <= balanceAmount) {
            this.setWithdrawAmount(withdraw_Amount);
            this.dateOfWithdraw = dateOfWithdraw;
            this.hasWithdrawn = true;
            super.setBalanceAmount(balanceAmount - withdraw_Amount);
        }
        else if (this.PIN != PIN) {
            System.out.println("The given PIN number is incorrect.");
        }
        else if (withdraw_Amount > balanceAmount){
            System.out.println("Insufficient Balance in account.");
        }
    }
    
    /* A method which display all the available information about the debit card. It calls the displayInfo() method 
     * of the superclass. If the debit card has been used to withdraw money, then, the withdraw information like 
     * withdraw_Amount, dateOfWithdraw and PIN are also displayed. Else, a suitable message is displayed indicating 
     * that the card has not been used to withdraw.
    */
    public void displayInfo()
    {
        super.displayInfo();
        if (this.hasWithdrawn == true) {
            System.out.println("PIN: " + this.PIN);
            System.out.println("Withdrawal Amount: " + getWithDrawAmount());
            System.out.println("Date of withdrawal: " + getDateOfWithdraw()); 
        }
        else {
            System.out.println("The card has not been used to withdraw");
        }
    }
    
}
