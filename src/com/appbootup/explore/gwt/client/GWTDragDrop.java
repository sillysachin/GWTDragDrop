package com.appbootup.explore.gwt.client;

import com.appbootup.explore.gwt.client.gridster.Gridster;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class GWTDragDrop implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		Gridster gridster = new Gridster();
		RootLayoutPanel.get().add( gridster );
		LogUtils.log( gridster.getJso() );
		gridster.addWidget( "0", 1, 2 );
		gridster.addWidget( "1", 3, 2 );
		gridster.addWidget( "2", 3, 2 );
		gridster.addWidget( "3", 2, 1 );
		gridster.addWidget( "4", 4, 1 );
		gridster.addWidget( "5", 1, 2 );
		gridster.addWidget( "6", 2, 1 );
		gridster.addWidget( "7", 3, 2 );
		gridster.addWidget( "8", 1, 1 );
		gridster.addWidget( "9", 2, 2 );
		gridster.addWidget( "10", 1, 3 );
	}
}