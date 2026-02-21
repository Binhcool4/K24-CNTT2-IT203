package BTTH;


public class EWallet extends PaymentMethod implements Payable {
    private String phoneNumber;
    private double balance;

    public EWallet(String accountName, String paymentId, String phoneNumber, double balance) {
        super(accountName, paymentId);
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    @Override
    public void validate() {
        if (phoneNumber.startsWith("0")) {
            System.out.println("Ví điện tử hợp lệ.");
        } else {
            System.out.println("LỖI: Số điện thoại không đúng định dạng!");
        }
    }

    @Override
    public void pay(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("Thanh toán ví (%s): %,.0fđ thành công. Số dư: %,.0fđ\n", phoneNumber, amount, balance);
        } else {
            System.out.println("Thanh toán thất bại: Số dư ví không đủ!");
        }
    }
}
