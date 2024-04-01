
/**
 * BankCard: A class that attempts to model an actual bank card with attributes
 * like cardId, balanceAmount, clientName, issuerBank and a bankAccount.
 * @author (Manish Koirala)
 * @version (9th Jan 2023)
 */
public class BankCard
{
    private int cardID;
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private double balanceAmount;
    
    /*The BankCard class has a constructor which takes four parameters:
       balanceAmount, cardID, bankAccount and issuerBank.
       The client name is initialized as an empty string, whereas all other instance
       variables are assigned values to the corresponding arguments.
     */
    public BankCard(double balanceAmount, int cardID, String bankAccount, String issuerBank)
    {
        this.clientName = "";
        this.balanceAmount = balanceAmount;
        this.cardID = cardID;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
    }
    
    // An accessor method which returns the value of instance variable balanceAmount.
    public double getBalanceAmount()
    {
        return this.balanceAmount;
    }
    
    // An accessor method which returns the value of instance variable cardID.
    public int getCardID()
    {
        return this.cardID;
    }
    
    // An accessor method which returns the value of the instance variable bankAccount.
    public String getBankAccount()
    {
        return this.bankAccount;
    }
    
    // An accessor method which returns the value of instance variable issuerBank.
    public String getIssuerBank()
    {
        return this.issuerBank;
    }
    
    // An accessor method which returns the value of instance variable clientName.
    public String getClientName()
    {
        return this.clientName;
    }
    
    /* A mutator method which takes a string argument clientName and sets the 
     * value of the instance variable clientName to that argument.
     */
    public void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
    
    /* A mutator method which takes a double argument balanceAmount and sets the
     * value of the instance variable balanceAmount to that argument.
     */
    public void setBalanceAmount(double balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }
    
    /*
     * A method which displays all the available 
     * information about the bank card object.
     */
    public void displayInfo()
    {
        System.out.println("Card ID: "+ getCardID());
        System.out.println("Bank Account: "+ getBankAccount());
        System.out.println("Issuer Bank: "+ getIssuerBank());
        System.out.println("Balance Amount: "+ getBalanceAmount());
        if (clientName == "") {
            System.out.println("Client name has not been assigned");
        }
        else {
            System.out.println("Client Name: "+ getClientName());
        }
    }
}
