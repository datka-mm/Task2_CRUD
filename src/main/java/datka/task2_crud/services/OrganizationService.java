package datka.task2_crud.services;

import datka.task2_crud.dto.request.OrganizationRequest;
import datka.task2_crud.dto.response.OrganizationResponse;
import datka.task2_crud.dto.response.Response;
import datka.task2_crud.models.Organization;
import datka.task2_crud.repositories.OrganizationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    private final JdbcTemplate jdbcTemplate;


    public OrganizationResponse createOrganization(OrganizationRequest request) {

        Organization organization = organizationRepository.save(Organization
                .builder()
                .ownershipForm(request.ownershipForm())
                .legalForm(request.legalForm())
                .name(request.name())
                .CEOName(request.CEOName())
                .fax(request.fax())
                .phone(request.phone())
                .website(request.website())
                .login(request.login())
                .licenseNumber(request.licenseNumber())
                .licenseDate(request.licenseDate())
                .certificateNumber(request.certificateNumber())
                .certificateDate(request.certificateDate())
                .address(request.address())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build());

        return new OrganizationResponse(organization);
    }


    public OrganizationResponse getOrganizationById(Long organizationId) {

        return organizationRepository.getOrganizationResponse(organizationId).orElseThrow(
                () -> new EntityNotFoundException("Organization with id: " + organizationId + " not found!")
        );
    }


    public Response updateOrganizationById(Long organizationId, OrganizationRequest request) {

        OrganizationResponse organization = getOrganizationById(organizationId);

        if (!request.ownershipForm().isBlank() && !request.ownershipForm().equals(organization.getOwnershipForm())) {
            organization.setOwnershipForm(request.ownershipForm());
        }
        if (!request.legalForm().isBlank() && !request.legalForm().equals(organization.getLegalForm())) {
            organization.setLegalForm(request.legalForm());
        }

        if (!request.name().isBlank() && !request.name().equals(organization.getName())) {
            organization.setName(request.name());
        }

        if (!request.CEOName().isBlank() && !request.CEOName().equals(organization.getCEOName())) {
            organization.setCEOName(request.CEOName());
        }

        if (!request.fax().isBlank() && !request.fax().equals(organization.getFax())) {
            organization.setFax(request.fax());
        }

        if (!request.phone().isBlank() && !request.phone().equals(organization.getPhone())) {
            organization.setPhone(request.phone());
        }

        if (!request.website().isBlank() && !request.website().equals(organization.getWebsite())) {
            organization.setWebsite(request.website());
        }

        if (!request.login().isBlank() && !request.login().equals(organization.getLogin())) {
            organization.setLogin(request.login());
        }

        if (!request.licenseNumber().isBlank() && !request.licenseNumber().equals(organization.getLicenseNumber())) {
            organization.setLicenseNumber(request.licenseNumber());
        }

        if (request.licenseDate() != null && !request.licenseDate().equals(organization.getLicenseDate())) {
            organization.setLicenseDate(request.licenseDate());
        }

        if (!request.certificateNumber().isBlank() && !request.certificateNumber().equals(organization.getCertificateNumber())) {
            organization.setCertificateNumber(request.certificateNumber());
        }

        if (request.certificateDate() != null && !request.certificateDate().equals(organization.getCertificateDate())) {
            organization.setCertificateDate(request.certificateDate());
        }

        if (!request.address().isBlank() && !request.address().equals(organization.getAddress())) {
            organization.setAddress(request.address());
        }

        return new Response("Organization successfully updated!");
    }

    public List<OrganizationResponse> getAllOrganizations() {
        String sql = "SELECT * FROM organizations";

        List<OrganizationResponse> organizationResponses = jdbcTemplate.query(sql, (rs, rowNum) -> {
            OrganizationResponse response = new OrganizationResponse();
            response.setId(rs.getLong("id"));
            response.setOwnershipForm(rs.getString("ownership_form"));
            response.setLegalForm(rs.getString("legal_form"));
            response.setName(rs.getString("name"));
            response.setCEOName(rs.getString("ceo_name"));
            response.setFax(rs.getString("fax"));
            response.setPhone(rs.getString("phone"));
            response.setWebsite(rs.getString("website"));
            response.setLogin(rs.getString("login"));
            response.setLicenseNumber(rs.getString("license_number"));
            response.setLicenseDate(rs.getDate("license_date").toLocalDate());
            response.setCertificateNumber(rs.getString("certificate_number"));
            response.setCertificateDate(rs.getDate("certificate_date").toLocalDate());
            response.setAddress(rs.getString("address"));
            return response;
        });

        return organizationResponses;
    }

    public Response deleteOrganizationById(Long organizationId) {

        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new EntityNotFoundException("Organization with id: " + organizationId + " not found!")
        );

        organizationRepository.delete(organization);
        return new Response("Organization successfully deleted!");
    }
}
