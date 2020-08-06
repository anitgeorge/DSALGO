

public class MergeSort{

    public void sort(int arr[]){

        if(arr == null || arr.length == 0)
           return;
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end){

       if(start >= end)
          return;
       int mid = start + (end - start) / 2;
       sort(arr, start, mid);
       sort(arr, mid + 1, end);
       merge(arr, start, mid, end);
    }

    private void merge(int[] arr, int start, int mid, int end){

        int[] L = new int[mid - start + 1];
        int[] R = new int[end - mid];

        int k = start;
        for(int i = 0; i < L.length; i++)
           L[i] = arr[k + i];
        k = mid + 1;
        for(int j = 0; j < R.length; j++)
           R[j] = arr[k + j];

        int i = 0, j = 0;
        k = start;
        while(i < L.length && j < R.length){
          if(L[i] <= R[j]){

              arr[k++] = L[i++];
          } else{

              arr[k++] = R[j++];
          }
        }

        while(i < L.length)
           arr[k++] = L[i++];
        while(j < R.length)
           arr[k++] = R[j++];
    }

    public static void main(String[] args){

        int arr[]     = new int[]{5, 10, -10, 8, 18, 0, 16};
        MergeSort obj = new MergeSort();
        obj.sort(arr);
        for(int num : arr)
           System.out.print(num + " ");
    }
}
