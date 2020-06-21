package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.security.acl.Owner;
import java.util.Date;
import java.util.List;

public enum PetType {

    AMPHIBIANS, AQUARIUM_SPECIES, BIRDS, CATS, DOGS, RODENTS, REPTILES
    @Id
    @GeneratedValue
    int petTypeId;
    String name;
    @OneToMany(mappedBy = "petType", fetch = FetchType.EAGER)
    //@JoinColumn(name = "petId")
            List<Pet> petList;
};
