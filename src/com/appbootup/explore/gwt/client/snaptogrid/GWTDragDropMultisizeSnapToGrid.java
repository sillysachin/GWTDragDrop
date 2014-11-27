package com.appbootup.explore.gwt.client.snaptogrid;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class GWTDragDropMultisizeSnapToGrid implements EntryPoint
{
	public void onModuleLoad()
	{
		DockLayoutPanel dLayoutPanelDashboard = new DockLayoutPanel( Unit.PCT );
		dLayoutPanelDashboard.setStyleName("cw-DockLayoutPanel");

		ScrollPanel sPanelPalette = new ScrollPanel();
		ListBox lBoxCharts = new ListBox();
		lBoxCharts.addItem( "Column With Rotated Series", "chart01" );
		lBoxCharts.addItem( "Column And Line Mix", "chart02" );
		lBoxCharts.addItem( "3D Cylinder Chart", "chart03" );
		lBoxCharts.addItem( "3D Column Chart", "chart04" );
		lBoxCharts.addItem( "Layered Column Chart", "chart05" );
		lBoxCharts.addItem( "3D Stacked Column Chart", "chart06" );
		sPanelPalette.add( lBoxCharts );

		ScrollPanel sPanelCanvas = new ScrollPanel();
		AbsolutePanel gridConstrainedDropTarget = new AbsolutePanel();
		gridConstrainedDropTarget.addStyleName( "cw-AbsolutePanel-GridConstrainedDropTarget" );

		sPanelCanvas.add( gridConstrainedDropTarget );
		dLayoutPanelDashboard.addWest( sPanelPalette, 200 );
		dLayoutPanelDashboard.addSouth( sPanelCanvas, 800 );

		RootLayoutPanel.get().add( dLayoutPanelDashboard );
	}
}
