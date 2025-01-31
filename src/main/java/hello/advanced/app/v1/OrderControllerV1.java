package hello.advanced.app.v1;

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
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;
    private final HelloTraceV1 trace;

    @GetMapping()
    public String home(){
        return "let's go";
    }

    @GetMapping("v1/request")
    public String save(@RequestParam("itemId") String itemId){
        TraceStatus status = null;
        try {
            status = trace.begin("orderController.request()");
            orderServiceV1.orderItem(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
        return "ok";
    }

}
