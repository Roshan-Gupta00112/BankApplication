import java.math.BigInteger;
import java.util.UUID;

public class HDFC_Account implements Bank{
    private String name;
    private String password;
    private String accountNo;
    private double balance;
    private double rateOfInterest;
    public HDFC_Account(String name, String password, double initialBalance){
        this.name=name;
        this.password=password;
        this.balance=initialBalance;

        if(this.balance<20000000) rateOfInterest=7;
        else rateOfInterest=7.74;

        String a=String.valueOf(UUID.randomUUID());
        a=a.replaceAll("-","");
        a=new BigInteger(a,16).toString();
        this.accountNo=a.substring(0,14);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    boolean checkPassword(String enterPassword){
        return enterPassword.equals(this.password);
    }

    @Override
    public String depositMoney(double amount) {
        this.balance+=amount;
        return "rs" +amount+ " has been credited to your bank account. Now your current bank balance is: " +this.balance;
    }

    @Override
    public String withdraw(double amount, String enterPassword){
        if(amount<=this.balance) {
            this.balance -= amount;
            return amount + " is deducted from your bank account. Now your current balance is: " + this.balance;
        }
        else return "Insufficient Balance";
    }

    @Override
    public double calculateInterest(int time) {
        return (balance*rateOfInterest*time)/100;
    }


}
