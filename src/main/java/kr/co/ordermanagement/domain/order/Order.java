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

    public boolean sameId(Long orderId) {
        return this.id.equals(orderId);
    }

    public void changeStateForce(String state) {
        this.state = state;
    }

    public boolean sameState(String state) {
        return this.state.equals(state);
    }

    public void cancel() {
        if (!this.state.equals("CREATED")) {
            throw new RuntimeException("이미 취소되었거나 취소할 수 없는 주문 상태입니다.");
        }

        this.state = "CANCELED";
    }
}