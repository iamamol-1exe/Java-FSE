package in.amold.loanservice.controller;

import in.amold.loanservice.model.Loan;
import in.amold.loanservice.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/loans")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan savedLoan = loanService.createLoan(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLoan);
    }

    @GetMapping("/loans/{number}")
    public ResponseEntity<Loan> getLoan(@PathVariable Long number) {
        return loanService.getLoanByNumber(number)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/loans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/loans/account/{accountNo}")
    public ResponseEntity<List<Loan>> getLoansByAccount(@PathVariable Long accountNo) {
        return ResponseEntity.ok(loanService.getLoansByAccountNo(accountNo));
    }

    @PutMapping("/loans/{number}")
    public ResponseEntity<Loan> updateLoan(@PathVariable Long number, @RequestBody Loan loanDetails) {
        try {
            Loan updatedLoan = loanService.updateLoan(number, loanDetails);
            return ResponseEntity.ok(updatedLoan);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/loans/{number}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long number) {
        try {
            loanService.deleteLoan(number);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
