/*******************************************************************************
 * Copyright (c) 2017 Chen Chao(cnfree2000@hotmail.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chen Chao  - initial API and implementation
 *******************************************************************************/

package org.sf.feeling.decompiler.update;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.sf.feeling.decompiler.JavaDecompilerPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class DecompilerUpdatePlugin extends AbstractUIPlugin implements IPropertyChangeListener
{

	// The plug-in ID
	public static final String PLUGIN_ID = "org.sf.feeling.decompiler.update"; //$NON-NLS-1$

	// The shared instance
	private static DecompilerUpdatePlugin plugin;

	private IPreferenceStore preferenceStore;


	/**
	 * The constructor
	 */
	public DecompilerUpdatePlugin( )
	{
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void start( BundleContext context ) throws Exception
	{
		super.start( context );
		plugin = this;
		getPreferenceStore( ).addPropertyChangeListener( this );
	}

	@Override
	public IPreferenceStore getPreferenceStore( )
	{
		if ( preferenceStore == null )
		{
			preferenceStore = JavaDecompilerPlugin.getDefault( ).getPreferenceStore( );
		}
		return preferenceStore;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void stop( BundleContext context ) throws Exception
	{
		getPreferenceStore( ).removePropertyChangeListener( this );
		plugin = null;
		super.stop( context );
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static DecompilerUpdatePlugin getDefault( )
	{
		return plugin;
	}

	@Override
	public void propertyChange( PropertyChangeEvent event )
	{

	}
}
