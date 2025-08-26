
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final Path DEFAULT_FILE = Path.of("expenses.tsv");

    public static void main(String[] args) {
        ExpenseManager mgr = new ExpenseManager();
        FileManager fm = new FileManager();
        Scanner scan = new Scanner(System.in); 

        try {
            List<Expense> loaded = fm.read(DEFAULT_FILE);
            mgr.replaceAll(loaded);
            
            if(loaded.isEmpty())
                System.out.println("Loaded " + loaded.size() + " expenses from " + DEFAULT_FILE);

        } catch (Exception e) {
            System.out.println("Couldn't load existing file " + "(" + e.getMessage() + ")");
        }

        // begin gui logic

    }

}
