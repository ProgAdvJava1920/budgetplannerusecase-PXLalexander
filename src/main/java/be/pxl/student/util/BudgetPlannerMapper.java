package be.pxl.student.util;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BudgetPlannerMapper {


    public  List<Account> mapAccounts(List<String> accountLines){
        List<Account> accountList = new ArrayList<>();
        for (String accountLine : accountLines) {
            Account account = mapDataLineToAccount(accountLine);
            if(!accountList.contains(account)){
                accountList.add(account);
            }
        }
        return accountList;

    }

    public Account mapDataLineToAccount(String line) {
        String[] items = line.split(",");
        String name = items[0];
        String iban = items[1];
        return new Account(name,iban);
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
