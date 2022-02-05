public class Enum {


    enum Dictionary {
        Word1("Book", "noun", "test0"),
        Word2("Reverse", "noun", "test1"),
        Word3("Book", "adjective", "test2"),
        Reverse1("Book", "verb", "test3"),
        Reverse2("Book", "verb", "To be Updated"), //Testing
        Distinct("Book", "verb", "test4"),
        Distinct1("Book", "verb", "test5");

        String word, pos, def;

        Dictionary(String w, String p, String d)
        {
            word = w;
            pos = p;
            def = d;
        }
    }



}
