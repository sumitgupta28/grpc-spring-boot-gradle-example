package grpcclient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/give-me-result")
    String giveMeResult(@RequestBody MathsInput mathsInput){
        return messageStub.giveMeResult(test.grpc.MathsInput.newBuilder()
                        .setFirstNumber(Integer.parseInt(mathsInput.getFirstNumber()))
                        .setSecondNumber(Integer.parseInt(mathsInput.getSecondNumber()))
                        .setSign(mathsInput.getMathsSign())
                .build()).getResult();
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
