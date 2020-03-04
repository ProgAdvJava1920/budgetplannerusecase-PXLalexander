package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BudgetPlannerMapperTest {
    Path testCsvFile = Paths.get("src/main/resources/account_payments.csv");
    List<String> accountLines;
    BudgetPlannerMapper budgetMapper = new BudgetPlannerMapper();
    String testDataLine = "Jos,BE69771770897312,BE91129905553774,Sat Feb 08 13:35:53 CET 2020,1642.56,EUR,Dolore non necessitatibus ut porro perspiciatis non voluptas.\n";

    @BeforeEach
    void setUp() throws BudgetPlannerException {
        accountLines = BudgetPlannerImporter.readFiles(testCsvFile);
    }

    @Test
    void it_should_return_non_empty_list() {
        List<Account> accountList = budgetMapper.mapAccounts(accountLines);
        assertFalse(accountList.isEmpty());
    }

    @Test
    void it_should_map_to_account_list_with_1_account_with_2_payments(){
        List<Account> accountList = budgetMapper.mapAccounts(accountLines);
        assertEquals(1,accountList.size(),"it should have 1 account");

    }

    @Test
    void it_should_map_payments_of_the_same_account_to_the_same_account() {
        List<Account> accountList = budgetMapper.mapAccounts(accountLines);
        assertEquals(2,accountList.get(0).getPayments().size(),"account should have 2 payments");
    }

    @Test
    void it_should_map_line_to_account_object(){
        Account expectedAccount  = new Account("Jos","BE69771770897312");
        Account lineToAccount =  budgetMapper.mapDataLineToAccount(testDataLine);
        assertEquals(expectedAccount, lineToAccount);
    }

    @Test
    void it_should_map_line_to_payment() throws ParseException {
        Payment expectedPayment = new Payment("BE91129905553774",
                budgetMapper.convertToDate("Sat Feb 08 13:35:53 CET 2020"),
                (float)1642.56,
                "EUR","Dolore non necessitatibus ut porro perspiciatis non voluptas");

       Payment actualPayment = budgetMapper.mapItemsToPayment(testDataLine.split(","));
       assertEquals(expectedPayment,actualPayment);
    }

    @Test
    void it_should_convert_string_to_date() throws ParseException {
        String testDate = "Sat Feb 08 13:35:53 CET 2020";
        Date date = budgetMapper.convertToDate(testDate);
        String dateToString = budgetMapper.convertDateToString(date);
        assertEquals(testDate,dateToString);
    }
}