package net.firstspring.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.firstspring.ems_backend.dto.EmployeeDto;
import net.firstspring.ems_backend.entity.Employee;
import net.firstspring.ems_backend.exception.ResourceNotFound;
import net.firstspring.ems_backend.mapper.EmployeeMapper;
import net.firstspring.ems_backend.repository.EmployeeRepository;
import net.firstspring.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto((savedEmployee));
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFound("Employee with the given id \""
                                +employeeId+
                                "\" doesn't exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((EmployeeMapper::mapToEmployeeDto))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

         Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                 () -> new ResourceNotFound("Employee with the given id \""
                         +employeeId+
                         "\" doesn't exist"));

         employee.setFirstName(updatedEmployee.getFirstName());
         employee.setLastName(updatedEmployee.getLastName());
         employee.setEmail((updatedEmployee.getEmail()));

         Employee updatedEmployeeObj = employeeRepository.save(employee);

         return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFound("Employee with the given id \""
                        +employeeId+
                        "\" doesn't exist"));

        employeeRepository.deleteById(employeeId);
    }
}
