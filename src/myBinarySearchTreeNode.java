class myBinarySearchTreeNode{
  int myValue; //whats its holding in the node
  myBinarySearchTreeNode left;
  myBinarySearchTreeNode right;
    
  myBinarySearchTreeNode(int inValue){
    inValue = myValue; // Saving the intager

  }
  
  myBinarySearchTreeNode(int[] A){
    //Finding traversing through the array then finding the tree root and inserting the root
    myValue = A[0];
    for(int i =1; i < A.length; i++){
      insert(A[i]);
    }
  }
  
  public void insert(int inValue){
    //Checking to see if the tree node is less then the value
    if(inValue < myValue){
      //if there isn't a node then it'll insert that value to the left
      if(left != null){
        left.insert(inValue);
      }
      //once it's inserted then saves the value
      else{
        left = new myBinarySearchTreeNode(inValue);
    }
      }
    //otherwise it's going to the right side
    else if(right != null) { //right
      right.insert(inValue);
    }else {
      right = new myBinarySearchTreeNode(inValue);

    }

  }
  
  public int height(){
    //Left and right are set to zero
    int leftHeight = 0;
    int rightHeight = 0;

    //When the left side is not zero then its going to add up the number of edges in the  subtree
    if(left != null){
      leftHeight = left.height() +1;
    }
    //When the right side is not zero then its going to add up the number of edges in the  subtree
    if(right != null){
      rightHeight = right.height() +1;
    }
    //returning the height of the largest subtree
     return Math.max(leftHeight,rightHeight);
  }
  
  public int depth(int search){
    // if there is no "Children" the it's just going to return zero
    if(search == myValue){
      return 0;
    }
    //Otherwise if the right side has "children" then it
    else if(right != null && search > myValue){
      return 1 + right.depth(search);
    }
    else if(left != null && search < myValue){
      return 1 + left.depth(search);
    }
    //returning the depth of the tree
    return -1;
  }

  public int size(){
    // This method recursively calculates the number of nodes in the (sub)tree.

    //counter  set to zero
    int sum = 0;
    //counts each tree node to the right the adds
    if(right != null){
      sum ++;
    }
    //counts each tree node to the left the adds
    else if(left != null){
      sum++;
    }
    //returns the  size
    return sum;
  }
  
  // Utility function included so you can debug your solution. 
  public void print() { print(""); }
  private void print(String prefix) {
    System.out.println(prefix + myValue);
    prefix = prefix.replace('\u251C', '\u2502');
    prefix = prefix.replace('\u2514', ' ');
    if(left != null) left.print(prefix + "\u251C ");
    if(right != null) right.print(prefix + "\u2514 ");
  }
  
} 
