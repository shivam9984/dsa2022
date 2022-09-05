import java.util.HashMap;

public class BinarySearchTree {

    private ConstructBinaryTree root;
    private ConstructBinaryTree exchange_node;


    // creation of binary tree using recursion

    public BinarySearchTree()
    {
        this.root=null;

    }

    // inserting binary tree

    public  ConstructBinaryTree insert_binaryTree( ConstructBinaryTree root, int data)
    {
          if(root==null)
          {
             root= new ConstructBinaryTree(data);
             return  root;
          }
          else if(data>root.getValue())
          {
              ConstructBinaryTree node= insert_binaryTree(root.getRight(),data);
              root.setRight(node);
          }
          else if(data< root.getValue())
          {
              ConstructBinaryTree node= insert_binaryTree(root.getLeft(),data);
              root.setLeft(node);
          }
       return  root;
    }
    // function that search certain element
    public HashMap<ConstructBinaryTree,ConstructBinaryTree>search_node(ConstructBinaryTree root, ConstructBinaryTree parent_root, int data)
    {

        if(root.getValue()==data)
        {
            return (HashMap<ConstructBinaryTree, ConstructBinaryTree>) new HashMap<>().put(root,parent_root);

        }
        else if(data> root.getValue())
            return  search_node(root.getRight(),root,data);
        else if(data< root.getValue())
            return search_node(root.getLeft(),root,data);
        return (HashMap<ConstructBinaryTree, ConstructBinaryTree>) new HashMap<>().put(root,root);
    }

 public ConstructBinaryTree predecessor(ConstructBinaryTree node)
 {
     if(node.getRight()==null)
     {
         this.exchange_node= node;
         return node.getLeft();

     }
     // save this exchange
     else
     {
         ConstructBinaryTree new_node= predecessor(node.getRight());
         node.setRight(new_node);
     }
     return node;
 }

 // inorder traversal
    public void inorder_traversal(ConstructBinaryTree root)
    {
        if(root==null)
            return;
        else
        {
            inorder_traversal(root.getLeft());
            System.out.print(" "+root.getValue());
            inorder_traversal(root.getRight());
        }
    }



    // deleting  node from binary search tree

     public ConstructBinaryTree delete_node(ConstructBinaryTree root, int data)
     {
         // deleting node which are leaf node
         if(root.getValue()==data)
         {
              if(root.getLeft()==null && root.getRight()==null)
                  return null;
              else if(root.getRight()==null && root.getLeft()!=null)
                      return root.getLeft();
              else if(root.getRight()!=null && root.getLeft()==null)
                  return root.getRight();
              else {
                  // find the predecessor or succesor
                  predecessor(root);
                  if(root.getLeft()==this.exchange_node)
                  {
                      root.setLeft(null);
                      root.setValue(exchange_node.getValue());
                      return  root;

                  }
                  else
                  {
                       root.setValue(exchange_node.getValue());
                       return root;
                  }

              }

         }
         else if(data> root.getValue())
         {
             ConstructBinaryTree node=delete_node(root.getRight(),data);
             root.setRight(node);
         }
         else if(data<root.getValue())
         {
             ConstructBinaryTree node=delete_node(root.getLeft(),data);
             root.setLeft(node);
         }
         return  root;





     }
public static void main(String args[])
{
    ConstructBinaryTree root;
    BinarySearchTree tree= new BinarySearchTree();
    root= tree.insert_binaryTree(null,20);
    tree.insert_binaryTree(root,10);
    tree.insert_binaryTree(root,30);
    tree.insert_binaryTree(root,40);
    tree.insert_binaryTree(root,35);
    tree.insert_binaryTree(root,38);
    tree.inorder_traversal(root);

    tree.delete_node(root,30);
    tree.inorder_traversal(root);




}




}
