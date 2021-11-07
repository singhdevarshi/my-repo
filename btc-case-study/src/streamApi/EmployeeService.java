package streamApi;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeService {
	public void sumofSalary(List<Employee> eList) {
		double totalSal = eList.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("Total Salary of all Employees = "+ totalSal);
	}
	
	public void countEmployeeEachDept(List<Employee> eList)
	{
		Map<String, Long> employeeCountByDepartment=
				eList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
				         
				Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
				         
				for (Entry<String, Long> entry : entrySet)
				{
				    System.out.println(entry.getKey()+" : "+entry.getValue());
				}
	}
	
	public void seniorMostEmployee(List<Employee> eList)
	{
		Optional<Employee> seniorMostEmp=
				eList.stream().sorted(Comparator.comparing(Employee::getHireDate)).findFirst();
				         
				Employee employeeDetail = seniorMostEmp.get();
				System.out.println("Senior Most Employee is = ");
				System.out.println(employeeDetail.getFirstName()+" "+ employeeDetail.getLastName());

	}

	public void  durationOfServiceInMonthDays(List<Employee> eList)
	{
		
		
	}
	
	public void highestCountOfEmp(List<Employee> eList)
	{
		Map<String, Long> employeeCountByDepartment=
				eList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
				         
				Set<Entry<String, Long>> entrySet = employeeCountByDepartment.entrySet();
				  Long max =0L;       
				for (Entry<String, Long> entry : entrySet)
				{ if(entry.getValue() > max)
				{
					max=entry.getValue();
				}
				}
				for(Entry<String, Long> entry : entrySet)
				{
					if(entry.getValue()==max)
					{
						System.out.println(entry.getKey()+" : "+entry.getValue());
					}
				}
		         
	}
	
	public void empWithoutDept(List<Employee> list)
	{
		System.out.println("Employee without Department");
		list.stream().filter(e1->e1.getDepartment()==null).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	public void employeeWithSalary(List<Employee> eList)
	{
		System.out.println();
		for(Employee e:eList)
		{
			System.out.print(e.getFirstName()+" "+e.getLastName()+" Salary = "+e.getSalary()+" Salary with 15% more "+e.getSalary()*1.15);
			System.out.println();
					
		}
	}
		
		public void empWithoutManager(List<Employee> eList)
		{
			List<Employee> empList=eList.stream().filter(e->e.getManagerId()==0).collect(Collectors.toList());
			for(Employee el:empList)
			{
				System.out.println("Employee without Manager = "+el.getFirstName()+" "+el.getLastName());
			}
				
		}
	
		public void sortEmpId(List<Employee> list)
		{
			System.out.println("Employee sorted by Employee Id");
			list.stream().sorted(Comparator.comparing(Employee::getEmployeeId)).collect(Collectors.toList()).forEach(System.out::println);
			}

			public void sortDept(List<Department> list)
			{
				System.out.println("Department sorted by Department Id");
				list.stream().sorted(Comparator.comparing(Department::getDepartmentId)).collect(Collectors.toList()).forEach(System.out::println);
			}

			public void sortByFirstName(List<Employee> list)
			{
				System.out.println("Employee sorted by Employee Name");
				 list.stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList()).forEach(System.out::println);
			}
}
