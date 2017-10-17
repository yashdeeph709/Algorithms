package com.algo.design.man.chap3;
import java.io.*;
// Tree printing by https://stackoverflow.com/users/2901325/laurent-demailly
// Printing code preset at https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
public class BinarySearchTreeTest{
	public static void main(String args[]) throws Exception{
		System.out.println("Starting Tests");
		testInsert();	
		testDelete();
	}
	public static void testInsert() throws Exception{
		BinarySearchTree tree=new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(4);
		tree.insert(16);
		tree.printTree(tree.root);
		boolean testResult=false;
		testResult=tree.root.left.data==5?true:false;
		testResult=tree.root.data==10?true:false;
		testResult=tree.root.right.data==15?true:false;
		testResult=tree.root.left.left.data==4?true:false;
		testResult=tree.root.right.right.data==16?true:false;
		if(testResult){
			System.out.println("BST Insertion Test Passed Successfully");
		}else{
			System.out.println("BST Insertion Test Failed");
		}
	}
	public static void testDelete() throws Exception{
		boolean testResult=false;
		BinarySearchTree tree=new BinarySearchTree();
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(4);
		tree.insert(16);
		tree.insert(14);
		tree.printTree(tree.root);
		//No Child Test
		tree.printTree(tree.root);
		tree.delete(4);			
		System.out.println("Delete leafnode");
		tree.printTree(tree.root);
		testResult=tree.root.left.left==null?true:false;
		//Single Child Test
		tree.insert(4);
		System.out.println("Delete single child 5");
		tree.printTree(tree.root);
		tree.delete(5);
		tree.printTree(tree.root);
		testResult=tree.root.left.data==4?true:false;
		//Double Child Test
		tree.insert(3);
		tree.insert(2);
		tree.insert(5);
		tree.insert(6);
		System.out.println("Delete double child 4");
		tree.printTree(tree.root);
		tree.delete(4);
		tree.printTree(tree.root);
		testResult=tree.root.left.data==2?true:false;
	}
	
	public static class BinarySearchTree{
		public Node root;
		
		public void insert(int data) throws Exception{
			Node temproot=root;
			Node parent=null;
			while(temproot!=null){
				if(temproot.data>data){
					parent=temproot;
				       	temproot=temproot.left;
				}else if(temproot.data<data){
					parent=temproot;
					temproot=temproot.right;
				}else{
					throw new Exception("Two same keys cannot exist in BST");
				}
			}	
			Node temp=new Node(data);
			if(parent==null){
				root=temp;
				return;
			}
			if(data<parent.data){
				parent.left=temp;		
				temp.parent=parent;
			}else if(data>parent.data){
				parent.right=temp;
				temp.parent=parent;
			}
		}
		public int search(Node root,int data){
			Node temproot=root;
			if(temproot.data==data){
				return data;
			}else if(temproot.data>data){
				return search(temproot.left,data);
			}else if(root.data<data){
				return search(temproot.right,data);
			}
			return -1;
		}
		public void delete(int data){
			Node temproot=root;
			while(temproot.data!=data){
				if(temproot.data>data){
				       	temproot=temproot.left;
				}else if(temproot.data<data){
					temproot=temproot.right;
				}
			}	
			if(temproot==null){
				return ;
			}
			if(temproot.left==null && temproot.right==null){
				if(temproot.data<temproot.parent.data){
					temproot.parent.left=null;
				}	
				if(temproot.data>temproot.parent.data){
					temproot.parent.right=null;
				}
			}else if(temproot.left==null || temproot.right==null){
				if(temproot.left!=null){
					temproot.data=temproot.left.data;
					temproot.left=null;
				}
				if(temproot.right!=null){
					temproot.data=temproot.right.data;
					temproot.right=null;
				}
			}else{
				Node rightSubtree=temproot.right;	
				while(rightSubtree.left!=null){
					rightSubtree=rightSubtree.left;
				}
				if(rightSubtree.right!=null){
					temproot.data=rightSubtree.data;
					rightSubtree.data=rightSubtree.right.data;
					if(rightSubtree.right!=null){
					rightSubtree.right=rightSubtree.right.right;
					}	
					if(rightSubtree.left!=null){
					rightSubtree.left=rightSubtree.right.left;
					}
				}

			}
		}
		public void printTree(Node root)throws IOException {
			OutputStreamWriter out = new OutputStreamWriter(System.out);
		        if (root.right != null) {
		            printTree(root.right,out, true, "");
		        }
		        printNodeValue(root.data,out);
		        if (root.left != null) {
		            printTree(root.left,out, false, "");
		        }
			out.flush();
	    	}
		 private void printNodeValue(int value,OutputStreamWriter out) throws IOException {
			if (value == 0 ) {
			    out.write("<null>");
			} else {
			    out.write("Data:");
			    out.write(value+"");
			}
			out.write('\n');
			out.flush();
		    }
		    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(Node root,OutputStreamWriter out, boolean isRight, String indent) throws IOException {
			if (root.right != null) {
		            printTree(root.right,out, true, indent + (isRight ? "        " : " |      "));
		        }
		        out.write(indent);
		        if (isRight) {
		            out.write(" /");
		        } else {
		            out.write(" \\");
		        }
		        out.write("----- ");
		        printNodeValue(root.data,out);
		        if (root.left != null) {
		            printTree(root.left,out, false, indent + (isRight ? " |      " : "        "));
		        }
		    }

	}
	public static class Node{
		public Node parent;
		public Node left;
		public Node right;
		public int data;
		public Node(int d){
			data=d;
			left=null;
			right=null;
			parent=null;
		}
	}
}
