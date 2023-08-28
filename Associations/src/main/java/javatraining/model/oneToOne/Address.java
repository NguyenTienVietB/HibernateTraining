package javatraining.model.oneToOne;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String city;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;


    public Address() {
        super();
    }

    public Address(String city) {
        super();
        this.city = city;
    }


    public Address(String city, Person person) {
        super();
        this.city = city;
        this.person = person;
    }

    public Address(String city, Long id) {
        super();
        this.city = city;
        this.id = id;
    }

}
