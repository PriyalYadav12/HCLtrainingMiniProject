public class Student {

    int eno;
    String name;
    String branch;
    int sem;
    double percentage;

    Student(int eno, String name, String branch, int sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    void display() {
        System.out.println(
            eno + " | " + name + " | " + branch +
            " | Sem: " + sem + " | %: " + percentage
        );
    }
}