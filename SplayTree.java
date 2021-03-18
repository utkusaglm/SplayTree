public class SplayTree {
    private Node root;
    private int count = 0;

    //construct
    public SplayTree() {
        root = null;
    }


    public boolean isEmpty() {
        return root == null;
    }


    public void clear() {
        root = null;
        count = 0;
    }

    //insert element
    public void insert(int ele) {
        Node z = root;
        Node p = null;
        while (z != null) {
            p = z;
            if (ele > p.element)
                z = z.right;
            else
                z = z.left;
        }
        z = new Node();
        z.element = ele;
        z.parent = p;
        if (p == null)
            root = z;
        else if (ele > p.element)
            p.right = z;
        else
            p.left = z;
        Splay(z);
        count++;  // count ++
    }

    //rotate
    public void makeLeftChildParent(Node c, Node p) {
        if ((c == null) || (p == null) || (p.left != c) || (c.parent != p))
            throw new RuntimeException("WRONG");

        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.right != null)
            c.right.parent = p;

        c.parent = p.parent;
        p.parent = c;
        p.left = c.right;
        c.right = p;
    }

    //rotate
    public void makeRightChildParent(Node c, Node p) {
        if ((c == null) || (p == null) || (p.right != c) || (c.parent != p))
            throw new RuntimeException("WRONG");
        if (p.parent != null) {
            if (p == p.parent.left)
                p.parent.left = c;
            else
                p.parent.right = c;
        }
        if (c.left != null)
            c.left.parent = p;
        c.parent = p.parent;
        p.parent = c;
        p.right = c.left;
        c.left = p;
    }

    //splay
    private void Splay(Node x) {
        while (x.parent != null) {
            Node Parent = x.parent;
            Node GrandParent = Parent.parent;
            if (GrandParent == null) {
                if (x == Parent.left)
                    makeLeftChildParent(x, Parent);
                else
                    makeRightChildParent(x, Parent);
            } else {
                if (x == Parent.left) {
                    if (Parent == GrandParent.left) {
                        makeLeftChildParent(Parent, GrandParent);
                        makeLeftChildParent(x, Parent);
                    } else {
                        makeLeftChildParent(x, x.parent);
                        makeRightChildParent(x, x.parent);
                    }
                } else {
                    if (Parent == GrandParent.left) {
                        makeRightChildParent(x, x.parent);
                        makeLeftChildParent(x, x.parent);
                    } else {
                        makeRightChildParent(Parent, GrandParent);
                        makeRightChildParent(x, Parent);
                    }
                }
            }
        }
        root = x;
    }

    //remove element
    public void remove(int ele) {
        Node node = findNode(ele);
        remove(node);
    }

    //remove node
    private void remove(Node node) {
        if (node == null)
            return;

        Splay(node);
        if ((node.left != null) && (node.right != null)) {
            Node min = node.left;
            while (min.right != null)
                min = min.right;

            min.right = node.right;
            node.right.parent = min;
            node.left.parent = null;
            root = node.left;
        } else if (node.right != null) {
            node.right.parent = null;
            root = node.right;
        } else if (node.left != null) {
            node.left.parent = null;
            root = node.left;
        } else {
            root = null;
        }
        node.parent = null;
        node.left = null;
        node.right = null;
        node = null;
        count--;
    }

    //countnode
    public int countNodes() {
        return count;
    }

    //searc
    public boolean search(int val) {
        return findNode(val) != null;
    }

    //findNode
    private Node findNode(int ele) {
        Node PrevNode = null;
        Node z = root;
        while (z != null) {
            PrevNode = z;
            if (ele > z.element)
                z = z.right;
            else if (ele < z.element)
                z = z.left;
            else if (ele == z.element) {
                Splay(z);
                return z;
            }

        }
        if (PrevNode != null) {
            Splay(PrevNode);
            return null;
        }
        return null;
    }

    int a = 0;
    //preorder
    public void preorder() {
        preorder(root);
    }

    private void preorder(Node r) {


        if (r != null) {

            System.out.print(r.element+" ");


            preorder(r.left);


             if(r.right==null&&r.left==null){

            }else if (r.right==null||r.left==null){
                if(count==1){

                }else{
                    System.out.print("-");
                }
            }

            preorder(r.right);

        } else {


        }
    }


}