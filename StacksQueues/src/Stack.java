public class Stack {
    private String[] values;
    private int lastIndex;

    public Stack(int capacity) {
        this.values = new String[capacity];
        this.lastIndex = -1;
    }

    public boolean isFull(){
        if(lastIndex == getCapacity()-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(String value) {
        if(!isFull()) {
            lastIndex++;
            values[lastIndex] = value;
        }else{
            System.err.println("The stack is full. Not inserting value " + value);
        }
    }

    public String pop() {
        String value = null;
        if(!isEmpty()) {
            value = peek();
            values[lastIndex] = null;
            lastIndex--;
        }else{
            System.err.println("Can not pop. Stack is empty.");
        }
        return value;
    }

    public String peek() {
        if(!isEmpty()){
            return values[lastIndex];
        }else{
            return null;
        }
    }

    public boolean isEmpty() {
        if (values[0] == null) {
            return true;
        }else{
            return false;
        }
    }

    public int getCapacity() {
        return values.length;
    }
}
