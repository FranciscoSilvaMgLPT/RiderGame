import Buildings.Hospital;
import Buildings.MotorcycleStore;
import FrontEnds.Jbl;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Hospital hospital = new Hospital();
    MotorcycleStore motorcycleStore = new MotorcycleStore();

    protected void start(User user) {
        menu(user);
    }

    private void menu(User user) {

        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.print("\n\n\nHello " + user.getName() + "! Good to see you! Choose an option!\n" +
                    "1- Play 🕹️   2-Music 🎧  0-Logout ⛔️\n\nOption:");
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
            System.out.println(user.getRider().getCash());
            System.out.println("\n\n" + (user.getRider().getTrains() % 3 == 0 && user.getRider().getTrains() != 0 ? "1-" + Colors.YELLOW + " Go to Tournament! 🏆" + Colors.RESET : "1- Go train! 💪"));
            System.out.print("2- Go to Hospital! 🏥\n" +
                    "3- Go to Motorcycle Store!  🏍️⚙️🧥\n" +
                    "4- Save game! 💾\n"+
                    "0- Back to menu  🔙\n\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    int broke = 0;
                    for (int i = 0; i < user.getRider().getBody().size(); i++) {
                        if (!user.getRider().getBody().get(i).isHealthy()) {
                            broke++;
                        }
                    }
                    if (broke == 0) {
                        if (user.getRider().getTrains() % 3 == 0 && user.getRider().getTrains() != 0) {
                            goToTournament(user);
                        } else {
                            goTrain(user);
                        }
                        user.getRider().setTrains(user.getRider().getTrains() + 1);
                    } else {
                        System.out.println("You cant ride with a broken parts!");
                    }
                    break;
                case 2:
                    goToHospital(user);
                    break;
                case 3:
                    goToStore(user);
                    break;
                case 4:
                    new FileManager().saveUser(user);
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
        int[] placed = {95, 80, 60};
        for (int i = 0; i < placed.length; i++) {
            placed[i] = placed[i] - user.getRider().getMotorcycle().getPower();
        }
        int randomNumberWin = random.nextInt(100) + 1;
        try {
            System.out.println("Ready!");
            Thread.sleep(500);
            System.out.print("Set");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("GOOOO!!!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (crash(user)) {
            System.out.println("FOR NOW YOU ARE GOD!");                 //FIIIIXXXXXXXXX!!!!!!!!!!!!!!!
        } else {

            if (randomNumberWin >= placed[0]) {
                prize = 1500;
                System.out.println("Congratz! You got first place!!!!! 🥇🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            } else if (randomNumberWin >= placed[1]) {
                prize = 700;
                System.out.println("Congratz! You got second place!!!!! 🥈🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            } else if (randomNumberWin >= placed[2]) {
                prize = 500;
                System.out.println("Congratz! You got third place!!!!! 🥉🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            } else {
                prize = 200;
                System.out.println("Congratz! You didnt got placed but you finished the race!! \n You won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            }
        }
        return 0;
    }

    private int goTrain(User user) {
        int prize;
        Random random = new Random();
        Thread thread = new Thread();
        int[] placed = {90, 70, 50};
        for (int i = 0; i < placed.length; i++) {
            placed[i] = placed[i] - user.getRider().getMotorcycle().getPower();
        }
        int randomNumberWin = random.nextInt(100) + 1;
        try {
            System.out.println("Ready!");
            Thread.sleep(500);
            System.out.print("Set");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.print(".");
            Thread.sleep(500);
            System.out.println(".");
            Thread.sleep(500);
            System.out.println("GOOOO!!!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (crash(user)) {
            System.out.println("FOR NOW YOU ARE GOD!");                 //FIIIIXXXXXXXXX!!!!!!!!!!!!!!!
        } else {

            if (randomNumberWin >= placed[0]) {
                prize = 300;
                System.out.println("Congratz! You got first place!!!!! 🥇🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            } else if (randomNumberWin >= placed[1]) {
                prize = 200;
                System.out.println("Congratz! You got second place!!!!! 🥈🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            } else if (randomNumberWin >= placed[2]) {
                prize = 100;
                System.out.println("Congratz! You got third place!!!!! 🥉🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            } else {
                prize = 50;
                System.out.println("Congratz! You didnt got placed but you finished the race!! \n You won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
                return 0;
            }
        }
        return 0;
    }

    private void goToHospital(User user) {
        Scanner sc = new Scanner(System.in);
        int option;
        int broken = 0;
        System.out.println("Hi " + user.getName() + ", welcome to the hospital!");
        for (int i = 0; i < user.getRider().getBody().size(); i++) {
            if (!user.getRider().getBody().get(i).isHealthy()) {
                broken++;
            }
        }
        if (broken != 0) {
            for (int i = 0; i < user.getRider().getBody().size(); i++) {
                if (!user.getRider().getBody().get(i).isHealthy()) {
                    System.out.println("[" + (i + 1) + "] You have a broken " + user.getRider().getBody().get(i).getName() + "! It costs "
                            + user.getRider().getBody().get(i).getRepairCost() + "€ to cure!");
                }
            }
            System.out.print("Insert ID of what to cure!    0- Back\nID:");
            option = sc.nextInt() - 1;
            if (user.getRider().getCash() < user.getRider().getBody().get(option).getRepairCost()) {
                System.out.println("Ahm!? You cant pay " + user.getRider().getBody().get(option).getRepairCost() + "€ " +
                        "with your " + user.getRider().getCash() + "€!!! Go get some money!");
            } else {
                hospital.cure(user.getRider().getBody().get(option));
                System.out.println("\nThe operation went perfect!! You have your " + user.getRider().getBody().get(option).getName() + " cured! Enjoy!");
            }
        } else {
            System.out.println("You have all healthy!!! You dont need us! 🥳");
        }
    }

    private void goToStore(User user) {

    }

    private boolean crash(User user) {
        int crash = 75;
        crash = crash + user.getRider().getMotorcycle().getSafety();
        Random random = new Random();
        int randomNumberCrash = random.nextInt(100) + 1;
        if (randomNumberCrash >= crash) {
            System.out.println("Damn... seems like you crashed 😭");
            return true;
        }
        return false;
    }

    private boolean damageBody(){

    }
}
