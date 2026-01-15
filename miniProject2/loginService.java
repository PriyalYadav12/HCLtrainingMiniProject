import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginService {

    private Map<String, String> users = new HashMap<>();

    public LoginService() {
        // Default login
        users.put("admin", "admin123");
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Employee Management System Login ===");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        return users.containsKey(username) && users.get(username).equals(password);
    }
}
