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

    Node convertarrytobst(T[] arr, int start, int end){
        if(start>end) return null;

        int mid=(start+end)/2;
        Node<Integer> newnode= new Node(arr[mid]);
        newnode.setLeft(convertarrytobst(arr,start,mid-1));
        newnode.setRight(convertarrytobst(arr, mid+1,end));

        return newnode;
    }




    }



