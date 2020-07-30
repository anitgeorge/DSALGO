/**
 * Order Agnostic
 *
 */

class BinarySerach{

   public int binarySearch(int[] arr, int key){

      if(arr == null || arr.length == 0)
	 return -1;
      boolean isAscending = false;
      if(arr[0] > arr[arr.length - 1]){
	   if(key > arr[0] || key < arr[arr.length - 1])
		 return -1;
      }
      else{
	  if(key < arr[0] || key > arr[arr.length - 1])
	    return -1;
	  isAscending = true; 
      }

      int start = 0, end = arr.length - 1, mid = 0;
      while(start <= end){
        
	  mid = start + (end - start) / 2;
	  if(arr[mid] == key)
		  return mid;
	  if(isAscending == true){

	     if(k < arr[mid])
		  end   = mid - 1;
	     else
		  start = mid + 1;
          }
	  else {
             if(key < arr[mid])
		 start  = mid + 1;
	     else
		 end    = mid - 1;
          }
      }

      return -1;
   }
}
