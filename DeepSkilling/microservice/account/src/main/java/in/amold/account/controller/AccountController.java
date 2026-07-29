package in.amold.account.controller;

import in.amold.account.dto.AccountDetails;
import in.amold.account.dto.Loan;
import in.amold.account.feign.LoanClient;
import in.amold.account.model.Account;
import in.amold.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final LoanClient loanClient;

    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account savedAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @GetMapping("/accounts/{accounts}")
    public ResponseEntity<Account> getAccounts(@PathVariable Long accounts) {
        return accountService.getAccountByNo(accounts)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("/accounts/{accounts}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accounts, @RequestBody Account accountDetails) {
        try {
            Account updatedAccount = accountService.updateAccount(accounts, accountDetails);
            return ResponseEntity.ok(updatedAccount);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/accounts/{accounts}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accounts) {
        try {
            accountService.deleteAccount(accounts);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/accounts/{accounts}/details")
    public ResponseEntity<AccountDetails> getAccountDetails(@PathVariable Long accounts) {
        try {
            AccountDetails details = accountService.getAccountDetails(accounts);
            return ResponseEntity.ok(details);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getLoan")
    public ResponseEntity<Loan> getLoan() {
        return loanClient.getLoan(343433434L);
    }
}
