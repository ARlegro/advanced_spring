package hello.advanced.app.v3;

import hello.advanced.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import hello.advanced.trace.template.code.AbstractTemplate;
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
public class OrderControllerV3{

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("v3/request")
    public String save(@RequestParam("itemId") String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace){
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("orderController.request()");
    }
}
