package spring.boot.demo.api.demo;

import spring.boot.demo.api.demo.dto.DemoRequest;
import spring.boot.demo.api.demo.dto.DemoResponse;

public interface DemoService {
    DemoResponse sayHello(DemoRequest req);

    DemoResponse sayGoodbye(DemoRequest req);
}
