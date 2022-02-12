import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DataLoader {
    Enum.Dictionary[] enums = Enum.Dictionary.values();
    // Lists that will hold available options for each entry
    ArrayList<String> spchType2 = new ArrayList<>();
    ArrayList<String> distinct3 = new ArrayList<>();
    ArrayList<String> reverse4 = new ArrayList<>();

    HashMap<String, ArrayList<String[]>> allWords = dataLoader();
    //// copyAllWords will be used to change values without changing original (deep copy)
    HashMap<String, ArrayList<String[]>> copyAllWords = new HashMap<>();


    public void firstCase(String word) {
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            toString();
            copyAllWords.clear();
        } else notAvailable();
    }

    public void secondCase(String word, String spch) {
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            merger(word, spch, 2);
            toString();
            copyAllWords.clear();
        } else notAvailable();
    }


    public void thirdCase(String word, String spch, String d_r) {
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            merger(word,spch,2);
            merger(word, d_r, 3);
            toString();
            copyAllWords.clear();
        } else notAvailable();
    }

    public void fourthCase(String word, String spch, String d_r, String reverse) {
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            merger(word,spch,2);
            merger(word,d_r,3);
            merger(word, reverse, 4);
            toString();
            copyAllWords.clear();
        } else notAvailable();
    }

    private void merger(String word, String keyword, int caseNumber) {
            errorChecker(keyword, caseNumber); // will check if placement of keyword is valid
            handler(word, keyword, caseNumber); // if placement is valid, do whatever the keyword asks
        }

    // dataLoader reads all enums and uses word as key, and speech and definition as value.
    private HashMap<String, ArrayList<String[]>> dataLoader() {
        HashMap<String, ArrayList<String[]>> allWords = new HashMap<>();
        ArrayList<String[]> values;
        String[] spchAndDef = new String[2]; //spchAndDef array holds pos and definition
        String word;
        filler(); // fills up ArrayLists used to check position of keywords in errorChecker()
        System.out.println("! Loading Data..."); //starts to load the data
        for (int i = 0; i < enums.length; i++) {
            word = enums[i].word; // word i.e "Book", "Reverse" etc
            spchAndDef[0] = enums[i].pos; // part of speech
            spchAndDef[1] = enums[i].def; // definition
            if (!allWords.containsKey(word)) {  // if word is not same then
                values = new ArrayList<>();
                values.add(spchAndDef.clone());
                allWords.put(word, values);
            } else allWords.get(word).add(spchAndDef.clone());
        }
        System.out.println("! Loading Completed...");
        System.out.println("\n===== Dictionary 340 Java =====\n----- Keywords: " + allWords.size() +
                "\n----- Definitions: " + enums.length + "\n");
        return allWords;
    }
    // Handler will perform whatever entry asks i.e. reverse, distinct
    private void handler(String word, String keyword, int n_list) {
        keyword = keyword.toLowerCase();
        String[] option = handlerHelper(keyword, n_list);
        ArrayList<String[]> values = new ArrayList<>();
        if (option[0].equals("true"))
            switch (option[1]) {
                case "distinct":
                    distinct(word);
                    break;
                case "reverse":
                    reverse(word);
                    break;
                default:
                    lookUp(word, keyword);
            }
    }

    // handlerHelper will check if entry is an available option.
    private String[] handlerHelper(String option, int n_list) {
        boolean checker = false;
        String[] holder = new String[2];
        String returner = ""; // will hold entry i.e. noun, reverse, distinct, etc
        switch (n_list) { // n_list will tell us what list to search on
            case 2:
                checker = spchType2.contains(option);
                returner = option;
                break;
            case 3:
                checker = distinct3.contains(option);
                returner = option;
                break;
            case 4:
                checker = reverse4.contains(option);
                returner = option;
                break;
        }
        holder[0] = Boolean.toString(checker);
        holder[1] = returner;
        return holder; //returning if entry was a valid (true or false) and the entry itself
    }
    // errorChecker will check if order of words inputted is right
    private void errorChecker(String finder, int n) {
        finder=finder.toLowerCase();
        if (!spchType2.contains(finder) && n==2) {
            System.out.println("\t|\n\t<The entered " + n + "nd parameter '"+ finder + "' is NOT a part of speech.>\n" +
                    "<The entered " + n + "nd parameter '" + finder +"' is NOT 'distinct'.>");

            //|
            //     <The entered 2nd parameter 'ok' is NOT a part of speech.>
            //     <The entered 2nd parameter 'ok' is NOT 'distinct'.>
            //     <The entered 2nd parameter 'ok' is NOT 'reverse'.>
            //     <The entered 2nd parameter 'ok' was disregarded.>
            //     <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>
        }
        else if(!distinct3.contains(finder) && n==3){
            System.out.println("Speech error" + n + "Attempt");
        }
        else if(!reverse4.contains(finder) && n==4){
            System.out.println("Speech error" + n + "Attempt");
        }


    }
    private void notAvailable() {
        System.out.println("\t|\n \t<NOT FOUND> To be considered for the next release. Thank you.\n \t|");
        Menu.guidePrinter();
    }

    // search specific part of speech
    private void lookUp(String word, String spch){
        ArrayList<String[]> values = (ArrayList<String[]>) copyAllWords.get(word).clone();
        for (int i = 0; i < values.size(); i++) {
            if (!values.get(i)[0].equals(spch)) {
                values.remove(i); // This line will delete duplicated definition
                i--;
            }
        }
        copyAllWords.replace(word, values);
    }

    private void reverse(String word) {
        ArrayList<String[]> values = (ArrayList<String[]>) copyAllWords.get(word).clone();
        Collections.reverse(values); //this line makes the list reversed
        copyAllWords.replace(word,values);
    }
    private void distinct(String word) {
        ArrayList<String[]> values = (ArrayList<String[]>) copyAllWords.get(word).clone();
        values = distinctHelper(values);
        copyAllWords.replace(word, values);

    }
    private ArrayList<String[]> distinctHelper(ArrayList<String[]> values) {
        int j = 0;
        if (values.size() > 1) {
            for (int i = 1; i < values.size(); i++) {
                if (values.get(j)[0].equals(values.get(i)[0]) && values.get(j)[1].equals(values.get(i)[1])) {
                    values.remove(j); // This line will delete duplicated definition
                    i--;
                    continue;
                }
                j++;
            }
        }
        return values;
    }
    private void filler(){
        spchType2.add("verb");
        spchType2.add("noun");
        spchType2.add("adjective");
        spchType2.add("adverb");
        spchType2.add("conjunction");
        spchType2.add("interjection");
        spchType2.add("preposition");
        spchType2.add("pronoun");
        spchType2.add("reverse");
        spchType2.add("distinct");
        distinct3.add("distinct");
        distinct3.add("reverse");
        reverse4.add("reverse");
    }

    @Override
    public String toString() {
        ArrayList<String[]> values;
        for (String word : copyAllWords.keySet()) {
            values = copyAllWords.get(word);
            System.out.println("\t|");
            for (int i = 0; i < values.size(); i++) {
                String spch = values.get(i)[0];
                String def = values.get(i)[1];
                System.out.println("\t " + word + " [" + spch + "] : " + def);
            }
            System.out.print("\t|\n");
        }
        return null;
    }
}



