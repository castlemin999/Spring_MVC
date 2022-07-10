package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j // private final Logger log = LoggerFactory.getLogger(getClass()); 생략 가능
@RestController // HTTP 메시지 바디에 바로 입력
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";
        System.out.println("name = " + name);

        /*
        * log.trace("trace my log=" + name);
        * 이런 식으로 log를 찍으면 적용 level이 아님에도 불구하고 연산이 일어남
        * 쓸모 없는 메모리 및 cpu 낭비
        * 반면
        * log.trace("trace log={}", name); 는 파라미터로 넘겨서 적용 level인지 확인하고
        * 실행 하기 때문에 불필요한 자원낭비가 없다.
        */

        // 개발 서버 : debug level 출력
        // 운영 서버 : info level 출력
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        return "OK";
    }

}
