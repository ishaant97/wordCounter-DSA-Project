import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        File myFile = new File("why.txt");
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

        System.out.println(s);
    }
}
