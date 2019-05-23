package pl.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USER")
public class User implements Serializable {

    @GeneratedValue
    @Id
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String login;

    @Column(unique = true)
    private String password;
}
