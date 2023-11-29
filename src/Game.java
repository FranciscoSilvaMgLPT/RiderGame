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
        boolean broke;
        while (user.getRider() == null || !user.getRider().isAlive()) {
            createRider(user);
        }
        do {
            System.out.println(user.getRider().getCash());
            System.out.println("\n\n" + (user.getRider().getTrains() % 3 == 0 && user.getRider().getTrains() != 0 ? "1-" + Colors.YELLOW + " Go to Tournament! 🏆" + Colors.RESET : "1- Go train! 💪"));
            System.out.print("2- Go to Hospital! 🏥\n" +
                    "3- Go to Motorcycle Store!  🏍️⚙️🧥\n" +
                    "4- Save game! 💾\n" +
                    "0- Back to menu  🔙\n\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    broke = false;
                    for (int i = 0; i < user.getRider().getBody().size(); i++) {
                        if (!user.getRider().getBody().get(i).isHealthy()) {
                            broke=true;
                        }
                    }
                    if(user.getRider().getMotorcycle().getEngine().isDestroyed() || user.getRider().getMotorcycle().getTires().isDestroyed()){
                        broke=true;
                    }
                    if (!broke) {
                        if (user.getRider().getTrains() % 3 == 0 && user.getRider().getTrains() != 0) {
                            goToTournament(user);
                        } else {
                            goTrain(user);
                        }
                        user.getRider().setTrains(user.getRider().getTrains() + 1);
                    } else {
                        System.out.println("You cant ride like this!!");
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
        } while (option != 0 && user.getRider().isAlive());
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

    private void goToTournament(User user) {
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

        } else {
            if (randomNumberWin >= placed[0]) {
                prize = 1500;
                System.out.println("Congratz! You got first place!!!!! 🥇🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            } else if (randomNumberWin >= placed[1]) {
                prize = 700;
                System.out.println("Congratz! You got second place!!!!! 🥈🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            } else if (randomNumberWin >= placed[2]) {
                prize = 500;
                System.out.println("Congratz! You got third place!!!!! 🥉🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            } else {
                prize = 200;
                System.out.println("Congratz! You didnt got placed but you finished the race!! \nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            }
        }
    }

    private void goTrain(User user) {
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
            System.out.print("");
        } else {
            if (randomNumberWin >= placed[0]) {
                prize = 300;
                System.out.println("Congratz! You got first place!!!!! 🥇🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            } else if (randomNumberWin >= placed[1]) {
                prize = 200;
                System.out.println("Congratz! You got second place!!!!! 🥈🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            } else if (randomNumberWin >= placed[2]) {
                prize = 100;
                System.out.println("Congratz! You got third place!!!!! 🥉🏆\nYou won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            } else {
                prize = 50;
                System.out.println("Congratz! You didnt got placed but you finished the race!! \n You won the prize of " +
                        prize + "€! Enjoy and use it wisely!");
                user.getRider().setCash(user.getRider().getCash() + prize);
            }
        }
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
        int bike = 40;
        int body = 80;
        crash = crash + user.getRider().getMotorcycle().getSafety();
        Random random = new Random();
        int randomNumberCrash = random.nextInt(100) + 1;
        int randomNumberDamage = random.nextInt(100) + 1;

        if (randomNumberCrash >= crash) {
            try {
                Thread.sleep(500);
                System.out.println("Damn... seems like you crashed 😭");
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (randomNumberDamage >= 40 && randomNumberDamage < 75) {
                damageBody(user);
            }
            if (randomNumberDamage >= 0 && randomNumberDamage < 40) {
                damageBike(user);
            }
            if (randomNumberDamage >= 75 && randomNumberDamage <= 100) {
                System.out.println(Colors.RED + "Damn......" + Colors.RESET);
                damageBody(user);
                damageBike(user);
            }
            return true;
        }
        return false;
    }

    private void damageBody(User user) {
        Random random = new Random();
        int head = 90;
        int torso = 60;
        int legs = 30;

        int randomNumberBody = random.nextInt(100) + 1;
        if (randomNumberBody >= head) {
            if (user.getRider().getHead().getEquipment() == null) {
                System.out.println("Damn.... Unlucky man! Seems like to ride a bike without a helmet is bad... You " +
                        "damaged your head, and there is no recuperation.... You died!");
                user.getRider().setAlive(false);
            }
        } else if (randomNumberBody >= torso) {
            if (user.getRider().getTorso().getEquipment() == null) {
                System.out.println("You got damaged in your torso! Next time buy a jacket!");
                user.getRider().getTorso().setHealthy(false);
            } else {
                System.out.println("You got damaged in your torso! Luckily you had a jacket!\n" +
                        "Time to buy a new one if you want because this one went to trash!");
                user.getRider().getTorso().setEquipment(null);
            }
        } else if (randomNumberBody >= legs) {
            if (user.getRider().getLegs().getEquipment() == null) {
                System.out.println("You got damaged in your legs! Next time buy some protection pants!");
                user.getRider().getLegs().setHealthy(false);
            } else {
                System.out.println("You got damaged in your legs! Luckily you had protection pants!\n" +
                        "Time to buy new ones if you want because this ones went to trash!");
                user.getRider().getLegs().setEquipment(null);
            }
        } else {
            if (user.getRider().getFeet().getEquipment() == null) {
                System.out.println("You got damaged in your feets! Next time buy some protection sneakers!");
                user.getRider().getFeet().setHealthy(false);
            } else {
                System.out.println("You got damaged in your feets! Luckily you had protection sneakers!\n" +
                        "Time to buy new ones if you want because this ones went to trash!");
                user.getRider().getFeet().setEquipment(null);
            }
        }
    }

    private void damageBike(User user) {
        int engine = 40;
        int both = 80;
        Random random = new Random();
        int randomNumberBike = random.nextInt(100) + 1;
        if (randomNumberBike >= both) {
            System.out.println("Hard accident... Your engine and tires got damaged... 😬 ");
            user.getRider().getMotorcycle().getEngine().setDestroyed(true);
            user.getRider().getMotorcycle().getTires().setDestroyed(true);
        } else if (randomNumberBike >= engine) {
            System.out.println("Your engine broke! 😭");
            user.getRider().getMotorcycle().getEngine().setDestroyed(true);
        } else {
            System.out.println("Your tires blew up");
            user.getRider().getMotorcycle().getTires().setDestroyed(true);
        }
    }
}
