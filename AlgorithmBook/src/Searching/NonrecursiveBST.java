
public class NonrecursiveBST<Key extends Comparable<Key>, Value> {

    private Node root;          // root of BST

    private class Node {
        private Key key;                // sorted by key
        private Value value;            // associated data
        private Node left, right;       // left and right subtrees

        public Node(Key key, Value value) {
            this.key   = key;
            this.value = value;
        }
    }


   /***********************************************************************
    *  Insert item into BST, nonrecursive version
    ***********************************************************************/
    public void put(Key key, Value value) {
        Node z = new Node(key, value);
        if (root == null) { root = z; return; }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int res = key.compareTo(x.key);
            if      (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else { x.value = value; return; }   // overwrite duplicate
        }
        int res = key.compareTo(parent.key);
        if (res < 0) parent.left  = z;
        else         parent.right = z;
    }
   

   /***********************************************************************
    *  Search BST for given key, nonrecursive version
    ***********************************************************************/
    Value get(Key key) {
        Node x = root;
        while (x != null) {
            int res = key.compareTo(x.key);
            if      (res < 0) x = x.left;
            else if (res > 0) x = x.right;
            else return x.value;
        }
        return null;
    }

    //
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue);
        return queue;
    }
    private void keys(Node x, Queue<Key> queue) { 
        if (x == null) return; 
        keys(x.left, queue); 
        queue.enqueue(x.key); 
        keys(x.right, queue); 
    } 


   /*****************************************************************************
    *  Test client
    *****************************************************************************/
    public static void main(String[] args) { 
        String[] a = StdIn.readAll().split("\\s+");
        int N = a.length;
        NonrecursiveBST<String, Integer> st = new NonrecursiveBST<String, Integer>();
        for (int i = 0; i < N; i++)
            st.put(a[i], i);
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
