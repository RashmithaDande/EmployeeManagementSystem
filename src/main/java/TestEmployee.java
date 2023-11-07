import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import in.co.vwits.emp.model.Employee;
import in.co.vwits.emp.service.EmployeeService;
import in.co.vwits.emp.service.impl.EmployeeServiceImpl;
import in.co.vwits.model.exception.EmployeeNotFoundException;

public class TestEmployee {

	public static void main(String[] args) {
		int option=1;
		Scanner sc = null;
		try {
			sc=new Scanner(System.in);
			EmployeeService service = new EmployeeServiceImpl();
		
	do {
			System.out.println("Welcome to employee mangement ");
			System.out.println("1 Find all records");
			System.out.println("2 Insert Records");
			System.out.println("3 Find employee by ID");
			System.out.println("4 Delete employee by ID");
			System.out.println("5 Update employee by ID");
			System.out.println("6 Sort employees");
			System.out.println("-1 to Exit");
			System.out.println("Enter choice");
			
			option= sc.nextInt();
			
			switch(option) {
			case 1:
				List<Employee> employees = service.findAll();
			    System.out.println(employees);
			    break;
			case 2:
				
				Employee s= new Employee();
				s.setName("shyam");
				s.setId(2);
				s.setSalary(35000);
				
				Employee s1= new Employee();
				s1.setName("Jay");
				s1.setId(5);
				s1.setSalary(38000);
				
				Employee s2= new Employee();
				s2.setName("Ram");
				s2.setId(3);
				s2.setSalary(48000);
				
//				System.out.println("Enter employee id:");
//				int id = sc.nextInt();
//				System.out.println("Enter employee name:");
////				Scanner sc = new Scanner(System.in);
//				String name = sc.next();
//				System.out.println("Enter employee salary:");
//				double salary = sc.nextDouble();
				service.save(s);
				service.save(s1);
				service.save(s2);
				System.out.println("Data saved successfully");
				break;
			case 3:
				System.out.println("Enter the Employee ID");
				int empid=sc.nextInt();
				Optional<Employee> foundemployee;
				
				try {
					
					foundemployee = service.findByEmpId(empid);
					System.out.println("Found Employee "+foundemployee.get());
				} catch (EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("Employee Not Found");
				}
				
				break;
			case 4:
				System.out.println("Enter the Employee ID");
				try {
					empid=sc.nextInt();
					service.deleteByEmpId(empid);
				}
				catch(InputMismatchException e) {
					System.out.println("Emp Id must be an Integer value");
					sc.nextLine(); 
				}
			
				break;
			
			case 5:
				double modifiedSalary;
				System.out.println("Enter the Employee ID");
				empid=sc.nextInt();
				System.out.println("Enter new salary");
				modifiedSalary=sc.nextDouble();
				service.updateByEmpId(empid,modifiedSalary);
				break;
				
			case 6:
				System.out.println(service.findAllEmployeesSortedBySalary());
				break;
		
			case -1:
				System.out.println("------End Of Process------");
				break;
				
			}
			
		}while(option!=-1);
		}
		finally {
			sc.close();
		}
		

	}

}