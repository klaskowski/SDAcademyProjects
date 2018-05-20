import java.io.*;

public class MyFileReader implements IReader {
    @Override
    public String read() {
        String input = new String();
        File file = new File("src\\files\\input\\input.txt");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while(br.ready()) {
                String line = br.readLine();
                input = input.concat(line);
                input = input.concat("\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(file.toString());
            return null;
        } catch (IOException e) {
            System.out.println("Cannot read from file");
            System.out.println(file.toString());
            return null;
        }
        System.out.println("Original file content is: ");
        System.out.println(input);
        return input;
    }
}
