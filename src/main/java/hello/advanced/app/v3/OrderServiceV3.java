package hello.advanced.app.v3;

import hello.advanced.TraceId;
import hello.advanced.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.code.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){

        AbstractTemplate<String> template = new AbstractTemplate<>(trace){
            @Override
            protected String call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("orderService.orderItem()");
    }
}
