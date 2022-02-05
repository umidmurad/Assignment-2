public class Enum {


    enum Dictionary {
        Word1("Book", "noun", "test1"),
        Word2("Book", "noun", "test2"),
        Word3("Book", "adjective", "test3"),
        Reverse1("Book", "verb", "test2"),
        Reverse2("Book", "verb", "To be Updated"), //Testing
        Distinct("Book", "verb", "test2");

        String word, pos, def;

        Dictionary(String w, String p, String d)
        {
            word = w;
            pos = p;
            def = d;
        }
    }



}
