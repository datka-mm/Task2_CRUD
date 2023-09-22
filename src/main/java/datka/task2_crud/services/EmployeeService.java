package datka.task2_crud.services;

import datka.task2_crud.dto.request.EmployeeRequest;
import datka.task2_crud.dto.response.EmployeeResponse;
import datka.task2_crud.dto.response.Response;
import datka.task2_crud.models.Employee;
import datka.task2_crud.models.Organization;
import datka.task2_crud.repositories.EmployeeRepository;
import datka.task2_crud.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final OrganizationRepository organizationRepository;

    public Response saveEmployee(Long organizationId, EmployeeRequest request) {

        Optional<Organization> organizationOptional = organizationRepository.findById(organizationId);

        if (organizationOptional.isEmpty()) {
            return new Response("Organization not found");
        }

        Organization organization = organizationOptional.get();

        Employee employee = Employee.builder()
                .email(request.email())
                .homePhone(request.homePhone())
                .mobilePhone(request.mobilePhone())
                .workPhone(request.workPhone())
                .homeAddress(request.homeAddress())
                .website(request.website())
                .bankDetails(request.bankDetails())
                .position(request.position())
                .organization(organization)
                .build();

        organization.getEmployees().add(employee);
        organizationRepository.save(organization);

        return new Response("Employee saved successfully");

    }

    public EmployeeResponse getEmployeeById(Long employeeId) {

        return employeeRepository.getByEmployeeResponse(employeeId);
    }

    public Response update(Long employeeId, EmployeeRequest request) {

        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);

        if (employeeOptional.isEmpty()) {
            return new Response("Employee not found");
        }

        Employee employee = employeeOptional.get();
        employee.setEmail(request.email());
        employee.setHomePhone(request.homePhone());
        employee.setMobilePhone(request.mobilePhone());
        employee.setWorkPhone(request.workPhone());
        employee.setHomeAddress(request.homeAddress());
        employee.setWebsite(request.website());
        employee.setBankDetails(request.bankDetails());
        employee.setPosition(request.position());

        employeeRepository.save(employee);

        return new Response("Employee updated successfully");

    }

    public List<EmployeeResponse> getAll(Long organizationId) {

        Optional<Organization> organizationOptional = organizationRepository.findById(organizationId);

        if (organizationOptional.isEmpty()) {
            return null; // You might want to handle this differently (e.g., returning an error response).
        }

        Organization organization = organizationOptional.get();
        List<Employee> employees = organization.getEmployees();

        return employees.stream()
                .map(employee -> EmployeeResponse.builder()
                        .email(employee.getEmail())
                        .homePhone(employee.getHomePhone())
                        .mobilePhone(employee.getMobilePhone())
                        .workPhone(employee.getWorkPhone())
                        .homeAddress(employee.getHomeAddress())
                        .website(employee.getWebsite())
                        .bankDetails(employee.getBankDetails())
                        .position(employee.getPosition())
                        .build())
                .collect(Collectors.toList());

    }

    public Response deleteById(Long employeeId) {
        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return new Response("Employee deleted successfully");
        } else {
            return new Response("Employee not found");
        }
    }
}
