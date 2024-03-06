import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileReader;

public class Client {

    public static Score[] loadScore(String fName){
        Score[] scoreArray = new Score[10];
        try{
            Scanner fileReader = new Scanner(new FileReader(fName));
            int counter = 0;
            while(fileReader.hasNextLine()){
                String[] line = fileReader.nextLine().split(" ");
                scoreArray[counter] = new Score(line[0], Integer.parseInt(line[1]));
                counter++;
            }

            return scoreArray;
        } catch (Exception e){
            System.out.println("Error reading file " + e);
            return null;
        }
    }

    public static double[] calculateScore(Score[] scores){
        int highest = scores[0].getScore(), lowest = scores[0].getScore();
        double avg = 0;

        for (Score score : scores){
            if (highest < score.getScore()){
                highest = score.getScore();
            } else if (lowest > score.getScore()){
                lowest = score.getScore();
            }

            avg += score.getScore();
        }

        avg = avg/scores.length;

        return new double[]{highest, lowest, avg};
    }

    public static void writeToFile(int recordAmt, double[] calArray){
        String fileName = "output.csv";
        try{
            PrintWriter writer = new PrintWriter(fileName);

            writer.write("numOfRecords,avg,largest,smallest\n");
            String dataString = Integer.toString(recordAmt);

            for (double i : calArray){
                if (i%1 == 0){
                    dataString += String.format(",%d", (int) i);
                    continue;
                }
                dataString += String.format(",%f", i);
            }

            writer.println(dataString);
            writer.close();
        } catch (Exception e){
            System.out.println("An error occured " + e);
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter input file name: ");
        String file = input.nextLine();

        Score[] scoreArray = loadScore(file);  

        double[] calScore = calculateScore(scoreArray);

        writeToFile(scoreArray.length, calScore);
        System.out.println("Output saved to output.csv");
    }
}