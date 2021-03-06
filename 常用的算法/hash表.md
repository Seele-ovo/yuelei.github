### 哈希表
1.哈希表（散列表）是由数组+链表或者数组+树结构形成的一种数据结构它通过key-value建立关系
  - 1.哈希查找第一步就是使用哈希函数将键映射成索引。这种映射函数就是哈希函数。
  - 2.哈希表（Hash table，也叫散列表），是根据关键码值(Key value)而直接进行访问的数据结构。也就是说，它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫做散列函数，存放记录的数组叫做散列表。
  - 3.哈希表hashtable(key，value) 就是把Key通过一个固定的算法函数既所谓的哈希函数转换成一个整型数字，然后就将该数字对数组长度进行取余，取余结果就当作数组的下标，将value存储在以该数字为下标的数组空间里。（或者：把任意长度的输入（又叫做预映射， pre-image），通过散列算法，变换成固定长度的输出，该输出就是散列值。这种转换是一种压缩映射，也就是，散列值的空间通常远小于输入的空间，不同的输入可能会散列成相同的输出，而不可能从散列值来唯一的确定输入值。简单的说就是一种将任意长度的消息压缩到某一固定长度的消息摘要的函数。）
    而当使用哈希表进行查询的时候，就是再次使用哈希函数将key转换为对应的数组下标，并定位到该空间获取value，如此一来，就可以充分利用到数组的定位性能进行数据定位。
  - 4.根据元素的一些特征把元素分配到不同的链表中去，也是根据这些特征，找到正确的链表，再从链表中找出这个元素。
   ![text](  https://github.com/Seele-ovo/yuelei.github/blob/master/IMG/erfen/20160603152646248.png)  
   
   ``` public class HashMAP {
    //匿名内部类
    private static class Node{
        String key;
        String value;
        Node next;
        public Node(String key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //暂时不考虑扩容问题
    private Node[] nodeTable = new Node[1000];
    private Node nodes(String key, String value){
        return new Node(key,value,null);
    }
    public void put(String key, String value){
        Node newNode = nodes(key, value);
        //根据hash找到位置
        int index = hash(key);
        Node nextNode = null;
        nextNode = nodeTable[index];
        if (nextNode == null) {//说明在这个位置第一个直接放入
            nodeTable[index] = newNode;
        }else if (nextNode != null) {//说明有值了
            while (true){
                //找到最后一个位置连接上去
                if (nextNode.next == null) {
                    nextNode.next = newNode;
                    break;
                }
                newNode = nextNode.next;

            }
        }
    }
    //根据键值获取对象
    public String get(String key){
        int hash = hash(key);
        Node n = nodeTable[hash];
        if (n.key == key) {
            return n.value;
        }else {
            while (true){
                if (n.key == key) {
                    return n.value;
                }
                n = n.next;
            }
        }
    }
    //计算键的hash
    private int hash(String key){
        return key.hashCode() / 1000 % 100;
    }
}
 ```

