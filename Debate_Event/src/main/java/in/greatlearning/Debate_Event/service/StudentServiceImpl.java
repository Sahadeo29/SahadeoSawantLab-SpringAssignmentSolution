package in.greatlearning.Debate_Event.service;


import in.greatlearning.Debate_Event.entities.Student;
import in.greatlearning.Debate_Event.repositrory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer theId) {
        return studentRepository.getById(theId);
    }

    @Override
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    public void deleteById(Integer theId) {
        studentRepository.deleteById(theId);
    }
}
