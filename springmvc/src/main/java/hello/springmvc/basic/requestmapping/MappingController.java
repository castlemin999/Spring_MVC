package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-go"})
    private String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1",  method = RequestMethod.GET)
    private String mappingGetV1() {
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    private String mappingGetV2() {
        log.info("mappingGetV2");
        return "ok";
    }

    // PathVariable
    // URL 경로를 템플릿화
    // @PathVariable를 사용하여 매칭 되는 부분을 편리하게 조회한다.
    @GetMapping("/mapping1/{userId}")
    public String mappingPath1(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "OK";
    }

    // @PathVariable의 이름이 파라미터 이름이 같으면 생략 가능하다.
    @GetMapping("/mapping2/{userId}")
    public String mappingPath2(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "OK";
    }

    // 다중 @PathVariable 사용
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath3(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userid={}, oderId={}", userId, orderId);
        return "OK";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes = 요청의 Content Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = 응답의 Content Type
     * accept가 있어야 한다.
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

}
