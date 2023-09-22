package datka.task2_crud.dto.response;

import lombok.Builder;

@Builder
public record EmployeeResponse(

        String email,

        String homePhone,

        String mobilePhone,

        String workPhone,

        String homeAddress,

        String website,

        String bankDetails,

        String position
) {
}