import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Prindi välja faili iga teine täht
public class Lesson3Task3 {
    public static void main(String[] args) throws FileNotFoundException {
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }
}
