import java.util.Scanner;

public class Main {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();


        System.out.print("Username: ");
        String user = sc.next();

        System.out.print("Password: ");
        String pass = sc.next();

        if (!user.equals(USERNAME) || !pass.equals(PASSWORD)) {
            System.out.println(" Invalid login credentials");
            return;
        }

        System.out.println(" Login Successful");


        int choice;
        do {
            System.out.println("""
                \n--- Student Management System ---
                1. Add Student
                2. Display All Students
                3. Search Student by Eno
                4. Update Student Branch
                5. Delete Student by Eno
                6. Display Sorted Students
                7. Exit
                """);

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1 -> {
                        System.out.print("Eno: ");
                        int eno = sc.nextInt();

                        System.out.print("Name: ");
                        String name = sc.next();

                        System.out.print("Branch: ");
                        String branch = sc.next();

                        System.out.print("Semester: ");
                        int sem = sc.nextInt();

                        System.out.print("Percentage: ");
                        double per = sc.nextDouble();

                        manager.addStudent(
                            new Student(eno, name, branch, sem, per)
                        );
                    }

                    case 2 -> manager.displayAll();

                    case 3 -> {
                        System.out.print("Enter Eno: ");
                        int eno = sc.nextInt();

                        Student s = manager.searchByEno(eno);
                        if (s != null) s.display();
                        else System.out.println(" Student not found");
                    }

                    case 4 -> {
                        System.out.print("Enter Eno: ");
                        int eno = sc.nextInt();

                        System.out.print("New Branch: ");
                        String branch = sc.next();

                        manager.updateBranch(eno, branch);
                    }

                    case 5 -> {
                        System.out.print("Enter Eno: ");
                        int eno = sc.nextInt();

                        manager.deleteByEno(eno);
                    }

                    case 6 -> {
                        manager.sortStudents();
                        manager.displayAll();
                    }

                    case 7 -> System.out.println(" Exiting system");

                    default -> System.out.println(" Invalid choice");
                }

            } catch (StudentException e) {
                System.out.println(e.getMessage());
            }

        } while (choice != 7);

        sc.close();
    }
}