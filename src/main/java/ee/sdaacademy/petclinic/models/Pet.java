package ee.sdaacademy.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pet")
@Getter
@Setter
public class Pet {

    @Id
    Integer petId;
    String name;
    Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "petTypeId")
    PetType petType;
    @ManyToOne
    @JoinColumn(name = "ownerId")
    Owner owner;
    boolean isVaccinated;
    @ManyToOne
    @JoinColumn(name = "vetId")
    Vet vet;
    @ManyToOne
    @JoinColumn(name = "consultantId")
    Consultant consultant;
    @OneToMany(mappedBy = "petId", fetch = FetchType.EAGER)
    //@JoinColumn(name = "appointmentId")
    List<Appointment> appointmentList;
}
