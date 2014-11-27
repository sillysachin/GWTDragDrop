package com.appbootup.explore.gwt.client;

import java.util.HashMap;

import com.allen_sauer.gwt.dnd.client.PickupDragController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.user.client.ui.AbsolutePanel;

public class SwappingPickupDragController extends PickupDragController
{
	HashMap<String, DropController> map = new HashMap<String, DropController>();

	public SwappingPickupDragController( AbsolutePanel boundaryPanel, boolean allowDroppingOnBoundaryPanel )
	{
		super( boundaryPanel, allowDroppingOnBoundaryPanel );
	}

	public void registerDropController( String id, DropController dropController )
	{
		map.put( id, dropController );
		registerDropController( dropController );
	}

	public DropController getSourceDragController( String id )
	{
		return map.get( id );
	}
}