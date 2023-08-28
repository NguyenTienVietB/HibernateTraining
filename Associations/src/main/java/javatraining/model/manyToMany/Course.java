package javatraining.model.manyToMany;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    // getters and setters


    public Course() {
        super();
    }

    public Course(String name) {
        super();
        this.name = name;
    }


    public Course(String name, Set<Student> students) {
        super();
        this.name = name;
        this.students = students;
    }



    // getters and setters

    public String getName(){
        return this.name;
    }

    public void getAll(){
        System.out.println("Course: " + this.name);
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
        }
    }


}
