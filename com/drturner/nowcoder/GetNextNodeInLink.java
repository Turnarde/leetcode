package com.drturner.nowcoder;

/**
 * ClassName: GetNextNodeInLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class GetNextNodeInLink {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode==null) return null;
        TreeLinkNode leftMost=null;
        if (pNode.right!=null){
            leftMost=pNode.right;
            while (leftMost.left!=null)
                leftMost=leftMost.left;
            return leftMost;
        }
        else {
            while (pNode.next!=null&&pNode!=pNode.next.left){
                pNode=pNode.next;
            }
            return pNode.next;
        }
    }
}
