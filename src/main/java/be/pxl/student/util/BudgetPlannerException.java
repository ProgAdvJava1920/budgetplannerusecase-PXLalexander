package be.pxl.student.util;

public class BudgetPlannerException extends Exception {
    public BudgetPlannerException(String s){
        super(s);
    }

    public BudgetPlannerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BudgetPlannerException(Throwable cause) {
        super(cause);
    }
}
