package spring.boot.demo.acceptance.test.demo;

import org.testng.annotations.Test;

import lombok.extern.slf4j.Slf4j;
import spring.boot.demo.acceptance.test.base.BaseAcceptanceBaseTest;
import spring.boot.demo.api.demo.DemoServiceGrpc;
import spring.boot.demo.api.demo.DemoServiceGrpc.DemoServiceBlockingStub;
import spring.boot.demo.api.demo.DemoServiceProto;

@Slf4j
public class DemoTest extends BaseAcceptanceBaseTest {

//    @Value("${grpc.server.demo.name}")
//    private String grpcServerName;
//    @Value("${grpc.server.demo.port}")
//    private int grpcServerPort;

    @Test
    public void test() {
        try {
            // 子类中不可获取 父类中的 private 方法
            DemoServiceBlockingStub demoServiceBlockingStub = DemoServiceGrpc.newBlockingStub(connect());
            DemoServiceProto.DemoResponse response = demoServiceBlockingStub.sayHello(convertRequest("TestHello"));
            log.info("接收到服务端返回结果:{}", response.toString());
        } finally {
            shutdown();
        }

    }

    // 先执行 @BeforeTest 再 执行 @Configuration
//    @BeforeTest
//    public void init() {
//        log.info(" grpc-client connect start.");
//        managedChannel = ManagedChannelBuilder.forAddress("127.0.0.1", 7052)
//                                              .usePlaintext()
//                                              .build();//池化处理 成本高
//
//    }



    private DemoServiceProto.DemoRequest convertRequest(String name) {
        DemoServiceProto.DemoRequest helloRequest = DemoServiceProto.DemoRequest.newBuilder()
                                                                                .setName(name)
                                                                                .build();
        return helloRequest;
    }
}
