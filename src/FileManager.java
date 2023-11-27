import java.io.*;

public class FileManager {
final String path="/Users/mindera/IdeaProjects/SoloGame/src/Users.txt";

    protected void saveUser(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(user.getName() + "||");
            writer.write(user.getPassword());
            writer.newLine();
            writer.close();
            System.out.println(Colors.GREEN+"User \""+user.getName()+"\" created, saved to the file successfully."+Colors.RESET);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }

    protected boolean findUser(String username, String password) {
        String[] lineSplited;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineSplited = line.split("\\|\\|");
                if (lineSplited[0].equals(username) && lineSplited[1].equals(password)) {
                    System.out.println("User found!!!");
                    reader.close();
                    return true;
                }
            }
            System.out.println(Colors.RED+"User not found."+Colors.RESET);

        } catch (IOException e) {
            System.err.println("Error reading from the file: " + e.getMessage());
        }
        return false;
    }

    protected void saveRider(Rider rider){
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path,true))) {
                oos.writeObject(rider);
                System.out.println("Object saved to the file successfully.");
            } catch (Exception e) {
                System.err.println("Error saving the object to the file: " + e.getMessage());
        }
    }
}
