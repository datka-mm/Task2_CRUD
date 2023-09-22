package datka.task2_crud.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(
            generator = "employee_gen",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "employee_gen",
            sequenceName = "employee_seq",
            allocationSize = 1
    )
    private Long id;

    private String email;

    private String homePhone;

    private String mobilePhone;

    private String workPhone;

    private String homeAddress;

    private String website;

    private String bankDetails;

    private String position;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE})
    private Organization organization;
}
