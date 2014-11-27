package com.appbootup.explore.gwt.client;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class SetWidgetDropController extends SimpleDropController
{
	private final SimplePanel dropTarget;

	private SwappingPickupDragController dragController;

	public SetWidgetDropController( SimplePanel dropTarget, SwappingPickupDragController dragController )
	{
		super( dropTarget );
		this.dropTarget = dropTarget;
		this.dragController = dragController;
	}

	@Override
	public void onDrop( DragContext context )
	{
		Widget target = dropTarget.getWidget();
		Widget source = context.draggable;

		String targetControllerId = target.getElement().getAttribute( "controllerId" );
		String sourceControllerId = source.getElement().getAttribute( "controllerId" );

		target.getElement().setAttribute( "controllerId", sourceControllerId );
		source.getElement().setAttribute( "controllerId", targetControllerId );

		DropController sourceDragController = dragController.getSourceDragController( sourceControllerId );
		SimplePanel dropSource = ( SimplePanel ) sourceDragController.getDropTarget();

		dropTarget.setWidget( source );
		dropSource.setWidget( target );
		super.onDrop( context );
	}

	@Override
	public void onPreviewDrop( DragContext context ) throws VetoDragException
	{
		if ( dropTarget.getWidget() != null )
		{
			GWT.log( "Detected Existing Widget. Need to Swap." );
			//throw new VetoDragException();
		}
		super.onPreviewDrop( context );
	}
}