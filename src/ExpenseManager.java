import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseManager {

    // stores and manages a collection of expenses

    private final List<Expense> expenses = new ArrayList<>();  
    
    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public Boolean removeExpense(int i) {
        if(i < 0 || i >= expenses.size()) return false; 
        expenses.remove(i);
        return true; 
    }

    public List<Expense> getAllExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    public void replaceAll(List<Expense> newExpenses) {
        expenses.clear();
        if (newExpenses != null) expenses.addAll(newExpenses);
    }
    
    public double getMonthlyTotal(int month, int year) {
        YearMonth search = YearMonth.of(year, month);
        return expenses.stream().filter(e -> YearMonth.from(e.getDate()).equals(search)).mapToDouble(Expense::getAmount).sum();
    }

    public double getTotal() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum(); 
    }

    public double getTotalByCategory(Category category) {
        return expenses.stream().filter(e -> e.getCategory() == category).mapToDouble(Expense::getAmount).sum(); 
    }

}
