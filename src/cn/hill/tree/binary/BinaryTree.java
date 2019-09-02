package cn.hill.tree.binary;

/**
 * @author HILL
 * @version V1.0
 * @date 2019/9/2
 **/
public class BinaryTree<T extends Number> {

    private Node<T> root;

    /**
     * 构建一个二叉查找树
     *
     * @param data
     * @Author: HILL
     * @date: 2019/9/2 17:48
     **/
    BinaryTree(T data) {
        this.root = new Node<T>(data);
    }

    /**
     * 根据data删除在树中的值，不支持重复
     * @Author: HILL
     * @date: 2019/9/2 18:41
     * @param data 要删除的数据的值
    **/
    public void delete(T data){
        //查找data在数中的位置
        Node<T> deleteNode = root;
        Node<T> deletePreNode = null;

        while (deleteNode !=null && deleteNode.data.doubleValue() != data.doubleValue()){
            if (deleteNode.data.doubleValue() > data.doubleValue()){
                deletePreNode = deleteNode;
                deleteNode = deleteNode.left;
            }else{
                deletePreNode = deleteNode;
                deleteNode = deleteNode.right;
            }
        }
        //判断要删除的节点是否由两个子节点
        if(deleteNode.left !=null && deleteNode.right!=null){
            //查找右子树中的最左叶子节点
            Node<T> tempNode = deleteNode.right;
            Node<T> tempNodePre = deleteNode;

            while (tempNode.left!=null){
                tempNodePre = tempNode;
                tempNode = tempNode.left;

            }
            //把最左节点的值覆盖到要删除的
            deleteNode.data = tempNode.data;
            //将要删除的节点替换为最左节点,后续就可以把所有节点当作删除只有一个节点的值一样处理
            deleteNode = tempNode;
            deletePreNode = tempNodePre;

        }

        //若要删除的节点有一个子节点
        Node<T> child ;
        if (deleteNode.left!=null) {
            child = deleteNode.left;
        } else if (deleteNode.right!=null){
            child = deleteNode.right;
        }else{
            //没有子节点
            child = null;
        }

        //当树中只有根节点时
        if (deletePreNode == null) {
            root = child;
        }else if (deletePreNode.left==deleteNode){
            deletePreNode.left = child;
        }else {
            deletePreNode.right = child;
        }

    }


    /**
     * 根据data在树中查找
     *
     * @param data 需要查找的数据的值
     * @author: HILL
     * @date: 2019/9/2 18:23
     * @return: T 查找到的数据，若没有则返回null
     **/
    public T find(T data) {
        Node<T> p = root;
        while (p != null) {
            //查找的值小与当前节点
            if (p.data.doubleValue() > data.doubleValue()) {
                p = p.left;
            } else if (p.data.doubleValue() < data.doubleValue()) {
                p = p.right;
            } else {
                return data;
            }
        }
        return null;

    }

    /**
     * 添加一个数据到适当的位置，不支持重复
     *
     * @param data 要添加的数据
     * @Author: HILL
     * @date: 2019/9/2 17:46
     * @return: void
     **/
    public void add(T data) {
        if (root == null) {
            root = new Node<T>(data);
            return;
        }
        Node<T> p = root;
        while (p != null) {
            //由根节点开始比较,大于根节点
            if (data.doubleValue() > p.data.doubleValue()) {
                if (p.right == null) {
                    p.right = new Node<T>(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node<T>(data);
                    return;
                }
                p = p.left;
            }
        }

    }

    /**
     * 中序遍历树，使其按顺序打印
     *
     * @author: HILL
     * @date: 2019/9/2 18:00
     * @return: void
     **/
    public void printTree() {
        print(root);
    }

    private void print(Node<T> node) {
        if (node == null) {
            return;
        }
        print(node.left);
        System.out.println(node.data.intValue());
        print(node.right);
    }

    class Node<T> {

        Node left;
        Node right;
        T data;

        Node(T data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }

        public Node(Node left, Node right, T data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

    }

}
