package org.chamomile.widgets;

import java.io.Serializable;

/**
 * Class representing the insets of an object.
 */
@SuppressWarnings("serial")
public final class Insets implements Serializable {

  /**
   * Insets whose top, left, bottom, and right values are all zero.
   */
  public static final Insets NONE = new Insets();

//  public static final String TOP_KEY = "top";
//  public static final String LEFT_KEY = "left";
//  public static final String BOTTOM_KEY = "bottom";
//  public static final String RIGHT_KEY = "right";

  public final Length top, left, bottom, right;

  public Insets() {
    this(Length.px(0D));
  }

  public Insets(Length inset) {
    this(inset, inset, inset, inset);
  }

  public Insets(Length top, Length left, Length bottom, Length right) {
    this.top = top;
    this.left = left;
    this.bottom = bottom;
    this.right = right;
  }

  public Insets(Insets insets) {
    if (insets == null) {
      throw new IllegalArgumentException("insets is null.");
    }

    this.top = insets.top;
    this.left = insets.left;
    this.bottom = insets.bottom;
    this.right = insets.right;
  }

  public Length getTop() {
    return top;
  }

  public Length getLeft() {
    return left;
  }

  public Length getBottom() {
    return bottom;
  }

  public Length getRight() {
    return right;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bottom == null) ? 0 : bottom.hashCode());
    result = prime * result + ((left == null) ? 0 : left.hashCode());
    result = prime * result + ((right == null) ? 0 : right.hashCode());
    result = prime * result + ((top == null) ? 0 : top.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Insets other = (Insets) obj;
    if (bottom == null) {
      if (other.bottom != null)
        return false;
    } else if (!bottom.equals(other.bottom))
      return false;
    if (left == null) {
      if (other.left != null)
        return false;
    } else if (!left.equals(other.left))
      return false;
    if (right == null) {
      if (other.right != null)
        return false;
    } else if (!right.equals(other.right))
      return false;
    if (top == null) {
      if (other.top != null)
        return false;
    } else if (!top.equals(other.top))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return top + " " + right + " " + bottom + " " + left;
  }

}
