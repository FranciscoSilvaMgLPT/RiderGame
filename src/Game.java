import Buildings.Hospital;
import Buildings.MotorcycleStore;
import FrontEnds.Jbl;
import Items.MotoParts.Engine;
import Items.MotoParts.Tires;
import Items.Motorcycle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Hospital hospital = new Hospital();
    MotorcycleStore motorcycleStore = new MotorcycleStore();
    Jbl jbl = new Jbl();

    protected void start(User user) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        menu(user);
    }

    private void menu(User user) throws UnsupportedAudioFileException, LineUnavailableException, IOException {

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
                    jbl.menu();
                    break;
                case 0:
                    System.out.println(user.getName() + Colors.RED + " logging out!" + Colors.RESET);
                    new App().start();
                    break;
            }
        } while (option != 0);
    }

    private void play(User user) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
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
                    try {
                        jbl.startRaceSound();
                    }catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                        System.out.println("Error: " + e);
                    }
                    for (int i = 0; i < user.getRider().getBody().size(); i++) {
                        if (!user.getRider().getBody().get(i).isHealthy()) {
                            broke = true;
                        }
                    }
                    if (user.getRider().getMotorcycle().getEngine().isDestroyed() || user.getRider().getMotorcycle().getTires().isDestroyed()) {
                        broke = true;
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
            placed[i] = placed[i] - user.getRider().getMotorcycle().getEngine().getLvl();
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
            Thread.sleep(1000);
            System.out.println("GOOOO!!!");
            Thread.sleep(2000);
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
            placed[i] = placed[i] - user.getRider().getMotorcycle().getEngine().getLvl();
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
            Thread.sleep(1000);
            System.out.println("GOOOO!!!");
            Thread.sleep(2000);
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

    private void goToStore(User user) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.print("\n\nHello pretty rider! Welcome to our store! 🏍️\nWhat do you need?\n1- Buy MotoParts  2- Buy clothes  3-Buy Motorcycle  0-Back\nOption:");
        option = sc.nextInt();
        switch (option) {
            case 1:
                for (int i = 0; i < motorcycleStore.getParts().size(); i++) {
                    System.out.println("[" + (i + 1) + "]- " + motorcycleStore.getParts().get(i).getName() + ", " + motorcycleStore.getParts().get(i).getCost() + "€, power:" + motorcycleStore.getParts().get(i).getLvl());
                }
                System.out.print("Insert ID:");
                option = sc.nextInt() - 1;

                break;
            case 2:
                for (int i = 0; i < motorcycleStore.getEquipment().size(); i++) {
                    System.out.println("[" + (i + 1) + "]- " + motorcycleStore.getEquipment().get(i).getName() + ", " + motorcycleStore.getEquipment().get(i).getCost() + "€");
                }
                System.out.print("Insert ID:");
                option = sc.nextInt() - 1;

                break;
            case 3:
                for (int i = 0; i < motorcycleStore.getMotorcycles().size(); i++) {
                    System.out.println("[" + (i + 1) + "]- " + motorcycleStore.getMotorcycles().get(i).getName() + ", " + motorcycleStore.getMotorcycles().get(i).getPrice() + "€");
                }
                System.out.println("0- Back");
                System.out.print("Insert ID:");
                option = sc.nextInt() - 1;
                user.getRider().setMotorcycle(motorcycleStore.getMotorcycles().get(option));
                switch (option) {
                    case -1:
                        goToStore(user);
                        break;
                }
                break;
            case 0:
                play(user);
                break;
            case 666:
                motorcycleStore.getMotorcycles().add(new Motorcycle("YAMAHA DO CHICO", 0, new Engine(0, 0, 500), new Tires(0, 0, 500)));
              jbl.cheatSound();
                System.out.println("CREATED! 👀");
                break;
            default:
                System.out.println("Whaaaa?!?!");
                goToStore(user);
        }
    }

    private boolean crash(User user) {
        int crash = 75;
        int bike = 40;
        int body = 80;
        crash = crash + user.getRider().getMotorcycle().getTires().getLvl();
        Random random = new Random();
        int randomNumberCrash = random.nextInt(100) + 1;
        int randomNumberDamage = random.nextInt(100) + 1;

        if (randomNumberCrash >= crash) {
            try{
                jbl.accidentSound();
            }catch (IOException | LineUnavailableException | UnsupportedAudioFileException e){
                System.out.println("Error: "+e);
            }
            try {
                Thread.sleep(500);
                System.out.println("Damn... seems like you crashed 😭");
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (randomNumberDamage >= 40 && randomNumberDamage < 80) {
                damageBody(user);
            }
            if (randomNumberDamage >= 0 && randomNumberDamage < 40) {
                damageBike(user);
            }
            if (randomNumberDamage >= 80 && randomNumberDamage <= 100) {
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
