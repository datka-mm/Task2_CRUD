package datka.task2_crud.dto.request;

public record EmployeeRequest(

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