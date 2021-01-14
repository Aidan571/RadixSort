public class Radix{
  public static int nth(int n, int col){
    n = n / (int)Math.pow(10, col);
    return Math.abs(n % 10);
  }

  public static int length(int n){
    if(n == 0){
      return 1;
    }
    else{
      return (int) (Math.log10(n) + 1);
    }
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for(int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int a = 1;
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int g = 0; g < 10; g++){
      buckets[g] = new SortableLinkedList();
    }
    for(int i = 0; i < a; i++){
      while(data.size() > 0){
        int holder = data.remove(0);
        //calculate the length
        if(i == 0){
          if(length(holder) > a){
            a = length(holder);
          }
        }
        buckets[nth(holder,i)].add(holder);
      }
      merge(data,buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    int a = 1;
    SortableLinkedList[] positiveBuckets = new SortableLinkedList[10];
    SortableLinkedList[] negativeBuckets = new SortableLinkedList[10];
    for(int g = 0; g < 10; g++){
      positiveBuckets[g] = new SortableLinkedList();
      negativeBuckets[g] = new SortableLinkedList();
    }
    for(int i = 0; i < a; i++){
      while(data.size() > 0){
        int holder = data.remove(0);
        //calculate the length
        if(i == 0){
          if(length(holder) > a){
            a = length(holder);
          }
        }
        int digit = nth(holder,i);
        if(holder < 0){
          negativeBuckets[9 - digit].add(holder);
        }
        else{
          positiveBuckets[digit].add(holder);
        }
          }
        if(data.size() != 0){
          for(int b = 0; b < data.size();){
            data.remove(b);
        }
      }
      merge(data, negativeBuckets);
      merge(data, positiveBuckets);
      System.out.println(data);
    }
  }

  public static void main(String[]args){
    System.out.println(nth(123,1));
    System.out.println(nth(-123,1));
    System.out.println(nth(123,2));
    System.out.println(nth(-123,2));
    System.out.println("-----------");
    System.out.println(length(2));
    System.out.println(length(27));
    System.out.println(length(532));
    System.out.println(length(1234));
    System.out.println("-----------");
    SortableLinkedList test = new SortableLinkedList();
    SortableLinkedList[] buckets = new SortableLinkedList[10];
    for(int i = 0; i < 10; i++){
      buckets[i] = new SortableLinkedList();
      for(int j = 0; j < 5; j++){
        buckets[i].add(j);
      }
    }
    merge(test, buckets);
    System.out.println(test);
    System.out.println("-----------");
    SortableLinkedList tester = new SortableLinkedList();
    tester.add(12345);
    tester.add(54311);
    tester.add(1367);
    tester.add(832189);
    tester.add(20);
    radixSortSimple(tester);
    System.out.println(tester);
    System.out.println("-----------");
    SortableLinkedList negative = new SortableLinkedList();
    negative.add(-1234);
    negative.add(-456);
    negative.add(234);
    negative.add(1);
    negative.add(-5782327);
    radixSort(negative);
    System.out.println(negative);
  }
}
