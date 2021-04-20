import java.util.*;


class SLNode {
	
	int data; // Contents of the node
	int level; // the level of this node
	SLNode next; // points to the next node on this level;
	SLNode down; // points to the node containing the duplicated data on the level below
	
	SLNode() {
		data=-1; level=0; next=null; down= null; // makes a dummy node on level 0
	}
	
	SLNode (int newData) { // makes a node containing data on level 0
		data= newData;
		level= 0;
		next= null;
		down= null;
	}
	

	SLNode (SLNode below) { // constructor to duplicate node below
		if (below!=null) {
			data= below.data; // duplicate data
			level= below.level+1; // level is one up
			next= null;
			down= below; // points to the node being duplicated
		}	
	}
	
	void printList(SLNode sList) {

		SLNode level = sList;
		System.out.println("---------- PRINTING SKIPLIST ---------");
		//Iterate levels, starting from top
		for(; level != null; level = level.down) {
			System.out.println("level=" + level.level);
			SLNode tmp = level;

			//Iterate through skip list
			while(tmp != null && tmp.next != null) {
				tmp = tmp.next;
				System.out.println(tmp.data);

			}
		}
		System.out.println("---------- END SKIPLIST ---------");
	}

		
		
	
	
	SLNode searchFirstExact (SLNode sList, int key) { //ToDo - P level
		// Pre : sList is valid
		// Post : returns the address of the node with the *highest* level
		// in sList whose data field matches the search term.
		if(sList!=null) {
			if(sList.data == key) {return sList;}
			else {
				SLNode level = sList;
				
				//Iterate levels, starting from top
				for(; level != null; level = level.down) {
					System.out.println("level=" + level.level);
					SLNode tmp = level;

					//Iterate through skip list
					//maybe <= key
					while(tmp != null && tmp.data < key && tmp.next != null) {
						tmp = tmp.next;
						System.out.println(tmp.data +" updated iter");
						System.out.println("test");
						if(tmp.data == key) {return tmp;}
					}
				}
			}

		}
		return sList;
	}
	
	SLNode searchFirstAtLeast (SLNode sList, int key) { //ToDo -- D/HD level
		// Pre : sList is valid
		// Post : returns the address of the node on the *highest* level in sList
		// so that all items reachable in the list from there have data value *at least*
		// the value of key, and any non-reachable item has data value strictly
		// less than the key.
		// Returns null if there is no such node.
	
		return null;
	}
	

	
	SLNode insert(SLNode sList, int toBeInserted, int topLevel) { // ToDo -- P level
		// Pre : sList is valid, and topLevel is no more than sList.level+1
		// Post : returns the first node of the list with the value toBeInserted inserted in sList
		// at level topLevel and on all levels below.
		// The returned list should be valid.
		
		// Details for insertion:
		// (1) if topLevel == sList.level+1, create a new level and insert
		// the node in this level
		// (2) For all other levels (below topLevel), find the place to insert: it must be in between the
		// node that is less than, and before the node that is greater than toBeInserted'
		// Do not insert if toBeInserted is already in the list.
		// (3) add the down links as appropriate..
		//Iterate levels, starting from top
		if(sList!=null && topLevel <= sList.level+1) {
				//if(sList.searchFirstExact(sList, toBeInserted) != null) {return sList;}
				//else {
					SLNode update = new SLNode();
					//Contains nodes to be connected to toBeInserted
					ArrayList<SLNode> updateArr = new ArrayList<SLNode>();
					//Contains nodes that toBeInserted connects to
					ArrayList<SLNode> updateArr2 = new ArrayList<SLNode>();
					System.out.println(toBeInserted + " val to be inserted");
					
					//Create new level if topLevel is greater than sList highest level
					if(topLevel > sList.level) {
						SLNode dummy = new SLNode();
						dummy.level = sList.level + 1;
						dummy.down = sList;
						sList = dummy;
					}
					
				
					//Iterate levels, starting from top
					SLNode tmp = sList;
					for(int i = sList.level; i >= 0; i--) {
						System.out.println("tmp level=" + tmp.level);
						System.out.println("tmp data= " + tmp.data);
						
			
						//Iterate through skip list
						while(tmp.next != null && tmp.next.data < toBeInserted) {
							tmp = tmp.next;
							System.out.println(tmp.data + " horiz iter");
						}
						updateArr.add(tmp);
						tmp = tmp.down;
					}
					System.out.println(sList.level);
					System.out.println(sList.data + "dewfewbfydegwydeuigwqdyiu");
					tmp = sList;
					for(int i = sList.level; i >= 0; i--) {
						//Iterate through skip list

						while(tmp != null && tmp.next != null && toBeInserted > tmp.next.data) {
							tmp = tmp.next;
							System.out.println(tmp.data + "!!!!");
						}
				
						if(tmp.next != null) {
							updateArr2.add(tmp.next);
							System.out.println(tmp.next.data + "!!!!");
						}
						
						tmp = tmp.down;
					}
					
					//Check that update arrays are for correct level
					

					//insertHere.next is where key should be inserted
					//System.out.println(tmp.data +" insert here");
					if(tmp ==  null || tmp.data != toBeInserted) {
						if(topLevel > sList.level) {
							for(int i = sList.level+1; i < topLevel+1; i++) {
								updateArr.set(i, sList);
							}
							sList.level = topLevel;
						}
						SLNode newNode = new SLNode(toBeInserted);
						
						ArrayList<SLNode> newNodes = new ArrayList<SLNode>(); 
						newNodes.add(newNode);
						
						//Create new node with new nodes with correct topLevel
						for(int i = 0; i < topLevel; i++) {
							newNode = new SLNode(newNode);
							newNodes.add(newNode);
						}
						
						//Collections.reverse(newNodes);
						Collections.reverse(updateArr2);
						Collections.reverse(updateArr);
						
						//debug new nodes
						System.out.println("----- PRINTING NEW NODES----");
						for (SLNode n : newNodes) {
							System.out.println(n.level + " =New Nodes level, " + n.data + " New Nodes data");
						}
						System.out.println("----- END PRINTING UPDATE ARR 1----");
						
						System.out.println("----- PRINTING UPDATE ARR 1----");
						for (SLNode n : updateArr) {
							System.out.println(n.level + " =Node level, " + n.data + " Node data");
							
						}
						System.out.println("----- END UPDATE ARR ----");
						
						System.out.println("----- PRINTING UPDATE ARR 2----");


						for (SLNode n : updateArr2) {
							System.out.println(n.level + " =Node level, " + n.data + " Node data");
			
							if(n.next != null) {
								//System.out.println(n.next.level + " =Next Node level, " + n.next.data + " Next Node data");
							}
							
						}
						System.out.println("----- END UPDATE ARR ----");
						
					
					
						for(int i = 0; i < updateArr.size(); i++) {
							updateArr.get(i).next = newNodes.get(i);
							
						}
						for(int i = 0; i < updateArr2.size(); i++) {
							System.out.println(newNodes.get(i).data + " newNode");
							System.out.println(updateArr2.get(i).data + " upd");
							newNodes.get(i).next = 	updateArr2.get(i);
							
						}
						
						update.printList(sList);

						
					}
				//}
				
			}
		
		
		return null;
	}
	
	SLNode remove(SLNode sList, int toBeRemoved) { // ToDo D/HD Level
		// Pre: Assume that each data value occurs exactly once on each level (individually).
		//      sList is valid
		
		// Post : returns the first node of the skip list with any nodes containing values equal to
		// toBeRemoved removed (i.e. on every level)
		//The returned list should contain all other nodes and must be valid.
		return null;
	}
}

 class SkipList {
	 SLNode top; // The top node in a Skip List
	 // class invariant:
	 // This defines a valid Skip List structure for SkipList;
	 // The first node on every level has data field (set to -1);
	 // All other data fields  have value at least zero;
	 // All nodes on the same level form an (increasing) sorted linked list; 
	 // All nodes are reachable from top, by following links (next or down);
	 // Any node on a non-zero level has a path to the zero layer following down links, going through
	 // nodes with strictly decreasing levels, but all with the same data;
	 // The nodes on the same level form a subset of node (data values) on the level below.
	 
	 SkipList(SLNode sList){ // Constructor
		 // Pre: sList is valid
		 top= sList;
	 }
	 
	 int findLastLevel(int lvl) { //ToDo -- P level
		 // POST: returns the value in the last node on level lvl
		 if(top!=null) {
		
					SLNode level = top;
					
					//Iterate levels, starting from top
					for(; level != null; level = level.down) {
						System.out.println("level=" + level.level);
						
						SLNode tmp = level;

				}

			}

		 
		 return -1;
	 }
	 
	 int[] findShortestPath(int key) { // ToDo -- CR level
		 // POST: Returns the array of node values (including dummy values) on any shortest path from
		 // the current top node to any node containing data value key on the bottom level		 
		 // Return null if no node's data value matches key.
		 
		 // Note: in general there could be more than one shortest path. In the final
		 // testing this case will not arise.
		return null; 
	 }
	 
	 int lengthShortest(int key) { // ToDo -- CR level
		 // POST: Returns the length of the shortest path from 
		 // the current top node to any node containing data value key on the bottom level.
		 // Returns 0 if there is no such node whose data value matches key
		return 0; 

	 }
	 
	 
	 boolean validate(){ // ToDo -- CR level
		 // POST:  Returns true if the list is valid (i.e. satisfies the class invariant).
		 // Otherwise returns false.
		 //1. nodes a, b, c are reachable, same lvl number but strictly INCREASING data values
		 
		 return false;
	 }
	 
	 int traverseAndAdd(int selectedLevel) { // ToDo -- P level		 
		 // POST: Returns the sum of the non-negative-valued nodes on level equal to selectedLevel 
		 // Return 0 if selected level does not appear in the list
		 return 0;
	 }
	 
	 int[] subsequence(int start, int end ){ // ToDo D/HD level
		 // POST:  Returns the (increasing) sorted array of all nodes drawn from (bottom level of original list)
		 // such that all the nodes have data at least value start and at most value end
		 return null;	 
	 }
	 
	 
	 int countAllNodes() { // ToDo -- P level
		 // POST:  Returns the total number of SLNodes in the current Skip List
		 // (The count includes all "dummy" nodes at the start of each level.)
		 return 0;
	 }	
 }

 


