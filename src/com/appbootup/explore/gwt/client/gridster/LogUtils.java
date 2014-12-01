package com.appbootup.explore.gwt.client.gridster;
public class LogUtils
{
	public static native void log( Object obj )
	/*-{
		console.log(obj);
		//JSON.stringify(obj, null, 4)
	}-*/;
}