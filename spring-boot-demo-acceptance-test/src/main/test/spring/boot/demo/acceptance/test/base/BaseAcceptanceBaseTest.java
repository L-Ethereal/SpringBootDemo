package spring.boot.demo.acceptance.test.base;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseAcceptanceBaseTest extends SpringBootDemoAcceptanceBaseTest{

    @Value("${grpc.server.demo.name}")
    private String grpcServerName;
    @Value("${grpc.server.demo.port}")
    private int grpcServerPort;

    protected ManagedChannel connect() {
        log.info(" grpc-client connect start.");
        log.info(grpcServerName);
        log.info(String.valueOf(grpcServerPort));
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress(grpcServerName, grpcServerPort)
                                                             .usePlaintext()
                                                             .build();//池化处理 成本高

        return managedChannel;
    }

    protected void shutdown() {
        try {
            connect().shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
