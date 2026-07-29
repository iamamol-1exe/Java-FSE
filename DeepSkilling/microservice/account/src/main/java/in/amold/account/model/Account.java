package in.amold.account.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    private Long accountNo;
    private String type;
    private long balance;

}
