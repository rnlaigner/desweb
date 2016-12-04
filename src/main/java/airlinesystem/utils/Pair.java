/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.utils;

import java.io.Serializable;

public class Pair<L,R> implements Serializable
{

  /**
	 * 
	 */
  private static final long serialVersionUID = 15408497224845273L;
  private final L left;
  private final R right;

  public Pair(L left, R right) {
    this.left = left;
    this.right = right;
  }

  public L getLeft() { return left; }
  public R getRight() { return right; }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair)) return false;
    //TODO testar
    Pair<?, ?> pair = (Pair<?, ?>) o;
    return this.left.equals(pair.getLeft()) &&
           this.right.equals(pair.getRight());
  }

}
