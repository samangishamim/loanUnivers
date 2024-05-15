package repository.studentRepository;

import base.repository.BaseRepository;
import model.LoanType;
import model.PaymentStatus;
import model.Student;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends BaseRepository<Student, Long> {

    public Optional<List<Student>> studentSignIn(String nationalId, String password);

    public Optional<Student> studentInfo(String nationalId);
}
