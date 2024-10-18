import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {
    Random random = new Random();

    public class Order {
        private String product;
        private double cost;

        public Order(String product, double cost) {
            this.product = product;
            this.cost = cost;
        }

        public String getProduct() {
            return product;
        }

        public double getCost() {
            return cost;
        }
    }

    public List<Order> getListOrders(int limit) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            orders.add(new Order(geneateProduct(), generateCost()));
        }
        return orders;
    }

    private String geneateProduct() {
        String[] products = new String[]{"Laptop", "Smartphone", "Tablet", "TV", "Printer", "Wi-Fi", "Soundbar"};
        return products[random.nextInt(7)];
    }
    private double generateCost() {
        return (double) ((random.nextInt(12) + 5) * 100);
    }
}
