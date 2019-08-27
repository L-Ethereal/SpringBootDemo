package spring.boot.demo.acceptance.test.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;
import spring.boot.demo.acceptance.test.base.SpringBootDemoAcceptanceBaseTest;
import spring.boot.demo.api.demo.DemoServiceGrpc;
import spring.boot.demo.api.demo.DemoServiceProto;

@Slf4j
public class DemoTest extends SpringBootDemoAcceptanceBaseTest {

    private ManagedChannel channel;
    private DemoServiceGrpc.DemoServiceBlockingStub demoServiceBlockingStub;

    @Autowired
    private ManagedChannel managedChannel;

    @Test
    public void test () {
        try {
            demoServiceBlockingStub = DemoServiceGrpc.newBlockingStub(managedChannel);

            DemoServiceProto.DemoResponse response = demoServiceBlockingStub.sayHello(convertRequest("Hello"));
            log.info("接收到服务端返回结果:{}",response.toString());
        } finally {
            shutdown();
        }

    }

//    @BeforeTest
//    public void init () {
//        log.info(" grpc-client connect start.");
//        channel = ManagedChannelBuilder.forAddress("127.0.0.1", 7052)
//                                       .usePlaintext()
//                                       .build();//池化处理 成本高
//        demoServiceBlockingStub = DemoServiceGrpc.newBlockingStub(channel);
//    }

    public void shutdown() {
        try {
            managedChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private DemoServiceProto.DemoRequest convertRequest(String name) {
        DemoServiceProto.DemoRequest helloRequest = DemoServiceProto.DemoRequest.newBuilder()
                                                                                .setName(name)
                                                                                .build();
        return helloRequest;
    }
}
