import java.util.*;

class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();


    void addStudent(Student s) throws StudentException {

        for (Student st : students) {
            if (st.eno == s.eno) {
                throw new StudentException(" Enrollment number must be unique");
            }
        }

        if (s.percentage <= 0) {
            throw new StudentException(" Percentage must be positive");
        }

        if (s.branch.isEmpty() || s.sem <= 0) {
            throw new StudentException(" Semester and Branch cannot be empty");
        }

        students.add(s);
        System.out.println(" Student added successfully");
    }


    void displayAll() {
        if (students.isEmpty()) {
            System.out.println(" No students available");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }


    Student searchByEno(int eno) {
        for (Student s : students) {
            if (s.eno == eno) {
                return s;
            }
        }
        return null;
    }


    void updateBranch(int eno, String newBranch) throws StudentException {
        Student s = searchByEno(eno);

        if (s == null) {
            throw new StudentException(" Student not found");
        }

        if (newBranch.isEmpty()) {
            throw new StudentException(" Branch cannot be empty");
        }

        s.branch = newBranch;
        System.out.println(" Branch updated successfully");
    }


    void deleteByEno(int eno) throws StudentException {
        Student s = searchByEno(eno);

        if (s == null) {
            throw new StudentException(" Student not found");
        }

        students.remove(s);
        System.out.println(" Student deleted successfully");
    }


    void sortStudents() {
        students.sort((a, b) -> a.eno - b.eno);
        System.out.println(" Students sorted by Enrollment Number");
    }
}