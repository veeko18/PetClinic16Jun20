package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Appointment {
    @Id
    Long appointmentId;
    String description;
    LocalDateTime time;
    Consultant consultant;
    Pet pet;
}
