
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String HEADER = "amount\tcategory\tdate\tdescription";

    public void save(List<Expense> expenses, Path path){
        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
            writer.write(HEADER); 
            writer.newLine();
            for(Expense e : expenses) {
                writer.write(e.toTsv());
                writer.newLine(); 
            }
        } catch(IOException e) {
            System.out.println("File not found");
            System.exit(0);
        }
    }

    public List<Expense> read(Path path){
        List<Expense> list = new ArrayList<>();
        if(!Files.exists(path))
            return list; 

        try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line; 
            boolean first = true;
            while((line = reader.readLine()) != null) {
                if(first) {
                    first = false; 
                    if (line.startsWith("amount\t")) 
                        continue; 
                }
                if(line.isBlank())
                    continue;
                list.add(Expense.fromTsv(line));
            }
        } catch(IOException e) {
            System.out.println("File not found");
            System.exit(0);
        }

        return list; 
    }

}
