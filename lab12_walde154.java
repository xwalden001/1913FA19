class PriorityQueue<Base>
{
    private class Node
    {
        private Base object;
        private int rank;
        private Node left;
        private Node right;
        private Node(Base object, int rank)
        {
            this.object = object;
            this.rank = rank;
            left = null;
            right = null;
        }
    }

    private Node root;

    public PriorityQueue()
    {
        root = new Node(null,-1);
        root.left = null;
        root.right = null;
    }
    public Base dequeue()
    {
        if(isEmpty())
        {
            throw new IllegalStateException("Queue is Empty");
        }
        else
        {
            Node temporary = root;
            while(temporary.left == null)
            {
                if(temporary.right.right == null && temporary.right.left == null)
                {
                    Base object = temporary.right.object;
                    temporary.right = null;
                    return object;
                }
                temporary = temporary.right;
            }
            while(temporary.left.left != null)
            {
                temporary = temporary.left;
            }
            Base object = temporary.left.object;
            if(temporary.left.right != null)
            {
                temporary.left = temporary.left.right;
            }
            else
            {
                temporary.left = null;
            }
            return object;



        }

    }
    public void enqueue(Base object, int rank)
    {
        if(rank<0)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            Node temporary = root;
            while(true)
            {
                if(rank <= temporary.rank)
                {
                    if (temporary.left == null)
                    {
                        temporary.left = new Node(object, rank);
                        return;
                    }
                    temporary = temporary.left;
                }
                else
                {
                    if(temporary.right == null)
                    {
                        temporary.right = new Node(object,rank);
                        return;
                    }
                    temporary = temporary.right;
                }
            }
        }
    }
    public boolean isEmpty() { return root.right == null; }
}

//  SNOBBERY. How the aristocracy behaves in a queue. 20 points.

class Snobbery
{

//  MAIN. Queue them up.

    public static void main(String[] args)
    {
        PriorityQueue<String> queue = new PriorityQueue<String>();

        System.out.println(queue.isEmpty());  //  true        2 points

        try
        {
            System.out.println(queue.dequeue());
        }
        catch (IllegalStateException ignore)
        {
            System.out.println("Blimey!");      //  Blimey!     2 points
        }

        queue.enqueue("Lancelot",  5);
        queue.enqueue("Fawlty",    7);
        queue.enqueue("Elizabeth", 0);
        queue.enqueue("Charles",   1);
        queue.enqueue("Turing",    7);

        try
        {
            queue.enqueue("Zeus", -100);
        }
        catch (IllegalArgumentException ignore)
        {
            System.out.println("No gods!");     //  No gods!    2 points
        }

        System.out.println(queue.isEmpty());  //  false       2 points

        System.out.println(queue.dequeue());  //  Elizabeth   2 points
        System.out.println(queue.dequeue());  //  Charles     2 points
        System.out.println(queue.dequeue());  //  Lancelot    2 points
        System.out.println(queue.dequeue());  //  Turing      2 points
        System.out.println(queue.dequeue());  //  Fawlty      2 points

//  It's OK if Fawlty comes out before Turing, but both must come out last.

        System.out.println(queue.isEmpty());  //  true        2 points.
    }

}
