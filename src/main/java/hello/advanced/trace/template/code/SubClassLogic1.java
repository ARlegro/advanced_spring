package hello.advanced.trace.template.code;

import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate{

    public SubClassLogic1(LogTrace trace) {
        super(trace);
    }

    @Override
    protected String call() {
        log.info("비즈니스 로직1");
        return null;
    }
}
