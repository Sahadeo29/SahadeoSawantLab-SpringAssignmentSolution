package in.greatlearning.Debate_Event.repositrory;

import in.greatlearning.Debate_Event.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainsAllIgnoreCase(String name);
}
