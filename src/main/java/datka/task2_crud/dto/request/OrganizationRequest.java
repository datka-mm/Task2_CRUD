package datka.task2_crud.dto.request;

import java.time.LocalDate;

public record OrganizationRequest(

        String ownershipForm,

        String legalForm,

        String name,

        String CEOName,

        String fax,

        String phone,

        String website,

        String login,

        String licenseNumber,

        LocalDate licenseDate,

        String certificateNumber,

        LocalDate certificateDate,

        String address
) {
}