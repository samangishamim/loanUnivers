package service.loanService;

import base.service.BaseService;
import model.Loan;
import model.Student;

import java.util.List;
import java.util.Optional;

public interface LoanService extends BaseService<Loan,Long> {
    public List<Loan> findLoanByIdStudent (Student student);
    public Optional<Loan> findStudentWithSemester (Student student , String semester);
}
