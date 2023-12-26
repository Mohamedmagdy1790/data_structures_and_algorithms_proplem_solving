class NodeData {
    Integer num;
    int freq;
    public NodeData(int n) {
        num = n;
        freq = 0;
    }
    public void visit() {
        System.out.printf("%d ", num);
    }
} //end class NodeData