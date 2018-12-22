
/**
 * This class includes two private instance Strings variables for 
 * representing the type of request that indicates where 
 * to search in the title having one of three values: (“start”, ”end”, or “any”)
 * and indicating the phrase to search for in the title of the earthquake.
 * 
 * This class also has a constructor to initialize those variables, 
 * and a satisfies method that returns true if the phrase is found 
 * at the requested location in the title.
 * 
 * @author pabl0cesar
 */
public class PhraseFilter implements Filter {
    private String type,phrase,name;
    
    public PhraseFilter(String type, String phrase, String name){
        this.name = name;
        this.type = type;
        this.phrase = phrase;
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(type.equals("start")){return qe.getInfo().startsWith(phrase);}
        if(type.equals("end")){return qe.getInfo().endsWith(phrase);}
        if(type.equals("any")){return qe.getInfo().contains(phrase);}
        return false;
    }
    
    public String getName(){
        return name;
    }
}
