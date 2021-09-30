package zw.co.afrosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import zw.co.afrosoft.domain.Employee;
import zw.co.afrosoft.domain.dto.request.EmployeeRequest;
import zw.co.afrosoft.domain.dto.response.MessageResponse;
import zw.co.afrosoft.persistence.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        employeeRepository.save(newEmployee);
        return new MessageResponse("New Employee Added successfully");
    }

    @Override
    public Optional<Employee> updateEmployee(Long employeeId, EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isEmpty()){
            return null;
        }else
            employee.get().setFirstName(employeeRequest.getFirstName());
            employee.get().setFirstName(employeeRequest.getLastName());
            employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.get().setEmail(employeeRequest.getEmail());
            employee.get().setSalary(employeeRequest.getSalary());
            employee.get().setDepartment(employeeRequest.getDepartment());
        return employee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        if(employeeRepository.getById(employeeId).getId().equals(employeeId)){
            employeeRepository.deleteById(employeeId);
        }else
            System.out.println("No record to delete");
    }

    @Override
    public Employee getASingleEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
