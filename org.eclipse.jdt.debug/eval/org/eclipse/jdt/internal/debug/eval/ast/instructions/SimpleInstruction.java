/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.debug.eval.ast.instructions;



/**
 * A simple instruction cannot contain other instructions
 * so its size is always one.
 */
public abstract class SimpleInstruction extends Instruction {

	/**
	 * Constructor for SimpleInstruction.
	 */
	protected SimpleInstruction() {
		super();
	}
	
	public int getSize() {
		return 1;
	}






}
