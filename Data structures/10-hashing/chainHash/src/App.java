import java.util.ArrayList;



class PhoneEntry {
	final static int INTERNAL_LIMIT = 65407;
	String name;			// key
	String phone_number;	// data

	int hash() {
		return hash_string(name, INTERNAL_LIMIT);
	}

	int hash_string(String str, int n) {
	long  nn = n;
	long  sum = 0;
	for (int i = 0; i <  str.length(); ++i)
		sum = (sum * 26 + str.charAt(i) - 'a') % nn;
	return (int) (sum % nn);
}

    PhoneEntry(String name, String phone_number) {
        this.name=name;
        this.phone_number=phone_number;
			 
	}

	void print() {
		System.out.println("(" + name + ", " + phone_number + ")  ");  ;
	}
};


class Phone_hash{
    int buckets;
    ArrayList<ArrayList<PhoneEntry>> table = new ArrayList<>();

    Phone_hash(int buckets) {
        this.buckets=buckets;
        //resize
		table.ensureCapacity(buckets);
	}


    void put(PhoneEntry phoneEntry){
        //% to handele entries to the specified buckts
        //idx is the index where the key is mapped to
         int idx= phoneEntry.hash() % buckets;
         int idxsize=table.get(idx).size();

         for (int i = 0; i < idxsize; ++i) {
			if (table.get(idx).get(i).name == phoneEntry.name) {
				table.get(idx).add(i,phoneEntry); // exist => update
				return;
			}
		}
        table.get(idx).add(idxsize, phoneEntry);

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






public class App {
    public static void main(String[] args) throws Exception {
        PhoneEntry pe =new PhoneEntry("MOHAMED", "01124030505");
        Phone_hash ph =new Phone_hash(30);
        ph.put(pe);
        ph.print_all();
    }
}
