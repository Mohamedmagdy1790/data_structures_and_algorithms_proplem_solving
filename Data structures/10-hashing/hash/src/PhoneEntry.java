

public class PhoneEntry {
    final static int INTERNAL_LIMIT = 65407;
    String name;			// key
    String phone_number;	// data

    PhoneEntry(String name, String phone_number) {
        this.name=name;
        this.phone_number=phone_number;

    }

    int hash() {
        return hash_string(name);
    }

    int hash_string(String str) {
        int  nn = PhoneEntry.INTERNAL_LIMIT;
        int  sum = 0;
        for (int i = 0; i <  str.length(); ++i)
            sum = (sum * 26 + str.charAt(i) - 'a') % nn;
        return (int) ((sum) % nn);
    }


    void print() {
        System.out.println("(" + name + ", " + phone_number + ")  ");  ;
    }
}
