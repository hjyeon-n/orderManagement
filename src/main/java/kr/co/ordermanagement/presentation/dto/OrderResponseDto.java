package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.order.Order;
import kr.co.ordermanagement.domain.order.State;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OrderResponseDto {
    private Long id;
    private List<ProductDto> orderedProduct;
    private Integer totalPrice;
    private State state;

    public OrderResponseDto(Long id, List<ProductDto> orderedProduct, Integer totalPrice, State state) {
        this.id = id;
        this.orderedProduct = orderedProduct;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public static OrderResponseDto toDto(Order order) {
        List<ProductDto> orderedProductDtos = order.getOrderedProducts()
                .stream()
                .map(orderProduct -> ProductDto.toDto(orderProduct))
                .toList();

        OrderResponseDto orderResponseDto = new OrderResponseDto(
                order.getId(),
                orderedProductDtos,
                order.getTotalPrice(),
                order.getState()
        );

        return orderResponseDto;
    }
}
