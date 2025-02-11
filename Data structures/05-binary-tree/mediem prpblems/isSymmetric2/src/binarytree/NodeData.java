package binarytree;

class NodeData {
    String str;
    public NodeData(String s) {
        str = s;
    }
    public void visit() {
        System.out.printf("%s ", str);
    }
} //end class NodeData