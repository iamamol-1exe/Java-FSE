package in.amold.account.feign;

import in.amold.account.dto.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "LOAN-SERVICE")
public interface LoanClient {
    @GetMapping("/loans/{number}")
    public ResponseEntity<Loan> getLoan(@PathVariable("number") Long number);

    @GetMapping("/loans/account/{accountNo}")
    public ResponseEntity<List<Loan>> getLoansByAccount(@PathVariable("accountNo") Long accountNo);
}
