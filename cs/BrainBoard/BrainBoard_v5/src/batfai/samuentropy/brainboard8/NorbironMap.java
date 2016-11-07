/*
 * NorbironMap.java
 *
 * Norbiron Game
 * This is a case study for creating sprites for SamuEntropy/Brainboard.
 *
 * Copyright (C) 2016, Dr. Bátfai Norbert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Ez a program szabad szoftver; terjeszthető illetve módosítható a
 * Free Software Foundation által kiadott GNU General Public License
 * dokumentumában leírtak; akár a licenc 3-as, akár (tetszőleges) későbbi
 * változata szerint.
 *
 * Ez a program abban a reményben kerül közreadásra, hogy hasznos lesz,
 * de minden egyéb GARANCIA NÉLKÜL, az ELADHATÓSÁGRA vagy VALAMELY CÉLRA
 * VALÓ ALKALMAZHATÓSÁGRA való származtatott garanciát is beleértve.
 * További részleteket a GNU General Public License tartalmaz.
 *
 * A felhasználónak a programmal együtt meg kell kapnia a GNU General
 * Public License egy példányát; ha mégsem kapta meg, akkor
 * tekintse meg a <http://www.gnu.org/licenses/> oldalon.
 *
 * Version history:
 *
 * 0.0.1, 2013.szept.29.
 */

package batfai.samuentropy.brainboard8;


import java.util.List;

public class NorbironMap
{
	private	int n = 10;
	private int m = 13;
	private int[][] map;
	private int BLOCK_SIZE = 120;
	private NorbironSurfaceView surfaceView;
	private NorbironResources norbironResources;

	public NorbironMap(NorbironSurfaceView surfaceView)
	{
		this.surfaceView = surfaceView;
		initMap();
		norbironResources = new NorbironResources(BLOCK_SIZE, this.surfaceView);
	}

	public void initMap()
	{
		// 0 - simple
		// 1 - red
		// 2 - board

		this.map = new int[][]
		{
		  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		  { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		  { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		};
	}

	public void draw(android.graphics.Canvas canvas, float scaleFactor, float startsx, float startsy)
	{
		canvas.save();
		canvas.scale(scaleFactor, scaleFactor);
		canvas.drawColor(android.graphics.Color.BLACK);

		for(int i = 0; i<n; i++)
		{
			for(int j = 0; j<m; j++)
			{
				canvas.drawBitmap(norbironResources.getImage(0), -startsx + i * BLOCK_SIZE, -startsy + j * BLOCK_SIZE, null);
			}		
		}

	}

}
