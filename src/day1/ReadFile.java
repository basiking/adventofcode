package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File myObj = new File("src//day1//input.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<Integer> calories = new ArrayList<>();
            int i = 0;
            int total = 0;
            while (myReader.hasNextInt()) {
                String data = myReader.nextLine();
                if (data.equals("")) {
                    calories.add(i);
                    calories.set(i, total);
                    System.out.println("Elf " + i + " has " + total + " calories.");
                    total = 0;
                    i++;
                }else{
                    int d = Integer.parseInt(data);
                    total = total + d;

                }

            }
            try {
                int largestNumber = Collections.max(calories);
                System.out.println("The biggest amount of calories is: " + largestNumber);
                calories.sort(Collections.reverseOrder());
                System.out.println("The three elves with the most calories have in total: " + (calories.get(0) + calories.get(1) + calories.get(2)));
            }catch (ClassCastException | NoSuchElementException e){
                System.out.println("Exception caught: " + e);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
