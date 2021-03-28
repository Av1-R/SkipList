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
	
	SLNode searchFirstExact (SLNode sList, int key) { //ToDo - P level
		// Pre : sList is valid
		// Post : returns the address of the node with the *highest* level
		// in sList whose data field matches the search term.
		if(sList!=null) {
			if(sList.data == key) {return sList;}
			else {
				SLNode top = sList;
				SLNode level = top;
				
				//Iterate levels, starting from top
				for(; level != null; level = level.down) {
					
					SLNode tmp = level;

					//Iterate through skip list
					while(tmp != null && tmp.data !=key && tmp.next != null) {
						tmp = tmp.next;
						if(tmp.data == key) {return tmp;}
					}
				}
			}

		}
		return null;
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

 


