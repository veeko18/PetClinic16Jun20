package ee.sdaacademy.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vet")
@Getter
@Setter
public class Vet {

    @Id
    Integer vetId;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String address;
    String telephoneNumber;
    String email;

    @OneToMany(mappedBy = "vet")
    List<Pet> petList;
}
