
package hello.advanced.trace.template.code;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate{

    public SubClassLogic2(LogTrace trace) {
        super(trace);
    }

    @Override
    protected String call() {
        log.info("비즈니스 로직2");
        return null;
    }
}
