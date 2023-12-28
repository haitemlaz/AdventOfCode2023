import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2Part2 {
    public static void main(String[] args) throws IOException {
        String filePath = "input2.txt";

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            ArrayList <Integer> SetPower =new ArrayList<Integer>();
            int solution =0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {


                Map <String ,Integer> colors= new HashMap<>();

                colors.put("red",0);
                colors.put("blue",0);
                colors.put("green",0);

                line = line.split(":")[1];
                List<String> cubes= List.of(line.split("[,;]"));

                for (int i = 0; i < cubes.size(); i++) {
                    String color = cubes.get(i).trim().split(" ")[1];

                    String s= cubes.get(i).trim().split(" ")[0];
                    int n;

                    try {
                        n=(s.charAt(0)-'0')*10+s.charAt(1)-'0';

                    } catch (Exception e) {
                        // throw new RuntimeException(e);
                        n=s.charAt(0)-'0';
                    }

                    if (n>colors.get(color)){
                        colors.put(color,n);
                    }

                }

                SetPower.add(colors.get("red")*colors.get("blue")*colors.get("green"));

            }

            for (int i = 0; i < SetPower.size(); i++) {
                solution += SetPower.get(i);
            }
            System.out.println(solution);



        } catch (IOException e) {
            // Handle exceptions such as file not found or unable to read
            e.printStackTrace();
        }
    }
}

