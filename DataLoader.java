import java.util.Scanner;

// Dictionary [] would return an array with all the Enums, they can be accessed through index
public class DataLoader extends Enum {
    Dictionary[] test = Dictionary.values(); //

    //Function to test DataLoader Class
    public void testDataLoader() {
        System.out.println(test[2]); // test[0] holds Book1
        System.out.println(test[0].def);// will print noun
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

}


