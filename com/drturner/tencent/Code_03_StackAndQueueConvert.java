package com.drturner.tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_03_StackAndQueueConvert {

	public static class MyQueue {
		private Stack<Integer> push;
		private Stack<Integer> pop;

		public MyQueue() {
			push = new Stack<Integer>();
			pop = new Stack<Integer>();
		}

		public void push(int pushInt) {
			push.push(pushInt);
		}

		public int poll() {
			if (pop.empty() && push.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (pop.empty()) {
				while (!push.empty()) {
					pop.push(push.pop());
				}
			}
			return pop.pop();
		}

		public int peek() {
			if (pop.empty() && push.empty()) {
				throw new RuntimeException("Queue is empty!");
			} else if (pop.empty()) {
				while (!push.empty()) {
					pop.push(push.pop());
				}
			}
			return pop.peek();
		}
	}

	public static class TwoQueuesStack {
		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int pushInt) {
			queue.add(pushInt);
		}

		public int peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			help.add(res);
			swap();
			return res;
		}

		public int pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("Stack is empty!");
			}
			while (queue.size() > 1) {
				help.add(queue.poll());
			}
			int res = queue.poll();
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> tmp = help;
			help = queue;
			queue = tmp;
		}

	}

}
