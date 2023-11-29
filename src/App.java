import java.io.File;
import java.util.Scanner;

public class App {


    protected void start() {
        intro();
        menu();
    }

    private void intro() {
        System.out.println("blabla");
    }

    protected void menu() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.print("\n\n1- LOGIN\n2- SIGN UP\n0-EXIT\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    signUp();
                    break;
                case 0:
                    System.out.println("Adios coraçon! 🥲");
                    break;
                default:
                    System.out.println("Ahm?");
                    menu();
            }
        } while (option != 0);
    }

    private void signUp() {
        Scanner sc = new Scanner(System.in);
        String text;
        System.out.print("Insert Acc login name.\nName:");
        text = sc.next();
        System.out.print("Insert password.\nPassword:");
        new FileManager().saveUserLog(new User(text, sc.next()));
    }

    private void login() {
        String name;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.print("LOGIN\n\nLogin name:");
        name = sc.next();
        System.out.print("Password:");
        password = sc.next();
        if (new FileManager().findUser(name, password)) {
            String filePath = "/Users/mindera/IdeaProjects/SoloGame/src/Users/".concat(name.concat(".txt"));
            File file = new File(filePath);
            if(file.exists()){
                System.out.println("asd");
                new Game().start(new FileManager().loadUser(new User(name,password)));
            }
            new Game().start(new User(name, password));
        } else {
            menu();
        }
    }


}
