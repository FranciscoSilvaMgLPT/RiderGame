import FrontEnds.Jbl;

import java.util.Random;
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
                    new Jbl().menu();
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
                    user.getRider().setTrains(0);
                    break;
                default:
                    createRider(user);
            }
        }
    }

    private int goToTournament(User user) {
        int prize;
        Random random = new Random();
        Thread thread = new Thread();
        int crash = 70;
        int[] placed = {95, 80, 60};
        int randomNumberCrash = random.nextInt(100) + 1;
        int randomNumberWin = random.nextInt(100) + 1;
        try {
            System.out.println("Ready!");
            thread.wait(500);
            System.out.print("Set");
            thread.wait(500);
            System.out.print(".");
            thread.wait(500);
            System.out.print(".");
            thread.wait(500);
            System.out.print(".");
            thread.wait(500);
            System.out.print("GOOOO!!!");
            thread.wait(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (randomNumberCrash >= crash) {
            System.out.println("Damn..!!! You just crashed!");
        }

        if (randomNumberWin >= placed[0]) {
            prize = 1500;
            System.out.println("Congratz! You got first place!!!!! 🥇🏆\n You won the prize of " +
                    prize + "€! Enjoy and use it wisely!");
        } else if (randomNumberWin >= placed[1]) {
            prize = 700;
            System.out.println("Congratz! You got second place!!!!! 🥈🏆\n You won the prize of " +
                    prize + "€! Enjoy and use it wisely!");
        } else if (randomNumberWin >= placed[2]) {
            prize = 500;
            System.out.println("Congratz! You got third place!!!!! 🥉🏆\n You won the prize of " +
                    prize + "€! Enjoy and use it wisely!");
        } else {
            prize = 200;
            System.out.println("Congratz! You didnt got placed but you finished the race!! \n You won the prize of " +
                    prize + "€! Enjoy and use it wisely!");
        }
        return 0;
    }

    private void goTrain(User user) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;

    }

    private void goToHospital(User user) {

    }

    private void goToStore(User user) {

    }

    private void crash(User user) {
    int crash = 70;

}
}
