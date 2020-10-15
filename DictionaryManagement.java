
import java.io.*;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
     static Scanner scanner = new Scanner(System.in);

    public static void insertFromCommandline() {
        System.out.print("Nhập số lượng từ và các từ:");
        int n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            String target = scanner.nextLine();
            String explain = scanner.nextLine();
            addWord(target, explain);
        }
    }

    public static void insertFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("dictionaries.txt"));

        String line;
        String target  = "";
        String explain = "";
        while ((line = bufferedReader.readLine()) != null) {
            if (line.length() >= 2) {
                if (line.contains("@"))  line = line.substring(1);

                if (line.contains("a /")) target = "a";
                else if (line.contains(" /"))
                target = line.substring(0,line.indexOf(" /"));

                explain = line + "\n";
            }
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("")) {
                    break;
                }
                explain = explain + line + "\n";
            }
              addWord(target, explain);
        }
        bufferedReader.close();
    }

    public static String dictionaryLookup(String target) {
        for (Word word : words)
            if (target.equals(word.getWord_target())) {
                return word.getWord_explain();
            }
        return "Word is not found!";
    }


    public static void dictionaryExportToFile() throws IOException {
        System.out.println("Nhập tên file xuất ra (Vd: new.txt) :");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
        for (Word word : words)
            bufferedWriter.write(word.getWord_target()
                    + "\t" + word.getWord_explain() + "\n");
        bufferedWriter.close();
    }

    public static String Search(String word, int Width) {
      if (word.length() == 0) return "";
      StringBuilder search = new StringBuilder();
      StringBuilder line = new StringBuilder();
        for (Word value : words) {
            if (value.getWord_target().startsWith(word)) {

                if ((line + value.getWord_target() + ", ").length() >= Width) {
                    search.append("\n");
                    line = new StringBuilder();
                }
                line.append(value.getWord_target()).append(", ");
                search.append(value.getWord_target()).append(", ");
                if (word.length() == 3) System.out.println("search :" + search);
            } else {
                if (!search.toString().equals("")) {
                    break;
                }
            }
        }
        if (search.toString().equals("")) return "Error: Word is not found!";
       return search.toString();
    }



}
