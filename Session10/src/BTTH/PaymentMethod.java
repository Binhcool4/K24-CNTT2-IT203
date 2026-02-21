package BTTH;


public abstract class PaymentMethod {
    // Protected để các lớp con có thể truy cập trực tiếp
    protected String accountName;
    protected String paymentId;

    public PaymentMethod(String accountName, String paymentId) {
        this.accountName = accountName;
        this.paymentId = paymentId;
    }

    // Kiểm tra tính hợp lệ (Số thẻ đúng định dạng, số điện thoại đúng...)
    public abstract void validate();
}
