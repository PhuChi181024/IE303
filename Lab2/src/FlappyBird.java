
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360;
    int boardHeight = 640;
    
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;
        Bird(Image img) {
            this.img = img;
        }
    }

    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWith = 64;
    int pipeHeight = 512;

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWith;
        int height = pipeHeight;
        Image img;
        boolean pass = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    // logic game
    Bird bird;
    int velocityX = -4; // Tốc độ các đường ống di chuyển sang trái
    int velocityY = 0;  // Tốc độ bird di chuyển lên xuống
    int gravity = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    Timer gameLoop;
    Timer placePipesTimer;
    boolean gameOver = false;
    double score = 0;

    Image backgroundImage;
    Image birdImage;
    Image topPipeImage;
    Image bottomPipeImage;

    FlappyBird() {      
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true); // Cho phép JPanel bắt sự kiện bàn phím
        addKeyListener(this);

        // load image
        backgroundImage = new ImageIcon(getClass().getResource("/Lab2/images/flappybirdbg.png")).getImage();
        birdImage = new ImageIcon(getClass().getResource("/Lab2/images/flappybird.png")).getImage();
        topPipeImage = new ImageIcon(getClass().getResource("/Lab2/images/toppipe.png")).getImage();
        bottomPipeImage = new ImageIcon(getClass().getResource("/Lab2/images/bottompipe.png")).getImage();

        //bird
        bird = new Bird(birdImage);

        pipes = new ArrayList<Pipe>();

        // Place Pipes Timer
        placePipesTimer = new Timer(1500, new ActionListener() {    // pipe được tạo mới mỗi 1.5s
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipesTimer.start();

        //game timer
        gameLoop = new Timer(1000/60, this);
        gameLoop.start();
    }
    
    public void placePipes() {
        int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        int space = boardHeight/4;

        Pipe topPipe = new Pipe(topPipeImage);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImage);
        bottomPipe.y = topPipe.y + pipeHeight + space;
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);

    }
    public void draw(Graphics g) {
        // Vẽ background
        g.drawImage(backgroundImage, 0, 0, boardWidth, boardHeight, null);

        // Vẽ bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        // Vẽ pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        // score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over:" + String.valueOf((int) score), 10, 35);
        }
        else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    public void move() {
        //bird
        velocityY += gravity;   // Chim rơi xuống
        bird.y += velocityY;    // Cập nhật toạ độ Y của bird
        bird.y = Math.max(bird.y, 0);   

        //pipes
        for (int i = 0; i < pipes.size(); i++) {    
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;    // Dịch chuyển ống sang tr

            if (!pipe.pass && bird.x > pipe.x + pipe.width) {
                pipe.pass = true;
                score += 0.5;
            }

            if (collision(bird, pipe)) {
                gameOver = true;
            }
        }

        if (bird.y > boardHeight) {
            gameOver = true;
        }
    }

    public boolean collision(Bird a, Pipe b) {
        return  a.x < b.x + b.width &&
                a.x + a.width > b.x  &&
                a.y < b.y + b.height &&
                a.y + a.height > b.y;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            placePipesTimer.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
            velocityY = -9;
            if (gameOver) {
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipesTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
}
