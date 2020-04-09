public class newSorting {
  // public
  public void newSorting(int[] A, int size){
    if(A.length <= size){
      quickSort(A);
    } else {
      int mid = (A.length / 2) - 1;
      int[] leftHalf = new int[mid + 1];
      int[] rightHalf = new int[A.length - (mid + 1)];

      for(int i = 0; i < leftHalf.length; i++){
        leftHalf[i] = A[i];
      }
      for(int i = 0; i < rightHalf.length; i++){
        rightHalf[i] = A[mid + 1 + i];
      }

      newSorting(leftHalf, size);
      newSorting(rightHalf, size);
      mergeSortedHalves(A, leftHalf, rightHalf);
    }
  }

  // private
  public void mergeSortedHalves(int[] A, int[] leftHalf, int[] rightHalf) {
    int leftIndex = 0;
    int rightIndex = 0;
    int mergePos = 0;

    while(leftIndex < leftHalf.length && rightIndex < rightHalf.length){
      if(leftHalf[leftIndex] <= rightHalf[rightIndex]){
        A[mergePos] = leftHalf[leftIndex];
        leftIndex++;
      } else {
        A[mergePos] = rightHalf[rightIndex];
        rightIndex++;
      }
      mergePos++;
    }

    while(leftIndex < leftHalf.length){
      A[mergePos] = leftHalf[leftIndex];
      leftIndex++;
      mergePos++;
    }
    while(rightIndex < rightHalf.length){
      A[mergePos] = rightHalf[rightIndex];
      rightIndex++;
      mergePos++;
    }
  }

  // private
  public void quickSort(int[] A){
    quickSort(A, 0, A.length - 1);
  }

  //private
  public void quickSort(int[] A, int startIndex, int endIndex) {
    // Base case: If there are 1 or zero elements to sort
    if (startIndex >= endIndex || (startIndex + 1 == endIndex && A[startIndex] < A[endIndex])) {
      return;
    }

    int partitionIndex = partition(A, startIndex, endIndex);

    quickSort(A, startIndex, partitionIndex);
    quickSort(A, partitionIndex + 1, endIndex);
  }

  // private
  public int partition(int[] A, int startIndex, int endIndex) {
    int pivot = A[startIndex];
    int less = startIndex + 1;
    int more = endIndex;

    while (less < more) {
      while (less <= endIndex && A[less] < pivot) {
        less++;
      }

      while (more >= startIndex && A[more] > pivot) {
        more--;
      }

      if (less < more) {
        int temp = A[less];
        A[less] = A[more];
        A[more] = temp;
      }
    }
    int temp = A[startIndex];
    A[startIndex] = A[more];
    A[more] = temp;

    return more;
  }
}

