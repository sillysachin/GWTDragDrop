package com.appbootup.explore.gwt.client.snaptogrid;

import com.allen_sauer.gwt.dnd.client.DragEndEvent;
import com.allen_sauer.gwt.dnd.client.DragHandler;
import com.allen_sauer.gwt.dnd.client.DragStartEvent;
import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTDragDropSnapToGrid implements EntryPoint
{
	private static final int COLUMNS = 3;

	private static final int ROWS = 3;

	private static final int IMAGE_HEIGHT = 225;

	private static final int IMAGE_WIDTH = 360;

	private PickupDragController dragController;

	private GridConstrainedDropController gridConstrainedDropController;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		// Create a boundary panel to constrain all drag operations
		AbsolutePanel boundaryPanel = new AbsolutePanel();
		boundaryPanel.setPixelSize( 1240, 760 );
		boundaryPanel.addStyleName( "getting-started-blue" );

		// Add both panels to the root panel
		RootLayoutPanel.get().add( boundaryPanel );
		// initialize our flex table
		AbsolutePanel gridConstrainedDropTarget = new AbsolutePanel();
		gridConstrainedDropTarget.addStyleName( "cw-AbsolutePanel-GridConstrainedDropTarget" );

		boundaryPanel.add( gridConstrainedDropTarget, 50, 20 );

		// initialize our drag controller
		dragController = new PickupDragController( boundaryPanel, false );
		dragController.setBehaviorMultipleSelection( false );

		// instantiate our drop controller
		gridConstrainedDropController = new GridConstrainedDropController( gridConstrainedDropTarget, IMAGE_WIDTH, IMAGE_HEIGHT );
		dragController.registerDropController( gridConstrainedDropController );
		// set our drop target size to a multiple of the draggable size
		gridConstrainedDropTarget.setPixelSize( IMAGE_WIDTH * 3, IMAGE_HEIGHT * 3 );

		int counter = 0;
		// create a few randomly placed draggable labels
		for ( int i = 0; i < COLUMNS; i++ )
		{
			for ( int j = 0; j < ROWS; j++ )
			{
				counter++;
				// create a simple panel drop target for the current cell
				SimplePanel simplePanel = new SimplePanel();
				String wrapperId = "drag-element-" + counter;
				simplePanel.getElement().setId( wrapperId );
				simplePanel.setPixelSize( IMAGE_WIDTH, IMAGE_HEIGHT );
				Widget createDraggable = createDraggable( counter );
				simplePanel.setWidget( createDraggable );
				// instantiate a drop controller of the panel in the current cell
				String controllerId = "controller-" + counter;
				createDraggable.getElement().setAttribute( "controllerId", controllerId );
				gridConstrainedDropController.drop( simplePanel, IMAGE_WIDTH * i, IMAGE_HEIGHT * j );
			}
		}
	}

	protected Widget createDraggable( int counter )
	{
		String chartId = "chart0" + counter;
		Image image = new Image( GWT.getHostPageBaseURL() + "images/demo/" + chartId + ".png" );
		dragController.makeDraggable( image );
		return image;
	}
}