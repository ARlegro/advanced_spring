package hello.advanced.trace.strategy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Strategy2 implements Strategy{
    @Override
    public void call() {
        log.info("비즈니스 전략2");
    }
}
