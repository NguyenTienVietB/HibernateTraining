package javatraining.model.manyToMany;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Getter
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

    // getters and setters



    public Student() {
        super();
    }

    public Student(String name) {
        super();
        this.name = name;
    }


    public Student(String name, Set<Course> courses) {
        super();
        this.name = name;
        this.courses = courses;
    }


    // getters and setters

    public String getName(){
        return this.name;
    }

    public void getAll(){
        System.out.println("Student: " + this.name);
        for (Course course : courses) {
            System.out.println("Course: " + course.getName());
        }
    }

 }
