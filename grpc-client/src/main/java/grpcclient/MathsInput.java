package grpcclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MathsInput {

    private String mathsSign;
    private String firstNumber;
    private String secondNumber;
}
