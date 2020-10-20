package day20201020;

/**
 * 如何找到链表的倒数第n个结点
 *
 * 首先，我们创建两个指针P1和P2，P1指向链表的头结点，P2指向链表的正数第n个结点（也就是例子中的第3个结点）
 * 接下来，我们让指针P1和P2同时循环右移，每次右移一步，直到指针P2移动到链表的末尾
 * 此时，由于P2指向链表的尾结点，且P1和P2的距离是n-1，因此P1所指的结点就是我们要寻找的链表倒数第n个结点：
 * 显然，这个方法从头到尾只需要对链表做一次遍历，而且仅仅使用了两个指针，算法的空间复杂度是O（1）。
 */
public class NthFromEnd {
    public static Node findNthFromEnd(Node head, int n){
        Node p1 = head;
        Node p2 = head;
        //把p2指针移动到正数第n个结点
        for(int i=1; i<n; i++){
            p2 = p2.next;
            if(p2 == null){
                throw new IllegalArgumentException("参数n超出链表长度！");
            }
        }
        //p1和p2一起右移，直到p2指向链表尾结点
        while (p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    //快速创建链表
    private static Node buildLinkList(int[] array){
        Node head = new Node(array[0]);
        Node p = head;
        for(int i=1; i<array.length; i++){
            p.next = new Node(array[i]);
            p = p.next;
        }
        return head;
    }

    //链表节点
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        int[] inputs = {5,3,7,2,4,1,9,8};
        Node head = buildLinkList(inputs);
        Node node = findNthFromEnd(head,3);
        System.out.println("链表倒数第3个元素是：" + node.data);
    }

}