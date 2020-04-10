import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class newSortingTester {
  // This test case checks whether the newSorting method can sort an array when the size is larger than the length of the array.
  // This way, the newSorting automatically sends the array to quickSort.
  // This test case is important because newSorting depends on quickSort, so it needs to be verified that quickSort works.
  // The array of {5, 4, 8, 3, 6, 2} was chosen because they are all positive integers and they were purposefully placed out of order.
  // They were purposefully placed out of order in order to make sure that quickSort can sort it.
  // The array length is also even in order to test if the partitioning works in an array that begins with the same amount of values on the left and right.
  // This test did not work for many tries and the error stated that it was stack overflow.
  // In order to fix this, I tried tracing each step of what was supposed to happen in my algorithm, while simultaneously printing each step within the code.
  // This allowed me to see what was happening, and I saw that the values kept o being swapped even when they were in the right place.
  // In order to fix this, I added an additional base condition that would stop if there were only two values in the partition.
  // This helped fix the error and the array was sorted as expected.
  // This means that the newSorting method can sort arrays with positive integers and a size larger than the array length.
  @Test
  public void testOne(){
    int[] inputArray = {5, 4, 8, 3, 6, 2};
    int[] expectedArray = {2, 3, 4, 5, 6, 8};

    newSorting testOne = new newSorting();
    testOne.newSorting(inputArray, 7);

    assertArrayEquals(expectedArray, inputArray);
  }

  // This test case checks whether the newSorting method can sort an array when the size is smaller than the length of the array.
  // This was done in order to make sure that the base case, recursive calls, as well as the mergeSortedHalves method can be executed correctly.
  // The array used is exactly the same as the previous array in order to isolate the only variable change, which was the value of size.
  // The size value chosen was 1 because that is the smallest possible size an array can be while still containing a value.
  // Since the value is 1, the method newSorting will have to go through multiple recursive calls in order to reach the base case.
  // This test did not work at first and stated that there was an index out of bounds.
  // Since the previous test already checked quickSort, I assumed the problem was either in newSorting or in mergeSortedHalves.
  // This allowed me to find one problem in newSorting where I did not correctly declare the size of the two new arrays.
  // However, I was still getting the same error, which I was able to find and fix in mergeSortedHalves.
  // The error was that I was iterating both left and right indexes for the length of the full array, which was past their bounds.
  // After this edit, the test was able to pass.
  // This means that the newSorting method can sort arrays with a size smaller than the arrays length.
  @Test
  public void testTwo(){
    int[] inputArray = {5, 4, 8, 3, 6, 2};
    int[] expectedArray = {2, 3, 4, 5, 6, 8};

    newSorting testTwo = new newSorting();
    testTwo.newSorting(inputArray, 1);

    assertArrayEquals(expectedArray, inputArray);
  }

  // This test case checks that the newSorting method can sort arrays of length 2.
  // This test case was chosen because in the first test case, I added an additional base case including an array of length 2, but that did not take into consideration if the array was unsorted.
  // This test case used the array {9, 4} with its values being chosen randomly as long as it was unsorted.
  // The size chosen was 2 in order to allow for the array to be sent directly to quickSort.
  // This test case failed upon first try since the expected array was not achieved.
  // I tried fixing this by removing the previous addition to the base case made during testOne, but that only led to a StackOverflow error.
  // In order to fix this, I edited the base case addition by including the condition that the two elements are sorted.
  // This edit seemed to work successfully and the test case was able to pass.
  // This means that newSorting is able to sort arrays with just two elements.
  @Test
  public void testThree(){
    int[] inputArray = {9, 4};
    int[] expectedArray = {4, 9};

    newSorting testThree = new newSorting();
    testThree.newSorting(inputArray, 2);

    assertArrayEquals(expectedArray, inputArray);
  }

  // This test case checks that the newSorting method can sort arrays with negative values and odd lengths.
  // This test case was chosen because the newSorting method needs to be able to send a half to quickSort while still working on splitting the other half.
  // The size of 2 was chosen in order to ensure that one half of the array is automatically sent to quickSort upon the first separation.
  // The values in the array of {4, 3, 2, -7, 7} were chosen at random except for -7 and 7, which are purposefully the same number in order to make sure that they are correctly compared.
  // This test case is important because it is adding more criteria that the newSorting method needs to be able to handle other than just positive integers with even length arrays.
  // This test case was successful and passed on the first try.
  // This means that the newSorting method is able to sort arrays with odd length and negative values.
  @Test
  public void testFour(){
    int[] inputArray = {4, 3, 2, -7, 7};
    int[] expectedArray = {-7, 2, 3, 4, 7};

    newSorting testFour = new newSorting();
    testFour.newSorting(inputArray, 2);

    assertArrayEquals(expectedArray, inputArray);
  }

  // This test case checks that the newSorting method can handle duplicates of numbers within the array.
  // The array of {5, 2, 9, 0, -3, 5, 1, -7, 9} was chosen randomly with only verifying that a duplicate was present and that one of the duplicates was the pivot.
  // The size of 3 was chosen in order to make sure that the newSorting method was still partitioning the array correctly through its recursive calls in case an undetected error pops up.
  // This test was chosen because the while loop conditions in quickSort do not include a condition when the value is equal to the pivot, and this test would bring light if it was necessary.
  // This test is also important for duplicates within the rest of the array that may not be placed in their rightful location due to the lack of conditionals for them in the quickSort method.
  // This test did not pass at first. First, the array was not sorted.
  // The resulting array had some of the duplicates in the correct spot, but the other duplicate would be in a different part of the array.
  // In order to fix this, I tried adding the equals sign when the value on the left was equal to the pivot in the quickSort method.
  // However, this created a StackOverflow error.
  // I then printed out the state of the array after each swap in order to pinpoint the error, and I saw that values were being swapped when they were already in their rightful location.
  // This test case with duplicates inspired testThree in order to make sure that values are being swapped only when necessary.
  // Once the problem was fixed by including an additional condition to the quickSort base case when an array of size 2 is already sorted, this test case passed.
  // This test case is especially important because after all the previous tests, I was convinced that quickSort would work for any array, but that was not the case.
  // This test case passed at the end, so the newSorting method is able to handle arrays with duplicates.
  @Test
  public void testFive(){
    int[] inputArray = {5, 2, 9, 0, -3, 5, 1, -7, 9};
    int[] expectedArray = {-7, -3, 0, 1, 2, 5, 5, 9, 9};

    newSorting testFive = new newSorting();
    testFive.newSorting(inputArray, 3);

    assertArrayEquals(expectedArray, inputArray);
  }

  // This test case checks to see what would happen if the size sent to the newSorting method was less than 1.
  // I included this test in order to create an edge test case where the method would not work.
  // The array chosen for this test case is {9, 4, 3, 2, 7}, which was chosen randomly with no particular regard for the values since they have already been tested.
  // The size value of 0 was chosen because it is not possible to sort a value that is empty.
  // This test case produced a StackOverflow error.
  // I was not expecting this test case to pass, but in order for it to pass in the future, I added an extra conditional to the newSorting method.
  // This condition states that if the value of size is less than 1, an error message will be printed out and the rest of the method will not be executed.
  // This means that the array will stay in the same order and nothing will be done to it.
  // According to those conditions, the test was able to pass.
  @Test
  public void testSix(){
    int[] inputArray = {9, 4, 3, 2, 7};
    int[] expectedArray = {9, 4, 3, 2, 7};

    newSorting testSix = new newSorting();
    testSix.newSorting(inputArray, 0);

    assertArrayEquals(expectedArray, inputArray);
  }

  // This test case was designed to be an edge case since it sends an empty array to the newSorting method.
  // I chose this test case in order to have steps in place in case this occurs.
  // The chosen size for this method was 1 because there has already been a test case for when the size is less than 1.
  // This test case passed upon first try, which was unexpected.
  // This test case passed because it satisfied the base case in quick sort that returns when the start index, 0, is greater than the assigned end index of -1.
  // This means that the newSorting method is able to handle cases where the inputted array is empty.
  @Test
  public void testSeven(){
    int[] inputArray = {};
    int[] expectedArray = {};

    newSorting testSeven = new newSorting();
    testSeven.newSorting(inputArray, 1);

    assertArrayEquals(expectedArray, inputArray);
  }
}
