package com.appbootup.explore.gwt.client.gridster;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptException;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;

public class GWTGridster extends ResizeComposite
{
	LayoutPanel divWrapper = new LayoutPanel();

	GridsterJSO jso;

	public GWTGridster( String id )
	{
		setId( id );
		initWidget( divWrapper );
		addStyleName( "gridster" );
	}

	public String getId()
	{
		String id = divWrapper.getElement().getId();
		return id;
	}

	public void setId( String id )
	{
		divWrapper.getElement().setId( id );
	}

	@Override
	protected void onLoad()
	{
		try
		{
			Scheduler.get().scheduleDeferred( new ScheduledCommand()
			{
				public void execute()
				{
					drawGridster( getId() );
					OnDrawGridster();
				}
			} );
		}
		catch ( JavaScriptException caught )
		{
			GWT.log( "Exception while rendering the chart", caught );
		}
	}

	public void OnDrawGridster()
	{
	}

	protected static native GridsterJSO drawGridster( String id )
	/*-{
		//		$wnd.$(".gridster ul").gridster({
		//			widget_margins : [ 10, 10 ],
		//			widget_base_dimensions : [ 140, 140 ]
		//		});

		var gridster = $wnd.$(".gridster ul").gridster().data('gridster');
		return gridster;
	}-*/;

	protected static native void addWidget()
	/*-{
		var gridster = @com.appbootup.explore.gwt.client.gridster.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		gridster.add_widget('<li class="new">The HTML of the widget...</li>',
				2, 1);
	}-*/;

	protected static native void removeWidget()
	/*-{
		var gridster = @com.appbootup.explore.gwt.client.gridster.WrapperUtils::unwrap(Lcom/google/gwt/core/client/IJavaScriptWrapper;)(this);
		gridster.remove_widget($('.gridster li').eq(3));
	}-*/;
}