Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int x = queue.size();
        for(int i = 0; i < x - 1; i++)
        	queue.offer(queue.poll());
        queue.poll();
    }

    // Get the top element.
    public int top() {
        int x = queue.size();
        for(int i = 0; i < x - 1; i++)
        	queue.offer(queue.poll());
        int top = queue.peek();
        queue.offer(queue.poll());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }