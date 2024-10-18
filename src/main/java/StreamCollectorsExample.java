import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        Store store = new Store();
        List<Store.Order> orders = store.getListOrders(100);
        Map<String, List<Store.Order>> groupedOrders = orders.stream()
                .collect(Collectors.groupingBy(Store.Order::getProduct));
    }
}
