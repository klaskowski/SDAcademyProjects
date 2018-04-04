import java.util.Stack;

public class JavaStack {

    static void push_stack(Stack<Integer> stack){
        for (int i = 0; i < 5; i++){
            stack.push(i);
        }
    }

    static void pop_stack(Stack<Integer> stack){
        System.out.println("Pop ");
        for (int i = 0; i < 5; i++){
            Integer y = (Integer) stack.pop();
            System.out.print(y + "\t");
        }
    }

    static void stack_peek(Stack<Integer> stack){
        Integer element = (Integer) stack.peek();
        System.out.println("Element on top of stack is " + element);
    }

    static void stack_search(Stack<Integer> stack, int element){
        Integer position = (Integer) stack.search(element);
        if (position == -1){
            System.out.println("The element is missing from stack");
        } else {
            System.out.println("The element " + element + " is in position " + position);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> testStack = new Stack<Integer>();

        if(testStack.empty()){
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack has some elements");
        }
        System.out.println();
        push_stack(testStack);
        if(testStack.empty()){
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack has some elements");
        }
        stack_peek(testStack);
        pop_stack(testStack);
        System.out.println();
        push_stack(testStack);
        System.out.println("Now trying to find element in stack!");
        stack_search(testStack, 76);
        stack_search(testStack, 3);

    }
}
