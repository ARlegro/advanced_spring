package hello.advanced.trace.strategy.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {

    private Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        log.info("템플릿 시작");
        // 위임
        strategy.call();
        log.info("템플릿 끝");
    }
}
