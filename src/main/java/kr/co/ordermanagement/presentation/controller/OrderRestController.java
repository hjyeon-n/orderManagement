package kr.co.ordermanagement.presentation.controller;

import kr.co.ordermanagement.application.SimpleOrderService;
import kr.co.ordermanagement.presentation.dto.OrderProductRequestDto;
import kr.co.ordermanagement.presentation.dto.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderRestController {

    private SimpleOrderService simpleOrderService;

    public OrderRestController(SimpleOrderService simpleOrderService) {
        this.simpleOrderService = simpleOrderService;
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderResponseDto> createOrder(
            @RequestBody List<OrderProductRequestDto> orderProductRequestDtos) {
        OrderResponseDto orderResponseDto = simpleOrderService.createOrder(orderProductRequestDtos);
        return ResponseEntity.ok(orderResponseDto);

    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long orderId) {
        OrderResponseDto orderResponseDto = simpleOrderService.findById(orderId);
        return ResponseEntity.ok(orderResponseDto);
    }

    @PatchMapping("/orders/{orderId}")
    public ResponseEntity<OrderResponseDto> changeOrderState(@PathVariable Long orderId,
                                                             @RequestBody ChangeStateRequestDto changeStateRequestDto) {
        OrderResponseDto orderResponseDto = simpleOrderService.changeState(orderId, changeStateRequestDto);
        return ResponseEntity.ok(orderResponseDto);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getOrderByState(@RequestParam String state) {
        List<OrderResponseDto> orderResponseDtos = simpleOrderService.findByState(state);
        return ResponseEntity.ok(orderResponseDtos);
    }
}
