/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.sun.jdi;


import java.util.List;
import java.util.Map;

public interface ReferenceType extends Type , Comparable , Accessible {
	public List allFields();
	public List allMethods();
	public List allLineLocations() throws AbsentInformationException;
	public ClassLoaderReference classLoader();
	public ClassObjectReference classObject();
	public boolean equals(Object arg1);
	public boolean failedToInitialize();
	public Field fieldByName(String arg1);
	public List fields();
	public String genericSignature();
	public Value getValue(Field arg1);
	public Map getValues(List arg1);
	public int hashCode();
	public boolean isAbstract();
	public boolean isFinal();
	public boolean isInitialized();
	public boolean isPrepared();
	public boolean isStatic();
	public boolean isVerified();
	public List locationsOfLine(int arg1) throws AbsentInformationException;
	public List methods();
	public List methodsByName(String arg1);
	public List methodsByName(String arg1, String arg2);
	public String name();
	public List nestedTypes();
	public String sourceName() throws AbsentInformationException;
	public List visibleFields();
	public List visibleMethods();
	public List sourceNames(String arg1) throws AbsentInformationException;
	public List sourcePaths(String arg1) throws AbsentInformationException;
	public String sourceDebugExtension() throws AbsentInformationException;
	public List allLineLocations(String arg1, String arg2) throws AbsentInformationException;
	public List locationsOfLine(String arg1, String arg2, int arg3) throws AbsentInformationException;
	public List availableStrata();
	public String defaultStratum();
}
