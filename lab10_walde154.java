class AssociationList<Key, Value> {
    private Node head;

    private class Node{
        private Key key;
        private Value value;
        private Node next;

        private Node(Key key, Value value, Node next){
            this.value = value;
            this.key = key;
            this.next = next;
        }

    }

    public AssociationList(){
        head = new Node(null, null, null);
    }

    private boolean isEqual(Key leftkey, Key rightkey){
        if(leftkey == null || rightkey == null){
            return leftkey == rightkey;
        }
        else{
            return leftkey.equals(rightkey);
        }
    }

    public boolean isIn(Key key){
         Node current = head.next;
         while(current != null){
             if(isEqual(current.key,key)){
                 return true;
             }
             else{
                 current = current.next;
             }
         }
         return false;
    }
    public Value get(Key key){
        Node current = head.next;
        while(current != null){
            if(isEqual(current.key,key)){
                return current.value;
            }
            else{
                current = current.next;
            }
        }
        throw new IllegalArgumentException("Key not in list");
    }
    public void put(Key key,Value value){
        Node current = head.next;
        while(current != null){
            if(isEqual(key,current.key)){
                current.value = value;
                break;
            }
            else{
                current = current.next;
            }
        }
        Node newPut = new Node(key,value,head.next);
        head.next = newPut;
    }

    public void delete(Key key){
        Node left = head;
        Node right = head.next;
        while(right != null){
            if(isEqual(right.key,key)){
                left.next = right.next;
                return;
            }
            else{
                left = right;
                right = right.next;
            }
        }
    }
}


