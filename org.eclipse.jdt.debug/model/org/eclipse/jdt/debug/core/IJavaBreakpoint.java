/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.jdt.debug.core;


import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.model.IBreakpoint;

/**
 * A breakpoint specific to the Java debug model. A Java breakpoint
 * supports:
 * <ul>
 * <li>a hit count</li>
 * <li>a suspend policy that determines if the entire VM or
 *   a single thread is suspended when hit</li>
 * <li>a thread filter to restrict a breakpoin to a specific
 *  thread within a VM</li>
 * <li>an installed property that indicates a breakpoint was successfully
 *  installed in a VM</li>
 * </ul>
 * <p>
 * Clients are not intended to implement this interface
 * </p>
 * @since 2.0
 */
public interface IJavaBreakpoint extends IBreakpoint {
	
	/**
	 * Suspend policy constant indicating a breakpoint will
	 * suspend the target VM when hit.
	 */
	public static final int SUSPEND_VM = 1;
	
	/**
	 * Default suspend policy constant indicating a breakpoint will
	 * suspend only the thread in which it occurred.
	 */
	public static final int SUSPEND_THREAD = 2;
	
	/**
	 * Returns whether this breakpoint is installed in at least
	 * one debug target.
	 * 
	 * @return whether this breakpoint is installed
	 * @exception CoreException if unable to access the property 
	 * 	on this breakpoint's underlying marker
	 */
	public boolean isInstalled() throws CoreException;
	/**
	 * Returns the fully qualified name of the type this breakpoint
	 * is located in, or <code>null</code> if this breakpoint
	 * is not located in a specific type - for example, a pattern breakpoint.
	 * 
	 * @return the fully qualified name of the type this breakpoint
	 *  is located in, or <code>null</code>
	 * @exception CoreException if unable to access the property
	 * 	from this breakpoint's underlying marker
	 */
	public String getTypeName() throws CoreException;
	/**
	 * Returns this breakpoint's hit count or, -1 if this
	 * breakpoint does not have a hit count.
	 * 
	 * @return this breakpoint's hit count, or -1
	 * @exception CoreException if unable to access the property
	 *  from this breakpoint's underlying marker
	 */
	public int getHitCount() throws CoreException;
	/**
	 * Sets the hit count attribute of this breakpoint.
	 * If this breakpoint is currently disabled and the hit count
	 * is set greater than -1, this breakpoint is automatically enabled.
	 * 
	 * @param count the new hit count
	 * @exception CoreException if unable to set the property
	 * 	on this breakpoint's underlying marker
	 */
	public void setHitCount(int count) throws CoreException;	
	
	/**
	 * Sets whether all threads in the target VM will be suspended
	 * when this breakpoint is hit. When <code>SUSPEND_VM</code> the target
	 * VM is suspended, and when <code>SUSPEND_THREAD</code> only the thread
	 * in which this breakpoint occurred is suspended.
	 * 
	 * @param suspendPolicy one of <code>SUSPEND_VM</code> or
	 *  <code>SUSPEND_THREAD</code>
	 * @exception CoreException if unable to set the property
	 * 	on this breakpoint's underlying marker
	 */
	public void setSuspendPolicy(int suspendPolicy) throws CoreException;
	
	/**
	 * Returns the suspend policy used by this breakpoint, one of
	 * <code>SUSPEND_VM</code> or <code>SUSPEND_THREAD</code>.
	 * 
	 * @return one of <code>SUSPEND_VM</code> or <code>SUSPEND_THREAD</code>
	 * @exception CoreException if unable to access the property 
	 * 	from this breakpoint's underlying marker
	 */
	public int getSuspendPolicy() throws CoreException;
	
	/**
	 * Restricts this breakpoint to suspend only in the given thread
	 * when encounterd in the given thread's target. A breakpoint can
	 * only be resticted to one thread per target. Any previous
	 * thread filter for the same target is lost.
	 * A thread filter is not persisted
	 * across workbench invocations.
	 * 
	 * @exception CoreException if unable to set the thread filter
	 */
	public void setThreadFilter(IJavaThread thread) throws CoreException;
	
	/**
	 * Removes this breakpoint's thread filter in the given target, if any. 
	 * Has no effect if this breakpoint does not have a filter in the given target.
	 * 
	 * @param target the target whose thread filter will be removed
	 * @exception CoreException if unable to remove the thread filter
	 */
	public void removeThreadFilter(IJavaDebugTarget target) throws CoreException;
	
	/**
	 * Returns the thread in the given target in which this breakpoint
	 * is enabled or <code>null</code> if this breakpoint is enabled in
	 * all threads in the given target.
	 * 
	 * @return the thread in the given target that this breakpoint is enabled for
	 * @exception CoreException if unable to determine this breakpoint's thread
	 *  filter
	 */
	public IJavaThread getThreadFilter(IJavaDebugTarget target) throws CoreException;
	/**
	 * Returns all thread filters set on this breakpoint.
	 * 
	 * @return the threads that this breakpoint is resticted to
	 * @exception CoreException if unable to determine this breakpoint's
	 *  thread filters
	 */
	public IJavaThread[] getThreadFilters() throws CoreException; 
	
	/**
	 * Adds the given object to the list of objects in which this
	 * breakpoint is restricted to suspend execution. Has no effect
	 * if the object has already been added. Note that clients should
	 * first ensure that a breakpoint supports instance filters.
	 * <p>
	 * Note: This implementation will add more than one filter. However, if there is
	 * more than one instance filter for a debug target, the breakpoint will never be hit
	 * in that target, as the current context cannot be two different instances at the
	 * same time.
	 * </p>
	 * 
	 * @param object instance filter to add
	 * @exception CoreException if unable to add the given instance filter
	 * @since 2.1
	 */
	public void addInstanceFilter(IJavaObject object) throws CoreException;
	
	/**
	 * Removes the given object from the list of objects in which this
	 * breakpoint is restricted to suspend execution. Has no effect if the
	 * object has not yet been added as an instance filter.
	 * 
	 * @param object instance filter to remove
	 * @exception CoreException if unable to remove the given instance filter
	 * @since 2.1
	 */
	public void removeInstanceFilter(IJavaObject object) throws CoreException;
	
	/**
	 * Returns whether this breakpoints supports instance filters.
	 * 
	 * @return whether this breakpoints supports instance filters
	 * @since 3.0
	 */
	public boolean supportsInstanceFilters();
	
	/**
	 * Returns the current set of active instance filters.
	 * 
	 * @return the current set of active instance filters.
	 * @exception CoreException if unable to retrive the list
	 * @since 2.1
	 */	
	public IJavaObject[] getInstanceFilters() throws CoreException;

	/**
	 * Returns whether this breakpoints supports thread filters.
	 * 
	 * @return whether this breakpoints supports thread filters
	 * @since 3.0
	 */
	public boolean supportsThreadFilters();
	
}

