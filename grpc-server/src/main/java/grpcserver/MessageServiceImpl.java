package grpcserver;

import test.grpc.GiveMeTrueRequest;
import test.grpc.GiveMeTrueResponse;
import test.grpc.MathsOutput;
import test.grpc.Message;
import test.grpc.MessageServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MessageServiceImpl extends MessageServiceGrpc.MessageServiceImplBase {

    @Override
    public void send(Message request, StreamObserver<Message> responseObserver) {
        // create response
        Message message = Message.newBuilder()
                .setMessage("gRPC server received your message: Thank U ❤️ \n Ur message is: " + request.getMessage())
                .build();

        // add to stream observer
        responseObserver.onNext(message);

        // complete
        responseObserver.onCompleted();
    }

    @Override
    public void giveMeTrue(GiveMeTrueRequest request, StreamObserver<GiveMeTrueResponse> responseObserver) {
        responseObserver.onNext(GiveMeTrueResponse.newBuilder().setTrue(true).build());
        responseObserver.onCompleted();
    }

    public void giveMeResult(test.grpc.MathsInput request,
                             io.grpc.stub.StreamObserver<test.grpc.MathsOutput> responseObserver) {
       int secondNumber= request.getSecondNumber();
       int firstNumber= request.getFirstNumber();
       String sign = request.getSign();
       String result = firstNumber + " " + sign + secondNumber +" = ";
       String finalResult;
       switch (sign) {
           case "+":
               finalResult=  result + (firstNumber + secondNumber);
               break;
           case "-":
               finalResult = result + (firstNumber - secondNumber);
               break;
           case "*":
               finalResult = result + (firstNumber * secondNumber);
               break;
           case "/":
               finalResult = result + (firstNumber - secondNumber);
               break;
           default:
               finalResult =" Unsuppoted Opration";
       }
        // add to stream observer
        responseObserver.onNext(MathsOutput.newBuilder().setResult(finalResult).build());
        // complete
        responseObserver.onCompleted();

    }

}
