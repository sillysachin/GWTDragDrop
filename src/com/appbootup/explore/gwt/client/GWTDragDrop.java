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
		gridster.addWidget();
	}
}