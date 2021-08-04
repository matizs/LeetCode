public class QuickSort {

    public static void main(String...msg){
        int[] array = new int[]{7,3,5,6,1,2,4};
        quickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }
    public static void quickSort(int array[], int left, int right) {
        if(left >= right) return;
        int middle = partition(array, left, right);

        quickSort(array, left, middle - 1);
        quickSort(array, middle, right);
    }

    private static int partition(int array[], int left, int right){
        int middle = (left + right) / 2;
        int midValue = array[middle];
        while (left <= right) {
            while (array[left] < midValue)
                left++;
            while (array[right] > midValue)
                right--;

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int array[], int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
