// Name: Harvey Liu
// Lab 3, Problem 2
// Submission date: 03/15/26

package lab3;

public class L3P2
{
    public static void main(String[] args)
    {
        int[] A = {4, 6, 5, 8, 2, 0, 1, 7, 3, 9};
        SortedLinkedList list = new SortedLinkedList();
        for (int num : A)
        {
            Node pos = list.findInsertPosition(num);
            if (pos == null) // Insert at the beginning
                list.addFirst(num);
            else if (pos.getNext() == null) // Insert at the end
                list.addLast(num);
            else    // Insert in the middle
                list.addMiddle(pos, num);
            System.out.println("Adding " + num + ": " + list);
        }
    }
}