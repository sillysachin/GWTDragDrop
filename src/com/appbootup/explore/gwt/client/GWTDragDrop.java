package com.appbootup.explore.gwt.client;

import com.appbootup.explore.gwt.client.gridster.Gridster;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class GWTDragDrop implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		Gridster gridster = new Gridster();
		RootLayoutPanel.get().add( gridster );
		LogUtils.log( gridster.getJso() );
//		gridster.addWidget( "<li>0</li>", 1, 2 );
//		gridster.addWidget( "<li>1</li>", 3, 2 );
//		gridster.addWidget( "<li>2</li>", 3, 2 );
//		gridster.addWidget( "<li>3</li>", 2, 1 );
//		gridster.addWidget( "<li>4</li>", 4, 1 );
//		gridster.addWidget( "<li>5</li>", 1, 2 );
//		gridster.addWidget( "<li>6</li>", 2, 1 );
//		gridster.addWidget( "<li>7</li>", 3, 2 );
//		gridster.addWidget( "<li>8</li>", 1, 1 );
//		gridster.addWidget( "<li>9</li>", 2, 2 );
//		gridster.addWidget( "<li>10</li>", 1, 3 );
		gridster.addWidget( "<li>11</li>", 3, 2 );
	}
}