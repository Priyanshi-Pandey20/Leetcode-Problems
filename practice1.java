import java.util.*;
public class practice1 {
    public int majorityElement(int[] nums){ // O(N2)
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int freq = 0;
            for(int j = 0;j<n;j++){
                if(nums[i] == nums[j]){
                    freq++;
                }

            }
            if(freq > n/2){
              return nums[i];
            }

        }
        return -1;
    }

    public int majorityElement1(int[] nums){ //O(LOGN)
        Arrays.sort(nums);
        int n = nums.length;
        int freq = 1,ans = nums[0];
        for(int i = 1;i<n;i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }else{
                if(freq > n/2){
                    return ans;
                }
                ans = nums[i];
                freq = 1;
            }
        }
        if(freq > n/2){
            return ans;
        }
        return -1;

    }

    public int mooreVotingAlgo(int[] nums){ //O(N)
        int freq = 0,ans = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(freq == 0){
                ans = nums[i];
            }
            if(ans == nums[i]){
                freq++;
            }else{
                freq--;
            }
        }
        int count = 0;
        for(int val = 0;val<n;val++){
            if(val == ans){
                count++;
            }

        }
        if(count > n/2){
            return ans;
        }else{
            return -1;
        }
        
    }

    public int[] findMissingAndRepeatedValues(int[][] grid){
        Set<Integer> set = new HashSet<>();
        int n = grid.length;
        int a = -1, b= -1;
        int actualSum = 0, expSum = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                actualSum += grid[i][j];

                if(set.contains(grid[i][j])){
                    a = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }
        expSum = (n * n) * (n * n + 1)/2;
        b = expSum + a - actualSum;
        return new int[] {a,b};
    }

    public void mergeSort(int[] nums1,int m , int[] nums2, int n){
        int idx = m + n -1, i = m-1,j = n-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                nums1[idx--] = nums1[i--];
             
            }else{
                nums1[idx--] = nums2[j--];
                
            }
        }
        while( j>=0){
            nums1[idx--] = nums2[j--];
        }
    }
public static void main(String[] args){
    int[] nums1 =  {1,2,3,0,0,0};
    int[] nums2 = {2,5,6};
    int n = 3, m=3;
    practice1 obj = new practice1();
    obj.mergeSort(nums1,m,nums2,n);
    System.out.println(Arrays.toString(nums1));
}
}

