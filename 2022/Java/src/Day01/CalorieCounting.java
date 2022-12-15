package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCounting {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/Day01/input01.txt"))) {
            ArrayList<Integer> result = new ArrayList<>();
            String line = br.readLine();
            List<String> lines = Files.readAllLines(Paths.get("src/Day01/input01.txt"));
            int lineCount = lines.size()/2;
            int accumulator = 0;

            for (int i = 0; i <= lineCount; i++) {
                accumulator += Integer.parseInt(line);
                line = br.readLine();
                if ("".equals(line)) {
                    line = br.readLine();
                    result.add(accumulator);
                    accumulator = 0;
                }
            }
            Collections.sort(result);
            Collections.reverse(result);
            System.out.println("Most Calories: " + result.get(0));
            int topThree = result.get(0) + result.get(1) + result.get(2);
            System.out.println("Top 3 Most Calories: " + topThree);
        }
    }
}