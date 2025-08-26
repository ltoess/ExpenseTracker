import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseManager {

    // stores and manages a collection of expenses

    private final List<Expense> expenses = new ArrayList<>();  
    
    private void addExpense(Expense e) {
        expenses.add(e);
    }

    private Boolean removeExpense(int i) {
        if(i < 0 || i >= expenses.size()) return false; 
        expenses.remove(i);
        return true; 
    }

    private List<Expense> getAllExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public void replaceAll(List<Expense> newExpenses) {
        expenses.clear();
        if (newExpenses != null) expenses.addAll(newExpenses);
    }
    
    

    // private void getMonthlyTotal(???)

    // private void listAllExpenses()

    



}
