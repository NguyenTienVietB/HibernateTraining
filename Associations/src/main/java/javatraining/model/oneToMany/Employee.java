package javatraining.model.oneToMany;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // getters and setters

    public Employee() {
        super();
    }

    public Employee(String name) {
        super();
        this.name = name;
    }


    public Employee(String name, Department department) {
        super();
        this.name = name;
        this.department = department;
    }


    // getters and setters

    public void getAll(){
        System.out.println("Employee: " + this.name + " - " + this.department.getName());
    }

}
