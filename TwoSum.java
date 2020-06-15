// Problem :https://leetcode.com/problems/two-sum/
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution(nums,target)));
        System.out.println(Arrays.toString(basicSolution(nums,target)));
    }
    
    // T(n) - O(n^2)
    public static int[] basicSolution(int[] nums, int target){
        int[] res  = new int[2];
        for(int i=0; i<nums.length-1; i++) {
            for(int j=1; j<nums.length; j++ ) {
                if(i!=j && (nums[i]+ nums[j] == target)) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
    // T(n) - O(n)
    public static int[] solution(int[] nums, int target){
        int[] res = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(hm.containsKey(diff)) {
                res[0] = hm.get(diff);
                res[1] = i;
                return res;
            } else {
                hm.put(nums[i], i);
            }
        }
        return res;
    }
}
