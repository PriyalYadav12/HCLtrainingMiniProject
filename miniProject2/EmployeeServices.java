// EmployeeService.java
import java.util.*;

public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee emp) throws CustomException {
        if (idExists(emp.getId())) throw new CustomException("Employee ID must be unique!");
        if (emp.getSalary() <= 0) throw new CustomException("Salary must be positive!");
        if (emp.getDepartment().isEmpty()) throw new CustomException("Department cannot be empty!");
        employees.add(emp);
        FileUtil.saveEmployees(employees);
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    public Employee searchEmployeeById(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public void updateSalary(int id, double newSalary) throws CustomException {
        Employee emp = searchEmployeeById(id);
        if (emp == null) throw new CustomException("Employee not found.");
        if (newSalary <= 0) throw new CustomException("Salary must be positive!");
        emp.setSalary(newSalary);
        FileUtil.saveEmployees(employees);
    }

    public void deleteEmployee(int id) throws CustomException {
        Employee emp = searchEmployeeById(id);
        if (emp == null) throw new CustomException("Employee not found.");
        employees.remove(emp);
        FileUtil.saveEmployees(employees);
    }

    public void displaySortedEmployees() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }

    public void displayDepartments() {
        Set<String> departments = new HashSet<>();
        for (Employee e : employees) {
            departments.add(e.getDepartment());
        }
        System.out.println("Departments: " + departments);
    }

    private boolean idExists(int id) {
        return employees.stream().anyMatch(e -> e.getId() == id);
    }
}
