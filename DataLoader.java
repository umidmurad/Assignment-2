// Dictionary [] would return an array with all the Enums, they can be accessed through index
public class DataLoader extends Enum {
    Dictionary[] test = Dictionary.values(); //

    //Function to test DataLoader Class
    public void testDataLoader() {
        System.out.println(test[2]); // test[0] holds Book1
        System.out.println(test[0].def);// will print noun
    }
}