package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Consultant {

    @Id
    @GeneratedValue
    Integer consultantId;
    String name;
    @OneToMany()
    List<Appointment> appointmentList;

    @OneToMany()
    List<Pet> petList;
}

