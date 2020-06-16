package ee.sdaacademy.petclinic.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue
    Integer adminId;
    String firstName;
    String lastName;
    String telephoneNumber;
    String email;
}
