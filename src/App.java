
import java.nio.file.Path;
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
            // printmenu method 
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
}
