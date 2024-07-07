package kr.co.ordermanagement.domain.order;

import kr.co.ordermanagement.domain.exception.CanNotCancelableStateException;

public enum State {
    CREATED {
        @Override
        void checkCancelable() {}
    },
    SHIPPING,
    COMPLETED,
    CANCELED;

    void checkCancelable() {
        throw new CanNotCancelableStateException("이미 취소되었거나 취소할 수 없는 주문 상태입니다.");
    }
}
