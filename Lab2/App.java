
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 360;
        int boaerHeight = 640;
        JFrame frame = new JFrame("Flappy Bird");   // Tạo một cửa sổ Jframe với tiêu đề Flappy Bird
        
        frame.setSize(boardWidth, boaerHeight); // Thiết lập kích thước của cửa sổ
        frame.setLocationRelativeTo(null);  // Hiển thị cửa sổ lên vị trí giữa màn hình
        frame.setResizable(false);  // Cài đặt không cho phép thay đổi kích thước cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // Thiết lập việc đóng chương trình

        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        flappyBird.requestFocus();
        frame.setVisible(true); // Hiển thị cửa sổ Frame
    }
}