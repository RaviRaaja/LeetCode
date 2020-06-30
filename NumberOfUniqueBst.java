class FindNumberOfUniqueBST {
    public int numTrees(int n) {
        int[] arr = new int[n+1];
        return helper(arr, n);
    }
    
    private int helper(int[] arr, int n) {
        int res = 0;
        
        //base condition
        if(n==0 || n==1) return 1;
        
        for(int i=0; i<n; i++) {
            
            if(arr[i] == 0) arr[i] = helper(arr, i);
                
            if(arr[n-i-1] == 0) arr[n-i-1] = helper(arr, n-i-1);
            
            res += arr[i] * arr[n-i-1];
        }
        
        return res;
    }
}
