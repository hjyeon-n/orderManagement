package kr.co.ordermanagement.presentation.controller;

import kr.co.ordermanagement.domain.order.State;
import lombok.Getter;

@Getter
public class ChangeStateRequestDto {
    private State state;
}
