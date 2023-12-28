import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Part1 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        int solution=0;

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            ArrayList<String> strs =new ArrayList<String>();

            // Read each line from the file until the end is reached
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<Character> ints= new ArrayList<Character>();
                for (int i=0;i<line.length();i++){
                    if(Character.isDigit(line.charAt(i)))
                    {
                        ints.add(line.charAt(i));
                    }
                }


                solution=solution+ (ints.get(0)-'0')*10+(ints.get(ints.size()-1)-'0');


            }

            System.out.println(solution);

        } catch (IOException e) {
            // Handle exceptions such as file not found or unable to read
            e.printStackTrace();
        }
    }
}