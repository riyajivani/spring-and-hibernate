package com.example.LabApi.service;

import com.example.LabApi.entity.Student;
import com.example.LabApi.exception.StudentNotFoundException;
import com.example.LabApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        Optional<Student> foundStudent = studentRepository.findById(studentId);

        Student student = null;

        if(foundStudent.isPresent()){
            student = foundStudent.get();
        }else {
            throw new StudentNotFoundException("Student with id: "+studentId+" not found");
        }

        return student;
    }

    @Override @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override @Transactional
    public Student update(int studentId, Student updateStudent) {
        Student matchStudent = findById(studentId);

        if(matchStudent!=null) {
            if (updateStudent.getName() != null)
                matchStudent.setName(updateStudent.getName());

            if (updateStudent.getCity() != null)
                matchStudent.setCity(updateStudent.getCity());

            if (updateStudent.getEmail() != null)
                matchStudent.setEmail(updateStudent.getEmail());

            if (updateStudent.getGender() != null)
                matchStudent.setGender(updateStudent.getGender());

            if (updateStudent.getSemester() != 0)
                matchStudent.setSemester(updateStudent.getSemester());

            if (updateStudent.getProgram() != null)
                matchStudent.setProgram(updateStudent.getProgram());
        }

        if(matchStudent==null){
            throw new StudentNotFoundException("Student with id: "+updateStudent.getId()+" not found");
        }
        return studentRepository.save(matchStudent);
    }

    @Override @Transactional
    public void deleteById(int studentId) {
        Student matchStudent = findById(studentId);
        studentRepository.deleteById(studentId);
    }
}
