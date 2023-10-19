import java.io.File;
import java.util.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainClass {

    static StringBuilder filePath = new StringBuilder();

    public static char mostRepeatingCharacter() {
        String filePathInString = filePath.toString();
        File myFile = new File(filePathInString);
        StringBuilder s = new StringBuilder();
        try {
            Scanner in = new Scanner(myFile);
            while (in.hasNext()) {
                String word = in.next();
                s = s.append(word);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Unable to read the file");

        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        char mostFrequentChar = '\0'; // Initialize to null character
        int maxFrequency = 0;

        for (Character character : map.keySet()) {
            int frequency = map.get(character);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequentChar = character;
            }
        }

        return mostFrequentChar;
    }

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
        String filePathInString = filePath.toString();
        File myFile = new File(filePathInString);
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
        String filePathInString = filePath.toString();
        File myFile = new File(filePathInString);
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
        // StringBuilder filePath = new StringBuilder();
        JFrame f = new JFrame("Simple Word Counter");
        f.setVisible(true);
        f.setSize(400, 400);
        f.setLayout(new FlowLayout());
        JLabel l1 = new JLabel("File Path : ");
        f.add(l1);
        JTextField t1 = new JTextField(20);
        f.add(t1);
        JButton b1 = new JButton("Choose File");
        f.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // StringBuilder filePath = new StringBuilder();
                // Create a JFileChooser object
                JFileChooser chooser = new JFileChooser();

                // Show the browse files dialog
                int result = chooser.showOpenDialog(f);

                // If the user selects a file, get the file path and set it in the text field
                if (result == JFileChooser.APPROVE_OPTION) {
                    t1.setText(chooser.getSelectedFile().getAbsolutePath());
                    filePath = filePath.append(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        JButton b2 = new JButton("Analyse File");
        f.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the analyseText() function
                int characterInTheFile = characterCoutnter();
                int wordsInTheFile = wordCounter();
                int readingTime = readingTime(wordsInTheFile);
                int speakingTime = speakingTime(wordsInTheFile);
                char mostFrequentChar = mostRepeatingCharacter();
                JLabel l2 = new JLabel("Character : " + characterInTheFile);
                f.add(l2);
                JLabel l3 = new JLabel("Words : " + wordsInTheFile);
                f.add(l3);
                JLabel l4 = new JLabel("Reading Time : " + readingTime + "sec");
                f.add(l4);
                JLabel l5 = new JLabel("Speaking Time : " + speakingTime + "sec");
                f.add(l5);
                JLabel l6 = new JLabel("Most Reapeating Character : " + mostFrequentChar);
                f.add(l6);
            }
        });
    }
}