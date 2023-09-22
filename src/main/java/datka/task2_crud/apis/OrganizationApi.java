package datka.task2_crud.apis;

import datka.task2_crud.dto.request.OrganizationRequest;
import datka.task2_crud.dto.response.OrganizationResponse;
import datka.task2_crud.dto.response.Response;
import datka.task2_crud.services.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/organizations")
public class OrganizationApi {

    private final OrganizationService organizationService;

    @PostMapping
    public OrganizationResponse createOrganization(@RequestBody OrganizationRequest request) {

        return organizationService.createOrganization(request);
    }

    @GetMapping("/{organizationId}")
    public OrganizationResponse getOrganizationById(@PathVariable Long organizationId) {

        return organizationService.getOrganizationById(organizationId);
    }

    @PutMapping("/{organizationId}")
    public Response updateOrganizationById(@PathVariable Long organizationId,
                                           @RequestBody OrganizationRequest request) {

        return organizationService.updateOrganizationById(organizationId, request);
    }

    @GetMapping
    public List<OrganizationResponse> getAllOrganizations() {

        return organizationService.getAllOrganizations();
    }

    @DeleteMapping("/{organizationId}")
    public Response deleteOrganizationById(@PathVariable Long organizationId) {

        return organizationService.deleteOrganizationById(organizationId);
    }
}
