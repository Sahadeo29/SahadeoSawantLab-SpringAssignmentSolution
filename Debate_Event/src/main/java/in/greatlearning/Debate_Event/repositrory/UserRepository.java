package in.greatlearning.Debate_Event.repositrory;

import in.greatlearning.Debate_Event.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);
}
