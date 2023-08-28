package javatraining.model.oneToMany;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

    // getters and setters

    public Department() {
        super();
    }

    public Department(String name) {
        super();
        this.name = name;
    }


    public Department(String name, List<Employee> employees) {
        super();
        this.name = name;
        this.employees = employees;
    }


    // getters and setters

    public void getAll(){
        System.out.println("Department: " + this.name);
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName());
        }
    }
}
