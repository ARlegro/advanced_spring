package hello.advanced.app.v2;

import hello.advanced.TraceId;
import hello.advanced.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(TraceId traceId, String itemId){

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"orderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}
