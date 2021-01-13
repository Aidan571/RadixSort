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
      for(int j = 0; j < data.size(); j++){
        if(i == 0){
          if(length(data.get(j)) > a){
            a = length(data.get(j));
          }
        }
        buckets[nth(data.get(j),i)].add(data.get(j));
      }
      if(data.size() != 0){
        for(int b = 0; b < data.size();){
          data.remove(b);
        }
      }
      merge(data,buckets);
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
  }
}
