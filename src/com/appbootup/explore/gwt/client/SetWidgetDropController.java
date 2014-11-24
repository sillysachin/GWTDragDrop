package com.appbootup.explore.gwt.client;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.drop.SimpleDropController;
import com.google.gwt.user.client.ui.SimplePanel;

public class SetWidgetDropController extends SimpleDropController
{

	private final SimplePanel dropTarget;

	public SetWidgetDropController( SimplePanel dropTarget )
	{
		super( dropTarget );
		this.dropTarget = dropTarget;
	}

	@Override
	public void onDrop( DragContext context )
	{
		dropTarget.setWidget( context.draggable );
		super.onDrop( context );
	}

	@Override
	public void onPreviewDrop( DragContext context ) throws VetoDragException
	{
		if ( dropTarget.getWidget() != null )
		{
			throw new VetoDragException();
		}
		super.onPreviewDrop( context );
	}
}