import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        PhoneHash table =new PhoneHash(2);

        table.put(new PhoneEntry("mostafa", "604-401-120"));
        table.put(new PhoneEntry("mostafa", "604-401-777"));	// update
        table.put(new PhoneEntry("ali", "604-401-343"));
        table.put(new PhoneEntry("ziad", "604-401-17"));


        table.print_all();


    }
}
