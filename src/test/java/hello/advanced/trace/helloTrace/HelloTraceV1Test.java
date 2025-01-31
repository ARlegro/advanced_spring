package hello.advanced.trace.helloTrace;

import hello.advanced.TraceStatus;
import org.junit.jupiter.api.Test;

public class HelloTraceV1Test {
    @Test
    void begin_end(){
        HelloTraceV1 helloV1 = new HelloTraceV1();
        TraceStatus status1 = helloV1.begin("ㅎㅇ");
        helloV1.end(status1);
    }

    @Test
    void exception(){
        HelloTraceV1 helloV1 = new HelloTraceV1();
        TraceStatus status = helloV1.begin("예외");
        helloV1.exception(status, new IllegalStateException());
    }
}
