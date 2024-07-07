package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.OrderedProduct;
import lombok.Getter;

@Getter
public class OrderedProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public OrderedProductDto(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static OrderedProductDto toDto(OrderedProduct orderedProduct) {
        OrderedProductDto orderedProductDto = new OrderedProductDto(
                orderedProduct.getId(),
                orderedProduct.getName(),
                orderedProduct.getPrice(),
                orderedProduct.getAmount()
        );

        return orderedProductDto;
    }
}
