package BTTH;

public class CreditCard extends PaymentMethod implements Payable {
    private String cardNumber; // Cần bảo mật tuyệt đối
    private String cvv;
    private double creditLimit;

    public CreditCard(String accountName, String paymentId, String cardNumber, String cvv, double creditLimit) {
        super(accountName, paymentId);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.creditLimit = creditLimit;
    }

    @Override
    public void validate() {
        if (cardNumber.length() == 16) {
            System.out.println("Thẻ tín dụng hợp lệ.");
        } else {
            System.out.println("LỖI: Số thẻ phải đúng 16 chữ số!");
        }
    }

    @Override
    public void pay(double amount) {
        if (amount <= creditLimit) {
            creditLimit -= amount;
            System.out.printf("Thanh toán thẻ: %,.0fđ thành công. Hạn mức còn lại: %,.0fđ\n", amount, creditLimit);
        } else {
            System.out.println("Thanh toán thất bại: Vượt quá hạn mức tín dụng!");
        }
    }
}
