/*
 * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
 * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
 */

class NumberRange{

   public int[] findNumberRange(int[] arr, int key){

      int[] result = new int[]{-1, -1};
      if(arr == null || arr.length == 0)
	  return result;
      if(key < arr[0] || key > arr[arr.length - 1])
	  return result;
      result[0] = search(arr, key, false);
      if(result[0] != -1)
	  result[1] = search(arr, key, true);
      return result;
   }

   private int search(int[] arr, int key, boolean flag){

      int index = -1, start = 0, end = arr.length - 1, mid = 0;
      while(start <= end){

	 int mid = start + (end - start) / 2;
	 if(arr[mid] > key)
	    end = mid - 1;
	 else if(arr[mid] < key)
	    start = mid + 1;
	 else{
            index = mid;
	    if(flag == true)
		start = mid + 1;
	    else
		end   = mid - 1;
         }
      }
      return index;
   }
}
