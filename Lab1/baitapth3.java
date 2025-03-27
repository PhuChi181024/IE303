import java.util.Arrays;
import java.util.Scanner;

class Point {
    int x, y;
    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class baitapth3 {
    public static long TichCoHuong(Point A, Point B, Point C) {
        return (B.x - A.x) * (C.y - A.y) - (C.x - A.x) * (B.y - A.y);
    }
    public static int ccw(Point A, Point B, Point C) {
        long S = TichCoHuong(A, B, C);
        if (S < 0) {
            return -1;  // ngược chiều kim đồng hồ
        } else if (S == 0) {
            return 0;   // thẳng hàng
        } else {
            return 1;   // theo chiều kim đồng hồ
        }
    }
    
    public static Point[] ConvexHull(Point[] p) { // bao lồi với các điểm theo thứ tự ngược chiều kim đồng hồ 
        int n = p.length;
        if (n < 3) {    // không đủ 3 điểm thì không thể tạo bao lồi
            return new Point[0];
        }
        // Điểm có tung độ nhỏ nhất (và trái nhất) lên tập đầu
        for (int i = 1; i < n; i++) {
            if (p[0].y > p[i].y || (p[0].y == p[i].y && p[0].x > p[i].x)) {
                Point temp = p[0];
                p[0] = p[i];
                p[i] = temp;
            }
        }

        Arrays.sort(p, 1, n, (A, B) -> {
            int c = ccw(p[0], A, B);
            if (c > 0) return -1;
            if (c < 0) return 1;
            if (A.x < B.x) return -1;
            if (A.x > B.x) return 1;
            if (A.y < B.y) return -1;
            if (A.y > B.y) return 1;
            return 0;
        });
        // Tập bao lồi
        Point[] hull = new Point[n];
        int Size = 0;
        
        hull[Size++] = p[0];

        // Dựng bao lồi
        for (int i = 1; i < n; ++i) {
            while (Size >= 2 && ccw(hull[Size - 2], hull[Size - 1], p[i]) < 0) {
                Size--;
            }
            hull[Size++] = p[i];
        }
        return Arrays.copyOf(hull, Size);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x, y;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            points[i] = new Point(x,y);
        }
        sc.close();

        Point[] hull = ConvexHull(points);
        
        for (Point p : hull) {
            System.out.println(p.x + " " + p.y);
        }
    }
}
