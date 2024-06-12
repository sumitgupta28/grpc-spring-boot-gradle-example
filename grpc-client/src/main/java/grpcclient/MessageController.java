package grpcclient;

import test.grpc.GiveMeTrueRequest;
import test.grpc.GiveMeTrueResponse;
import test.grpc.Message;
import test.grpc.MessageServiceGrpc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageServiceGrpc.MessageServiceBlockingStub messageStub;

    public MessageController(MessageServiceGrpc.MessageServiceBlockingStub messageStub) {
        this.messageStub = messageStub;
    }

    @GetMapping("/greetings")
    String send() {
         return this.messageStub.send(Message.newBuilder().setMessage("How are u?").build()).getMessage();
    }

    @GetMapping("/give-me-true")
    boolean giveMeTrue() {
        return this.messageStub.giveMeTrue(GiveMeTrueRequest.getDefaultInstance()).getTrue();
    }
}
