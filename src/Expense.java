import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Expense {

    // a single spending entry 

    private double amount; 
    private Category category;
    private String description; 
    private LocalDate date; 

    private static final DateTimeFormatter FMT = DateTimeFormatter.ISO_LOCAL_DATE;

    public Expense(double amount, Category cat, String desc, LocalDate date) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative.");
        this.amount = amount; 
        this.description = desc;
        this.category = Objects.requireNonNull(category, "category");
        this.date = Objects.requireNonNull(date, "date");
    }


    /* helper methods that account for a user saving a description with a tab character
    *  as to not mess up the parsing system. replaces tab character "/t" with "//t" as 
    *  well as newline character, return, and backslash
    */ 
    private static String escape(String s) {
        return s.replace("\\", "\\\\").replace("\t", "\\t").replace("\n", "\\n").replace("\r", "\\r");
    }

    private static String unescape(String s) {
        StringBuilder out = new StringBuilder();
        boolean esc = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!esc) {
                if (c == '\\') esc = true;
                else out.append(c);
            } else {
                switch (c) {
                    case 't': out.append('\t'); break;
                    case 'n': out.append('\n'); break;
                    case 'r': out.append('\r'); break;
                    case '\\': out.append('\\'); break;
                    default: out.append(c); break;
                }
                esc = false;
            }
        }
        if (esc) out.append('\\'); // trailing backslash safety
        return out.toString();
    }


    public String toTsv() {
        // amount \t category \t date(YYYY-MM-DD) \t description(with escaped tabs/newlines)
        return amount + "\t" + category.name() + "\t" + date.format(FMT) + "\t" + escape(description);
    }


    public static Expense fromTsv(String line) {
        String[] parts = line.split("\t", -1); 
        if(parts.length < 4) throw new IllegalArgumentException("Bad TSV: " + line);

        double amount = Double.parseDouble(parts[0]);
        Category cat = Category.fromString(parts[1]);
        LocalDate date = LocalDate.parse(parts[2], FMT);
        String desc = unescape(parts[3]);
        return new Expense(amount, cat, desc, date);
    }
    

    public double getAmount() {
        return amount; 
    }

    public String getDescription() {
        return description; 
    }

    public Category getCategory() {
        return category; 
    }

    public LocalDate getDate() {
        return date;
    }
    

    public String toString() {
        return String.format("%s | %s | $%.2f | %s",
                date, category.name(), amount, description.isEmpty() ? "-" : description);
    }


}
