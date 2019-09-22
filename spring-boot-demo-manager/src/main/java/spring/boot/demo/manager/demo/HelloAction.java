package spring.boot.demo.manager.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;

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

    /*
    由于 manager 包引用了 service 包
    而 service 包中引用了 dao
    相当于 manager 引用了 dao 所以可以使用 @Autowired 注入 dao 层的 Mapper
     */
    @Autowired
    private AcctMapper acctMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;



//    @DynamicDataSource(dataSource = Const.DATASOURCE_SLAVE)
    @Override
    public void sayHello(DemoServiceProto.DemoRequest req, StreamObserver<DemoServiceProto.DemoResponse> responseObserver) {
        log.info("接收到 GRPC-Client 消息:{}",req.getName());
        accts ();
        System.out.println("Say Hello");
        String acctNbr = "111111111";
        AcctKey acctKey = new AcctKey();
        acctKey.setAcctnbr(acctNbr);
        Acct acct = acctMapper.selectByPrimaryKey(acctKey);

        acct.setName("梅长苏");
        acctMapper.updateByPrimaryKeySelective(acct);


        log.info(acct.toString());
        log.info("接收到 GRPC-Client 消息:{}",req.getName());
        DemoServiceProto.DemoResponse response = DemoServiceProto.DemoResponse.newBuilder().setMessage("Hello =============> " + req.getName()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    /**
     * 查询所有
     *
     * @return
     */
    public void accts () {
        String acctNbr = "111111111";
        AcctKey acctKey = new AcctKey();
        acctKey.setAcctnbr(acctNbr);
        Acct acct = acctMapper.selectByPrimaryKey(acctKey);
        // 具体使用
        redisTemplate.opsForList().leftPush("acct:list", JSON.toJSONString(acct));
        stringRedisTemplate.opsForValue().set("acct:acctnbr", acctNbr);
    }
}
