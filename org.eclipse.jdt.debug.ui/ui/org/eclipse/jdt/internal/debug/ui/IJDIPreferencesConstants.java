package org.eclipse.jdt.internal.debug.ui;

import org.eclipse.jdt.debug.ui.IJavaDebugUIConstants;

/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
 
/**
 * Defines constants which are used to refer to values in the plugin's preference store.
 */
public interface IJDIPreferencesConstants {
	
	// keys 	
	static final String ATTACH_LAUNCH_PORT= "org.eclipse.jdt.debug.ui.attachlaunch.port"; //$NON-NLS-1$
	static final String ATTACH_LAUNCH_HOST= "org.eclipse.jdt.debug.ui.attachlaunch.host"; //$NON-NLS-1$
	static final String ATTACH_LAUNCH_ALLOW_TERMINATE= "org.eclipse.jdt.debug.ui.attachlaunch.allowTerminate"; //$NON-NLS-1$
		
	static final String SHOW_HEX_VALUES= "org.eclipse.jdt.debug.ui.javaDebug.showHexValues"; //$NON-NLS-1$
	static final String SHOW_CHAR_VALUES= "org.eclipse.jdt.debug.ui.javaDebug.showCharValues"; //$NON-NLS-1$
	static final String SHOW_UNSIGNED_VALUES= "org.eclipse.jdt.debug.ui.javaDebug.showUnsignedValues"; //$NON-NLS-1$
	static final String SUSPEND_ON_UNCAUGHT_EXCEPTIONS= "org.eclipse.jdt.ui.javaDebug.SuspendOnUncaughtExceptions"; //$NON-NLS-1$
	/**
	 * Boolean preference controlling whether to use the new AST evaluation support
	 * or the old class-file based evaluation support. This is a temporary option
	 * which will exist only while the AST evaluation is a work in progresss
	 */
	public static final String PREF_USE_AST_EVALUATION= IJavaDebugUIConstants.PLUGIN_ID + ".use_ast_evaluation"; //$NON-NLS-1$
	/**
	 * Integer preference controlling how long evaluations
	 * are allowed to proceed before the user is prompted
	 * to suspend the evalution. Represented in seconds.
	 */
	public static final String PREF_EVALUATION_TIMEOUT= IJavaDebugUIConstants.PLUGIN_ID + ".evaluation_timeout"; // $NON-NLS-1$
	/**
	 * Boolean preference controlling whether to suspend
	 * execution when a compilation error is encountered
	 * (while debugging).
	 */
	public static final String PREF_SUSPEND_ON_COMPILATION_ERRORS= IJavaDebugUIConstants.PLUGIN_ID + ".suspend_on_compilation_errors"; //$NON-NLS-1$
	
	/**
	 * Boolean preference controlling whether step filters
	 * are currently used in Java debug sessions.
	 */
	public static final String PREF_USE_FILTERS = IJavaDebugUIConstants.PLUGIN_ID + ".use_filters"; //$NON-NLS-1$
	
	/**
	 * Boolean preference controlling whether synthetic
	 * methods are to be filtered when stepping (and step
	 * filters are enabled).
	 */	
	public static final String PREF_FILTER_SYNTHETICS = IJavaDebugUIConstants.PLUGIN_ID + ".filter_synthetics"; //$NON-NLS-1$
	
	/**
	 * Boolean preference controlling whether static
	 * initializers are to be filtered when stepping (and step
	 * filters are enabled).
	 */		
	public static final String PREF_FILTER_STATIC_INITIALIZERS = IJavaDebugUIConstants.PLUGIN_ID + ".filter_statics"; //$NON-NLS-1$
	
	/**
	 * Boolean preference controlling whether constructors
	 * are to be filtered when stepping (and step
	 * filters are enabled).
	 */			
	public static final String PREF_FILTER_CONSTRUCTORS = IJavaDebugUIConstants.PLUGIN_ID + ".filter_constructors"; //$NON-NLS-1$
	
	/**
	 * List of active step filters. A String containing a comma
	 * separated list of fully qualified type names/patterns.
	 */			
	public static final String PREF_ACTIVE_FILTERS_LIST = IJavaDebugUIConstants.PLUGIN_ID + ".active_filters"; //$NON-NLS-1$
	
	/**
	 * List of inactive step filters. A String containing a comma
	 * separated list of fully qualified type names/patterns.
	 */				
	public static final String PREF_INACTIVE_FILTERS_LIST = IJavaDebugUIConstants.PLUGIN_ID + ".inactive_filters"; //$NON-NLS-1$	
	
	// Preference update flag useful for IPropertyChangeListeners to
	// by notified of variable rendering preference changes
	static final String VARIABLE_RENDERING = "VARIABLE_RENDERING"; //$NON-NLS-1$
	static final String ALERT_HCR_FAILED = "org.eclipse.jdt.debug.ui.javaDebug.alertHCRFailed"; //$NON-NLS-1$
	static final String ALERT_OBSOLETE_METHODS = "org.eclipse.jdt.debug.ui.javaDebug.alertObsoleteMethods"; //$NON-NLS-1$
}