import java.util.Scanner;


public class baitapth1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập bán kính r: ");
        double r = sc.nextDouble();
        sc.close();
        int point = 1000000;
        int C = 0; // Số lần thẩy ngẫu nhiên 
        double x = 0.0, y = 0.0;
       
        for (int i = 0; i < point; i++) {
            x = (Math.random() * 2 - 1) * r;
            y = (Math.random() * 2 - 1) * r;
            if (x*x + y*y <= r*r) {
                C++;
            }
        }
        double S = (C*4.0*r*r)/point;
        System.out.println("Xấp xỉ diện tích của hình tròn bán kính " + r + " là: " + S);
    }
}