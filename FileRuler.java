import java.io.*;

public class FileRuler {
    static void FileWrite(File file, String login, String password) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter((file), true))) {
            br.write("#" + login + "\n");
            br.write(Enigma.getHash(password) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void NewFile(File file) {
        try {
            boolean created = file.createNewFile();
            if (created)
                System.out.println("File created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static boolean RegistrationLoginCheck(File file, String login) {
        if (!(login.isEmpty()) && (login.matches("[a-zA-Z[1-9]]+")) && RegistrationLoginComparator(file, login)) {
            return true;
        }
        return false;
    }

    private static boolean RegistrationLoginComparator(File file, String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains("#")) {
                    if (login.equals(line.substring(1))) {
                        return false;
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    private static boolean LogInPasswordCheck(String password) {
        if (!(password.isEmpty()) && (password.matches("[a-zA-Z[1-9]]+"))) {
            return true;
        }
        return false;
    }

    static boolean LogIn(File file, String login, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains("#")) {
                    if (login.equals(line.substring(1))) {
                        if (LogInPasswordCheck(password)) {
                            line = reader.readLine();
                            if (Enigma.getHash(password).equals(line)) {
                                return true;
                            }
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
