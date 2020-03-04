package be.pxl.student.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
/**
 * Util class to import csv file
 */
public class BudgetPlannerImporter {
    public static List<String> readFiles(Path filePath) throws BudgetPlannerException {
        List<String> returnLines = new ArrayList<>();
        String line;
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(filePath);
            line = reader.readLine();
            while((line = reader.readLine()) != null){
                returnLines.add(line);
            }
        } catch (IOException e) {
            throw new BudgetPlannerException("something went wrong with reading the csv file");
        }


        return returnLines;
    }
}
