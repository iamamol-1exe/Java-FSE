package in.amold.loanservice.service;

import in.amold.loanservice.model.Loan;
import in.amold.loanservice.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public Optional<Loan> getLoanByNumber(Long number) {
        return loanRepository.findById(number);
    }

    public List<Loan> getLoansByAccountNo(Long accountNo) {
        return loanRepository.findByAccountNo(accountNo);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan updateLoan(Long number, Loan loanDetails) {
        Loan loan = loanRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("Loan not found with number: " + number));
        
        loan.setType(loanDetails.getType());
        loan.setAmount(loanDetails.getAmount());
        loan.setEmi(loanDetails.getEmi());
        loan.setTenure(loanDetails.getTenure());
        loan.setAccountNo(loanDetails.getAccountNo());
        
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long number) {
        Loan loan = loanRepository.findById(number)
                .orElseThrow(() -> new RuntimeException("Loan not found with number: " + number));
        loanRepository.delete(loan);
    }
}
