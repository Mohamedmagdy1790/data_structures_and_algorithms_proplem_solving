import static java.lang.Integer.max;
import java.util.AbstractMap;

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

    // Students suggestion: just count left and right and comapre
    AbstractMap.SimpleEntry<Boolean, Integer> _isPerfect(Node temp) {

        if(temp ==null) return new AbstractMap.SimpleEntry<>(false,0);

        if(isleaf(temp)) return new AbstractMap.SimpleEntry<>(true,1);

        var left =_isPerfect(temp.getLeft());
        var right =_isPerfect(temp.getRight());

        // left and right should be perfect and nodes are equal
        if(temp.getLeft()!=null && temp.getRight()!=null && (left.getValue() == right.getValue()))
            return new AbstractMap.SimpleEntry<>(true,   left.getValue()+right.getValue()+1);

        else return new AbstractMap.SimpleEntry<>(false,0);

    }

    Boolean isPerfect() {
        return _isPerfect(root).getKey();
    }













    int maxDepth(Node root) {
        if (root ==null) return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return max(l, r) + 1;
    }
    boolean isPerfect(Node temp,int maxdepth){
        if(temp == null) return false;

        //return false if currnt node height != 0 which is max depth true if equal
        if(isleaf(temp)) return maxdepth==0;
        //if me satisfy these  conditions then check  my left and my right and they must both satisfy these conditions
        if(temp.getLeft()!=null && temp.getRight() !=null)
            return isPerfect(temp.getLeft(),maxdepth-1) && isPerfect(temp.getRight(),maxdepth-1);
        else return false;

    }
    boolean is_perfect(){
        return isPerfect(root,maxDepth(root)-1);
    }





    int count(Node temp){
        if(temp ==null) return 0;

        return count(temp.left)+count(temp.right)+1;

    }
    //n2 time n memory
    boolean isPerfectCount(Node temp){
        if(temp ==null) return true;
        //don't need this statement  because temp ==null returns true
        //if(isleaf(temp))return true;

        if(count(temp.left) != count(temp.right))return false;

        return isPerfectCount(temp.left) && isPerfectCount(temp.right);

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



