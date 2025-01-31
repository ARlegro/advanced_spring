package hello.advanced.trace.filedLogTrace;

import hello.advanced.TraceStatus;
import hello.advanced.trace.logtrace.FieldLogTrace;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest {
    FieldLogTrace trace = new FieldLogTrace();
    @Test
    void begin_end(){

        TraceStatus status1 = trace.begin("AAAA");
        TraceStatus status2 = trace.begin("BBBB");
        trace.end(status1);
        trace.end(status2);
    }
}
