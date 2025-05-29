import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingShoe extends JFrame {
    private JLabel mainImageLabel, nameLabel, priceLabel, brandLabel, descriptionLabel;
    private JPanel rightPanel;
    private ArrayList<Product> products = new ArrayList<>();
    
    public ShoppingShoe() {
        setTitle("Shopping Shoe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new BorderLayout());

        // Tạo panel trái để hiển thị thông tin sản phẩm chính
        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(400, 600));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        leftPanel.setBackground(Color.WHITE);

        // Tạo nhãn hiển thị ảnh sản phẩm chính
        mainImageLabel = new JLabel();
        mainImageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainImageLabel.setPreferredSize(new Dimension(300, 200));

        // Tạo nhãn hiển thị tên sản phẩm
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Tạo nhãn hiển thị giá sản phẩm
        priceLabel = new JLabel();
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Tạo nhãn hiển thị hãng sản xuất
        brandLabel = new JLabel();
        brandLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Tạo nhãn hiển thị mô tả sản phẩm
        descriptionLabel = new JLabel("<html>This product is excluded from all promotional discounts and offers.</html>");
        descriptionLabel.setForeground(Color.GRAY);
        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Tạo đường gạch ngang để phân cách ảnh và thông tin
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));

        // Thêm các thành phần vào panel trái
        leftPanel.add(mainImageLabel);
        leftPanel.add(Box.createVerticalStrut(20));
        leftPanel.add(separator);
        leftPanel.add(nameLabel);
        leftPanel.add(priceLabel);
        leftPanel.add(brandLabel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(descriptionLabel);

        // Tạo panel phải để hiển thị danh sách sản phẩm
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 4, 10, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(150, 20, 20, 20));
        rightPanel.setBackground(Color.WHITE);

        Products();     // Gọi phương thức để thêm danh sách sản phẩm
        displayProduct(products.get(0));   // Hiển thị sản phẩm đầu tiên

        add(leftPanel, BorderLayout.WEST);  // Thêm panel trái vào cửa sổ

        // Tạo thanh cuộn cho panel phải
        JScrollPane scrollPane = new JScrollPane(rightPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30); // Tốc độ cuộn
        scrollPane.getVerticalScrollBar().setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {     // Tùy chỉnh thanh cuộn
            @Override
            protected void configureScrollBarColors() { // Chỉnh màu sắc cho thanh cuộn
                this.thumbColor = new Color(180, 180, 180);
                this.trackColor = new Color(235, 235, 235);
            }
            @Override
            protected JButton createDecreaseButton(int bt) { 
                JButton button = super.createDecreaseButton(bt);
                button.setBackground(new Color(235, 235, 235));
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
            @Override
            protected JButton createIncreaseButton(int bt) {
                JButton button = super.createIncreaseButton(bt);
                button.setBackground(new Color(235, 235, 235));
                button.setBorder(BorderFactory.createEmptyBorder());
                return button;
            }
        });

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        add(scrollPane, BorderLayout.CENTER);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private void Products() {
        products.add(new Product("4DFWD PULSE SHOES", "images/img1.png", "$160.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("FORUM MID SHOES", "images/img2.png", "$100.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("SUPERNOVA SHOES", "images/img3.png", "$150.00", "Adidas", "NMD City Stock 2."));
        products.add(new Product("Adidas NMD City", "images/img4.png", "$160.00", "Adidas", "NMD City Stock 2."));
        products.add(new Product("Dark Pulse Shoes", "images/img5.png", "$120.00", "Adidas", "NMD City Stock 2."));
        products.add(new Product("4DFWD ORANGE", "images/img6.png", "$160.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("4DFWD PULSE SHOES", "images/img1.png", "$160.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("FORUM MID SHOES", "images/img2.png", "$100.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("4DFWD PULSE SHOES", "images/img1.png", "$160.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("FORUM MID SHOES", "images/img2.png", "$100.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("SUPERNOVA SHOES", "images/img3.png", "$150.00", "Adidas", "NMD City Stock 2."));
        products.add(new Product("Adidas NMD City", "images/img4.png", "$160.00", "Adidas", "NMD City Stock 2."));
        products.add(new Product("Dark Pulse Shoes", "images/img5.png", "$120.00", "Adidas", "NMD City Stock 2."));
        products.add(new Product("4DFWD ORANGE", "images/img6.png", "$160.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("4DFWD PULSE SHOES", "images/img1.png", "$160.00", "Adidas", "This product is excluded from all promotional discounts and offers."));
        products.add(new Product("FORUM MID SHOES", "images/img2.png", "$100.00", "Adidas", "This product is excluded from all promotional discounts and offers."));

        for (Product p : products) {
            rightPanel.add(new ProductShoe(p, this));
        }
    }

    public void displayProduct(Product product) {
        ImageIcon icon = new ImageIcon(product.image);
        Image img = icon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        mainImageLabel.setIcon(new ImageIcon(img));
        nameLabel.setText(product.name);
        priceLabel.setText(product.price);
        brandLabel.setText(product.brand);
        descriptionLabel.setText("<html>" + product.description + "</html>");
    }

    public void ChangeProduct(Runnable change) {
        Timer timer = new Timer(10, null);
        final float[] alpha = {1f};
        timer.addActionListener(_ -> {
            alpha[0] -= 0.1f;
            mainImageLabel.setOpaque(true);
            mainImageLabel.setBackground(new Color(1f, 1f, 1f, Math.max(0, alpha[0])));
            if (alpha[0] <= 0) {
                change.run();
                alpha[0] = 1f;
                timer.stop();
            }
        });
        timer.start();
    }
}