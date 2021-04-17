
public class skipListClient {
	
	public static SLNode createBasicTestList(){
		
		// This creates a basic test list with three levels:
		
		// Level 2: -1 (dummy),       7	
		// Level 1: -1 (dummy), 3,    7
		// Level 0: -1 (dummy), 3, 5, 7, 9

		// Note that in the final testing for the assessment, this list WILL NOT BE USED
		// It WILL be used when you submit for trial automarking.
		
		SLNode firstNode= new SLNode(-1);
		int i= 3;
		SLNode prev= firstNode;
		SLNode temp;
		
		SLNode nodeThree=null;
		SLNode nodeSeven=null;
		
		// bottom level
		while (i < 10) {
			temp= new SLNode(i);
			if (i==3) {nodeThree= temp;} // save pointers to nodes 3, 7 to make the next level
			if (i==7) {nodeSeven= temp;}
			prev.next= temp;
			prev= temp;
			i= i+2;
		}
		
		// level 1
		
		temp= new SLNode();
		temp.down= firstNode;
		firstNode= temp;
		firstNode.level= 1;
		prev= firstNode;
		prev.next= new SLNode(3);
		temp= prev.next;
		temp.level= 1;
		temp.down= nodeThree;
		prev= temp;
		
		prev.next= new SLNode(7);
		temp= prev.next;
		temp.level= 1;
		temp.down= nodeSeven; // save pointer to the newly inserted node 7 on level 1
		nodeSeven= temp;
		temp.next= null;
		
		//top level
		
		temp= new SLNode();
		temp.down= firstNode;
		firstNode= temp;
		firstNode.level= 2;
		prev= firstNode;
		prev.next= new SLNode(7);
		temp= prev.next;
		temp.level= 2;
		temp.down= nodeSeven;
		temp.next= null;
				
	 return firstNode;
		
	}	
	

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
		
		/*for(SLNode tmp = list.top; tmp != null; tmp = tmp.next){
			System.out.println(tmp.data);
		}*/
		//SLNode tmp = nodeA.searchFirstExact(nodeA, 12);
		//nodeA.insert(nodeA, 99, 2);
		
		//
		// Level 2: -1 (dummy),       7	
		// Level 1: -1 (dummy), 3,    7
		// Level 0: -1 (dummy), 3, 5, 7, 9
		
 		SkipList skList = new SkipList(skipListClient.createBasicTestList());
 		skList.top.insert(skList.top, 4, 3);
 		//SLNode tmp = skList.top.searchFirstExact(skList.top, 9);
 

		
		
	}

}


