public class BT<T extends  Comparable<T>> {

   public Node root ;

    BT(){
        root=null;
    }


    void  add(T v){

        if(root==null){
            root=new Node<T>(v);
        }
        else  {

            Node<T> temp =root;
            while (temp != null) {

                //check  if the value you want to add already exists
                if (temp.getValue() == v) {
                    throw new RuntimeException("value already exists");
                }
                //compare v with the currnt node if bigger go to the right node
                else if (temp.getValue().compareTo(v) < 0) {
                    if(temp.getRight() ==null){
                        Node newnode =new Node<>(v);
                        temp.setRight(newnode);
                        return;
                    }
                    temp= temp.getRight();

                }
                //compare v with the currnt node if smaller go to the left node
                else if (temp.getValue().compareTo(v) > 0) {
                    if(temp.getLeft() ==null){
                        Node newnode =new Node<>(v);
                        temp.setLeft(newnode);
                        return;
                    }
                    temp= temp.getLeft();

                }
            }


        }

    }

    boolean isFull(Node temp){
        if(temp ==null) return false;
        if(isleaf(temp) ) return true;
        if(temp.getRight()==null && temp.getLeft() !=null || temp.getRight()!=null && temp.getLeft() ==null) return false;


        return isFull(temp.getLeft()) && isFull(temp.getRight());
    }

    boolean isfullme(Node temp){
        if(temp ==null) return false;
        if(isleaf(temp)) return true;
        //if me satisfy these three conditions then check  my left and my right and they must both satisfy these conditions
        if(!isleaf(temp) && (temp.getLeft()!=null && temp.getRight() !=null))
            return isfullme(temp.getLeft()) && isfullme(temp.getRight());
        else return false;

    }

    private boolean isleaf(Node temp) {
        if(temp.getLeft() ==null && temp.getRight()==null)return true;
        return false;
    }

    private void _printInOrder(Node temp){
          if(temp == null) return;
           _printInOrder(temp.getRight());
           _printInOrder(temp.getLeft());
           System.out.println(temp.getValue());
    }
    void printInOrder(){
        _printInOrder(root);
    }

    boolean exists(T v){
          Node temp =root;
          int count =0;
        while (temp != null) {
            if (temp.getValue() == v) {
                System.out.println("counter equal : "+ count);
                return true;
            }
            else if (temp.getValue().compareTo(v) < 0) {

                temp = temp.getRight();
            }

            else if (temp.getValue().compareTo(v) > 0) {

                temp = temp.getLeft();
            }
            count++;
        }
        return false;
    }

    Boolean existsInternalRecursion(T value, Node temp){

        if(temp == null) return false;
        else if (temp.getValue() == value) return true;
            //compare value with the currnt node if bigger go to the right node
        else if (temp.getValue().compareTo(value) <0) return existsInternalRecursion(value,temp.getRight());

        else if (temp.getValue().compareTo(value) >0) return existsInternalRecursion(value,temp.getLeft());
        return false;
        }

        boolean existsRecursion(T value){
         return existsInternalRecursion(value,root);
        }

    }



