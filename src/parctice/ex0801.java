package parctice;

public class ex0801 {

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int index = start;

        int[] sorted = new int[arr.length];

        while ((i <= mid) && (j <= end)) {
            if (arr[i] < arr[j]) {
                sorted[index] = arr[i];
                index++;
                i++;
            } else {
                sorted[index] = arr[j];
                index++;
                j++;
            }
        }
        while (i <= mid) {
            sorted[index] = arr[i];
            index++;
            i++;
        }
        while (j <= end) {
            sorted[index] = arr[j];
            index++;
            j++;
        }
        for (int l = start; l <= end; l++) {
            arr[l] = sorted[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}
