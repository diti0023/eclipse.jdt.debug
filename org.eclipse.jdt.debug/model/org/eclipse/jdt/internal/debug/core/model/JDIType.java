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
package org.eclipse.jdt.internal.debug.core.model;

 
import java.text.MessageFormat;

import org.eclipse.debug.core.DebugException;
import org.eclipse.jdt.debug.core.IJavaType;

import com.sun.jdi.ArrayType;
import com.sun.jdi.ClassType;
import com.sun.jdi.InterfaceType;
import com.sun.jdi.Type;

/**
 * A type of an object or primitive data type in a debug target.
 */
public class JDIType implements IJavaType {
	
	/**
	 * Underlying type on target VM
	 */
	private Type fType;
	
	/**
	 * The debug target this type originated from
	 */
	private JDIDebugTarget fDebugTarget;
	
	/**
	 * Constructs a new type based on the specified underlying
	 * type, in the given debug target
	 * 
	 * @param target the debug target this type originated from
	 * @param type underlying type on the target VM
	 */
	protected JDIType(JDIDebugTarget target, Type type) {
		setDebugTarget(target);
		setUnderlyingType(type);
	}

	/**
	 * Creates the appropriate kind of type, based on the specialized
	 * type.
	 */
	public static JDIType createType(JDIDebugTarget target, Type type) {
		if (type instanceof ArrayType) {
			return new JDIArrayType(target, (ArrayType)type);
		}
		if (type instanceof ClassType) {
			return new JDIClassType(target, (ClassType)type);
		}
		if (type instanceof InterfaceType) {
			return new JDIInterfaceType(target, (InterfaceType)type);
    	}	
		return new JDIType(target, type);
	}
	
	/**
	 * @see IJavaType#getSignature()
	 */
	public String getSignature() throws DebugException {
		try {
			return getUnderlyingType().signature();
		} catch (RuntimeException e) {
			getDebugTarget().targetRequestFailed(MessageFormat.format(JDIDebugModelMessages.getString("JDIType.exception_while_retrieving_signature"), new String[] {e.toString()}), e); //$NON-NLS-1$
			// execution will not reach this line as
			// #targetRequestFailed will throw an exception
			return null;
		}
	}

	/**
	 * Returns the debug target this type originated from.
	 * 
	 * @return the debug targe this type originated
	 * 	from
	 */
	protected JDIDebugTarget getDebugTarget() {
		return fDebugTarget;
	}

	/**
	 * Sets the debug target this type originated from.
	 * 
	 * @param debugTarget the debug targe this type originated
	 * 	from
	 */
	protected void setDebugTarget(JDIDebugTarget debugTarget) {
		fDebugTarget = debugTarget;
	}

	/**
	 * Returns the underlying type on the VM.
	 * 
	 * @return the underlying type on the VM
	 */
	public Type getUnderlyingType() {
		return fType;
	}

	/**
	 * Sets the underlying type on the VM.
	 * 
	 * @param type the underlying type on the VM
	 */
	protected void setUnderlyingType(Type type) {
		fType = type;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return getUnderlyingType().toString();
	}
	
	/**
	 * @see IJavaType#getName()
	 */
	public String getName() throws DebugException {
		try {
			return getUnderlyingType().name();
		} catch (RuntimeException e) {
			getDebugTarget().targetRequestFailed(MessageFormat.format(JDIDebugModelMessages.getString("JDIType.exception_while_retrieving_type_name"), new String[]{e.toString()}), e); //$NON-NLS-1$
		}
		// execution will not fall through as an exception
		// will be thrown by the catch block
		return null;
	}
	
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		return object instanceof JDIType && fType.equals(((JDIType)object).fType);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return fType.hashCode();
	}

}
