
public class skipListClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLNode nodeA = new SLNode();
		SLNode nodeB = new SLNode(11);
		SLNode nodeBlvl1 = new SLNode(nodeB);
		SLNode nodeBlvl0 = new SLNode(nodeBlvl1);
		SLNode nodeC = new SLNode(12);
		SLNode nodeD = new SLNode(13);
		SLNode nodeE = new SLNode(14);
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		nodeE.next = null;
		
		//lvl2	-1, 11, 12, 13, 14
		//lvl1    	11
		//lvl0    	11
		
		SkipList list = new SkipList(nodeA);
		
		for(SLNode tmp = list.top; tmp != null; tmp = tmp.next){
			System.out.println(tmp.data);
		}
		SLNode tmp = nodeA.searchFirstExact(nodeA, 12);
		System.out.println(tmp.data);
	}

}
