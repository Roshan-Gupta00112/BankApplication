import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Name, Password and initial Amount.");
        String name=sc.next();
        String password=sc.next();
        double amount=sc.nextDouble();

        SBI_Account roshanAcc=new SBI_Account(name, password, amount);

        System.out.println("Your account has been created with AccountNo. "+ roshanAcc.getAccountNo());

        // get balance
        System.out.println("Your current Balance is: "+ roshanAcc.getBalance());

        // Deposit
        System.out.println(roshanAcc.depositMoney(200000));
        System.out.println("New balance is: "+roshanAcc.getBalance());

        // withdraw
        System.out.println("Enter Amount to be withdrawn: ");
        double withdraw=sc.nextDouble();
        System.out.println("Enter Your Password");
        String enterPassword=sc.next();
        System.out.println(roshanAcc.withdraw(withdraw, enterPassword));

        // interest
        System.out.println("Enter Time of Your FD");
        int time=sc.nextInt();
        System.out.println("Interest for " +time+ " yrs on Your Current Balance: " +roshanAcc.getBalance()+ " is: " +roshanAcc.calculateInterest(time));
    }
}