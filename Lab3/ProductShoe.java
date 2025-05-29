import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class ProductShoe extends JPanel {
    
    // Hàm khởi tạo thẻ sản phẩm với thông tin sản phẩm và tham chiếu đến lớp chính
    public ProductShoe(Product product, ShoppingShoe parent) {
        setOpaque(false); 
        setLayout(new BorderLayout()); 
        setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12)); // Đặt lề cho panel 
        setBackground(new Color(240, 240, 240)); 
        setMaximumSize(new Dimension(180, 260)); 
        setPreferredSize(new Dimension(180, 260)); 
        setMinimumSize(new Dimension(180, 260)); 

        // Đặt lại trong suốt để hiển thị nền bo tròn tùy chỉnh
        setOpaque(false);
        setBackground(new Color(240, 240, 240));

        // Tạo panel trên cùng để chứa tên và ghi chú
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS)); 
        topPanel.setOpaque(false);

        // Tạo nhãn cho tên sản phẩm
        JLabel name = new JLabel();
        name.setText("<html><div style='width:140px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>" + product.name + "</div></html>");
        name.setFont(new Font("Arial", Font.BOLD, 20)); 
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Tạo nhãn cho ghi chú sản phẩm
        JLabel note = new JLabel();
        note.setText("<html><div style='width:140px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>" + product.description + "</div></html>");
        note.setFont(new Font("Arial", Font.BOLD, 14)); 
        note.setForeground(Color.GRAY); 
        note.setAlignmentX(Component.CENTER_ALIGNMENT); 

        topPanel.add(name); // Thêm nhãn tên vào panel trên cùng
        topPanel.add(note); // Thêm nhãn ghi chú vào panel trên cùng

        // Tạo nhãn chứa ảnh sản phẩm
        ImageIcon icon = new ImageIcon(product.image); 
        Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH); 
        JLabel imgLabel = new JLabel(new ImageIcon(img)); 
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        // Tạo nhãn cho hãng sản xuất
        JLabel brand = new JLabel();
        brand.setText("<html><div style='width:90px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;'>" + product.brand + "</div></html>");
        brand.setFont(new Font("Arial", Font.PLAIN, 14)); 

        // Tạo nhãn cho giá sản phẩm
        JLabel price = new JLabel(product.price); 
        price.setFont(new Font("Arial", Font.BOLD, 18));

        // Tạo panel chứa hãng và giá, sắp xếp theo BorderLayout
        JPanel brandPricePanel = new JPanel();
        brandPricePanel.setLayout(new BorderLayout()); 
        brandPricePanel.setOpaque(false); 
        brandPricePanel.add(brand, BorderLayout.WEST); 
        brandPricePanel.add(price, BorderLayout.EAST); 

        // Thêm các thành phần vào thẻ sản phẩm
        add(topPanel, BorderLayout.NORTH); 
        add(imgLabel, BorderLayout.CENTER); 
        add(brandPricePanel, BorderLayout.SOUTH); 

        // Thêm sự kiện click chuột để hiển thị sản phẩm khi thẻ được nhấn
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                parent.ChangeProduct(() -> parent.displayProduct(product));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        g2.dispose();
    }
}