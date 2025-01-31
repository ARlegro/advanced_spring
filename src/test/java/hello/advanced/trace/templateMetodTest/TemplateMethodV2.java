package hello.advanced.trace.templateMetodTest;

import hello.advanced.trace.template.code.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodV2 {

    @Test
    void templateV2_1() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직 3");
            }
        };
        // 실행
        template1.execute();
    }
}