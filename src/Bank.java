public interface Bank {
    double getBalance();
    String depositMoney(double amount);
    String withdraw(double amount, String enterPassword);
    double calculateInterest(int time);
}
