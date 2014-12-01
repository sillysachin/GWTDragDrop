package com.appbootup.explore.gwt.client.gridster;

import com.google.gwt.core.client.IJavaScriptWrapper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;

public class Gridster extends ResizeComposite implements IJavaScriptWrapper<GridsterJSO>
{
	protected GridsterJSO jso;

	private String id;

	private LayoutPanel divWrapper = new LayoutPanel();

	private UnorderedListWidget ulWidget = new UnorderedListWidget();

	private FlowPanel divWidget = new FlowPanel();

	public Gridster()
	{
		init();
	}

	private void init()
	{
		String id = Document.get().createUniqueId();
		setId( id );
		divWidget.addStyleName( "gridster" );
		ulWidget.addStyleName( "gridsterUl" );
		divWidget.setHeight( "100%" );
		divWidget.setWidth( "1240px" );
		divWidget.add( ulWidget );
		divWrapper.add( divWidget );
		initWidget( divWrapper );
	}

	private void init( JavaScriptObject configJSO )
	{
		init();
		makeGridster( getId(), configJSO );
	}

	public void setId( String id )
	{
		this.id = id;
		divWrapper.getElement().setId( id );
	}

	public String getId()
	{
		return id;
	}

	@Override
	public GridsterJSO getJso()
	{
		return this.jso;
	}

	@Override
	public void setJso( GridsterJSO jso )
	{
		this.jso = jso;
	}

	@Override
	protected void onLoad()
	{
		String id = getId();
		jso = makeGridster( id );
	}

	protected static native GridsterJSO makeGridster( String id )
	/*-{
		var gridster;

		$wnd
				.$(function() {

					gridster = $wnd.$(".gridster > ul").gridster({
						widget_margins : [ 5, 5 ],
						widget_base_dimensions : [ 100, 55 ]
					}).data('gridster');
					this.@com.appbootup.explore.gwt.client.gridster.Gridster::jso = gridster;
					var widgets = [ [ '<li>0</li>', 1, 2 ],
							[ '<li>1</li>', 3, 2 ], [ '<li>2</li>', 3, 2 ],
							[ '<li>3</li>', 2, 1 ], [ '<li>4</li>', 4, 1 ],
							[ '<li>5</li>', 1, 2 ], [ '<li>6</li>', 2, 1 ],
							[ '<li>7</li>', 3, 2 ], [ '<li>8</li>', 1, 1 ],
							[ '<li>9</li>', 2, 2 ], [ '<li>10</li>', 1, 3 ] ];

					$wnd.$.each(widgets, function(i, widget) {
						gridster.add_widget.apply(gridster, widget)
					});
				});
		gridster.add_widget('<li >' + 11 + '</li>', 3, 3);
		return gridster;
	}-*/;

	protected static native GridsterJSO makeGridster( String id, JavaScriptObject configJSO )
	/*-{
		var gridster;
		$wnd
				.$(function() {
					gridster = $wnd.$(".gridster > ul").gridster({
						widget_margins : [ 5, 5 ],
						widget_base_dimensions : [ 100, 55 ]
					}).data('gridster');
					this.@com.appbootup.explore.gwt.client.gridster.Gridster::jso = gridster;
				});
		return gridster;
	}-*/;

	public native void addWidget( String textContent, int col, int row )
	/*-{
		var gridster = this.@com.appbootup.explore.gwt.client.gridster.Gridster::jso;
		console.log(gridster);
		gridster.add_widget('<li >' + textContent + '</li>', 3, 3);
	}-*/;

	public native void addWidget( String textContent )
	/*-{
		var gridster = this.@com.appbootup.explore.gwt.client.gridster.Gridster::jso;
		gridster.add_widget('<li >' + textContent + '</li>');
	}-*/;

	public native void removeWidget()
	/*-{
		var gridster = this.@com.appbootup.explore.gwt.client.gridster.Gridster::jso;
		gridster.remove_widget($('.gridster li').eq(3));
	}-*/;
}