package DigitalStore;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    public List<Order> getListOrders(int limit) {
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            orders.add(new Order(geneateProduct(), generateCost()));
        }
        return orders;
    }

    Random random = new Random();

    private String geneateProduct() {
        String[] products = new String[]{"Laptop", "Smartphone", "Tablet", "TV", "Printer", "Wi-Fi", "Soundbar"};
        return products[random.nextInt(7)];
    }

    private double generateCost() {
        return (double) ((random.nextInt(12) + 5) * 100);
    }

    public Map<String, List<Order>> getGroupedOrders(List<Order> orders) {
        Map<String, List<Order>> groupedOrders = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct));
        return groupedOrders;
    }

    public Map<String, Double> calculateTotalCost(Map<String, List<Order>> groupedOrders) {
        Map<String, Double> totalCost = groupedOrders.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        product -> product.getValue()
                                .stream()
                                .mapToDouble(Order::getCost)
                                .sum()
                ));
        return totalCost;
    }

    public List<Map.Entry<String, Double>> sortByTotalCost(Map<String, Double> totalCost) {
        List<Map.Entry<String, Double>> sorted = totalCost.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());
        return sorted;
    }

    public List<Map.Entry<String, Double>> getMostExpensiveProd(List<Map.Entry<String, Double>> sortedList) {
        return sortedList.stream()
                .limit(3)
                .collect(Collectors.toList());
    }

    public Double getSum(List<Map.Entry<String, Double>> sortedList) {
        return sortedList.stream()
                .mapToDouble(Map.Entry::getValue)
                .sum();
    }

    public void printResult(List<Map.Entry<String, Double>> collection) {
        collection.forEach(entry -> {
            System.out.println(String.format("%s %f", entry.getKey(), entry.getValue()));
                });
        System.out.println(getSum(collection));
    }

}
