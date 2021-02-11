package L9_Iterators_and_Comparators_exercise.P3_Stack_Iterator;

import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {
    private Node top;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node currnetNode = top;


            @Override
            public boolean hasNext() {
                return currnetNode != null;
            }

            @Override
            public Integer next() {
                int element = currnetNode.element;
                currnetNode = currnetNode.prev;
                return element;
            }
        };
    }

    private class Node {
        private int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = this.top;
        }
        this.top = newNode;
    }

    public int pop() {
        if (this.top == null) {
            throw new IllegalStateException("No elements");
        }
        int poppedElement = this.top.element;
        this.top = this.top.prev;
        return poppedElement;
    }
}
