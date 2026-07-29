package in.amold.account.service;

import in.amold.account.dto.AccountDetails;
import in.amold.account.dto.Loan;
import in.amold.account.feign.LoanClient;
import in.amold.account.model.Account;
import in.amold.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final LoanClient loanClient;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Optional<Account> getAccountByNo(Long accountNo) {
        return accountRepository.findById(accountNo);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account updateAccount(Long accountNo, Account accountDetails) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNo));

        account.setType(accountDetails.getType());
        account.setBalance(accountDetails.getBalance());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long accountNo) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNo));
        accountRepository.delete(account);
    }

    public AccountDetails getAccountDetails(Long accountNo) {
        Account account = accountRepository.findById(accountNo)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNo));

        List<Loan> loans = Collections.emptyList();
        try {
            ResponseEntity<List<Loan>> response = loanClient.getLoansByAccount(accountNo);
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                loans = response.getBody();
            }
        } catch (Exception e) {
            // Log error or handle fallback logic when LOAN-SERVICE is down
            System.err.println("Failed to fetch loans from LOAN-SERVICE: " + e.getMessage());
        }

        return new AccountDetails(account, loans);
    }
}
