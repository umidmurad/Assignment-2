import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*     -Menu options
       -User will exit program with !q
       -Empty entries, !help keyword, and words that do not exist
        in the dictionary will display a guide
*/
public class Menu extends DataLoader{

    // function to Test the Menu class
    public void testMenu(){
    guiderPrinter();

    }
    public void menuPrinter(){
        Scanner input = new Scanner(System.in); // will hold whatever value user inputs
        while (!input.equals("!q")){

        }
    }



    public void guiderPrinter(){
        String guide = "\t|\n \t PARAMETER HOW-TO, please enter:\n" +
        "\t 1. A search key -then 2. An optional part of speech -then\n" +
        "\t 3. An optional 'distinct' -then 4. An optional 'reverse'\n \t|";
        System.out.println(guide);
    }


}
