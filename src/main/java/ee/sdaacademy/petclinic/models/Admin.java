package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue
    Long adminId;
    String firstName;
    String lastName;
    String telephoneNumber;
    String email;
}
