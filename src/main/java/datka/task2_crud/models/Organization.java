package datka.task2_crud.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(
            generator = "organization_gen",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "organization_gen",
            sequenceName = "organization_seq",
            allocationSize = 1
    )
    private Long id;

    private String ownershipForm;

    private String legalForm;

    private String name;

    private String CEOName;

    private String fax;

    private String phone;

    private String website;

    private String login;

    private String licenseNumber;

    private LocalDate licenseDate;

    private String certificateNumber;

    private LocalDate certificateDate;

    private String address;

    private LocalDateTime createdDate;

    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "organization", cascade = {CascadeType.ALL})
    private List<Employee> employees;
}
