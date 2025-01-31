package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
@RequiredArgsConstructor
public class FiledServiceTest {

    private final FieldService fieldService = new FieldService();

    @Test
    void field() throws InterruptedException {
        log.info("Main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        // 동시성 문제 해결용 sleep
        Thread.sleep(2000);
        threadB.start();

        // 메인 스레드 종료 지연용
        Thread.sleep(3000);
    }
}
