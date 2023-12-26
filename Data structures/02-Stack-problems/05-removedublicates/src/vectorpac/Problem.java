package vectorpac;

public class Problem {


    public String removeDublicates(String s){

        char[] arr =s.toCharArray();
        StringBuilder result =new StringBuilder();
        Stack<Character> stack =new Stack<>(20);
        for (int i=0; i< arr.length; i++){
            //if stack is empty push first char in string
            if(stack.IsEmptystack()){stack.push(arr[i]);}
            else if (arr[i] == stack.peek()){
               stack.pop();
            }
            else stack.push(arr[i]);

        }

        while(!stack.IsEmptystack()){
            result.append(stack.pop());
        }

        return result.toString();

    }
}
