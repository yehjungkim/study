package physical.education.yehjung.Member.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;//ROLE_USER. ROLE_ADMIN
    private String provider;
    private String providerId;
    @CreationTimestamp
    private Timestamp createdate;
}
