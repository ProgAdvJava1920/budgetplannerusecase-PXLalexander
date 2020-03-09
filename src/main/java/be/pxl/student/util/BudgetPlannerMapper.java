package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BudgetPlannerMapper {


    public static final int CSV_ITEM_COUNT = 7;
    private Map<String,Account>  accountMap = new HashMap<>();

    public  List<Account> mapAccounts(List<String> accountLines){
        for (String accountLine : accountLines) {
            Account account = null;
            try {
                account = mapDataLineToAccount(accountLine);
                accountMap.putIfAbsent(account.getIBAN(),account);
            } catch(ParseException e){
                System.err.println("Could not parse line " + accountLine);
            } catch (BudgetPlannerException e) {
                System.err.println("got an error at " + accountLine);
            }

        }
       // return accountList;
        return new ArrayList<>(accountMap.values());
    }

    public Account mapDataLineToAccount(String line) throws ParseException, BudgetPlannerException {
        String[] items = line.split(",");
        if (items.length!= CSV_ITEM_COUNT){
            throw new BudgetPlannerException(String.format("invalid line, expected %d items, Found %s", CSV_ITEM_COUNT, items.length));
        }
        String name = items[0];
        String iban = items[1];

        Account account = accountMap.getOrDefault(iban, new Account(name,iban));
        Payment payment = mapItemsToPayment(items);
        account.getPayments().add(payment);

        return account;
    }

    public Date convertToDate(String testDate) throws ParseException {
        return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).parse(testDate);
    }

    public String convertDateToString(Date date){
        return new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH).format(date);
    }

    public Payment mapItemsToPayment(String[] items) throws ParseException {
        return new Payment(
                items[2],
                convertToDate(items[3]),
                Float.parseFloat(items[4]),
                items[5],
                items[6]
        );
    }
}
