class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
   
	  if(arr  == null || arr.length == 0) return new int[]{};

	  int[]  squares = new int[arr.length];
	  int start = 0, end = arr.length - 1, high = arr.length - 1;

	  while(start <=end){

		  int left  = arr[start] * arr[start];
		  int right = arr[end] * arr[end];

		  if(left >= right){
                  
			  squares[high--] = left;
			  start++;
	          } else{

			  squares[high--] = right;
			  end--;
	          }
          }
  }
  return squares;
}  
