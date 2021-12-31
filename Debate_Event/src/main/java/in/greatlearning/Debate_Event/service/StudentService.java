package in.greatlearning.Debate_Event.service;

import in.greatlearning.Debate_Event.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Integer theId);

    void save(Student theStudent);

    void deleteById(Integer theId);
}
