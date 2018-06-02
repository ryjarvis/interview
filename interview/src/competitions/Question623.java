package competitions;

import java.util.ArrayList;
import java.util.List;

import tree.BinaryTreeLevelOrderTraversal.TreeNode;

/**
 * @author: ryjarvis Dec 9, 2017
 * 
 */

public class Question623 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}
	}
//Sample Solution
	int distance = Integer.MAX_VALUE;
	int value = -1;

	public int findClosestLeaf(TreeNode root, int k) {
		distance = Integer.MAX_VALUE;
		value = -1;
		find(root, -1, k);
		return value;
	}

	private int find(TreeNode root, int knownDistance, int target) {
		if (root == null) {
			return -1;
		}
		if (root.val == target) {
			if (root.left == null && root.right == null) {
				distance = 0;
				value = target;
			} else {
				find(root.left, 1, target);
				find(root.right, 1, target);
			}
			return 1;
		} else if (knownDistance != -1) {
			if (root.left == null && root.right == null) {
				if (distance > knownDistance) {
					distance = knownDistance;
					value = root.val;
				}
			} else {
				find(root.left, knownDistance + 1, target);
				find(root.right, knownDistance + 1, target);
			}
			return -1;
		} else {
			int left = find(root.left, -1, target);
			int right = find(root.right, -1, target);
			if (left != -1 || right != -1) {
				int dis = Math.max(left, right);
				if (left == -1) {
					find(root.left, dis + 1, target);
				}
				if (right == -1) {
					find(root.right, dis + 1, target);
				}
				return dis + 1;
			} else {
				return -1;
			}
		}
	}
///End Sample
	
//Sample 2//
    List<Integer>[] edges;
    int K;

    private void add(TreeNode u, TreeNode v) {
        if (u == null || v == null) return;
        int uu = u.val, vv = v.val;
        edges[uu].add(vv);
        edges[vv].add(uu);
    }

    private void dfs1(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            isLeaf[root.val] = true;
        }

        add(root, root.left);
        add(root, root.right);
        dfs1(root.left);
        dfs1(root.right);
    }

    int dist = 0;
    int ans = 0;
    boolean[] isLeaf;


    private void dfs2(int root, int parent, int d) {
        if (isLeaf[root]) {
            if (d < dist) {
                dist = d;
                ans = root;
            }
        }

        for (int i : edges[root])
            if (i != parent) {
                dfs2(i, root, d + 1);
            }
    }

    public int findClosestLeafSample2(TreeNode root, int k) {
        this.K = k;
        edges = new List[1001];
        for (int i = 0; i < edges.length; i++)
            edges[i] = new ArrayList<>();
        isLeaf = new boolean[1001];

        dist = Integer.MAX_VALUE;

        dfs1(root);
        dfs2(k, -1, 0);
        return ans;
    }
 //End Sample2
	boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public void getDown(TreeNode root, int dis, int mindis, List<TreeNode> ans) {
		if (root == null)
			return;
		if (isLeaf(root)) {
			if (dis < mindis) {
				mindis = dis;
				ans.add(root);
			}
		}

		getDown(root.left, dis + 1, mindis, ans);
		getDown(root.right, dis + 1, mindis, ans);
	}

	void find(TreeNode root, TreeNode ances[], int mindis, List<TreeNode> ans, int k, int i) {
		if (root == null)
			return;
		if (root.val == k) {
			getDown(root, 0, mindis, ans);
			for (int j = 0; j < i; j++)
				getDown(ances[j], i - j, mindis, ans);
			return;
		}

		ances[i] = root;
		find(root.left, ances, mindis, ans, k, i + 1);
		find(root.right, ances, mindis, ans, k, i + 1);
	}
	

	int findClosestLeafNotSolved(TreeNode node, int k)

	{

		TreeNode ancestors[] = new TreeNode[1000];
		List<TreeNode> ans = new ArrayList<TreeNode>();
		int mindist = Integer.MAX_VALUE;
		find(node, ancestors, mindist, ans, k, 0);
		return ans.get(ans.size() - 1).val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
