package in.co.vwits.emp.service;

import java.util.List;
import java.util.Optional;

import in.co.vwits.emp.model.Employee;
import in.co.vwits.model.exception.EmployeeNotFoundException;

public interface EmployeeService {

		List<Employee> findAll();

		void save(Employee s);

		Optional<Employee> findByEmpId(int empid) throws EmployeeNotFoundException;

		void deleteByEmpId(int empid);

		void updateByEmpId(int empid, double modifiedSalary);

		List<Employee> findAllEmployeesSortedBySalary();
}
