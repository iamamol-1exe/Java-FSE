package in.amold.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loan {

    private Long number;
    private String type;
    private Long amount;
    private Long emi;
    private Long tenure;
    private Long accountNo;

}
