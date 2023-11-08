public class BinaryTree {
	// Node class
	private class Node {
		int data;
		Node left;
		Node right;
		// constructor
		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
		// insert method
		public void insert(int value) {
			if (value <= data) {
				if (left == null) {
					left = new Node(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new Node(value);
				} else {
					right.insert(value);
				}
			}
		}
		// find method
		public boolean find(int value) {
			if (value == data) {
				return true;
			} else if (value < data) {
				if (left == null) {
					return false;
				} else {
					return left.find(value);
				}
			} else {
				if (right == null) {
					return false;
				} else {
					return right.find(value);
				}
			}
		}
		// print function
		public void printInOrder() {
			if (left != null) {
				left.printInOrder();
			}
			System.out.println(data);
			if (right != null) {
				right.printInOrder();
			}
		}

		// height
		public int height() {
			int leftHeight = 0;
			int rightHeight = 0;
			if (left != null) {
				leftHeight = left.height();
			}
			if (right != null) {
				rightHeight = right.height();
			}
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

}
