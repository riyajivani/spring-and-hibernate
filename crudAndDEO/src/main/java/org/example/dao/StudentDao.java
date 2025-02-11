package org.example.dao;
import org.example.entities.Student;
import java.util.List;

public interface StudentDao {
    void saveStudent(Student student);
    Student getStudentById(long id);

    List<Student> getAllStudent();

    void updateStudent(Student student);
    void deleteStudent(long id);
}
