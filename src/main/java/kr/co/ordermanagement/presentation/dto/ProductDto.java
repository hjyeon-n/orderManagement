package kr.co.ordermanagement.presentation.dto;

import kr.co.ordermanagement.domain.product.Product;
import lombok.Getter;

@Getter
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public ProductDto(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAmount()
        );

        return productDto;
    }
}