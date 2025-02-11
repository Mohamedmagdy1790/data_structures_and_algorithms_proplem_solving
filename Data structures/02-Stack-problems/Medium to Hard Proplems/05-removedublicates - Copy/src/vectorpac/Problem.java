package vectorpac;


public class Problem {
    void next_greater_num(int v[], int len) {
        // this stack will save positions of array that are not adjusteded with our requrments
        Stack<Integer> postition =new Stack<>(20);



        for (int i=0; i<len; i++){

            while (!postition.IsEmptystack() &&  v[i]> v[postition.peek()]) v[postition.pop()]=v[i];
                postition.push(i);
        }

        for (int i=0; i<len; i++){

            System.out.printf(v[i]+" ");
        }

    }


}
