package datka.task2_crud.apis;

import datka.task2_crud.dto.request.EmployeeRequest;
import datka.task2_crud.dto.response.EmployeeResponse;
import datka.task2_crud.dto.response.Response;
import datka.task2_crud.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeApi {

    private final EmployeeService employeeService;

    @PostMapping("/{organizationId}")
    public Response saveEmployee(@PathVariable Long organizationId,
                                 @RequestBody EmployeeRequest request) {

        return employeeService.saveEmployee(organizationId, request);
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse getEmployeeById(@PathVariable Long employeeId) {

        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/{employeeId}")
    public Response updateEmployeeById(@PathVariable Long employeeId,
                                       @RequestBody EmployeeRequest request) {

        return employeeService.update(employeeId, request);
    }

    @GetMapping("/{organizationId}")
    public List<EmployeeResponse> getAll(@PathVariable Long organizationId) {

        return employeeService.getAll(organizationId);
    }

    @DeleteMapping("/{employeeId}")
    public Response deleteById(@PathVariable Long employeeId) {

        return employeeService.deleteById(employeeId);
    }
}
