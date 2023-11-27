import FrontEnds.Jbl;

import java.util.Scanner;

public class Game {


    protected void start(User user) {
        menu(user);
    }

    private void menu(User user) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.print("\n\n\nHello " + user.getName() + "! Good to see you! Choose an option!\n" +
                    "1- Play   2-Music   0-Logout\n\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    play(user);
                    break;
                case 2:
                    Jbl.menu();
                case 0:
                    System.out.println(user.getName() + Colors.RED + " logging out!" + Colors.RESET);
                    new App().start();
                    break;
            }
        } while (option != 0);
    }

    private void play(User user) {
        Scanner sc = new Scanner(System.in);
        int option;
        while (user.getRider() == null || !user.getRider().isAlive()) {
            createRider(user);
        }
        do {
            System.out.println("\n\n" + (user.getRider().getTrains() % 3 == 0 && user.getRider().getTrains() != 0 ? "1- Go to Tournament! 🏆" : "1- Go train! 💪"));
            System.out.print("2- Go to Hospital!\n" +
                    "3- Go to Motorcycle Store!\n" +
                    "0- Back to menu\n\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    if (user.getRider().getTrains() % 3 == 0) {
                        goToTournament(user);
                    } else {
                        goTrain(user);
                    }
                    user.getRider().setTrains(user.getRider().getTrains() + 1);
                    break;
                case 2:
                    goToHospital(user);
                    break;
                case 3:
                    goToStore(user);
                    break;
                case 0:
                    System.out.println(user.getName() + Colors.RED + " logging out!" + Colors.RESET);
                    new App().menu();
                    break;
                default:
                    System.out.println("ahm?");
            }
        } while (option != 0 || !user.getRider().isAlive());

    }

    private void createRider(User user) {
        Scanner sc = new Scanner(System.in);
        String name;
        int option;
        if (user.getRider() == null) {
            System.out.print("Insert rider name!\nName:");
            name = sc.nextLine();
            user.setRider(new Rider(name, 1000));
        } else {
            System.out.print("1- Create new rider!\n2-Revive rider " + user.getRider().getName() + "\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    user.setRider(null);
                    createRider(user);
                    break;
                case 2:
                    user.getRider().setAlive(true);
                    break;
                default:
                    createRider(user);
            }
        }
    }

    private void goToTournament(User user) {

    }

    private void goTrain(User user) {

    }

    private void goToHospital(User user) {

    }

    private void goToStore(User user) {

    }


}
