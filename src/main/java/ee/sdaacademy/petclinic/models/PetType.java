package ee.sdaacademy.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "petType")
@Getter
@Setter
public class PetType {

    @Id
    int petTypeId;
    String name;
    @OneToMany(mappedBy = "petType", fetch = FetchType.EAGER)
    //@JoinColumn(name = "petId")
            List<Pet> petList;
}
