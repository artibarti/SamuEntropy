/*
 * Sprite.java
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
package batfai.samuentropy.brainboard3;

/**
 *
 * @author nbatfai
 */

public class Sprite {

    private android.graphics.Bitmap tiles;
    private int length;
    private int width;
    private int height;
    private int tileIndex = 0;
    private float x;
    private float y;
    private android.graphics.Rect from;
    private android.graphics.Rect to;
	private android.graphics.Paint paint;
	private android.graphics.Color color;

	private int base_x, base_y, max_x, max_y;

    public Sprite(android.graphics.Bitmap tiles, int length, int width, int height, int base_x, int base_y, int max_x, int max_y)
	{
        this.tiles = tiles;
        this.length = length;
        this.width = width;
        this.height = height;
		this.base_x = base_x;
		this.base_y = base_y;
		this.max_x = max_x;
		this.max_y = max_y;

        from = new android.graphics.Rect(0, 0, width, height);
        to = new android.graphics.Rect(0, 0, width, height);
		paint = new android.graphics.Paint();
		color = new android.graphics.Color();
    }

	public void Move(int style)
	{
		if(style == 1) moveLeft();
		if(style == 2) moveRight();
		if(style == 3) moveUp();
		if(style == 4) moveDown();
	}

    public void nextTile() {
        tileIndex = (tileIndex + 1) % length;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

	public void moveLeft()
	{
		this.x -= 1;
	}

	public void moveRight()
	{
		this.x += 1;
	}

	public void moveUp()
	{
		this.y -= 1;
	}

	public void moveDown()
	{
		this.y += 1;
	}

    public void draw(android.graphics.Canvas canvas) {

        from.left = tileIndex * width;
        from.right = tileIndex * width + width;
        to.left = (int) x;
        to.top = (int) y;
        to.right = (int) x + width;
        to.bottom = (int) y + height;
		
		paint.setStyle(android.graphics.Paint.Style.STROKE);
		paint.setColor(color.BLACK);
        paint.setStrokeWidth(3);
        canvas.drawBitmap(tiles, from, to, null);

    }

}
