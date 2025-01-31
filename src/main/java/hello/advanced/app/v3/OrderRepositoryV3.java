package hello.advanced.app.v3;

import hello.advanced.TraceId;
import hello.advanced.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.code.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId){
        AbstractTemplate<String> template = new AbstractTemplate<>(trace){
            @Override
            protected String call() {
                if ("ex".equals(itemId)){
                    throw new IllegalStateException("예외 발생");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
