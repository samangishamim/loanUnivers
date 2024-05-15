package repository.studentRepository;

import base.repository.BaseRepositoryImpl;
import connection.SessionFactorySingleton;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Student, Long> implements StudentRepository {
    private final SessionFactory sessionFactory = SessionFactorySingleton.getInstance();
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public String getMyClass() {
        return "student";
    }

    @Override
    public Optional<List<Student>> studentSignIn(String nationalId, String password) {
        Session session = sessionFactory.getCurrentSession();
        String hql ="FROM Student s WHERE s.nationalId=:nationalId AND s.password=:password ";
        Query<Student> query = session.createQuery(hql , Student.class);
        query.setParameter("nationalId", nationalId );
        query.setParameter( "password" , password );
        List<Student> resultList = query.getResultList();

        return Optional.ofNullable(resultList);
    }

    @Override
    public Optional<Student> studentInfo(String nationalId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> query = session.createQuery("FROM Student s  " +
                " WHERE s.nationalId=:nationalId" , Student.class);
        query.setParameter("nationalId", nationalId );
        Student student = query.uniqueResult();

        return Optional.ofNullable(query.getSingleResult());
    }


}
