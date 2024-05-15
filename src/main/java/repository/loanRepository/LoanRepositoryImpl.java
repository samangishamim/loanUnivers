package repository.loanRepository;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.Loan;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class LoanRepositoryImpl extends BaseRepositoryImpl<Loan,Long>
        implements LoanRepository {
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    public LoanRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Loan> getEntityClass() {
        return Loan.class;
    }

    @Override
    public String getMyClass() {
        return "Loan";
    }

    @Override
    public List<Loan> findLoanByIdStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        Query<Loan> query = session.createQuery("FROM Loan l WHERE student=:student",Loan.class);
        query.setParameter("student", student);

        return query.getResultList();
    }

    @Override
    public Optional<Loan> findStudentWithSemester(Student student, String semester) {
        Session session = sessionFactory.getCurrentSession();
        Query<Loan> query = session.createQuery("FROM Loan l " +
                "WHERE l.student=:student AND l.semester=:getLoanSemester", Loan.class);
        query.setParameter("student", student);
        query.setParameter("semester", semester);

        return Optional.ofNullable(query.getSingleResult());
    }
}
