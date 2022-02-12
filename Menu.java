import java.util.ArrayList;
import java.util.Scanner;
/*     -Menu options
       -User will exit program with !q
       -Empty entries, !help keyword, and words that do not exist
        in the dictionary will display a guide
*/
public class Menu extends DataLoader {

    public void testMenu() {
        menuPrinter();
    }

    public void menuPrinter() {
        Scanner input = new Scanner(System.in); // will hold whatever value user inputs
        int searchNumber = 1;
        while (!input.equals("!q")) {
            System.out.print("Search [" + searchNumber + "]: ");
//            if(input.equals("!help")){
//                guidePrinter();
//                searchNumber++;
//                continue;
//            }
            String holder = input.nextLine();
            ArrayList<String> separator = optionReader(holder);
            switch (separator.size()) {
                case 1:
                    firstCase(separator.get(0));
                    break;
                case 2:
                    secondCase(separator.get(0), separator.get(1));
                    break;
                case 3:
                    thirdCase(separator.get(0), separator.get(1), separator.get(2));
                    break;
                case 4:
                    fourthCase(separator.get(0), separator.get(1), separator.get(2), separator.get(3));
                    break;
                default:
                    guidePrinter();

            }
            searchNumber++;
        }
    }

    /* -Will simply separate users input into an array separated by " ". if an extra " "
      is inputted, it will strip it out (we do not want spaces counting as search options like: reverse    reverse == reverse reverse)
       - returns an ArrayList<String>, each index holds a search option, i.e (reverse, distinct, reVERSE)
    */
    protected ArrayList<String> optionReader(String user) {
        String[] tempHolder = user.split(" ");
        ArrayList<String> separator = new ArrayList<>();
        for (int i = 0; i < tempHolder.length; i++) {
            if (tempHolder[i].equals(""))
                continue;
            tempHolder[i] = tempHolder[i].strip();
            separator.add(tempHolder[i]);
        }
        return separator;
    }

    public static void guidePrinter() {
        String guide = "\t|\n \t PARAMETER HOW-TO, please enter:\n" +
                "\t 1. A search key -then 2. An optional part of speech -then\n" +
                "\t 3. An optional 'distinct' -then 4. An optional 'reverse'\n \t|";
        System.out.println(guide);
    }
}

