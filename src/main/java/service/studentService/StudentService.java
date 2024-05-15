package service.studentService;

import base.service.BaseService;
import model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService extends BaseService<Student, Long> {
    public List<Student> studentSignIn(String nationalId, String password);
    public Optional<Student> studentInfo(String nationalId);
}
