package com.appbootup.explore.gwt.client.gridster;

import com.google.gwt.core.client.IJavaScriptWrapper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ResizeComposite;

public class Gridster extends ResizeComposite implements IJavaScriptWrapper<GridsterJSO>
{
	protected GridsterJSO jso;

	String id;

	private LayoutPanel divWrapper = new LayoutPanel();

	public Gridster()
	{
		init();
	}

	private void init()
	{
		String id = Document.get().createUniqueId();
		setId( id );
		initWidget( divWrapper );
	}

	private void init( JavaScriptObject configJSO )
	{
		init();
		jso = makeGridster( getId(), configJSO );
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
		return jso;
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
		makeGridster( id );
	}

	protected static native GridsterJSO makeGridster( String id )
	/*-{
		var gridster;

		$wnd.$(function() {

			gridster = $wnd.$(".gridster > ul").gridster({
				widget_margins : [ 5, 5 ],
				widget_base_dimensions : [ 100, 55 ]
			}).data('gridster');

			var widgets = [ [ '<li>0</li>', 1, 2 ], [ '<li>1</li>', 3, 2 ],
					[ '<li>2</li>', 3, 2 ], [ '<li>3</li>', 2, 1 ],
					[ '<li>4</li>', 4, 1 ], [ '<li>5</li>', 1, 2 ],
					[ '<li>6</li>', 2, 1 ], [ '<li>7</li>', 3, 2 ],
					[ '<li>8</li>', 1, 1 ], [ '<li>9</li>', 2, 2 ],
					[ '<li>10</li>', 1, 3 ] ];

			$wnd.$.each(widgets, function(i, widget) {
				gridster.add_widget.apply(gridster, widget)
			});

		});
		console.log(gridster);
		return gridster;
	}-*/;

	protected static native GridsterJSO makeGridster( String id, JavaScriptObject configJSO )
	/*-{

		var gridster;

		$wnd.$(function() {

			gridster = $wnd.$(".gridster > ul").gridster({
				widget_margins : [ 5, 5 ],
				widget_base_dimensions : [ 100, 55 ]
			}).data('gridster');

			var widgets = [ [ '<li>0</li>', 1, 2 ], [ '<li>1</li>', 3, 2 ],
					[ '<li>2</li>', 3, 2 ], [ '<li>3</li>', 2, 1 ],
					[ '<li>4</li>', 4, 1 ], [ '<li>5</li>', 1, 2 ],
					[ '<li>6</li>', 2, 1 ], [ '<li>7</li>', 3, 2 ],
					[ '<li>8</li>', 1, 1 ], [ '<li>9</li>', 2, 2 ],
					[ '<li>10</li>', 1, 3 ] ];

			$wnd.$.each(widgets, function(i, widget) {
				gridster.add_widget.apply(gridster, widget)
			});

		});
		console.log(gridster);
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