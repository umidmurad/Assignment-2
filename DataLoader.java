import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DataLoader extends Enum {
    Dictionary[] enums = Dictionary.values();
    ArrayList<String> spchType1 = new ArrayList<>();
    ArrayList<String> distinct2 = new ArrayList<>();
    ArrayList<String> reverse3 = new ArrayList<>();
    HashMap<String, ArrayList<String[]>> allWords = dataLoader();
    //// copyAllWords will be used to change values without changing original
    HashMap<String, ArrayList<String[]>> copyAllWords = new HashMap<>();
    //ArrayList<String> spchType1 = new ArrayList<>();
    // first case is for when only word is inputted

//    public ArrayList<String> listof() {
//        ArrayList<String> listof = new ArrayList<>();
//        return listof;
//    }
    public void filler(){
        spchType1.add("verb");
        spchType1.add("noun");
        spchType1.add("adjective");
        spchType1.add("adverb");
        spchType1.add("conjunction");
        spchType1.add("interjection");
        spchType1.add("preposition");
        spchType1.add("pronoun");
        spchType1.add("reverse");
        spchType1.add("distinct");
        distinct2.add("distinct");
        distinct2.add("reverse");
        reverse3.add("reverse");
    }

    public void firstCase(String word) {
        word = reWriter(word);
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            allWordsPrinter(copyAllWords, word);
        } else notavailable();
    }

    public void secondCase(String word, String spch) {
        word = reWriter(word);
        Integer n = 0;
        //check before here
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            errorChecker(spch, 2);
            handlerHelper(word, spch, 1, copyAllWords);
            allWordsPrinter(copyAllWords, word); //prints the word
        } else notavailable();
    }


    public void thirdCase(String word, String spch, String d_r) {

        word = reWriter(word);
        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            errorChecker(spch, 2);
            handlerHelper(word, spch, 1, copyAllWords);
            errorChecker(d_r, 3);
            handlerHelper(word, d_r, 2, copyAllWords);
            allWordsPrinter(copyAllWords, word);
        } else notavailable();
    }

    public void fourthCase(String word, String spch, String d_r, String reverse) {
        word = reWriter(word);

        if (allWords.containsKey(word)) {
            copyAllWords.put(word, allWords.get(word));
            errorChecker(spch, 2);
            handlerHelper(word, spch, 1, copyAllWords);
            errorChecker(d_r, 3);
            handlerHelper(word, d_r, 2, copyAllWords);
            errorChecker(reverse, 4);
            handlerHelper(word, reverse, 3, copyAllWords);
            allWordsPrinter(copyAllWords, word);
        } else notavailable();

    }

    // errorChecker will check if order of words inputted is right

    public void errorChecker(String finder, Integer n) {
        if (!spchType1.contains(finder) && n==2) {
            System.out.println("Speech error" + n + "attempt");
            //|
            //     <The entered 2nd parameter 'ok' is NOT a part of speech.>
            //     <The entered 2nd parameter 'ok' is NOT 'distinct'.>
            //     <The entered 2nd parameter 'ok' is NOT 'reverse'.>
            //     <The entered 2nd parameter 'ok' was disregarded.>
            //     <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>
        }
        else if(!distinct2.contains(finder) && n==3){
            System.out.println("Speech error" + n + "Attempt");
        }
        else if(!reverse3.contains(finder) && n==4){
            System.out.println("Speech error" + n + "Attempt");
        }


    }
    public void notavailable()
    {
        System.out.println("\t|\n \t<NOT FOUND> To be considered for the next release. Thank you.\n \t|");
        Menu.guidePrinter();
    }

    public String[] handler (String option, int n_list){
        Boolean checker = false;
        String[] holder = new String[2];
        String returner = "";
        switch (n_list){
            case 1: checker = spchType1.contains(option);
                returner = option;
                break;
            case 2: checker = distinct2.contains(option);
                returner = option;
                break;
            case 3: checker = reverse3.contains(option);
                returner = option;
                break;
        }
        holder[0] = checker.toString();
        holder[1] = returner;
        return holder;
    }
    public ArrayList<String[]> handlerHelper(String word, String spch, int n_list, HashMap<String, ArrayList<String[]>> copyAllWords){
        spch = spch.toLowerCase();
        String[] option = handler(spch,n_list);
        ArrayList<String[]> values = new ArrayList<>();
        if(option[0].equals("true") && option[1].equals("distinct"))
            copyAllWords = distinct(copyAllWords,word); //distinct
        else if(option[0].equals("true") && option[1].equals("reverse"))
            copyAllWords = reverse(copyAllWords, word); //reverse
        else if(option[0].equals("true"))
            copyAllWords = lookUp(copyAllWords, word,spch); //looks for def
        values = copyAllWords.get(word);
        return values;
    }
    public HashMap<String, ArrayList<String[]>> lookUp(HashMap<String, ArrayList<String[]>> copy, String word, String spch){
        word = reWriter(word);
        ArrayList<String[]> values = (ArrayList<String[]>) copy.get(word).clone();
        copy.replace(word, values);

        for (int i = 0; i < values.size(); i++) {
            if (!values.get(i)[0].equals(spch)) {
                values.remove(i); // This line will delete duplicated definition
                i--;
                continue;
            }
        }
        return copy;
    }

    public  HashMap<String, ArrayList<String[]>> reverse(HashMap<String, ArrayList<String[]>> copy, String word) {

        word = reWriter(word);
        ArrayList<String[]> values = (ArrayList<String[]>) copy.get(word).clone();
        Collections.reverse(values); //this line makes the list reversed
        copy.replace(word,values);
        return  copy;
    }
    public HashMap<String, ArrayList<String[]>> distinct(HashMap<String, ArrayList<String[]>> copy, String word) {
        word = reWriter(word);
        ArrayList<String[]> values = (ArrayList<String[]>) copy.get(word).clone();
        values = looper(values);
        copy.replace(word, values);
        return copy;

    }

    public ArrayList<String[]> looper(ArrayList<String[]> values) {
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

    public void allWordsPrinter(HashMap<String, ArrayList<String[]>> copy, String word) {
        ArrayList<String[]> values;
        word = reWriter(word);
        values = copy.get(word);
        System.out.println("\t|");
        for (int i = 0; i < values.size(); i++) {
            String spch = values.get(i)[0];
            String def = values.get(i)[1];
            System.out.println("\t " + word + " [" + spch + "] : " + def);
        }
        System.out.print("\t|\n");
    }

    // reWriter will take: ReVerSE adn will make it --> Reverse
    public String reWriter(String word) {
        word = word.toLowerCase();
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        return word;
    }

    // dataLoader reads all enums and uses word as key, and speech and definition as value.
    protected HashMap<String, ArrayList<String[]>> dataLoader() {
        //System.out.println("! Loading Data..."); //starts to load the data
        HashMap<String, ArrayList<String[]>> allWords = new HashMap<>();
        filler();
        ArrayList<String[]> values;
        System.out.println("! Loading Data..."); //starts to load the data
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

        return allWords;
    }
}



