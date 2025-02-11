public class Main {
    public static void main(String[] args) {
        Solution s =new Solution();
        int[] arr ={1,3,6,8,10,17,19};
        int sol= s.binarySerach(arr,0,arr.length,5);

        System.out.println(sol);
    }
}