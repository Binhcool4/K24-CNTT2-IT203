package BTTH;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("========== HỆ THỐNG GIAO DỊCH ĐIỆN TỬ ==========");

        // 1. CreditCard
        CreditCard card = new CreditCard("BUI DUC LOI", "CC001", "1234567890123456", "123", 50000000);
        card.validate();
        card.pay(1500000);

        // 2. EWallet
        EWallet wallet = new EWallet("LOI BUI", "EW001", "0987654321", 2000000);
        wallet.validate();
        wallet.pay(500000);

        // 3. Anonymous Class: Reward Points
        Payable rewardPoints = new Payable() {
            private int currentPoints = 5000;

            @Override
            public void pay(double amount) {
                // Giả sử 1 điểm = 100đ
                int pointsNeeded = (int) (amount / 100);
                if (currentPoints >= pointsNeeded) {
                    currentPoints -= pointsNeeded;
                    System.out.printf("Đã đổi %d điểm để thanh toán %,.0fđ. Điểm còn lại: %d\n", pointsNeeded, amount, currentPoints);
                } else {
                    System.out.println("Không đủ điểm thưởng để thanh toán!");
                }
            }
        };
        rewardPoints.pay(100000);

        System.out.println("================================================");
    }
}
