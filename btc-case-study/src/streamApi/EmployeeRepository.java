package streamApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class EmployeeRepository {
	public static void main(String[] args) {
		Employee emp1=new Employee(1001,"Mahesh","Babu", "mahesh@gmail.com", "9789654534", LocalDate.of(1998,03,20), "Manager", 65000, 0, "Account");
		Employee emp2=new Employee(1005, "Rohit","Singh", "rohits@gmail.com", "7689254730", LocalDate.of(1999,01,10), "Salesman", 50000, 1002, "Sales");
		Employee emp3=new Employee(1002, "Arun","Tomar", "arjun@gmail.com", "9389654567", LocalDate.of(2000,11,14), "Analyst", 55000, 1005, "HR");
		Employee emp4=new Employee(1003, "John","kenedy", "johnk@gmail.com", "8399354514", LocalDate.of(2004,9,29), "HR", 35000, 1001, "Sales");
		Department dept1= new Department(10, "Account", 1001);
		Department dept2= new Department(20, "Sales", 1005);
		Department dept3= new Department(30, "HR", 1003);
		
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		
		List<Department> deptList = new ArrayList<Department>();
		
		deptList.add(dept1);
		deptList.add(dept2);
		deptList.add(dept3);
		
		EmployeeService empService = new EmployeeService();
	
		empService.sumofSalary(employeeList);
		empService.countEmployeeEachDept(employeeList);
		empService.seniorMostEmployee(employeeList);
		empService.highestCountOfEmp(employeeList);
		empService.employeeWithSalary(employeeList);
		empService.empWithoutManager(employeeList);
		empService.empWithoutDept(employeeList);
		empService.sortEmpId(employeeList);
		empService.sortByFirstName(employeeList);
		empService.sortDept(deptList);
	}
	
}
