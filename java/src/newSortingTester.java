import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class newSortingTester {
  // test on quick sort
  @Test
  public void testOne(){
    int[] a = {4, 5};
    newSorting test = new newSorting();
    test.quickSort(a);
    for(int i = 0; i < a.length; i ++){
      System.out.print(a[i] + " ");
    }
  }
  //test on new sorting
  @Test
  public void testTwo(){
    int[] a = {5, 4, 8, 3, 6, 2};
    newSorting test = new newSorting();
    test.newSorting(a, 10);
    for(int i = 0; i < a.length; i ++){
      System.out.print(a[i] + " ");
    }
  }
  //
  @Test
  public void testThree(){
    int[] a = {3, 7, 10};
    int[] b = {4, 8, 9};
    int[] c = new int[6];
    newSorting test = new newSorting();
    test.mergeSortedHalves(c, a, b);
    for(int i = 0; i < c.length; i ++){
      System.out.print(c[i] + " ");
    }
  }
}
