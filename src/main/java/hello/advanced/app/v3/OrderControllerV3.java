package hello.advanced.app.v3;

import hello.advanced.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/")
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    // beginSync + 메서드에 파라미터
    @GetMapping("v3/request")
    public String save(@RequestParam("itemId") String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("orderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }

}
