public class Enum {


    enum Dictionary {
        Book1("Book", "noun", "To be updated"),
        Book2("Book", "noun", "To be updated");

        String word, pos, def;

        Dictionary(String w, String p, String d)
        {
            word = w;
            pos = p;
            def = d;
        }
    }



}
