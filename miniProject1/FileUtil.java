package assignments.mini_projects.Day3;

import java.io.*;

public class FileUtil {

    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccount(BankAccount account) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(account);
        } catch (Exception e) {
            System.out.println("Error saving file");
        }
    }

    public static BankAccount loadAccount() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (BankAccount) ois.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
