import java.util.Iterator;

class ArrayQueue<Base>
{
    private int front;      //  Index of front object in BASES.
    private int rear;       //  Index of rear object in BASES.
    private Base [] bases;  //  The BASEs in the queue.

//  Constructor. Make a new empty queue that can hold SIZE - 1 elements.

    public ArrayQueue(int size)
    {
        if (size >= 1)
        {
            front = 0;
            rear = 0;
            bases = (Base []) new Object[size];
        }
        else
        {
            throw new IllegalArgumentException("Size must be at least 1.");
        }
    }

//  DEQUEUE. Remove a BASE from the front of the queue and return it.

    public Base dequeue()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("Queue is empty.");
        }
        else
        {
            front = (front + 1) % bases.length;
            Base temp = bases[front];
            bases[front] = null;
            return temp;
        }
    }

//  ENQUEUE. Add BASE to the rear of the queue.

    public void enqueue(Base base)
    {
        int nextRear = (rear + 1) % bases.length;
        if (front == nextRear)
        {
            throw new IllegalStateException("Queue is full.");
        }
        else
        {
            rear = nextRear;
            bases[rear] = base;
        }
    }

//  IS EMPTY. Test if the queue is empty.

    public boolean isEmpty()
    {
        return front == rear;
    }

//  IS FULL. Test if the queue can hold no more elements.

    public boolean isFull()
    {
        return front == (rear + 1) % bases.length;
    }

    public Iterator<Base> iterator(){
        ArrayQueueIterator temp = new ArrayQueueIterator(front, rear,bases);
        return temp;

    }

    private class ArrayQueueIterator implements Iterator<Base>{
        private int front;      //  Index of front object in BASES.
        private int rear;       //  Index of rear object in BASES.
        private Base [] bases;  //  The BASEs in the queue.

        private ArrayQueueIterator(int front, int rear, Base [] bases){
            this.front = front;
            this.rear = rear;
            this.bases = bases;

        }

        public boolean hasNext() {
            return front != rear;
        }

        public Base next(){
            if (hasNext()){
                front = (front + 1)%bases.length;
                Base temp = bases[front];
                return temp;
            }
            else{
                throw new IllegalStateException("No more elements remain");
            }
        }

        public void remove(){}

    }

}
