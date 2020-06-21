package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pet {

    @Id
    Integer petId;
    String name;
    Date dateOfBirth;
    PetType petType;
    Owner owner;
    boolean isVaccinated;
    Vet vet;
    Consultant consultant;
    @OneToMany()
    //@JoinColumn(name = "appointmentId")
            List<Appointment> appointmentList;
}