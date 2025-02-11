package vectorpac;


public class Problem {

  

    void next_greater_num(int v[], int len) {
        // Stack if all positions we are waiting for future answer for the,
        Stack<Integer> pos =new Stack<>(len);

        /*
         * Reverse thinking
         * 	Instead of finding the next greater of an element
         * 	Use an element to find all items it is greater than them
         *
         * We will add each new element in the stack waiting for its next greater
         *
         * Given a new number, iterate on all previous in the stack
         * 	and mark my self as their next great
         * 	but stop once found a number >= me
         * 	why? because I can't be used for more numbers (he is better than me)
         *
         * 	Example: {30, 20, 10, 7, 8, 15}
         * 	Assume stack has now positions for { 30, 20, 10, 7}
         * 	Now we have 8: 8 pops from stack 7 as it is > than it, but stop at 10
         * 	Now we have 15: 15 pops from stack 8, 10 as it is > than it, but stop at 20
         * 	and so on
         *
         * O(n) time! We iterate on numbers ~twice
         */
        for (int i = 0; i < (int) len; ++i) {
            while (!pos.IsEmptystack() && v[i] > v[pos.peek()])
                v[pos.pop()] = v[i];
            pos.push(i);
        }
        // all items in the stack are not answered
        while (!pos.IsEmptystack())
            v[pos.pop()] = -1;

        for (int i = 0; i < (int) len; ++i)
            System.out.println( v[i] +" "+"\n");;


    }


}
