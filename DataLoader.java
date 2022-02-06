import java.util.ArrayList;
import java.util.HashMap;
// Dictionary [] would return an array with all the Enums, they can be accessed through index
public class DataLoader extends Enum {
    Dictionary[] enums = Dictionary.values(); //
    HashMap<String, ArrayList<String[]>> allWords = dataLoader();

    //// copyAllWords will be used to change values without changing original
    HashMap<String, ArrayList<String[]>> copyAllWords = (HashMap<String, ArrayList<String[]>>) allWords.clone();

    //Function to test DataLoader Class
    public void testDataLoader() {
        System.out.println(enums[2]); // test[0] holds Book1
        System.out.println(enums[0].def);// will print noun
    }

    // first case is for when only word is inputted
    public void firstCase(String word) {

    }

    // word and search option i.e reverse, distinct, noun, etc
    public void secondCase(String word, String spch) {
        copyAllWords = distinct(word);
        /*allWordsPrinter(copyAllWords, word);*/
    }

    public void thirdCase(String word, String spch, String distinct) {

    }

    public void fourthCase(String word, String spch, String distinct, String reverse) {

    }

    // errorChecker will check if order of words inputted is right
    public void errorChecker() {

    }

    public void reverse() {
        copyAllWords = (HashMap<String, ArrayList<String[]>>) allWords.clone();
    }

    public HashMap<String, ArrayList<String[]>> distinct(String word) {
        word = reWriter(word);
        copyAllWords = (HashMap<String, ArrayList<String[]>>) allWords.clone();
        ArrayList<String[]> values = allWords.get(word);
        values = looper(values);
        copyAllWords.replace(word, values);

        return copyAllWords;

    }

    public ArrayList<String[]> looper(ArrayList<String[]> values) {
        int j = 0; // 2 , i = 2
        if (values.size() > 1) {
            for (int i = 0; i < values.size(); i++) {
                if (values.get(j)[1].equals(values.get(i)[1])) {
                    values.remove(j); // This line will delete duplicated definitio
                    j++;
                    System.out.println(values.get(j)[1] + "  NEW : NEW  " + values.get(i)[1]);
                    continue;
                }
                j++;
            }
        }
        System.out.println(values.get(5)[1] + "  : " + values.get(6)[1]);
        return values;
    }

    public void allWordsPrinter(HashMap<String, ArrayList<String[]>> copyAllWords, String word) {
        ArrayList<String[]> values;
        word = reWriter(word);
        values = copyAllWords.get(word);
        for (int i = 0; i < values.size(); i++) {
            String spch = values.get(i)[0];
            String def = values.get(i)[1];

            System.out.println("\n|\n " + word + " [" + spch + "] :" + def);
            // Reverse [verb] : lTurn something inside out.
        }
    }

    // reWriter will take: ReVerSE adn will make it --> Reverse
    public String reWriter(String word) {
        word = word.toLowerCase();
        word  = word.substring(0, 1).toUpperCase() +word.substring(1);
        return word;
    }


    // dataLoader reads all enums and uses word as key, and speech and definition as value.
    protected HashMap<String, ArrayList<String[]>> dataLoader() {
        System.out.println("! Loading Data..."); //starts to load the data
        HashMap<String, ArrayList<String[]>> allWords = new HashMap<>();
        ArrayList<String[]> values;
        String[] spchAndDef = new String[2]; //spchAndDef array holds pos and definition
        int calc = 0; //will keep track of definitions
        for (int i = 0; i < enums.length; i++) {
            String word = enums[i].word;
            spchAndDef[0] = enums[i].pos;
            spchAndDef[1] = enums[i].def;
            if (!allWords.containsKey(word)) {  //if word is not same then
                values = new ArrayList<>();
                values.add(spchAndDef.clone());
                allWords.put(word, values);
            } else allWords.get(word).add(spchAndDef.clone());
        }
        System.out.println("! Loading Completed...");

        for (String keyword : allWords.keySet() //finds the definition amount.
        ) {
            ArrayList<String[]> values2 = allWords.get(keyword);
            calc += values2.size();
        }
        System.out.println("\n===== Dictionary 340 Java =====\n----- Keywords: " + allWords.size() + "\n----- Definitions: " + calc + "\n");

        System.out.println(allWords.get("Book").get(2)[0]); // line not necessary just to test logic
        return allWords;
    }


}


