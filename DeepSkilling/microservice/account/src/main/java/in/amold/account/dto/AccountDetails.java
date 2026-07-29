package in.amold.account.dto;

import in.amold.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetails {
    private Account account;
    private List<Loan> loans;
}
