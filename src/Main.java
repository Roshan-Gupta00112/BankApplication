import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Name, Password and initial Amount for SBI_Account");
        String name=sc.next();
        String password=sc.next();
        double amount=sc.nextDouble();

        SBI_Account roshanAcc=new SBI_Account(name, password, amount);

        System.out.println("Your account has been created with AccountNo. "+ roshanAcc.getAccountNo());

        // get balance
        System.out.println("Your current Balance is: "+ roshanAcc.getBalance());

        // Deposit
        System.out.println("Enter Amount to deposit in your SBI Account");
        double deposit_sbi= sc.nextDouble();
        System.out.println(roshanAcc.depositMoney(deposit_sbi));

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



        // For HDFC_Account
        System.out.println();
        System.out.println();
        System.out.println("You Want to Create an Account HDFC Bank?");
        String ans1= sc.next();
        if(ans1.charAt(0)=='y' || ans1.charAt(0)=='Y') {
            System.out.println("Enter your Name, Password and initial Amount for HDFC_Account");
            String name_hdfc = sc.next();
            String password_hdfc = sc.next();
            double amount_hdfc = sc.nextDouble();

            HDFC_Account hac = new HDFC_Account(name_hdfc, password_hdfc, amount_hdfc);
            System.out.println("Your bank account has been created with account no: " + hac.getAccountNo());

            // check balance
            System.out.println("Your current Balance is: rs"+ hac.getBalance());


            // deposit
            System.out.println("You want to Deposit Money?");
            String ans2 = sc.next();
            while (ans2.charAt(0) == 'y' || ans2.charAt(0) == 'Y') {
                System.out.println("Enter Amount to be Deposited..");
                double deposit_hdfc = sc.nextDouble();
                System.out.println(hac.depositMoney(deposit_hdfc));
                System.out.println("You want to Deposit Money Again?");
                ans2 = sc.next();
            }


            // Withdraw
            System.out.println("You want to Withdraw Money?");
            String ans3 = sc.next();
            int count=0;
            while (ans3.charAt(0) == 'y' || ans3.charAt(0) == 'Y') {
                System.out.println("Enter Amount to be withdrawn: ");
                double withdraw_hdfc = sc.nextDouble();
                System.out.println("Enter Your Password: ");
                String enterPassword_hdfc = sc.next();
                if(!hac.checkPassword(enterPassword_hdfc)){
                    count++;
                    System.out.println("WARNING! Password Incorrect. You have Entered Wrong Password " +count+ "times");
                    if(count==2) System.out.println("Be Careful! This will be your last chance.");
                    if(count==3){
                        System.out.println("Sorry! you have reached maximum limit of Entering Password. Come Tomorrow.");
                        break;
                    }
                    continue;
                }
                System.out.println(hac.withdraw(withdraw_hdfc, enterPassword_hdfc));
                System.out.println("You want to Withdraw Money Again?");
                ans3 = sc.next();
            }


            // interest
            System.out.println("Enter Time of Your FD");
            int time_hdfc = sc.nextInt();
            System.out.println("Interest for " + time_hdfc + " yrs on Your Current Balance: " + hac.getBalance() + " is: " + hac.calculateInterest(time_hdfc));
        }
    }
}