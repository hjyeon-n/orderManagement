package kr.co.ordermanagement.domain.order;

import kr.co.ordermanagement.domain.exception.CanNotCancelableStateException;
import kr.co.ordermanagement.domain.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Order {
    @Setter
    private Long id;
    private List<OrderedProduct> orderedProducts;
    private Integer totalPrice;
    private State state;

    public Order(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculateTotalPrice(orderedProducts);
        this.state = State.CREATED;
    }

    private Integer calculateTotalPrice(List<OrderedProduct> orderedProducts) {
        return orderedProducts.stream()
                .mapToInt(orderedProduct -> orderedProduct.getPrice() * orderedProduct.getAmount())
                .sum();
    }

    public boolean sameId(Long orderId) {
        return this.id.equals(orderId);
    }

    public void changeStateForce(State state) {
        this.state = state;
    }

    public boolean sameState(State state) {
        return this.state.equals(state);
    }

    public void cancel() {
        this.state.checkCancelable();
        this.state = State.CANCELED;
    }
}