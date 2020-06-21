package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Owner {

    @Id
    @GeneratedValue
    Integer ownerId;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String address;
    String telephoneNumber;
    String email;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    List<Pet> petList;
}

