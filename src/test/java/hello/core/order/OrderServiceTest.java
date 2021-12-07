package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        // given
        Long MemberId = 1L;
        Member member = new Member(MemberId, "test1", Grade.VIP);
        memberService.join(member);

        // when
        Order resultPrice = orderService.createOrder(MemberId, "item1", 3000);

        // then
        Assertions.assertThat(resultPrice.getDiscountPrice()).isEqualTo(1000);
    }
}
