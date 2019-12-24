class RunnyStack<Base> {
    private Run top;
    private int depth;
    private int runs;

    private class Run{
        private Base base;
        private int length;
        private Run next;
        private Run(Base base, int length, Run next){
            this.base = base;
            this.length = length;
            this.next = next;
        }


    }
    public RunnyStack(){
        top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }

    public Base peek(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is Empty");
        }
        else{
            return top.base;
        }
    }

    public void pop(){
        if(isEmpty()){
        throw new IllegalStateException("Stack is Empty");
        }
        else{
            if(top.length -1 == 0){
                top = top.next;
                runs -=1;
                depth -=1;
            }
            else{
                top.length = top.length - 1;
                depth -=1;

            }
        }
    }

    public void push(Base base){
        if(isEmpty()){
            top = new Run(base, 1,null);
            runs+=1;
            depth +=1;
        }
        else{
            if(base == top.base){
                top.length +=1;
                depth +=1;
            }
            else{
                Run oldTop = top;
                Run temp = new Run(base,1, oldTop);
                top = temp;
                runs +=1;
                depth +=1;
            }
        }
    }

    public int depth(){
        return depth;
    }
    
    public int runs(){
        return runs;
    }
}
