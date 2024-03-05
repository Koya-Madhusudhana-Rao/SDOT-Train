import java.util.*;
class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}
class Main
{
  public static void add(Node a, int b){
    Node n = new Node(b);
    if(a==null){
      a = n;
      return;
    }
    else{
      Node temp = a;
      while(temp.next!=null){
        temp = temp.next;
      }
      temp.next = n;
      return;
    }
  }
  public static Node mer(Node a1, Node a2) {
    if (a1 == null) {
        return a2;
    } else if (a2 == null) {
        return a1;
    }

    Node dummy = new Node(-1);
    Node tail = dummy;

    while (a1 != null && a2 != null) {
        if (a1.data < a2.data) {
            tail.next = a1;
            a1 = a1.next;
        } else {
            tail.next = a2;
            a2 = a2.next;
        }
        tail = tail.next;
    }

    if (a1 != null) {
        tail.next = a1;
    }

    if (a2 != null) {
        tail.next = a2;
    }

    return dummy.next;
}

  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    Node a1 = null;
    Node tail = null;
    for(int i = 0; i<n1; i++){
      Node n = new Node(sc.nextInt());
      if(a1==null){
        a1 = n;
        tail = n;
      }
      else{
        tail.next=n;
        tail= tail.next;
      }
    }
    n1 = sc.nextInt();
    Node a2 = null;
    for(int i = 0; i<n1; i++){
      Node n = new Node(sc.nextInt());
      if(a2==null){
        a2 = n;
        tail = n;
      }
      else{
        tail.next=n;
        tail= tail.next;
      }
    }
    Node head = mer(a1,a2);
    while(head!=null){
      System.out.print(head.data + "->");
      head = head.next;
    }
    System.out.println("NULL");
  }
}