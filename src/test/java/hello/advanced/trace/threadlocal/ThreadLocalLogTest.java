package hello.advanced.trace.threadlocal;

import hello.advanced.TraceStatus;
import hello.advanced.trace.logtrace.ThreadLocalLogTrace;
import org.junit.jupiter.api.Test;

public class ThreadLocalLogTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();
    @Test
    void begin_end_level2() {
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        trace.end(status2);
        trace.end(status1);
    }
}
