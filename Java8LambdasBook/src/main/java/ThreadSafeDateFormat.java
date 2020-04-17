import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ThreadSafeDateFormat {


    private static final ThreadLocal<DateFormat> formatter = ThreadLocal.withInitial(SimpleDateFormat::new);

    private final DateFormat dateFormat;
    public ThreadSafeDateFormat(){
        dateFormat = formatter.get();
    }
    public static void main (String[] args){

    }
}
