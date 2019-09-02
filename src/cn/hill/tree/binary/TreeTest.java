package cn.hill.tree.binary;

import org.junit.Test;

/**
 * @author HILL
 * @version V1.0
 * @date 2019/9/2
 **/
public class TreeTest {

    @Test
    public void fun(){
        BinaryTree<Integer> tree = new BinaryTree<>(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(10);


        tree.delete(5);
        tree.printTree();

    }
}
