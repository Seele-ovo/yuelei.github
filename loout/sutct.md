散列表
  在我的理解中就是数组＋链表的方式也可以数组加树，利用传入数据哈希值来计算要存入的下标，并将这个数据打成链表的格式来连接到下一个位置，如果要查询
  数据的时候获取这个数据的hash值所在的位置依次遍历所有的链表。为了节省数据采用的是单链表的形式

哈夫曼树：
  哈夫曼树用于压缩文件，当一个数据出现的次数过多的时候就采用短码，为了防止前缀发生相同会打成哈夫曼树因为在树中每个叶子节点的路径都不相同也就避    免了前缀发生相同的现象，压缩的大致步骤1.先统计每个字符出现的次数 2.根据每个字符出现的次数打成哈夫曼树 3.取出每一个叶子节点路径和叶子的item    放入map集合中， 4.根据每个字符打成哈夫曼类型的二进制 5.没此截取8个字符打成短码这样就完成压缩

哈夫曼的解码：与压缩相反解压首先会把数据恢复成哈夫曼字符串，之后一步步截取字符串与表进行对比对比成功则放入集合中，最后就完成了解压缩

二叉排序树：特点就是快速查找与快速储存， 特点 左面的比节点小右面比节点大。先说构建一颗二叉排序树：在插入一颗新的叶子的时候首先会与当前的节点进行比较如果新加入的大在判断当前节点的右面是否为空节点如果为空直接挂上，如果不为空则进入右节点在进行判断。同理。递归就是做重复的事情

查找节点：与插入差不多首先会进入当前节点与查找的内容进行判断如果查找的内容相同直接返回，如果查找的内容小于当前节点则递归去当前的左节点继续判断，直到找到为止，如果遍历完毕后也查找不到则直接返回null：大致为进入节点进行判断如果不对在去左或者右进行递归继续判断

删除二叉树节点：删除分为三种情况，被删除的节点没有左右节点，这样直接删除，被删除的节点有左或者右节点在判断出这个节点在父节点的哪个方向直接挂上去，删除的节点右左右节点那么需要在右节点找到最小节点之后与被删除的节点替换

AVL树：
  因为普通的二叉树如果链子过长的话反而不如单链表，这时候需要调整，如果左子树的高度比右子树的高度要高需要向右旋转，如果右子树比左子树高度要高那      么需要右旋转，都需要则双向旋转。
    右旋转：步骤1.创建一个新结点与当前结点相同，新结点的右结点是当前结点的右节点，左节点是当前结点的左子树的右结点，当前结点的替换为当前结点的左子树，而左子树替换为当前的左子树的左子树，右节点为新结点
    左旋转：创建一个与当前结点相同的结点，新结点的左子树等于当前结点的左子树右子树等于当前右子树的左节点，当前结点替换为右子树的值右字数的左结点为新结点，右结点为当前结点的右节点的右结点，
      双向旋转：发现左或者右结点不平衡则触发旋转。
      
      
图
  深度遍历：深度遍历就是一直向下找直到没有回溯到上一层继续找一直直到都结束为止
  广度遍历：广度遍历就是取出第一个值遍历下面的值放到队列中之后依次从队列中取一个值遍历完有就放入集合中直到集合的元素全部被移除完毕
  
 动态规划算法
    最优子结构
      用动态规划求解最优化问题第一步就是刻画出最优结构如果一个问题的解包含其子问题的最优解就称此问题具有最优子结构性质。某个问题是否适合应用       动态规划算法，它是否具有最优子结构性质是一个很好的线索。使用动态规划算法时，用子问题的最优解来构造原问题的最优解。因此必须考查最优解中       用到的所有子问题。（这个问题的最优解包含子问题的最优解，用子问题的最优解来构造原问题的解。就称最优子结构）
    重叠子问题
      在动态规划算法中使用数组来保存子问题的解，这样子问题多次求解的时候可以直接查表不用调用函数递归。
      
    普林姆算法（Prim）：
      普林姆算法采用的是一种贪心算法的模式，1首先确定一个点 2.查找所有旁边连接到这个点的点（利用贪心算法的思想找到距离当前节点最小的点）添加
      进节点集合，重复上面1，2步骤结束
      普林姆算法大体思路为从一个点慢慢的蔓延至其他点直到所有点都被链接上去算法结束
      
     克鲁斯卡尔算法（Kruskal）
      克鲁斯卡尔算法与普林姆算法不一样，克鲁斯卡尔算法方案为1.取出所有的边 2.给边进行从小到大排序 3.依次取出每条边进行链接 4.利用并查集的方       式判断是否形成回路如果此边形成回路直接丢弃，直到所有点全部链接在一起算法结束
      
     迪杰斯特拉斯算法(Dijkstra)
        迪杰斯特拉斯算法用于计算出从一个顶点到其他点的最短距离，利用的思想为利用贪心算法的思想：1.确定一个顶点 2.查找到次结点的距离其他点的         所有距离，之后取出一个未访问的点并且是与起始点链接在一起的点（当前点的距离未 = 起始点+距离点的距离），重复此动作直到所有节点均被访问
        
     弗洛伊德算法（Floyd）
      如果说迪杰斯特拉斯算法采用的是贪心算法的思想则弗洛伊德算法则采用了动态规划算法的思想，1.取出一个点用作中间点 2.计算出两个点相邻的距离       3.计算的结果保存起来，需要的时候直接查找使用， 4.重复此过程直到所有的点都作为中间点完毕，算法结束
      
     骑士周游算法问题
        就是利用递归的回溯方法1.查找到当前位置所能移动的所有位置 2.选择一个进行移动再次判断移动的位置 3.如果移动的次数等于表格的大小则标明算         法成功，如果没成功则当前的点取消未一走回溯到上一步继续判断直到找到全部移动完毕。
        这样暴力破解虽然可以但是效率及其低下，因为每一个点都会产生回溯-所以采用贪心算法尽量取出点最小的集合，因为这样递归次数最小。优化完毕
