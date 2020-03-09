package be.pxl.student;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import be.pxl.student.util.BudgetPlannerException;
import be.pxl.student.util.BudgetPlannerImporter;
import be.pxl.student.util.BudgetPlannerMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BudgetPlanner {
    private static  Logger logger = LogManager.getLogger(BudgetPlanner.class);

    public static void main(String[] args) {

        String csvFile = "src/main/resources/account_payments.csv";

        List<String> lines = null;
        try {
            logger.info("Starting import");
            lines = BudgetPlannerImporter.readFiles(Paths.get(csvFile));
            logger.info("csv info imported");
            logger.info("starting accoutn mapping");
            List<Account> accounts = new BudgetPlannerMapper().mapAccounts(lines);
            accounts.forEach(logger::debug);
            logger.info("account mapping done");
        } catch ( BudgetPlannerException e) {
            logger.error("excepting importin accounts", e);
        }
        Account account = new Account();
        List<Payment> payments = new ArrayList<>();


        for (String line : lines) {


        }
    }


}
