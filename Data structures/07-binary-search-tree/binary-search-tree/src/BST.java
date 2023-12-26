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

    boolean exists(T value){
          Node temp =root;
          int count =0;
        while (temp != null) {
            if (temp.getValue() == value) {
                System.out.println("counter equal : "+ count);
                return true;
            }
            else if (temp.getValue().compareTo(value) < 0) {

                temp = temp.getRight();
            }

            else if (temp.getValue().compareTo(value) > 0) {

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
        //temp.value < value
        else if (temp.getValue().compareTo(value) <0) return existsInternalRecursion(value,temp.getRight());
        //temp.value > value
        else if (temp.getValue().compareTo(value) >0) return existsInternalRecursion(value,temp.getLeft());


        return false;
        }

        boolean existsRecursion(T value){
         return existsInternalRecursion(value,root);
        }

    }



