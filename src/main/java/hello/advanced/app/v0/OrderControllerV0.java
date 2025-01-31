package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.rmi.server.LogStream.log;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderControllerV0 {

    private final OrderServiceV0 orderServiceV0;

    @GetMapping("/v0/request")
    public String save(String itemId){
        orderServiceV0.orderItem(itemId);
        log("ok");
        return "ok";
    }

}
