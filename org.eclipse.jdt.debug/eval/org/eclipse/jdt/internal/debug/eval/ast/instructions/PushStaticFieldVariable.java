/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.internal.debug.eval.ast.instructions;


import java.text.MessageFormat;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.debug.core.IJavaClassType;
import org.eclipse.jdt.debug.core.IJavaInterfaceType;
import org.eclipse.jdt.debug.core.IJavaType;
import org.eclipse.jdt.debug.core.IJavaVariable;
import org.eclipse.jdt.internal.debug.core.JDIDebugPlugin;
 
/**
 * Pushes the value of the static fields of the given type
 * onto the stack.
 */
public class PushStaticFieldVariable extends CompoundInstruction {
	
	private String fFieldName;
	
	private String fQualifiedTypeName;
	
	public PushStaticFieldVariable(String fieldName, String qualifiedTypeName, int start) {
		super(start);
		fFieldName= fieldName;
		fQualifiedTypeName= qualifiedTypeName;
	}
	
	public void execute() throws CoreException {
		IJavaType receiver= getType(fQualifiedTypeName);
		
		IJavaVariable field= null;

		if (receiver instanceof IJavaInterfaceType) {
			field= ((IJavaInterfaceType)receiver).getField(fFieldName);
		} else if (receiver instanceof IJavaClassType) {
			field= ((IJavaClassType)receiver).getField(fFieldName);
		}
		if (field == null) {
			String message= MessageFormat.format(InstructionsEvaluationMessages.getString("PushStaticFieldVariable.Cannot_find_the_field_{0}_in_{1}_1"), new String[]{fFieldName, fQualifiedTypeName}); //$NON-NLS-1$
			throw new CoreException(new Status(IStatus.ERROR, JDIDebugPlugin.getUniqueIdentifier(), IStatus.OK, message, null)); // couldn't find the field
		}
		push(field);
	}
	
	public String toString() {
		return MessageFormat.format(InstructionsEvaluationMessages.getString("PushStaticFieldVariable.push_static_field_{0}_2"), new String[]{fFieldName}); //$NON-NLS-1$
	}

}

