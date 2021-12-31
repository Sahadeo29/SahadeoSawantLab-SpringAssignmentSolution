package in.greatlearning.Debate_Event.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Student_Details")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private String name;
    private String department;
    private String country;

    public Student(String name, String department, String country) {
        super();
        this.name=name;
        this.department=department;
        this.country=country;
    }
}
