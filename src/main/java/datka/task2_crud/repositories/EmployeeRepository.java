package datka.task2_crud.repositories;

import datka.task2_crud.dto.response.EmployeeResponse;
import datka.task2_crud.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("""
           select new datka.task2_crud.dto.response.EmployeeResponse(
           e.email,
           e.homePhone,
           e.mobilePhone,
           e.workPhone,
           e.homeAddress,
           e.website,
           e.bankDetails,
           e.position)
           from Employee e
           where e.id = :id
           """)
    EmployeeResponse getByEmployeeResponse(Long id);
}
