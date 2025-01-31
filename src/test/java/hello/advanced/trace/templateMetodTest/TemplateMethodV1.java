package hello.advanced.trace.templateMetodTest;

import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.trace.template.SubClassLogic1;
import hello.advanced.trace.template.SubClassLogic2;
import org.junit.jupiter.api.Test;

public class TemplateMethodV1 {

    @Test
    void templateTest(){
        AbstractTemplate template1 = new SubClassLogic1();
        AbstractTemplate template2 = new SubClassLogic2();

        template1.execute();
        template2.execute();
    }
}
