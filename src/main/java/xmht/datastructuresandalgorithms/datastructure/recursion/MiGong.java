package xmht.datastructuresandalgorithms.datastructure.recursion;

/**
 * @author shengjk1
 * @date 2020/2/23
 */
public class MiGong {
	public static void main(String[] args) {
		//二维数据模拟地图
		int[][] map = new int[8][7];
		/*
		使用1作为墙
		上下全部置为1
		 */
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//左右全部置为1
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		//设置挡板
		map[3][1] = 1;
		map[3][2] = 1;
		
		//输入
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		setWay(map, 1, 1);
		
		System.out.println("小球走过，并标识过的地图情况");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		/*
		是，则重新加载整个地图
		 */
		System.out.println("alter 是否重新开始？");
	}
	
	
	/**
	 * 使用递归回溯来给小球找路
	 * 1.map 表示的是地图
	 * 2.i,j 表示开始出发的位置
	 * 3.如果小球能到(6,5)位置，则说明通路找到
	 * 4.当map[i][j] 为 0 时，表示该点没有走过，当为1表示墙，2表示是通路可以走，3表示该点已经走过，但走不通
	 * 5.走迷宫的策略 下 -> 右 -> 上 -> 左
	 *
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean setWay(int[][] map, int i, int j) {
		//表示已经走通
		if (map[6][5] == 2) {
			return true;
		} else {
			//当前节点尚未走过
			if (map[i][j] == 0) {
				//假设此节点可以走
				map[i][j] = 2;
				//向下走
				if (setWay(map, i + 1, j)) {
					return true;
					//向右走
				} else if (setWay(map, i, j + 1)) {
					return true;
					//向上走
				} else if (setWay(map, i - 1, j)) {
					return true;
					//向左走
				} else if (setWay(map, i, j - 1)) {
					return true;
				} else {
					//此点走不通
					map[i][j] = 3;
					return false;
				}
			} else {
				//map[i][j]的值可能是 1，2，3
				//走入死路或者走对了，都重新加载才能继续走一次
				return false;
			}
		}
	}
}
