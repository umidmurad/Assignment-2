import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Dictionary [] would return an array with all the Enums, they can be accessed through index
public class DataLoader extends Enum {
    Dictionary[] enums = Dictionary.values(); //

    //Function to test DataLoader Class
    public void testDataLoader() {
        System.out.println(enums[2]); // test[0] holds Book1
        System.out.println(enums[0].def);// will print noun
    }
    // first case is for when only word is inputted
    public void firstCase(String word){

    }
    // word and search option i.e reverse, distinct, noun, etc
    public void secondCase(String word, String spch){

    }

    public void thirdCase(String word, String spch, String distinct){

    }
    public void fourthCase(String word, String spch, String distinct, String reverse){

    }
    // errorChecker will check if order of words inputted is right
    public void errorChecker(){

    }
    public void reverse(){
        // just overwrite compareTo() method, look it up its very ez to revert this way
    }
    public void distinct(){
    }



    // dataLoader reads all enums and uses word as key, and speech and definition as value.
    protected HashMap<String,ArrayList<String []>> dataLoader(){
        System.out.println("! Loading Data..."); //starts to load the data
        HashMap<String,ArrayList<String []>> allWords = new HashMap<>();
        ArrayList<String[]> values;
        String[] spchAndDef = new String[2]; //spchAndDef array holds pos and definition
        int calc=0; //will keep track of definitions
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

        for (String keyword:allWords.keySet() //finds the definition amount.
             ) {
            ArrayList<String[]> values2 = allWords.get(keyword);
            calc+= values2.size();
        }
        System.out.println("\n===== Dictionary 340 Java =====\n----- Keywords: " + allWords.size() + "\n----- Definitions: " +calc +"\n");

        System.out.println(allWords.get("Book").get(2)[0]); // line not necessary just to test logic
        return allWords;} // allWords contain: Key (word), and as value an ArrayList<String[]>
    // so for example: allWords.get("Book") will return you an ArrayList full of String arrays
    // The String arrays contain speech and def
    // So allWords.get("Book")=> ArrayList(                         )




}


