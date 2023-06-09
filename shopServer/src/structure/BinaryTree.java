package structure;

import java.util.Comparator;
import java.util.Iterator;

public class BinaryTree <T> implements Iterable<T> {
	
	private Node<T> root;
	private Comparator<T> comparator;
	private boolean t = true;
	private boolean m = true;
	private Node <T> auxRoot;

	public BinaryTree(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}

	public void add(T value) {
		root = addRecursive(root, value);
	}

	private Node<T> addRecursive(Node<T> current, T value) {
	    if (current == null) {
	        return new Node(value);
	    }
	    if (comparator.compare(value, current.getData()) < 0) {
	        current.setLeft(addRecursive(current.getLeft(), value));
	    } else if (comparator.compare(value, current.getData()) > 0) {
	        current.setRight(addRecursive(current.getRight(), value));
	    } else {
	        return current;
	    }

	    return current;
	}
	
	public String showInOrder() {
		 return traverseInOrder(root, new StringBuilder()).toString();
	}
	
	private StringBuilder traverseInOrder(Node node, StringBuilder st) {
	    if (node != null) {
	        traverseInOrder(node.getLeft(), st);
	        st.append(node.getData() + "\n" );
	        traverseInOrder(node.getRight(), st);
	    }
	    return st;
	}
	
	
	private T traverseInOrder(Node<T> node, T dat) {
	    if (node != null) {
	       traverseInOrder(node.getLeft(), dat);
	      
	        	dat = node.getData() ;
	        	System.out.println(dat);
	        	 
	        
	        	  traverseInOrder(node.getRight(), dat);
	        return dat;
	    }
	    return null;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> myIterator = new Iterator<T>() {
		
		Node <T> actual = root;
		Node <T> rightMost = root;
			
		@Override
		public boolean hasNext() {
			return actual != null;
		}
			@Override
			public T next() {
				if (actual.getLeft() == null) {
					Node<T> temp = actual;
					actual = actual.getRight();
					return temp.getData();
				}

				rightMost = actual.getLeft();

				while (rightMost.getRight() != null && rightMost.getRight() != actual)
					rightMost = rightMost.getRight();

				if (rightMost.getRight() == null) {
					rightMost.setRight(actual);
					actual = actual.getLeft();
				}

				else {
					rightMost.setRight(null);
					Node<T> temp = actual;
					actual = actual.getRight();
					return temp.getData();
				}

				return next();
			}

		};
		return myIterator;

	}

	private T containsNodeRecursive(Node<T> current, T value) {
		if (current == null) {
			return null;
		}
		if (comparator.compare(value, current.getData()) == 0) {
			return current.getData();
		}
		return comparator.compare(value, current.getData()) < 0 ? containsNodeRecursive(current.getLeft(), value)
				: containsNodeRecursive(current.getRight(), value);
	}

	public T search(T value) {
		return containsNodeRecursive(root, value);
	}
	
	private T findSmallestValue(Node<T> root) {
	    return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
	}
	
	private Node deleteRecursive(Node<T> current, T value) {
	    if (current == null) {
	        return null;
	    }

	    if (comparator.compare(value, current.getData()) == 0) {
	    	if (current.getLeft() == null && current.getRight() == null) {
	    	    return null;
	    	}
	    	
	    	if (current.getRight() == null) {
	    	    return current.getLeft();
	    	}

	    	if (current.getLeft()== null) {
	    	    return current.getRight();
	    	}
	    	
	    	T smallestValue = findSmallestValue(current.getRight());
	    	current.setData( smallestValue);
	    	current.setRight(deleteRecursive(current.getRight(), smallestValue));
	    	return current;
	    } 
	    if (comparator.compare(value, current.getData()) < 0) {
	        current.setLeft(deleteRecursive(current.getLeft(), value));
	        return current;
	    }
	    current.setRight(deleteRecursive(current.getRight(), value));
	    return current;
	}
	
	public void delete(T value) {
	    root = deleteRecursive(root, value);
	}
	
	public boolean isEmpty() {
		return root == null;
	}
}
