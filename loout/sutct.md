散列表
  在我的理解中就是数组＋链表的方式也可以数组加树，利用传入数据哈希值来计算要存入的下标，并将这个数据打成链表的格式来连接到下一个位置，如果要查询
  数据的时候获取这个数据的hash值所在的位置依次遍历所有的链表。为了节省数据采用的是单链表的形式