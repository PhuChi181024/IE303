public class baitapth2 {
    public static void main(String[] args) {
        int point = 1000000;
        int C = 0; // Số lần thẩy ngẫu nhiên 
        double x = 0.0, y = 0.0;
       
        for (int i = 0; i < point; i++) {
            x = (Math.random() * 2 - 1);
            y = (Math.random() * 2 - 1);
            if (x*x + y*y <= 1) {
                C++;
            }
        }
        double pi = (C*4.0)/point;
        System.out.println("Xấp xỉ pi của hình tròn bán kính bằng 1 là: " + pi);
    }
}