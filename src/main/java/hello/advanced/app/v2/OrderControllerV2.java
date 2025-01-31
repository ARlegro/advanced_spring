package hello.advanced.app.v2;

import hello.advanced.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
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
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV1 trace;

    // beginSync + 메서드에 파라미터
    @GetMapping("v2/request")
    public String save(@RequestParam("itemId") String itemId){
        TraceStatus status = null;
        try {
            status = trace.begin("orderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }

}
