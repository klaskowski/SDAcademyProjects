import java.util.HashMap;
import java.util.Map;

public class PostCodes {
    public static final Map<String, PostAreaCode> POST_CODES = new HashMap<>();
    PostAreaCode postAreaCode;
    static {
        POST_CODES.put("700001",new PostAreaCode("Iasi","Strada Strapungere Silvestru", 1,7));
        POST_CODES.put("700002",new PostAreaCode("Iasi","Strada Strapungere Silvestru", 9,11));
        POST_CODES.put("010017",new PostAreaCode("Bucuresti","Strada Edgar Quinet",1,1));
        POST_CODES.put("010018",new PostAreaCode("Bucuresti","Strada Edgar Quinet",2,2));
        POST_CODES.put("010019",new PostAreaCode("Bucuresti","Strada Biserica Enei",1,100));
        POST_CODES.put("300002",new PostAreaCode("Timisoara","Strada Blaga Lucian",2,3));
        POST_CODES.put("300001",new PostAreaCode("Timisoara","Bulevard Republicii", 2,8));
        POST_CODES.put("300004",new PostAreaCode("Timisoara","Piata Huniade Iancu",1,2));
        POST_CODES.put("300003",new PostAreaCode("Timisoara","Strada Enescu Ion",4,8));
        POST_CODES.put("400001",new PostAreaCode("Cluj","Cale Motilor",1,40));
        POST_CODES.put("400002",new PostAreaCode("Cluj","Strada Maior Petru",1,100));
        POST_CODES.put("400003",new PostAreaCode("Cluj","Piata Blaga Lucian",1,2));
        POST_CODES.put("500003",new PostAreaCode("Brasov","Strada Dobrogeanu Gherea",1,75));
        POST_CODES.put("500007",new PostAreaCode("Brasov","Strada Pietii",1,100));
        POST_CODES.put("500008",new PostAreaCode("Brasov","Piata Teatrului",2,3));
        POST_CODES.put("500009",new PostAreaCode("Brasov","Bulevard Eroilor",1,7));
        POST_CODES.put("600001",new PostAreaCode("Bacau","Strada Ipatescu Ana",1,3));
        POST_CODES.put("600002",new PostAreaCode("Bacau","Strada Ipatescu Ana",5,32));
        POST_CODES.put("600004",new PostAreaCode("Bacau","Strada Florilor",1,4));
        POST_CODES.put("600003",new PostAreaCode("Bacau","Strada Valea Alba",1,4));
    }

}
