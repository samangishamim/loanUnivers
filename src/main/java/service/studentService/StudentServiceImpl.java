package service.studentService;

import base.service.BaseServiceImpl;
import connection.SessionFactorySingleton;
import exeption.NotFoundException;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.studentRepository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl extends BaseServiceImpl<Student, Long , StudentRepository>
        implements StudentService{
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    public StudentServiceImpl(StudentRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }

    @Override
    public List<Student> studentSignIn(String nationalId, String password) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<List<Student>> find = repository.studentSignIn(nationalId, password);
            find.orElseThrow(() -> new NotFoundException("Entity not found"));
            session.getTransaction().commit();
            return find.get();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Optional<Student> studentInfo(String nationalId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<Student> find = repository.studentInfo(nationalId);
            find.orElseThrow(() -> new NotFoundException("Entity not found"));
            session.getTransaction().commit();
            return find;
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
