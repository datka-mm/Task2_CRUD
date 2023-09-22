package datka.task2_crud.repositories;

import datka.task2_crud.dto.response.OrganizationResponse;
import datka.task2_crud.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("""
           select new datka.task2_crud.dto.response.OrganizationResponse(
           o.id,
           o.ownershipForm,
           o.legalForm,
           o.name,
           o.CEOName,
           o.fax,
           o.phone,
           o.website,
           o.login,
           o.licenseNumber,
           o.licenseDate,
           o.certificateNumber,
           o.certificateDate,
           o.address)
           from Organization o
           where o.id = :organizationId
           """)
    Optional<OrganizationResponse> getOrganizationResponse(Long organizationId);
}