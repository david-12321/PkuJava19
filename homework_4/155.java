Stack<Integer> stack = new Stack<Integer>();
Stack<Integer> minstack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        //if(x < minstack.peek())
        //	minstack.push(x);
        //else
        //	minstack.push(minstack.peek());
        if(!minstack.isEmpty())
        {
        	if(x < minstack.peek())
            	minstack.push(x);
            else
            	minstack.push(minstack.peek());
        }
        else
        	minstack.push(x);
    }

    public void pop() {
        stack.pop();
        minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }