import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    DataLoader dataloader = new DataLoader();

    public void menuPrinter() {
        Scanner input = new Scanner(System.in); // will hold whatever value user inputs
        int searchNumber = 1;
        while (true) {
            System.out.print("Search [" + searchNumber + "]: ");
            String holder = input.nextLine();
            if(holder.equals("!q")){
                System.out.println("-----Thank You-----");
                System.exit(0);}
            if(holder.equals("!help")){
                guidePrinter();
                searchNumber++;
                continue;
            }
            ArrayList<String> separator = optionReader(holder);
            //This switch method will separate amount of words inputted and pass it to desired case.
            switch(separator.size()) {
                case 1:
                    dataloader.firstCase(separator.get(0));
                    break;
                case 2:
                    dataloader.secondCase(separator.get(0), separator.get(1));
                    break;
                case 3:
                    dataloader.thirdCase(separator.get(0), separator.get(1), separator.get(2));
                    break;
                case 4:
                    dataloader.fourthCase(separator.get(0), separator.get(1), separator.get(2), separator.get(3));
                    break;
                default:
                    guidePrinter();

            }
            searchNumber++;
        }
    }
    public static void guidePrinter() {
        String guide = "\t|\n \t PARAMETER HOW-TO, please enter:\n" +
                "\t 1. A search key -then 2. An optional part of speech -then\n" +
                "\t 3. An optional 'distinct' -then 4. An optional 'reverse'\n \t|";
        System.out.println(guide);
    }

    /* -Will simply separate users input into an array separated by " ". if an extra " "
      is inputted. Returns an ArrayList<String>, each index holds a search option, i.e (reverse, distinct, reVERSE)
    */
    protected ArrayList<String> optionReader(String user) {
        String[] tempHolder = user.split(" ");
        if (tempHolder[0].length()> 0)
            tempHolder[0] = reWriter(tempHolder[0]);
        ArrayList<String> separator = new ArrayList<>();
        for (int i = 0; i < tempHolder.length; i++) {
            if (tempHolder[i].equals(""))
                continue;
            tempHolder[i] = tempHolder[i].strip();
            separator.add(tempHolder[i]);
        }
        return separator;
    }
    // reWriter will take: ReVerSE adn will make it --> Reverse
    public String reWriter(String word) {
        word = word.toLowerCase();
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        return word;
    }
}

