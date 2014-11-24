package com.appbootup.explore.gwt.client;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.AbsolutePositionDropController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.allen_sauer.gwt.dnd.client.util.DOMUtil;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTDragDropFloat implements EntryPoint
{
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		// Create a boundary panel to constrain all drag operations
		AbsolutePanel boundaryPanel = new AbsolutePanel();
		boundaryPanel.setPixelSize( 1240, 760 );
		boundaryPanel.addStyleName( "getting-started-blue" );

		// Create a drop target on which we can drop labels
		AbsolutePanel targetPanel = new AbsolutePanel();
		targetPanel.setPixelSize( 360, 225 );
		targetPanel.addStyleName( "getting-started-blue" );

		// Add both panels to the root panel
		RootLayoutPanel.get().add( boundaryPanel );
		boundaryPanel.add( targetPanel, 10, 10 );

		// Create a DragController for each logical area where a set of draggable
		// widgets and drop targets will be allowed to interact with one another.
		PickupDragController dragController = new PickupDragController( boundaryPanel, true );

		// Positioner is always constrained to the boundary panel
		// Use 'true' to also constrain the draggable or drag proxy to the boundary panel
		dragController.setBehaviorConstrainedToBoundaryPanel( false );

		// Allow multiple widgets to be selected at once using CTRL-click
		dragController.setBehaviorMultipleSelection( true );

		// create a DropController for each drop target on which draggable widgets
		// can be dropped
		DropController dropController = new AbsolutePositionDropController( targetPanel );

		// Don't forget to register each DropController with a DragController
		dragController.registerDropController( dropController );

		// create a few randomly placed draggable labels
		for ( int i = 1; i <= 9; i++ )
		{
			// create a label and give it style
			Image img = new Image( GWT.getHostPageBaseURL() + "images/demo/" + "chart0" + i + ".png" );
			img.addStyleName( "getting-started-image" );

			// add it to the DOM so that offset width/height becomes available
			targetPanel.add( img, 0, 0 );

			// determine random label location within target panel
			int left = Random.nextInt( DOMUtil.getClientWidth( targetPanel.getElement() ) - img.getOffsetWidth() );
			int top = Random.nextInt( DOMUtil.getClientHeight( targetPanel.getElement() ) - img.getOffsetHeight() );

			// move the label
			targetPanel.setWidgetPosition( img, left, top );

			// make the label draggable
			dragController.makeDraggable( img );
		}
	}
}