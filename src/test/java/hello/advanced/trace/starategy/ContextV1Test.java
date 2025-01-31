package hello.advanced.trace.starategy;


import hello.advanced.trace.strategy.test.ContextV1;
import hello.advanced.trace.strategy.test.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategy(){
        ContextV1 contextV1 = new ContextV1(() -> log.info("익명 내부 클래스"));
        contextV1.execute();
    }
}
