package ee.sdaacademy.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Owner {

    @Id
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

