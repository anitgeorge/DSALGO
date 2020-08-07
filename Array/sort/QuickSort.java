public class QuickSort{

    private void swap(int[] arr, int i1, int i2){

      int temp = arr[i1];
      arr[i1]  = arr[i2];
      arr[i2]  = temp;
    }

    private int partition(int arr[] , int low, int high){

        int pivot = arr[high];
        int i = low - 1, j = low;
        for(; j< high; j++)
          if(arr[j] <= pivot)
             swap(arr, j, ++i);
        swap(arr, ++i, high);
        return i;
    }

    public void sort(int[] arr, int low, int high){

        if(low >= high)
           return;
        int part = partition(arr, low, high);
        sort(arr, low, part - 1);
        sort(arr, part + 1, high);
    }

    public static void main(String[] args){

        int arr[]     = new int[]{5, 10, -10, 8, 18, 0, 16};
        QuickSort obj = new QuickSort();
        obj.sort(arr, 0, arr.length - 1);
        for(int num : arr)
           System.out.print(num + " ");
    }
}
