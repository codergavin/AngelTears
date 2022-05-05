package com.ruoyi.common.utils.tree;

import com.ruoyi.common.utils.StringUtils;

import java.util.List;

/**
 * 树节点
 *
 * @author gaofu
 *
 * @param <T>
 */
public abstract class TreeNode<T extends TreeNode<T>> {

    /**
     * 判断是否是主枝干
     *
     * @return
     */
    public boolean isTrunk() {
        return StringUtils.isEmpty(getParentCode());
    }

    /**
     * 判断本节点是否是node的父节点
     *
     * @param node
     * @return
     */
    public boolean isParentOf(T node) {
        if (node != null) {
            return TreeUtil.isEquals(node.getParentCode(), this.getCode());
        }
        return false;
    }

    /**
     * 判断本节点是否是node的孩子节点
     *
     * @param node
     * @return
     */
    public boolean isChildOf(T node) {
        if (node == null) {
            if (this.getParentCode() == null) {
                return true;
            }
        } else {
            return TreeUtil.isEquals(node.getCode(), this.getParentCode());
        }
        return false;
    }

    public abstract String getParentCode();

    public abstract void setParentCode(String parentId);

    public abstract String getCode();

    public abstract void setCode(String id);

    public abstract List<T> getChildren();

    public abstract void setChildren(List<T> children);

}