package kr.co.ordermanagement.domain.order;

import lombok.Getter;

@Getter
public class OrderedProduct {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public OrderedProduct(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
}
