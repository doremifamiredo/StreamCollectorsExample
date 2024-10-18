import DigitalStore.Order;
import DigitalStore.OrderService;

import java.util.*;

public class StreamCollectorsExample {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        List<Order> orders = orderService.getListOrders(100);
        Map<String, List<Order>> grouped = orderService.getGroupedOrders(orders);
        Map<String, Double> totalCost = orderService.calculateTotalCost(grouped);
        List<Map.Entry<String, Double>> sorted = orderService.sortByTotalCost(totalCost);
        List<Map.Entry<String, Double>> expensive = orderService.getMostExpensiveProd(sorted);
        orderService.printResult(expensive);
    }
}
