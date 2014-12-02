package com.appbootup.explore.gwt.client.gridster;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class GWTDragDropGridster implements EntryPoint
{
	int counter = 0;

	public void onModuleLoad()
	{
		SplitLayoutPanel splitLayoutPanelDashboard = new SplitLayoutPanel( 5 );
		splitLayoutPanelDashboard.getElement().getStyle().setProperty( "border", "3px solid #e7e7e7" );

		VerticalPanel vPanelPalette = new VerticalPanel();
		vPanelPalette.add( new Label( "Palette" ) );
		vPanelPalette.setSpacing( 10 );
		final ListBox lBoxCharts = new ListBox();
		lBoxCharts.addItem( "Column With Rotated Series", "chart01" );
		lBoxCharts.addItem( "Column And Line Mix", "chart02" );
		lBoxCharts.addItem( "Layered Column Chart", "chart03" );
		lBoxCharts.addItem( "Simple Column Chart", "chart04" );
		lBoxCharts.addItem( "3D Cylinder Chart", "chart05" );
		lBoxCharts.addItem( "3D Stacked Column Chart", "chart06" );
		lBoxCharts.addItem( "Stacked Column Chart", "chart07" );
		lBoxCharts.addItem( "3D Column Chart", "chart08" );
		lBoxCharts.addItem( "100% Stacked Column Chart", "chart09" );
		vPanelPalette.add( lBoxCharts );

		Button btnAdd = new Button( "Add" );
		Button btnRemove = new Button( "Remove" );
		FlowPanel btnWrapper = new FlowPanel();

		btnWrapper.add( btnAdd );
		btnWrapper.add( btnRemove );
		vPanelPalette.add( btnWrapper );

		ScrollPanel sPanelPalette = new ScrollPanel();
		sPanelPalette.setHeight( "100%" );
		sPanelPalette.add( vPanelPalette );

		ScrollPanel sPanelCanvas = new ScrollPanel();
		sPanelCanvas.setHeight( "100%" );
		final Gridster gridster = new Gridster();
		//sPanelCanvas.add( gridsterWrapper );

		splitLayoutPanelDashboard.addNorth( new Label( "Title" ), 50 );
		splitLayoutPanelDashboard.addSouth( new Label( "Footer" ), 50 );
		splitLayoutPanelDashboard.addWest( sPanelPalette, 220 );
		splitLayoutPanelDashboard.addNorth( new Label( "Subtitle" ), 50 );
		splitLayoutPanelDashboard.addSouth( new Label( "Subfooter" ), 50 );
		splitLayoutPanelDashboard.add( gridster );

		btnAdd.addClickHandler( new ClickHandler()
		{
			@Override
			public void onClick( ClickEvent event )
			{
				String selectedItemText = lBoxCharts.getSelectedItemText();
				gridster.addWidget( selectedItemText );
			}
		} );
		btnRemove.addClickHandler( new ClickHandler()
		{
			@Override
			public void onClick( ClickEvent event )
			{
				gridster.removeWidgetByIndex( 0 );
			}
		} );

		RootLayoutPanel.get().add( splitLayoutPanelDashboard );
	}
}