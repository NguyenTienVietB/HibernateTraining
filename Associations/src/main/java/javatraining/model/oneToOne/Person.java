package javatraining.model.oneToOne;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Address address;

    // getters and setters

    public Person() {
        super();
    }


    public Person(String name) {
        super();
        this.name = name;
    }


    public Person(String name, Address address) {
        super();
        this.name = name;
        this.address = address;
    }


    // getters and setters
    public  void getAll(){
        System.out.println("Person: " + this.name + " - " + this.address.getCity());
    }
}