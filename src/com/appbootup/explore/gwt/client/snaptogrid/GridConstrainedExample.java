package com.appbootup.explore.gwt.client.snaptogrid;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController;
import com.allen_sauer.gwt.dnd.demo.client.RedBoxDraggableWidget;
import com.allen_sauer.gwt.dnd.demo.client.example.Example;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * {@link com.allen_sauer.gwt.dnd.client.drop.GridConstrainedDropController} example.
 */
public final class GridConstrainedExample extends Example
{

	private static final String CSS_DEMO_GRID_CONSTRAINED_EXAMPLE = "demo-GridConstrainedExample";

	private int draggableOffsetHeight;

	private int draggableOffsetWidth;

	private GridConstrainedDropController gridConstrainedDropController;

	public GridConstrainedExample( PickupDragController dragController )
	{
		super( dragController );
		addStyleName( CSS_DEMO_GRID_CONSTRAINED_EXAMPLE );

		// determine runtime dimensions of our basic draggable widgets
		determineRedBoxDimensions();

		// use the drop target as this composite's widget
		AbsolutePanel gridConstrainedDropTarget = new AbsolutePanel();
		setWidget( gridConstrainedDropTarget );

		// instantiate our drop controller
		gridConstrainedDropController = new GridConstrainedDropController( gridConstrainedDropTarget, draggableOffsetWidth, draggableOffsetHeight );
		dragController.registerDropController( gridConstrainedDropController );

		// set our drop target size to a multiple of the draggable size
		gridConstrainedDropTarget.setPixelSize( draggableOffsetWidth * 5, draggableOffsetHeight * 2 );
	}

	public String getDescription()
	{
		return "Drops (moves) are constrained to a (" + draggableOffsetWidth + " x " + draggableOffsetHeight + ") grid on the gray drop target.";
	}

	public Class< ? >[] getInvolvedClasses()
	{
		return new Class[]
		{ GridConstrainedExample.class, GridConstrainedDropController.class, };
	}

	protected void onInitialLoad()
	{
		gridConstrainedDropController.drop( createDraggable(), 0, 0 );
		gridConstrainedDropController.drop( createDraggable(), draggableOffsetWidth, draggableOffsetHeight );
	}

	private void determineRedBoxDimensions()
	{
		RedBoxDraggableWidget redBox = new RedBoxDraggableWidget();
		RootPanel.get().add( redBox, -500, -500 );
		draggableOffsetWidth = redBox.getOffsetWidth();
		draggableOffsetHeight = redBox.getOffsetHeight();
		redBox.removeFromParent();
	}
}