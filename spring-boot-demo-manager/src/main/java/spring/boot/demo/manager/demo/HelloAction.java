package spring.boot.demo.manager.demo;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import spring.boot.demo.api.demo.DemoServiceGrpc;
import spring.boot.demo.api.demo.DemoServiceProto;

@Slf4j
@GrpcService
public class HelloAction extends DemoServiceGrpc.DemoServiceImplBase {
    @Override
    public void sayHello(DemoServiceProto.DemoRequest req, StreamObserver<DemoServiceProto.DemoResponse> responseObserver) {
        log.info("接收到 GRPC-Client 消息:{}",req.getName());
        System.out.println("Say Hello");
        log.info("接收到 GRPC-Client 消息:{}",req.getName());
        DemoServiceProto.DemoResponse response = DemoServiceProto.DemoResponse.newBuilder().setMessage("Hello =============> " + req.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
