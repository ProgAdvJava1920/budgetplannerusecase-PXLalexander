package be.pxl.student;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import be.pxl.student.util.BudgetPlannerException;
import be.pxl.student.util.BudgetPlannerImporter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class BudgetPlanner {
    private static final Logger logger = LogManager.getLogger(BudgetPlanner.class);

    public static void main(String[] args) {
        logger.trace("test");
        List<String> lines = null;
        try {
            lines = BudgetPlannerImporter.readFiles(Paths.get("src/main/resources/account_payments.csv"));
        } catch ( BudgetPlannerException e) {
            e.printStackTrace();
        }
        Account account = new Account();
        List<Payment> payments = new ArrayList<>();


        for (String line : lines) {

            /**List<String> budgetData = Arrays.asList(line.split(","));
            if (account.equals(new Account())) {
                account.setIBAN(budgetData.get(1));
                account.setName(budgetData.get(0));
            }

            Payment payment;
            try {
                if (budgetData.size()==7) {
                    payment = new Payment(
                            new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(budgetData.get(3)),
                            Float.parseFloat(budgetData.get(4)), budgetData.get(5), budgetData.get(6));
                    payments.add(payment);
                    account.setPayments(payments);
                    logger.trace("test");

                }
            } catch (ParseException e) {
                System.out.println(budgetData.toString());
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }**/
        }
    }


}
