// Name: Harvey Liu
// Lab 3, Problem 2
// Submission date: 03/15/26

package lab3;

public class Node
{
    private int data;
    private Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public int getData()
    {
        return this.data;
    }
    
    public Node getNext()
    {
        return this.next;
    }
}