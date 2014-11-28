package com.appbootup.explore.gwt.client.snaptogrid;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class GWTDragDropMultisizeSnapToGrid implements EntryPoint
{
	private static final int TILE_SIZE_PIXEL = 60;

	int counter = 0;

	private PickupDragController dragController;

	private GridConstrainedDropController gridConstrainedDropController;

	public void onModuleLoad()
	{
		SplitLayoutPanel splitLayoutPanelDashboard = new SplitLayoutPanel( 5 );
		splitLayoutPanelDashboard.getElement().getStyle().setProperty( "border", "3px solid #e7e7e7" );

		VerticalPanel vPanelPalette = new VerticalPanel();
		vPanelPalette.add( new Label( "Palette" ) );

		ListBox lBoxCharts = new ListBox();
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

		CheckBox chkBoxOneSquare = new CheckBox();
		chkBoxOneSquare.setText( "One Square" );
		vPanelPalette.add( chkBoxOneSquare );
		CheckBox chkBoxFourSquare = new CheckBox();
		chkBoxFourSquare.setText( "Four Square" );
		vPanelPalette.add( chkBoxFourSquare );
		CheckBox chkBoxEightSquare = new CheckBox();
		chkBoxEightSquare.setText( "Eight Square" );
		vPanelPalette.add( chkBoxEightSquare );
		CheckBox chkBoxSixteenSquare = new CheckBox();
		chkBoxSixteenSquare.setText( "Sixteen Square" );
		vPanelPalette.add( chkBoxSixteenSquare );

		CheckBox chkBoxTwoHorizontalSquare = new CheckBox();
		chkBoxTwoHorizontalSquare.setText( "Two Horizontal Square" );
		vPanelPalette.add( chkBoxTwoHorizontalSquare );
		CheckBox chkBoxThreeHorizontalSquare = new CheckBox();
		chkBoxThreeHorizontalSquare.setText( "Three Horizontal Square" );
		vPanelPalette.add( chkBoxThreeHorizontalSquare );
		CheckBox chkBoxFourHorizontalSquare = new CheckBox();
		chkBoxFourHorizontalSquare.setText( "Four Horizontal Square" );
		vPanelPalette.add( chkBoxFourHorizontalSquare );
		Button btnAdd = new Button( "Add" );
		vPanelPalette.add( btnAdd );

		ScrollPanel sPanelPalette = new ScrollPanel();
		sPanelPalette.setHeight( "100%" );
		sPanelPalette.add( vPanelPalette );

		ScrollPanel sPanelCanvas = new ScrollPanel();
		sPanelCanvas.setHeight( "100%" );
		AbsolutePanel boundaryPanel = new AbsolutePanel();
		sPanelCanvas.add( boundaryPanel );
		dragController = new PickupDragController( boundaryPanel, false );
		dragController.setBehaviorMultipleSelection( false );

		final FlowPanel fPanelWrapper = new FlowPanel();
		btnAdd.addClickHandler( new ClickHandler()
		{
			@Override
			public void onClick( ClickEvent event )
			{
				counter++;
				FlowPanel fPanelChartWrapper = new FlowPanel();
				String wrapperId = "wrapper-controller--" + counter;
				fPanelChartWrapper.getElement().setId( wrapperId );
				fPanelChartWrapper.addStyleName( "fPanelChartWrapper" );
				if ( counter % 2 == 0 )
				{
					fPanelChartWrapper.setWidth( TILE_SIZE_PIXEL * 2 + "px" );
					fPanelChartWrapper.setHeight( TILE_SIZE_PIXEL + "px" );
				}
				else if ( counter % 3 == 0 )
				{
					fPanelChartWrapper.setWidth( TILE_SIZE_PIXEL * 3 + "px" );
					fPanelChartWrapper.setHeight( TILE_SIZE_PIXEL + "px" );
				}
				else if ( counter % 5 == 0 )
				{
					fPanelChartWrapper.setWidth( TILE_SIZE_PIXEL + "px" );
					fPanelChartWrapper.setHeight( ( TILE_SIZE_PIXEL * 2 ) + 6 + 2 + "px" );
					GWT.log( "Odd Height" );
				}
				else
				{
					fPanelChartWrapper.setWidth( TILE_SIZE_PIXEL + "px" );
					fPanelChartWrapper.setHeight( TILE_SIZE_PIXEL + "px" );
				}
				// instantiate a drop controller of the panel in the current cell
				fPanelWrapper.add( fPanelChartWrapper );
			}
		} );
		boundaryPanel.add( fPanelWrapper );

		splitLayoutPanelDashboard.addNorth( new Label( "North1" ), 50 );
		splitLayoutPanelDashboard.addSouth( new Label( "South1" ), 50 );
		splitLayoutPanelDashboard.addWest( sPanelPalette, 200 );
		/*splitLayoutPanelDashboard.addNorth( new Label( "North2" ), 50 );*/
		/*splitLayoutPanelDashboard.addSouth( new Label( "South2" ), 50 );*/
		splitLayoutPanelDashboard.add( sPanelCanvas );

		RootLayoutPanel.get().add( splitLayoutPanelDashboard );
	}

	protected Widget createDraggable( int counter )
	{
		String chartId = "chart0" + counter;
		Image image = new Image( GWT.getHostPageBaseURL() + "images/demo/" + chartId + ".png" );
		dragController.makeDraggable( image );
		return image;
	}
}