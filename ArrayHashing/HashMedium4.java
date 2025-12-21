class HashMedium4 {
    /**
     * myFirst solution, calculating the total product of all elements in the
     * array while keeping track of the number of zeros. If there are more
     * than one zero, the result is all zeros. If there is exactly one zero,
     * the result is zero for all positions except for the position of the zero
     * in the input array, which is the total product of all non-zero elements.
     * If there are no zeros, the result for each position is the total product
     * divided by the element at that position.
     * @param nums input array
     * @return array where each element is the product of all other elements
     */
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        int zeroCount = 0;
        int posZero = -1;
        int[] result = new int[nums.length];
        for (int i= 0; i < nums.length; i++){
            int num = nums[i];
            if (num == 0){
                if (++zeroCount > 1) return result;
                posZero = i;
            }
            else totalProduct *= num;
        }
        if (zeroCount == 1){
            result[posZero] = totalProduct;
            return result;
        }
        for (int i = 0; i < nums.length; i++){
            result[i] = totalProduct / nums[i];
        }
        return result;
    }

    // Other solutions can be made by, for example,
    // 1. Using two auxiliary arrays to store the products of all elements
    //    to the left and right of each index, and then multiplying these
    //    two arrays to get the final result.
    // 2. Using a single pass to calculate the left products and then
    //    another pass to calculate the right products while updating
    //    the result array in place.
}