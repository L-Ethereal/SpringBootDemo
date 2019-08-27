package spring.boot.demo.api.demo;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *服务端接口类
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.0)",
    comments = "Source: Demo.proto")
public final class DemoServiceGrpc {

  private DemoServiceGrpc() {}

  public static final String SERVICE_NAME = "grpc.DemoService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSayHelloMethod()} instead. 
  public static final io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
      spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> METHOD_SAY_HELLO = getSayHelloMethod();

  private static volatile io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
      spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> getSayHelloMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
      spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> getSayHelloMethod() {
    io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest, spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> getSayHelloMethod;
    if ((getSayHelloMethod = DemoServiceGrpc.getSayHelloMethod) == null) {
      synchronized (DemoServiceGrpc.class) {
        if ((getSayHelloMethod = DemoServiceGrpc.getSayHelloMethod) == null) {
          DemoServiceGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest, spring.boot.demo.api.demo.DemoServiceProto.DemoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.DemoService", "sayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  spring.boot.demo.api.demo.DemoServiceProto.DemoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  spring.boot.demo.api.demo.DemoServiceProto.DemoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DemoServiceMethodDescriptorSupplier("sayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSayGoodbyeMethod()} instead. 
  public static final io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
      spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> METHOD_SAY_GOODBYE = getSayGoodbyeMethod();

  private static volatile io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
      spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> getSayGoodbyeMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
      spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> getSayGoodbyeMethod() {
    io.grpc.MethodDescriptor<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest, spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> getSayGoodbyeMethod;
    if ((getSayGoodbyeMethod = DemoServiceGrpc.getSayGoodbyeMethod) == null) {
      synchronized (DemoServiceGrpc.class) {
        if ((getSayGoodbyeMethod = DemoServiceGrpc.getSayGoodbyeMethod) == null) {
          DemoServiceGrpc.getSayGoodbyeMethod = getSayGoodbyeMethod = 
              io.grpc.MethodDescriptor.<spring.boot.demo.api.demo.DemoServiceProto.DemoRequest, spring.boot.demo.api.demo.DemoServiceProto.DemoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "grpc.DemoService", "sayGoodbye"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  spring.boot.demo.api.demo.DemoServiceProto.DemoRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  spring.boot.demo.api.demo.DemoServiceProto.DemoResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new DemoServiceMethodDescriptorSupplier("sayGoodbye"))
                  .build();
          }
        }
     }
     return getSayGoodbyeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DemoServiceStub newStub(io.grpc.Channel channel) {
    return new DemoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DemoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DemoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DemoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DemoServiceFutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class DemoServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request,
        io.grpc.stub.StreamObserver<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void sayGoodbye(spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request,
        io.grpc.stub.StreamObserver<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSayGoodbyeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
                spring.boot.demo.api.demo.DemoServiceProto.DemoResponse>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSayGoodbyeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                spring.boot.demo.api.demo.DemoServiceProto.DemoRequest,
                spring.boot.demo.api.demo.DemoServiceProto.DemoResponse>(
                  this, METHODID_SAY_GOODBYE)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class DemoServiceStub extends io.grpc.stub.AbstractStub<DemoServiceStub> {
    private DemoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DemoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DemoServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request,
        io.grpc.stub.StreamObserver<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayGoodbye(spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request,
        io.grpc.stub.StreamObserver<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayGoodbyeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class DemoServiceBlockingStub extends io.grpc.stub.AbstractStub<DemoServiceBlockingStub> {
    private DemoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DemoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DemoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public spring.boot.demo.api.demo.DemoServiceProto.DemoResponse sayHello(spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public spring.boot.demo.api.demo.DemoServiceProto.DemoResponse sayGoodbye(spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayGoodbyeMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class DemoServiceFutureStub extends io.grpc.stub.AbstractStub<DemoServiceFutureStub> {
    private DemoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DemoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DemoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DemoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> sayHello(
        spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse> sayGoodbye(
        spring.boot.demo.api.demo.DemoServiceProto.DemoRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayGoodbyeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_GOODBYE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DemoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DemoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((spring.boot.demo.api.demo.DemoServiceProto.DemoRequest) request,
              (io.grpc.stub.StreamObserver<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse>) responseObserver);
          break;
        case METHODID_SAY_GOODBYE:
          serviceImpl.sayGoodbye((spring.boot.demo.api.demo.DemoServiceProto.DemoRequest) request,
              (io.grpc.stub.StreamObserver<spring.boot.demo.api.demo.DemoServiceProto.DemoResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class DemoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DemoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return spring.boot.demo.api.demo.DemoServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DemoService");
    }
  }

  private static final class DemoServiceFileDescriptorSupplier
      extends DemoServiceBaseDescriptorSupplier {
    DemoServiceFileDescriptorSupplier() {}
  }

  private static final class DemoServiceMethodDescriptorSupplier
      extends DemoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DemoServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DemoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DemoServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayGoodbyeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
