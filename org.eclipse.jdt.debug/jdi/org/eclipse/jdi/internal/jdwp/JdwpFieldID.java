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
package org.eclipse.jdi.internal.jdwp;


import org.eclipse.jdi.internal.VirtualMachineImpl;

/**
 * This class implements the corresponding Java Debug Wire Protocol (JDWP) ID
 * declared by the JDWP specification.
 *
 */
public class JdwpFieldID extends JdwpID {
	/**
	 * Creates new JdwpID.
	 */
	public JdwpFieldID(VirtualMachineImpl vmImpl) {
		super(vmImpl);
	}
	
	/**
	 * @return Returns VM specific size of ID.
	 */
	public int getSize() {
		return fVirtualMachine.fieldIDSize();
	}

	/**
	 * @return Returns true if ID is null.
	 */
	public boolean isNull() {
		return false;
 	}
}
