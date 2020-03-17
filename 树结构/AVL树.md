### avl树
1.在AVL树中，任一节点对应的两棵子树的最大高度差为1，因此它也被称为高度平衡树。  
2.增加和删除元素的操作则可能需要借由一次或多次树旋转，以实现树的重新平衡。  
3.平衡因子
  - 节点的平衡因子是它的左子树的高度减去它的右子树的高度（有时相反）。带有平衡因子1、0或 -1的节点被认为是平衡的。带有平衡因子 -2或2的节点被认为是不平衡的，并需要重新平衡这个树。平衡因子可以直接存储在每个节点中，或从可能存储在节点中的子树高度计算出来。

```
public class TreeNode {
    private Node root;
    private static class Node {
        int hight;//高度
        int val;
        //左子树
        Node left;
        //右子树
        Node right;
        //构造方法
        Node(int x) {
            val = x;
        }
    }
    public void printf(){
        printf(root);
    }
    private void printf(Node root){
        if (root != null) {
            printf(root.left);
            System.out.println(root.val);
            printf(root.right);
        }
    }
    public int addTree(int item){
        int h = -1;
        if (root == null) {
            root = node(item);
        }else{
            h = addTree(root, item).val;
        }
        return h;
    }
    private Node node(int item){
        return new Node(item);
    }
    //右旋转
    private Node rightRote(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.hight = Math.max(hights(node.right),hights(node.left)) + 1;
        temp.hight = Math.max(hights(temp.right),hights(temp.left)) + 1;
        return temp;
    }
    //左旋转
    private Node letfRote(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.hight = Math.max(hights(node.right),hights(node.left)) + 1;
        temp.hight = Math.max(hights(temp.right),hights(temp.left)) + 1;
        return temp;
    }

    //双旋转
    private Node leftAndRightRotate(Node node){
        node.left = letfRote(node);
        return rightRote(node);
    }
    private Node rightAndLeftRotate(Node node){
        node.right = rightRote(node);
        return letfRote(node);
    }
    //添加节点
    private Node addTree(Node node,int item){
      //判断需要向哪里添加
        /**
         *y一直找到要链接位置的空位置创建对象，之后在将本结点返回回去
         */
      if (node == null) {
          return node(item);
      }
      if (item > node.val) {
          node.right = addTree(node.right,item);
          //判断是否不平衡
          if (hights(node.right) - hights(node.left) == 2) {
              //右旋转
              node = leftAndRightRotate(node);
          }else {
              node = rightAndLeftRotate(node);
          }
      }else {
          node.left = addTree(node.left,item);
          if (hights(node.left) - hights(node.right) == 2) {
                node = letfRote(node);
          }else {
              node = leftAndRightRotate(node);
          }
      }
      node.hight = Math.max(hights(node.left),hights(node.right)) + 1;
      return node;
    }
    //删除节点
    public int delNode(int item) {
        /**
         * 删除结点有三种情况
         * 1.被删除的结点没有子节点（也就是叶子结点）
         * 2.被删除的结点有一个子节点
         * 3.被删除的结点有俩结点（需要从右结点中找到最小的结点进行替换）
         */
        //获取要删除结点
        Node node = selectNode(root, item);//获取当前结点
        if (node == null) {
            return -1;
        }
        //获取父节点
        Node parth = getPath(root, item);
        //判断删除的
        if (node.left == null && node.right == null) {
            //判断是左子树还是右子树
            if (parth.left == node) {
                parth.left = null;
            } else {
                parth.right = null;
            }
        } else if (node.left != null && node.right != null) {
                node.val = node(getNodeMin(node.right)).val;
        } else {
            if (node.left != null) {
                if (parth.left == node) {
                    parth.left = node.left;
                } else {
                    parth.right = node.left;
                }
            } else {
                if (parth.left == node) {
                    parth.left = node.right;
                } else {
                    parth.right = node.right;
                }
            }

        }
        return 0;
    }
    private int getNodeMin(Node node){
        Node n = node;
        while (node != null){
            node = node.right;
        }
        delNode(n.val);
        return n.val;
    }
    //获取父节点
    private Node getPath(Node node , int item){
        if (node == null) {
            return null;
        }
        if (node.left !=null && node.left.val == item || node.right !=null && node.right.val == item) {
            return node;
        }else if (node.val > item){
            return getPath(node.left,item);
        }else {
            return getPath(node.right,item);
        }

    }

    public int selectNode(int item){
        return selectNode(root,item).val;
    }
    //查找结点节点
    private Node selectNode(Node node, int item){
        if (node == null){
            return null;
        }
        if (item == node.val){
            return node;
        }else if (item > node.val) {
            return selectNode(node.right,item);
        }else {
            return selectNode(node.left,item);
        }
    }
    //返回当前结点的高度
    private int hights(Node node){
        return node != null ? node.hight : -1;
    }
}
```
