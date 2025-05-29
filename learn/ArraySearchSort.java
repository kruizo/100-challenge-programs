public class ArraySearchSort {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }
            
            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            } 
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        
        // If the element is not present in the array
        return -1;
    }
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2; // Finding the middle of the array
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[arr.length - mid];

            // Dividing the array into two halves
            System.arraycopy(arr, 0, leftHalf, 0, mid);
            System.arraycopy(arr, mid, rightHalf, 0, arr.length - mid);

            // Sorting the first half
            mergeSort(leftHalf);
            // Sorting the second half
            mergeSort(rightHalf);

            // Merging the sorted halves
            int i = 0, j = 0, k = 0;
            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    arr[k] = leftHalf[i];
                    i++;
                } else {
                    arr[k] = rightHalf[j];
                    j++;
                }
                k++;
            }

            // Checking if any element was left
            while (i < leftHalf.length) {
                arr[k] = leftHalf[i];
                i++;
                k++;
            }
            while (j < rightHalf.length) {
                arr[k] = rightHalf[j];
                j++;
                k++;
            }
        }
    }
    void quicksort(int[] arr, int low, int high)
	{
		if(low >= high)
		{
			return;
		}
		

		int pivot = arr[high];
		int greater_piv = low;
		int lower_piv = high;
		
		while(greater_piv < lower_piv)
		{
			while(arr[greater_piv] <= pivot && greater_piv < lower_piv)
			{
				greater_piv++;
			}
			while(arr[lower_piv] >= pivot && greater_piv < lower_piv)
			{
				lower_piv--;
			}

			swap(arr, lower_piv, greater_piv);

		}	
		swap(arr, greater_piv, high);
		
		quicksort(arr, greater_piv+1, high);
		quicksort(arr, 0, greater_piv-1);	
	}

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swapping elements
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
	void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	
	}
	public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int target = 10;
        
        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not present in the array");
        }
    }
}
