// Name: Harvey Liu
// Lab 3, Problem 2
// Submission date: 03/15/26

package lab3;

public class SortedLinkedList
{
    private Node head = null;

    public SortedLinkedList(){}

    public void addFirst(int data)
    {
        if (head == null)
        {
            head = new Node(data);
        }
        else
        {
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addLast(int data)
    {
        Node node = head;
        while (node.getNext() != null)
        {
            node = node.getNext();
        }
        Node newNode = new Node(data);
        node.setNext(newNode);
    }

    public void addMiddle(Node prev, int data)
    {
        Node newNode = new Node(data);
        newNode.setNext(prev.getNext());
        prev.setNext(newNode);
    }

    // Find the node after which the new data should be inserted
    // Returns the node after which to insert, or null if insertion is at the head
    public Node findInsertPosition(int data)
    {
        Node node = head;
        while (node != null)
        {
            if (node == head && data <= node.getData())
            {
                return null;
            }
            else if (node.getNext() == null && data >= node.getData() || data >= node.getData() && data <= node.getNext().getData())
            {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    @Override
    public String toString()
    {
        String string = "";
        Node node = head;
        while (node != null)
        {
            string += Integer.toString(node.getData());
            string += " -> ";
            node = node.getNext();
        }
        string += "null";
        return string;
    }
}