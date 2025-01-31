package hello.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;

// 추상 클래스
@Slf4j
public abstract class AbstractTemplate {

    // 1. 실행 메서드
    public void execute(){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        call(); //상속
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    // 2. Overriding 시킬 메서드
    // 변하는 부분을 오버라이딩 시킨다
    protected abstract void call();
    //왜 private이 아님?
}
