/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package me.deftware.client.framework.util.types;

import lombok.Generated;

public class Pair<L, R> {
    private L left;
    private R right;

    @Generated
    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Generated
    public L getLeft() {
        return this.left;
    }

    @Generated
    public R getRight() {
        return this.right;
    }

    @Generated
    public void setLeft(L left) {
        this.left = left;
    }

    @Generated
    public void setRight(R right) {
        this.right = right;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair other = (Pair)o;
        if (!other.canEqual(this)) {
            return false;
        }
        L this$left = this.getLeft();
        L other$left = other.getLeft();
        if (this$left == null ? other$left != null : !this$left.equals(other$left)) {
            return false;
        }
        R this$right = this.getRight();
        R other$right = other.getRight();
        return !(this$right == null ? other$right != null : !this$right.equals(other$right));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof Pair;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        L $left = this.getLeft();
        result = result * 59 + ($left == null ? 43 : $left.hashCode());
        R $right = this.getRight();
        result = result * 59 + ($right == null ? 43 : $right.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "Pair(left=" + String.valueOf(this.getLeft()) + ", right=" + String.valueOf(this.getRight()) + ")";
    }
}

