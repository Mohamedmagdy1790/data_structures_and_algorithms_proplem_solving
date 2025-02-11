import java.util.ArrayList;
import java.util.Objects;

public class PhoneHash {

    int buckets;
    ArrayList<ArrayList<PhoneEntry>> table;

    PhoneHash(int buckets) {
        this.buckets=buckets;
        //resize
        table = new ArrayList<>(buckets);

        // Initialize the inner ArrayLists
        for (int i = 0; i < buckets; i++) {
            table.add(new ArrayList<>());
        }
    }


    void put(PhoneEntry phoneEntry){
        //% to handele entries to the specified buckts
        //idx is the index where the key is mapped to
        int idx= phoneEntry.hash() % buckets;

        int idxsize=table.get(idx).size();

        //loop inside list
        // if name (key) already exsists then update it
        for (int i = 0; i < idxsize; ++i) {
            if (Objects.equals (table.get (idx).get (i).name, phoneEntry.name)) {
                table.get(idx).set(i, phoneEntry); // exist => update
                return;
            }
        }
        table.get(idx).add(phoneEntry);
    }

    void print_all() {
        for (int hash = 0; hash < buckets; ++hash) {
            if (table.get(hash).size() == 0)
                continue;

            System.out.println( "Hash " + hash + ": ");

            for (int i = 0; i < (int) table.get(hash).size(); ++i)
                table.get(hash).get(i).print();

            System.out.println();
        }
    }

}
