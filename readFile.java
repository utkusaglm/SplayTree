import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {


    Scanner scanner;
    private int height;
    private int width;
    private int numberOfObstacles;
    //public static String inputStr="";
    public static ArrayList<String> fileArrayString = new ArrayList<>();
    public static ArrayList<Integer> fileArrayInt = new ArrayList<>();

    public static String stringIns;
    private int count =0;
    static String b=Main.a;



    public void openFile() {
        try {
            scanner = new Scanner(new File(b));

        } catch (Exception e) {

        }
    }

    public void readFile() {


        while (scanner.hasNext()) {

            String as = scanner.next().trim();



            if (!as.contains("[a-zA-Z]+") && as.length() > 2) {
                fileArrayString.add(as);

            }else{
                int a=Integer.parseInt(as);
                fileArrayInt.add(a);
            }






        }


    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }

    public void closeFile() {

        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
