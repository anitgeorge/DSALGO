public class BubbleSort{

   public void sort(int[] arr){

       if( arr == null || arr.length == 0)
          return;
       for(int  i = 1; i < arr.length; i++){

            for(int j = 0; j < i; j++){

                if( arr[j] > arr[i]){

                    int temp = arr[i];
                    arr[i]   = arr[j];
                    arr[j]   = temp;
                }
            }
      }
      for(int num : arr)
         System.out.print(num + " ");
   }

   public static void main(String[] args){

       int arr[]     = new int[]{5, 10, -10, 8, 18, 0, 16};
       BubbleSort obj = new BubbleSort();
       obj.sort(arr);
   }
}
