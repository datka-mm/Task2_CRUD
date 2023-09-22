package datka.task2_crud.dto.response;

import datka.task2_crud.models.Organization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse {

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

    public OrganizationResponse(Organization organization) {
        this.id = organization.getId();
        this.ownershipForm = organization.getOwnershipForm();
        this.legalForm = organization.getLegalForm();
        this.name = organization.getName();
        this.CEOName = organization.getCEOName();
        this.fax = organization.getFax();
        this.phone = organization.getPhone();
        this.website = organization.getWebsite();
        this.login = organization.getLogin();
        this.licenseNumber = organization.getLicenseNumber();
        this.licenseDate = organization.getLicenseDate();
        this.certificateNumber = organization.getCertificateNumber();
        this.certificateDate = organization.getCertificateDate();
        this.address = organization.getAddress();
    }
}