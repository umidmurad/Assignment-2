public class Enum {


    enum Dictionary {
        Word1("Book", "noun", "To be updated"),
        Word2("Book", "noun", "To be updated"),
        Reverse1("Reverse", "noun", "To be Updated"); //Testing

        String word, pos, def;

        Dictionary(String w, String p, String d)
        {
            word = w;
            pos = p;
            def = d;
        }
    }



}
