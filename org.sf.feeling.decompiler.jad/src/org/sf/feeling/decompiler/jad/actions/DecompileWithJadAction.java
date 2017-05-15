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

package org.sf.feeling.decompiler.jad.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.Action;
import org.sf.feeling.decompiler.jad.JadDecompilerPlugin;
import org.sf.feeling.decompiler.jad.i18n.Messages;
import org.sf.feeling.decompiler.util.UIUtil;

public class DecompileWithJadAction extends Action
{

	public DecompileWithJadAction( )
	{
		super( Messages.getString( "JavaDecompilerActionBarContributor.Action.DecompileWithJad" ) ); //$NON-NLS-1$
		this.setImageDescriptor( JadDecompilerPlugin.getImageDescriptor( "icons/jad_16.gif" ) ); //$NON-NLS-1$
	}

	public void run( )
	{
		try
		{
			new DecompileWithJadHandler( ).execute( null );
		}
		catch ( ExecutionException e )
		{
		}
	}

	public boolean isEnabled( )
	{
		return UIUtil.getActiveEditor( ) != null
				|| UIUtil.getActiveSelection( ) != null;
	}
}