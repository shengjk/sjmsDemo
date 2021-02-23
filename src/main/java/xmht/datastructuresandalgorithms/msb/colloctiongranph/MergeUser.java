package xmht.datastructuresandalgorithms.msb.colloctiongranph;

import java.util.HashMap;
import java.util.List;

/**
 * @author shengjk1
 * @date 2021/2/21
 */
public class MergeUser {
	static class User {
		String idCard;
		String bId;
		String gId;
	}

	private HashMap<String, User> idCardMap;
	private HashMap<String, User> bidMap;
	private HashMap<String, User> gidMap;

	public MergeUser() {
		this.idCardMap = new HashMap<>();
		this.bidMap = new HashMap<>();
		this.gidMap = new HashMap<>();
	}

	public void merge(List<User> users) {
		UnionFind.UnionSet<User> userUnionSet = new UnionFind.UnionSet<User>(users);

		for (User user : users) {
			if (!idCardMap.containsKey(user.idCard)) {
				idCardMap.put(user.idCard, user);
			} else {
				userUnionSet.union(idCardMap.get(user.idCard), user);
			}

			if (!bidMap.containsKey(user.bId)) {
				bidMap.put(user.bId, user);
			} else {
				userUnionSet.union(bidMap.get(user.bId), user);
			}
			if (!gidMap.containsKey(user.gId)) {
				gidMap.put(user.gId, user);
			} else {
				userUnionSet.union(gidMap.get(user.gId), user);
			}
		}
	}
}
