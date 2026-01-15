import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = FileUtil.loadEmployees();
        EmployeeService empService = new EmployeeService(employees);
        LoginService loginService = new LoginService();
        Scanner sc = new Scanner(System.in);

        if (loginService.login()) {
            int choice;
            do {
                showMenu();
                choice = sc.nextInt();
                sc.nextLine();

                try {
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Enter Employee ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter Salary: ");
                            double salary = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("Enter Department: ");
                            String dept = sc.nextLine();

                            empService.addEmployee(new Employee(id, name, salary, dept));
                            System.out.println("Employee added successfully!");
                        }
                        case 2 -> empService.displayAllEmployees();
                        case 3 -> {
                            System.out.print("Enter Employee ID to search: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            Employee emp = empService.searchEmployeeById(id);
                            System.out.println(emp != null ? emp : "Employee not found.");
                        }
                        case 4 -> {
                            System.out.print("Enter Employee ID to update salary: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter new salary: ");
                            double salary = sc.nextDouble();
                            sc.nextLine();
                            empService.updateSalary(id, salary);
                            System.out.println("Salary updated successfully!");
                        }
                        case 5 -> {
                            System.out.print("Enter Employee ID to delete: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            empService.deleteEmployee(id);
                            System.out.println("Employee deleted successfully!");
                        }
                        case 6 -> empService.displaySortedEmployees();
                        case 7 -> empService.displayDepartments();
                        case 8 -> System.out.println("Exiting system...");
                        default -> System.out.println("Invalid choice!");
                    }
                } catch (CustomException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } while (choice != 8);
        } else {
            System.out.println("Login failed. Exiting...");
        }
    }

    private static void showMenu() {
        System.out.println("\n=== Employee Management System Menu ===");
        System.out.println("1. Add Employee");
        System.out.println("2. Display All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Update Employee Salary");
        System.out.println("5. Delete Employee");
        System.out.println("6. Display Sorted Employees");
        System.out.println("7. Display Departments");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }
}
