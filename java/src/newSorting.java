public class newSorting {
  public void newSorting(int[] A, int size){
    // Check whether the value of size is valid.
    if(size < 1){
      System.out.println("Error. Invalid size.");
      return;
    }

    // Base Case.
    // Send the array to quickSort if it is less than or equal to the size.
    if(A.length <= size){
      quickSort(A);
    } else {
      // Find the middle index.
      // The middle is subtracted by 1 in the case of arrays with an even length.
      // This keeps the number of elements on the left and right equal.
      int mid = (A.length / 2) - 1;
      // Declare the left and right arrays.
      int[] leftHalf = new int[mid + 1];
      int[] rightHalf = new int[A.length - (mid + 1)];

      // Manually copy the values from the larger array onto each of the halves.
      for(int i = 0; i < leftHalf.length; i++){
        leftHalf[i] = A[i];
      }
      // Begin copying after the middle index for the right half.
      for(int i = 0; i < rightHalf.length; i++){
        rightHalf[i] = A[mid + 1 + i];
      }

      // Recursively call newSorting with the left and right halves.
      newSorting(leftHalf, size);
      newSorting(rightHalf, size);
      // Merge the two sorted halves.
      mergeSortedHalves(A, leftHalf, rightHalf);
    }
  }

  private void mergeSortedHalves(int[] A, int[] leftHalf, int[] rightHalf) {
    // Begin all the indexes at 0.
    int leftIndex = 0;
    int rightIndex = 0;
    int mergePos = 0;

    // Iterate through both the left and right until the end of one of the arrays is reached.
    while(leftIndex < leftHalf.length && rightIndex < rightHalf.length){
      // Add the value in the left array to the merged array if it is smaller than the value in the right array.
      if(leftHalf[leftIndex] <= rightHalf[rightIndex]){
        A[mergePos] = leftHalf[leftIndex];
        // Increment the left index.
        leftIndex++;
      } else {
        // Add the value in the right array to the merged array if it is smaller than the value in the left array.
        A[mergePos] = rightHalf[rightIndex];
        // Increment the left index.
        rightIndex++;
      }
      // Increment the merged index after a value was added to it.
      mergePos++;
    }

    // Add the remaining values of the left array to the merged array if the right array reached its end.
    while(leftIndex < leftHalf.length){
      A[mergePos] = leftHalf[leftIndex];
      leftIndex++;
      mergePos++;
    }
    // Add the remaining values of the right array to the merged array if the left array reached its end.
    while(rightIndex < rightHalf.length){
      A[mergePos] = rightHalf[rightIndex];
      rightIndex++;
      mergePos++;
    }
  }

  private void quickSort(int[] A){
    // Begin the recursive quickSort call.
    quickSort(A, 0, A.length - 1);
  }

  private void quickSort(int[] A, int startIndex, int endIndex) {
    // Base case.
    // Return if there are 1 or two sorted elements to sort.
    if (startIndex >= endIndex || (startIndex + 1 == endIndex && A[startIndex] < A[endIndex])) {
      return;
    }

    // Find the index of the partition.
    int partitionIndex = partition(A, startIndex, endIndex);

    // Recursively call quickSort with the left and right half.
    quickSort(A, startIndex, partitionIndex);
    // Right half begins one index after the partitioned index.
    quickSort(A, partitionIndex + 1, endIndex);
  }

  private int partition(int[] A, int startIndex, int endIndex) {
    // Declare the pivot as the first index.
    int pivot = A[startIndex];
    // Declare less as the index right after the pivot.
    int less = startIndex + 1;
    // Declare more as the very last index.
    int more = endIndex;

    // Check that the value less has not iterated past the value more and vice versa.
    while (less < more) {
      // Iterate until a value on the left that is more than the pivot is found.
      while (less <= endIndex && A[less] < pivot) {
        less++;
      }

      // Iterate until a value on the right that is less than the pivot is found.
      while (more >= startIndex && A[more] > pivot) {
        more--;
      }

      // Swap the two values as long as less has not iterated past more.
      if (less < more) {
        int temp = A[less];
        A[less] = A[more];
        A[more] = temp;
      }
    }
    // Swap the value in the pivot with the value in the index more.
    int temp = A[startIndex];
    A[startIndex] = A[more];
    A[more] = temp;

    // Return the index more as the division between the low and high partition.
    return more;
  }
}

