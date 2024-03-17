package suanfa.test;

public class T240 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(searchMatrix1(matrix,30));

    }

    //1、直接寻找
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] nums : matrix) {
            for (int num :nums) {
                if(num == target){
                    return true;
                }
            }
        }
        return false;
    }

    //2、二分法
    public static boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] arrays : matrix) {
            int search = search(arrays,target);
            if(search > 0){
                return true;
            }
        }
        return false;
    }

    private static int search(int[] arrays,int target) {
        int left = 0;
        int right = arrays.length-1;

        while (left <= right){
            int mid = (left + right) / 2;
            int num = arrays[mid];
            if(num == target){
                return mid;
            }else if(num > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }

    // 贪心-
    public boolean searchMatrix2(int[][] matrix, int target) {
        return false;
    }
}
