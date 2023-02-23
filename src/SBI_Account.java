import java.math.BigInteger;
import java.util.UUID;

public class SBI_Account implements Bank{
    private String name;
    private String password;
    private String accountNo;
    private double balance;
    private double rateOfInterest;

    public SBI_Account(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;

        if(this.balance<100000000) this.rateOfInterest=2.7;  // Considering Account as a Saving Account
        else this.rateOfInterest=3;

        //this.accountNo= String.valueOf(UUID.randomUUID());
        String ac = String.valueOf(UUID.randomUUID());
        String a=ac.replaceAll("-","");
        String b= new BigInteger(a,16).toString();
        this.accountNo=b.substring(0,11);

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
        return this.balance;
    }

    @Override
    public String depositMoney(double amount) {
        this.balance+=amount;
        return amount+" is credited in your bank account. The total amount is : "+ balance;
    }

    @Override
    public String withdraw(double amount, String enterPassword) {
        if(enterPassword.equals(this.password)){
            if(amount>this.balance) return "Insufficient Balance";
            else {
                this.balance-=amount;
                return amount+" is deducted from your bank account. Now your current balance is: "+this.balance;
            }
        }
        else return "Password Incorrect";
    }

    @Override
    public double calculateInterest(int time) {  // Considering it's as  FD
        return (balance*rateOfInterest*time)/100.0;
    }


}
