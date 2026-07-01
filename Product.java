import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private int stockQuantity;

    public Product(String productId, String productName, double price, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        setPrice(price);
        setStockQuantity(stockQuantity);
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price < 0 ? 0.0 : price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity < 0 ? 0 : stockQuantity;
    }

    public void applyDiscount(double percentage) {
        if (percentage > 0) {
            price -= price * percentage / 100;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter stock quantity: ");
        int stock = scanner.nextInt();

        Product product = new Product(id, name, price, stock);

        System.out.print("Enter discount percentage: ");
        double discount = scanner.nextDouble();
        product.applyDiscount(discount);

        System.out.println("Updated price: " + product.getPrice());
        System.out.println("Stock quantity: " + product.getStockQuantity());

        scanner.close();
    }
}
