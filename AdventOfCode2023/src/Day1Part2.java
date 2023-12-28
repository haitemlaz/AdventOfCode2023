import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1Part2 {
    public static void main(String[] args) {
        String filePath = "input.txt";
        int solution=0;
        List <String> digits = Arrays.asList("one","two","three","four","five","six","seven","eight","nine");

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;

            ArrayList<String> strs =new ArrayList<String>();

            // Read each line from the file until the end is reached
            while ((line = bufferedReader.readLine()) != null) {

                ArrayList<Integer> ints= new ArrayList<Integer>();
                ArrayList<String> DigitsInLine= new ArrayList<String>();
                String s="";


                for (int i=0;i<line.length();i++){
                    if(Character.isDigit(line.charAt(i)))
                    {
                        ints.add(line.charAt(i)-'0');
                    }
                    else {
                        s +=String.valueOf(line.charAt(i));
                        for (int j = 0; j < digits.size(); j++) {
                            if (s.contains(digits.get(j))){
                                ints.add(j+1);

                                s= String.valueOf(s.charAt(s.length()-1));


                            }
                        }
                    }

                }
                int m=(ints.getFirst())*10+(ints.getLast());
                System.out.println(ints+" "+m);

                solution=solution+ (ints.getFirst())*10+(ints.getLast());

            }

            System.out.println(solution);

        } catch (IOException e) {
            // Handle exceptions such as file not found or unable to read
            e.printStackTrace();
        }
    }
}