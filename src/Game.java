import java.util.Scanner;

public class Game {


    protected void start(User user) {
        menu(user);
    }

    private void menu(User user) {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n\n" + (user.getRider().getTrains() % 3 == 0 && user.getRider().getTrains() != 0 ? "1- Go to Tournament! 🏆" : "1- Go train! 💪"));
            System.out.print("2- Go to Hospital!\n" +
                    "3- Go to Motorcycle Store!\n" +
                    "0-" + Colors.RED + " Logout " + Colors.RESET + user.getName() + Colors.RED + "!" + Colors.RESET + "\n\nOption:");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    if (user.getRider().getTrains() % 3 == 0) {
                        goToTournament(user);
                    } else {
                        goTrain(user);
                    }
                    user.getRider().setTrains(user.getRider().getTrains()+1);
                    break;
                case 2:
                    goToHospital(user);
                    break;
                case 3:
                    goToStore(user);
                    break;
                case 0:
                    System.out.println(user.getName() + Colors.RED + " logging out!" + Colors.RESET);
                    new App().start();
                    break;
                default:
                    System.out.println("ahm?");
            }
        } while (option != 0);
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
