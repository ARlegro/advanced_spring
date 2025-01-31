package hello.advanced.trace.logtrace;

import hello.advanced.TraceId;
import hello.advanced.TraceStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {

    private static final String START_PREFIX = "-->";
    private static final String COMPLETE_PREFIX = "<--";
    private static final String EX_PREFIX = "<X-";

    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceStatus begin(String message) {

        // TraceId는 traceHolder에 담아야
        syncTraceId();
        //TraceId traceId = new TraceId();
        TraceId traceId = traceIdHolder.get();
        Long startTimeMs = System.currentTimeMillis();
        log.info("[{}] {} {}", traceId.getId(), addSpace(START_PREFIX, traceId.getLevel()), message);

        return new TraceStatus(traceId, startTimeMs, message);
    }

    // 여부분
    private void syncTraceId() {
        TraceId traceId = traceIdHolder.get();
        if (traceId == null){
            traceIdHolder.set(new TraceId());
        } else {
            traceIdHolder.set(traceId.createNextId());
        }
    }

    private String addSpace(String prefix, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append((i == level - 1) ? "|" + prefix : "|   ");
        }
        return sb.toString();
    }

    @Override
    public void end(TraceStatus status) {
        complete(status, null);
    }

    @Override
    public void exception(TraceStatus status, Exception e) {
        complete(status, e);
    }

    private void complete(TraceStatus status, Exception e) {
        TraceId traceId = status.getTraceId();
        Long resultTime = System.currentTimeMillis() - status.getStartTimeMs();
        if (e == null){
            log.info("[{}] {} {} time={}ms", traceId.getId(), addSpace(COMPLETE_PREFIX, traceId.getLevel()), status.getMessage(), resultTime);
        } else {
            log.info("[{}] {} {} time={}ms 예외 : {}", traceId.getId(), addSpace(EX_PREFIX, traceId.getLevel()), status.getMessage(), resultTime, e.toString());
        }

        // 여기서부터 달라진다.
        // traceId를 바꿔야하기 때문
        releaseTraceId();
    }

    private void releaseTraceId() {
        TraceId traceId = traceIdHolder.get();
        if (traceId.isFirstLevel()){
            traceIdHolder.remove();  // remove
        } else {
            traceIdHolder.set(traceId.createPreviousId());
        }
    }
}
