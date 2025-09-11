
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final Path DEFAULT_FILE = Path.of("expenses.tsv");

    public static void main(String[] args) {
        ExpenseManager mgr = new ExpenseManager();
        FileManager fm = new FileManager();
        Scanner scan = new Scanner(System.in); 

        // try to auto load on startup
        try {
            List<Expense> loaded = fm.read(DEFAULT_FILE);
            mgr.replaceAll(loaded);
            
            if(loaded.isEmpty())
                System.out.println("Loaded " + loaded.size() + " expenses from " + DEFAULT_FILE);

        } catch (Exception e) {
            System.out.println("Couldn't load existing file " + "(" + e.getMessage() + ")");
        }

        while(true) {
            printMenu();
            String choice = scan.nextLine().trim(); 
            switch(choice) {
                case "1": 
                    addExpenseFlow(mgr,scan); 
                case "2": 
                    listExpenses(mgr); 
                case "3": 
                    removeExpenseFlow(mgr,scan);
                case "4": 
                    totalsByCategoryFlow(mgr, scan); 
                case "5": 
                    monthlyTotalFlow(mgr, scan); 
                case "6": 
                    saveFlow(mgr, fm, scan); 
                case "7": 
                    loadFlow(mgr, fm, scan); 
                case "0": {
                    try {
                        fm.save(mgr.getAllExpenses(), DEFAULT_FILE); 

                    } catch (Exception e) {
                    System.out.println("Exit save failed: " + e.getMessage()); 
                    }
                    return; 
                }
                default: 
                    System.out.println("Invalid choice.");
                    
                    

            }

            
        }

        

    }
    
    private static void printMenu() {
        System.out.println();
        System.out.println("==== Expense Tracker ====");
        System.out.println("1) Add expense");
        System.out.println("2) List expenses");
        System.out.println("3) Remove expense");
        System.out.println("4) Total by category");
        System.out.println("5) Monthly total");
        System.out.println("6) Save to file");
        System.out.println("7) Load from file");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }



    private static void addExpenseFlow(ExpenseManager manager, Scanner scan) {
        try {
            System.out.print("Amount (e.g., 12.50): ");
            double amount = Double.parseDouble(scan.nextLine().trim());

            System.out.print("Category " + java.util.Arrays.toString(Category.values()) + ": ");
            Category category = Category.fromString(scan.nextLine());

            System.out.print("Date (YYYY-MM-DD) [leave blank for today]: ");
            String dateStr = scan.nextLine().trim();
            LocalDate date = dateStr.isEmpty() ? LocalDate.now() : LocalDate.parse(dateStr);

            System.out.print("Description (optional): ");
            String desc = scan.nextLine();

            Expense e = new Expense(amount, category, desc, date);
            manager.addExpense(e);
            System.out.println("Added: " + e);
        } catch (Exception e) {
            System.out.println("Failed to add expense: " + e.getMessage());
        }
    }

    private static void listExpenses(ExpenseManager manager) {
        List<Expense> all = manager.getAllExpenses(); 
        if (all.isEmpty()) {
            System.out.println("No expenses yet.");
            return; 
        }
        System.out.println("Index | Expense");
        for (int i = 0; i < all.size(); i++) {
            System.out.printf("%5d | %s%n", i, all.get(i).toString());
        }
        System.out.printf("Total: $%.2f%n", manager.getTotal());
    }

    private static void removeExpenseFlow(ExpenseManager manager, Scanner scan) {
        listExpenses(manager);
        System.out.print("Enter index to remove: ");
        try { 
            int index = Integer.parseInt(scan.nextLine().trim()); 
            boolean valid = manager.removeExpense(index); 
            System.out.println(valid ? "Removed. " : "Invalid index." );
        } catch (NumberFormatException e) {
            System.out.println("Not a number.");
        }
    }

    private static void totalsByCategoryFlow(ExpenseManager manager, Scanner scan) {
        System.out.print("Category: " + java.util.Arrays.toString(Category.values()) + ":"); 
        Category category = Category.fromString(scan.nextLine());
        double total = manager.getTotalByCategory(category); 
    }

    private static void monthlyTotalFlow(ExpenseManager manager, Scanner scan) {
        try {
            System.out.print("Year: (e.g., 2025): "); 
            int year = Integer.parseInt(scan.nextLine().trim());
            System.out.print("Month (1-12): "); 
            int month = Integer.parseInt(scan.nextLine().trim()); 
            double total = manager.getMonthlyTotal(month, year);
            System.out.printf("Total for %04d-%02d: $%.2f%n", year, month, total); 
        } catch (NumberFormatException e) {
            System.out.println("Invalid year/month."); 
        }
    }

    private static void saveFlow(ExpenseManager manager, FileManager fm, Scanner scan) {
        System.out.print("Filename [default: expenses.tsv]: ");
        String name = scan.nextLine().trim(); 
        if(name.isEmpty()) 
            name = "expenses.tsv"; 
        try {
            fm.save(manager.getAllExpenses(), Path.of(name));
            System.out.println("Saved to: " + name);
        } catch (Exception e) {
            System.out.println("Save failed: " + e.getMessage()); 
        }
    }

    private static void loadFlow(ExpenseManager manager, FileManager fm, Scanner scan) {
        System.out.print("Filename to load [default: expenses.tsv]: ");
        String name = scan.nextLine().trim(); 
        if (name.isEmpty()) 
            name = "expenses.tsv";
        try {
            List<Expense> loaded = fm.read(Path.of(name)); 
            manager.replaceAll(loaded); 
            System.out.println("Loaded " + loaded.size() + " expenses from " + name); 
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
    
    }


}


