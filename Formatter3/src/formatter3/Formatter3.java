package formatter3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter3 {

    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        String str = ft.format(new Date());
        System.out.println("Formatted Date: "+str);
        
        //parsing a given string
        str = "02/18/1995";
        ft = new SimpleDateFormat("MM/dd/yyyy");
        Date date = ft.parse(str);
        
        //this will print the date as per parsed string
        System.out.println("Parsed Date : " + date);
    }
    
}
