import Body.*;
import Items.Clothes.Equipment;
import Items.Motorcycle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class Human {
    private final String name;
    private ArrayList<Equipment> equipment;
    private ArrayList<BodyPart> body;
    private Motorcycle motorcycle;
    private int cash;
    private boolean alive = true;
    private Head head;
    private Feets feet;
    private Torso torso;
    private Legs legs;

    public Human(String name, int cash) {
        this.equipment = new ArrayList<>();
        this.body = new ArrayList<>();
        this.motorcycle = null;
        this.head = new Head();
        this.torso = new Torso(800);
        this.legs = new Legs(400);
        this.feet = new Feets(200);
        this.body.addAll(Arrays.asList(this.head, this.torso, this.legs, this.feet));
        this.name = name;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setEquipment(ArrayList<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public void setMotorcycle(Motorcycle motorcycle) {
        Scanner sc = new Scanner(System.in);
        int option;
        if (this.motorcycle != null) {
            System.out.print("Are you sure? Your motorcycle [" + this.motorcycle.getName() +
                    "] will get rewritten by the new one!  \n" +
                    "1-Yes!!💪  2-No..!😭\n\n"+Colors.YELLOW+"Option:"+Colors.RESET);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    this.motorcycle = motorcycle;
                    break;
                case 2:
                    break;
                default:
                    System.out.println("??");
                    setMotorcycle(motorcycle);
            }
        } else {
            this.motorcycle = motorcycle;
        }
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        if(alive){
            this.head.setHealthy(true);
            this.torso.setHealthy(true);
            this.legs.setHealthy(true);
            this.feet.setHealthy(true);
        }
        this.alive = alive;
    }
    public ArrayList<BodyPart> getBody() {
        return body;
    }

    public Head getHead() {
        return head;
    }

    public Feets getFeet() {
        return feet;
    }

    public Torso getTorso() {
        return torso;
    }

    public Legs getLegs() {
        return legs;
    }
}
