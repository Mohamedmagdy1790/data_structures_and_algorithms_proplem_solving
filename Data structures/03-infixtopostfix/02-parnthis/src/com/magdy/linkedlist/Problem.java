package com.magdy.linkedlist;

public class Problem {

   //handling only + _ *   /
     int precedence(char c){
         if(c == '+'|| c=='-' ) return 1;
         else if(c == '*'|| c=='/') return 2;
         return 0;
    }


  String InfixToPostfixWithParenthis(String infix){

      StringBuilder postfix =new StringBuilder();
      Stack<Character> operators=new Stack<>();


      for(int i=0; i<infix.length(); i++){
          if (Character.isDigit(infix.toCharArray()[i] )) postfix.append(infix.toCharArray()[i]);
          else if (infix.toCharArray()[i] == '(') operators.push(infix.toCharArray()[i]);
          else if (infix.toCharArray()[i] ==')') {
              while (operators.peek() != '(') postfix.append(operators.pop());
              operators.pop();
          }
          else{
           while((!operators.isEmpty()) &&  (precedence(operators.peek()) >= precedence(infix.toCharArray()[i]) )) postfix.append(operators.pop());
           operators.push(infix.toCharArray()[i]);
          }
          }

      while (!operators.isEmpty()) postfix.append(operators.pop());


         return postfix.toString();
      }



  }




