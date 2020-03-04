package be.pxl.student.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetPlannerImporterTest {

    Path testCsvFile =Paths.get("src/main/resources/account_payments.csv");

    @Test
    void readFiles_should_return_none_empty_lists() throws BudgetPlannerException {

        assertFalse(BudgetPlannerImporter.readFiles(testCsvFile).isEmpty());
    }

    @Test
    void readFiles_should_return_list_of_size_2() throws BudgetPlannerException {
        assertEquals(2, BudgetPlannerImporter.readFiles(testCsvFile).size());
    }

    @Test
    void readFiles_should_throw_exception_when_csv_file_does_not_exist(){
        assertThrows(BudgetPlannerException.class , () -> {
                    BudgetPlannerImporter.readFiles(Paths.get("not existing path"));

        });
    }

    @Test
    void readFiles_should_throw_exception_when_csv_file_is_null(){
        assertThrows(BudgetPlannerException.class , () -> {
            BudgetPlannerImporter.readFiles(Paths.get(null));

        });
    }
}