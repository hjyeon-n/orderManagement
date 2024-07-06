package kr.co.ordermanagement.domain.order;

import kr.co.ordermanagement.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Order {
    @Setter
    private Long id;
    private List<Product> orderedProducts;
    private Integer totalPrice;
    private String state;

    public Order(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculateTotalPrice(orderedProducts);
        this.state = "CREATED";
    }

    private Integer calculateTotalPrice(List<Product> orderedProducts) {
        return orderedProducts.stream()
                .mapToInt(orderedProduct -> orderedProduct.getPrice() * orderedProduct.getAmount())
                .sum();
    }
}