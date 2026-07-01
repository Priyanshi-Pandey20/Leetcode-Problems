import java.util.*;
import java.util.Arrays;
public class practice1 {
    public int majorityElement(int[] nums){
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

    public int majorityElement1(int[] nums){
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
     

public static void main(String[] args){
    int[] nums = {1,2,3,1,3,3,3,3};
    practice1 obj = new practice1();
    int ans = obj.majorityElement1(nums);
    System.err.println(ans);



}
}

