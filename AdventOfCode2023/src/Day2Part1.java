import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2Part1 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\TRANSHOST\\IdeaProjects\\AdventOfCode2\\input.txt";

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            boolean GameIsPossible=true;
            int solution=0;

            String line;
            int id=0;
            ArrayList <Integer> ids=new ArrayList<Integer>();
            while ((line = bufferedReader.readLine()) != null) {
                id++;

                line = line.split(":")[1];

                List<String> cubes= List.of(line.split("[,;]"));

                for (int i = 0; i < cubes.size(); i++) {
                    String s= cubes.get(i).trim().split(" ")[0];
                    int n;

                    try {
                        n=(s.charAt(0)-'0')*10+s.charAt(1)-'0';

                    } catch (Exception e) {
                        // throw new RuntimeException(e);
                        n=s.charAt(0)-'0';
                    }
                    //  System.out.println(n);

                    String color = cubes.get(i).trim().split(" ")[1];
                    //     System.out.println(color);

                    if (n>12){
                        if(color.equals("red")) {
                            GameIsPossible=false;
                        }
                        else if (color.equals("green")&&n >13)
                        {
                            GameIsPossible=false;
                        }
                        else if (color.equals("blue")&&n >14) {
                            GameIsPossible=false;
                        }


                    }

                }
                if (GameIsPossible) {
                    ids.add(id);
                    System.out.println(id+"added");
                }
                GameIsPossible=true;
            }

            for (int i = 0; i < ids.size(); i++) {
                solution +=ids.get(i);
            }

            System.out.println(solution);

        } catch (IOException e) {
            // Handle exceptions such as file not found or unable to read
            e.printStackTrace();
        }
    }
}