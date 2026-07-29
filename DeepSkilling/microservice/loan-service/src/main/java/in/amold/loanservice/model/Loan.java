package in.amold.loanservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Loan {

    @Id
    private Long number;
    private String type;
    private Long amount;
    private Long emi;
    private Long tenure;
    private Long accountNo;

}
