// Thanks to @echoxiaolee for suggesting this solution.

// example:
// Values ->  1 2 3 4 3
// Indexes -> 0 1 2 3 4

// In linked list representation as below

class FloydCycleDetection {
	public int findDuplicate(int[] nums){
		if (nums.size() > 1)
		{
			int slow = nums[0];
			int fast = nums[nums[0]];
			while (slow != fast)
			{
				slow = nums[slow];
				fast = nums[nums[fast]];
			}

			fast = 0;
			while (fast != slow)
			{
				fast = nums[fast];
				slow = nums[slow];
			}
			return slow;
		}
		return -1;
	}
}

// My solution is as below
// I have solution that modifys the given array.

class Solution {
    public int findDuplicate(int[] nums) {
        for(int i : nums) {
            if(nums[Math.abs(i)] >= 0) {
                nums[Math.abs(i)] = -nums[Math.abs(i)];
            } else {
                return Math.abs(i);
            }
        }
        
        return 0;
    }
}
