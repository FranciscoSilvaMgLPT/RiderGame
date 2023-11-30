package FrontEnds;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Jbl {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("1- Play/Stop background music   0- Back");
        option = sc.nextInt();
        switch (option) {
            case 1:
                try {
                    backgroundMusic();
                } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    System.out.println("Error: " + e);
                }
                break;
            default:
                System.out.println("Ahm?");
                break;
            case 0:

        }

    }

    public void backgroundMusic() throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/IdeaProjects/SoloGame/src/FrontEnds/Mp3Files/RuGonnaMove.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioInputStream);
            clip.loop(10);
            clip.start();
    }

    public void startRaceSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/IdeaProjects/SoloGame/src/FrontEnds/Mp3Files/Tires-screeching-_480p_.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void accidentSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/IdeaProjects/SoloGame/src/FrontEnds/Mp3Files/accident.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void fatalitySound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/fatality.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }

    public void cheatSound() throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        Clip clip = AudioSystem.getClip();
        File file = new File("/Users/mindera/Documents/School/NavalBattle/src/Sound/aii.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip.open(audioInputStream);
        clip.start();
    }


}
