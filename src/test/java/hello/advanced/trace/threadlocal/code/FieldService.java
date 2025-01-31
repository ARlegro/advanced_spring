package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j
public class FieldService {

    //여러 개의 스레드가 동일한 FieldService 객체를 공유
    //동시에 nameStore 값을 변경하면 race condition(경쟁 상태)**이 발생
    private String nameStore;

    public String logic(String name){
        log.info("저장 name={} -> nameStore={}", name, nameStore);
        nameStore = name;  // 동시 진행시 덮어쓰기가 되어서 이상한 값이 저장될 수 있다
        sleep(1000);
        log.info("조회 nameStore={}",nameStore);
        return nameStore;
    }

    public void sleep(int million){
        try {
            Thread.sleep(million);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
