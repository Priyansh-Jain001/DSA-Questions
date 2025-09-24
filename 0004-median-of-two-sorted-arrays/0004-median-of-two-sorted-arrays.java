class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0, j=0;

        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                list.add(nums1[i]);
                i++;
            }else{
                list.add(nums2[j]);
                j++;
            }
        }

        while(i<nums1.length){
            list.add(nums1[i]);
            i++;
        }

        while(j<nums2.length){
            list.add(nums2[j]);
            j++;
        }

        if(list.size()%2 != 0){
            int ans = list.get(list.size()/2);
            System.out.print(ans);
            return (double)ans;
        }else{
            int m = list.size()/2;
            int n = list.size()/2 - 1;

            double ans = ((double)list.get(n)+ (double)list.get(m))/2;
            return ans; 
        }

        // return 0.0;
    }
}