
/**********************************************************************
Copyright (c) 2000, 2002 IBM Corp.  All rights reserved.
This file is made available under the terms of the Common Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/cpl-v10.html
**********************************************************************/

public class ConditionalStepReturn {
  public static void main(String[] args) {
    new ConditionalStepReturn().foo();
  }
  public void foo() {
    boolean bool= true; // BREAKPOINT HERE
    System.out.println("grah"); // CONDITIONAL BREAKPOINT HERE
  }
}