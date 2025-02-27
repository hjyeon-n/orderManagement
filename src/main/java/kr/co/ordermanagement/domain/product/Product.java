package kr.co.ordermanagement.domain.product;

import kr.co.ordermanagement.domain.exception.NotEnoughAmountExeption;
import lombok.Builder;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer amount;

    public Product(Long id, String name, Integer price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    public void checkEnoughAmount(Integer orderedAmount) {
        if (this.amount < orderedAmount) {
            throw new NotEnoughAmountExeption(this.id + "번 상품의 수량이 부족합니다.");
        }
    }

    public void decreaseAmount(Integer orderedAmount) {
        this.amount -= orderedAmount;
    }
}