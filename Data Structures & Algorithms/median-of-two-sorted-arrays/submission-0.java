class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0 && nums2.length==0)
            return 0;
        int id1 = 0, id2 = 0, index = 0;
        int[] common = new int[nums1.length + nums2.length];
        while(id1<nums1.length && id2<nums2.length){
            if(nums1[id1] < nums2[id2]){
                common[index++] = nums1[id1++];
            } else {
                common[index++] = nums2[id2++];
            }
        }

        while(id1<nums1.length){
            common[index++] = nums1[id1++];
        }

        while(id2<nums2.length){
            common[index++] = nums2[id2++];
        }

        int mid = (common.length-1)/2;
        if(common.length%2 != 0){
            return common[mid];
        } else
            return (double)(common[mid]+common[mid+1])/2;
    }
}
