import java.io.File;
import java.util.*;
import java.io.IOException;

class MainClass {

    public static int readingTime(int words) {
        int averageWPM = 200;

        double readingTimeInMin = (double) words / averageWPM;

        double readingTimeInSec = readingTimeInMin * 60;

        return (int) readingTimeInSec;
    }

    public static int speakingTime(int words) {
        int averageWPM = 150;

        double speakingTimeInMin = (double) words / averageWPM;

        double speakingTimeInSec = speakingTimeInMin * 60;

        return (int) speakingTimeInSec;
    }

    public static int characterCoutnter() {
        File myFile = new File("why.txt");
        int count = 0;
        try {
            Scanner in = new Scanner(myFile);
            while (in.hasNext()) {
                String word = in.next();
                count = count + word.length();
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Unable to read the file");

        }
        return count;
    }

    public static int wordCounter() {
        File myFile = new File("why.txt");
        int count = 0;
        try {
            Scanner in = new Scanner(myFile);
            while (in.hasNext()) {
                in.next();
                count++;
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Unable to read the file");

        }
        return count;
    }

    public static void main(String[] args) {
        // File myFile = new File("why.txt");
        // try {
        // Scanner in = new Scanner(myFile);
        // while (in.hasNextLine()) {
        // System.out.println(in.nextLine());
        // }
        // in.close();
        // } catch (IOException e) {
        // System.out.println("Unable to read the file");

        // }
        // System.out.println("Hello World");
        int characterInTheFile = characterCoutnter();
        int wordsInTheFile = wordCounter();
        int readingTime = readingTime(wordsInTheFile);
        int speakingTime = speakingTime(wordsInTheFile);
        System.out.println("Character : " + characterInTheFile);
        System.out.println("Words : " + wordsInTheFile);
        System.out.println("Reading Time : " + readingTime + "sec");
        System.out.println("Speaking Time : " + speakingTime + "sec");
    }
}