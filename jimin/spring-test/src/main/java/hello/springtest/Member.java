package hello.springtest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String name;
}
