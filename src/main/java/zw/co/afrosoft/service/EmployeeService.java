package zw.co.afrosoft.service;

import org.springframework.stereotype.Component;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.domain.dto.request.EmployeeRequest;
import zw.co.afrosoft.domain.dto.response.MessageResponse;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);
    Optional<Employee> updateEmployee(Long employeeId, EmployeeRequest employeeRequest);
    void deleteEmployee(Long employeeId);
    Employee getASingleEmployee(Long employeeId);
    List<Employee> getAllEmployee();
}
