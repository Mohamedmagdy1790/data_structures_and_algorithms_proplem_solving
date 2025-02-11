import java.util.ArrayList;

public class BST<T extends  Comparable<T>> {

   public Node root ;

    BST(){
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
                // temp.value < v
                else if (temp.getValue().compareTo(v) < 0) {
                    if(temp.getRight() ==null){
                        Node newnode =new Node<>(v);
                        temp.setRight(newnode);
                        return;
                    }
                    temp= temp.getRight();

                }
                //compare v with the currnt node if smaller go to the left node
                //temp.value> v
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

    Node<Integer> insert(Node temp, Integer value){
      if(temp==null)return new Node<>(value);

      if(temp.getValue().compareTo(value)>0) temp.setLeft(insert(temp.getLeft(), value));
      else if (temp.getValue().compareTo(value)<0) temp.setRight(insert(temp.getRight(), value));

      return temp;
    }

   int getMinimum(Node temp){
        if(isLeaf(temp)) return (int) temp.value;
        return getMinimum(temp.getLeft());
    }


    public boolean isLeaf(Node temp){
        if(temp.right==null && temp.left==null)return true;
        return false;
    }




        // i wiil get from it the succesor going backword until chain ends
     Boolean findChain(Integer value, Node temp, ArrayList<Node> array){
         array.add(temp);

        if(temp == null) return false;
        else if (temp.getValue() == value) return true;
            //compare value with the currnt node if bigger go to the right node
            //temp.value < value
        else if (temp.getValue().compareTo(value) <0) return findChain(value,temp.getRight(),array);
            //temp.value > value
        else if (temp.getValue().compareTo(value) >0) return findChain(value,temp.getLeft(),array);


        return false;
    }
    Boolean findChain2(Integer value, Node temp, ArrayList<Node> array){
        if(temp.getLeft() !=null) array.add(temp);

        if(temp == null) return false;
        else if (temp.getValue() == value) return true;
            //compare value with the currnt node if bigger go to the right node
            //temp.value < value
        else if (temp.getValue().compareTo(value) <0) return findChain2(value,temp.getRight(),array);
            //temp.value > value
        else if (temp.getValue().compareTo(value) >0) return findChain2(value,temp.getLeft(),array);


        return false;
    }

     //return last element and then removes it
     Node getNext(ArrayList<Node> array){
         if(array.size() ==0) return null;

         Node node = array.get(array.size()-1);
         array.remove(array.size()-1);
         return node;
     }


     Pair<Boolean,Integer> successor(Integer target) {
         ArrayList<Node> arrayList = new ArrayList<>();

         if (!findChain(target, root, arrayList)) return new Pair<>(false, -1);
         //get last elemnt in arraylist and delete it, which is the target
         Node child = getNext(arrayList);
         //does this node has right ?
         if (child.getRight() != null) return new Pair<>(true, getMinimum(child.getRight()));

         Node parent= getNext(arrayList);

         while (parent!=null && parent.getRight()==child){
             child=parent;
             parent=getNext(arrayList);
           }


        if(parent!=null) return new Pair<>(true,(Integer) parent.value);

        return new Pair<>(false,-1);
     }


    Pair<Boolean,Integer> successor_2(Integer target) {
        ArrayList<Node> arrayList = new ArrayList<>();

        if (!findChain2(target, root, arrayList)) return new Pair<>(false, -1);
        //get last elemnt in arraylist and delete it, which is the target
        Node node = getNext(arrayList);
        //does this node has right ?
        if (node.getRight() != null) return new Pair<>(true, getMinimum(node.getRight()));

        if(node.getRight() ==null) return new Pair<>(true,(Integer) node.value);

        return new Pair<>(false,-1);
    }


    }



