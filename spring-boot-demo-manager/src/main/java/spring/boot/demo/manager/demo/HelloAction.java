package spring.boot.demo.manager.demo;

import org.springframework.beans.factory.annotation.Autowired;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import spring.boot.demo.api.demo.DemoServiceGrpc;
import spring.boot.demo.api.demo.DemoServiceProto;
import spring.boot.demo.dao.generate.demo.Acct;
import spring.boot.demo.dao.generate.demo.AcctKey;
import spring.boot.demo.dao.mapper.demo.AcctMapper;

@Slf4j
@GrpcService
public class HelloAction extends DemoServiceGrpc.DemoServiceImplBase {

    @Autowired
    private AcctMapper acctMapper;

    @Override
    public void sayHello(DemoServiceProto.DemoRequest req, StreamObserver<DemoServiceProto.DemoResponse> responseObserver) {
        log.info("接收到 GRPC-Client 消息:{}",req.getName());
        System.out.println("Say Hello");
        String acctNbr = "1111";
        AcctKey acctKey = new AcctKey();
        acctKey.setAcctnbr(acctNbr);
        Acct acct = acctMapper.selectByPrimaryKey(acctKey);
        log.info(acct.toString());
        log.info("接收到 GRPC-Client 消息:{}",req.getName());
        DemoServiceProto.DemoResponse response = DemoServiceProto.DemoResponse.newBuilder().setMessage("Hello =============> " + req.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
