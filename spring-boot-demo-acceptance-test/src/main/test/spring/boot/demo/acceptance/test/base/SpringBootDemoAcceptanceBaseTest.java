package spring.boot.demo.acceptance.test.base;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

import lombok.extern.slf4j.Slf4j;
import spring.boot.demo.acceptance.server.SpringBootDemoAcceptanceServerApplication;

@Slf4j
@SpringBootTest(classes = SpringBootDemoAcceptanceServerApplication.class)
public class SpringBootDemoAcceptanceBaseTest extends AbstractTestNGSpringContextTests {

    /*
    什么是static
    static方法就是没有this的方法。在static方法内部不能调用非静态方法，反过来是可以的。而且可以在没有创建任何对象的前提下，
    仅仅通过类本身来调用static方法。也就是说说被static关键字修饰的方法或者变量不需要依赖于对象来进行访问，只要类被加载了，
    就可以通过类名去进行访问

    static代码块
　　static关键字还有一个比较关键的作用就是用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。
    在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。
　　

    static方法
    静态方法可以直接通过类名调用，任何的实例也都可以调用， 因此静态方法中不能用this和super关键字，
    不能直接访问所属类的实例变量和实例方法(就是不带static的成员变量和成员成员方法)，只能访问所属类的静态成员变量和成员方法。

    static变量
　  按照是否静态的对类成员变量进行分类可分两种：一种是被static修饰的变量，叫静态变量或类变量；另一种是没有被static修饰的变量，叫实例变量

    static 执行顺序
    如果不继承别的类,那么执行顺序应该是:
    static代码块–>普通代码块–>类构造方法
    如果继承了别的类,那么执行顺序应该是:
    父类static代码块–>子类static代码块–>父类普通代码块–>父类构造方法–>子类普通代码块–>子类构造方法
    下面直接上代码

     */
    // 当声明为 static 时，@Value 获取不到值

    // @Before,@After和@BeforeClass和@AfterClass的区别
    // @Before：在跑测试test001，test002时候都会各执行一次@Before部分的代码。
    //@Beforeclass： 在类中只会被执行一次
    //@After：释放资源  对于每一个测试方法都要执行一次
    //@Afterclass:所有测试用例执行完才执行一次
    //一个JUnit4的单元测试用例执行顺序为： 
    //@BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
    //每一个测试方法的调用顺序为： 
    //@Before -> @Test -> @After; 

    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Start SpringBootDemoAcceptanceBaseTest.setUp");
    }
//
//    private <T extends AbstractStub<T>> init (AbstractStub<T> abstractStub) {
//
//        log.info(" grpc-client connect start.");
//        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("127.0.0.1", 7052)
//                                                             .usePlaintext()
//                                                             .build();//池化处理 成本高
//
//        abstractStub.
//        abstractStub = newBlockingStub(managedChannel);
//
//        return abstractStub;
//    }


}
