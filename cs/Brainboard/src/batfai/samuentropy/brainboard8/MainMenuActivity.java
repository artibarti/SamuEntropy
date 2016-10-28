/*
 * MainMenuActivity.java
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

/**
 *
 * @author nbatfai
 */

import android.widget.ImageButton;
import android.view.View;
import java.util.*;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;          
import android.view.animation.AnimationSet;

public class MainMenuActivity extends android.app.Activity 
{

	private List<ImageButton> menuItems;
	Animation btnAnim;
	private LinearLayout mainLayout;
	private Intent intent;

    @Override
    public void onCreate(android.os.Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

   		menuItems = new ArrayList<ImageButton>();
		btnAnim = AnimationUtils.loadAnimation(this, R.anim.btn_anim);

		findViewById(R.id.main_menu_account_btn).startAnimation(btnAnim);
		findViewById(R.id.main_menu_neurtable_btn).startAnimation(btnAnim);
		findViewById(R.id.main_menu_neurgame_btn).startAnimation(btnAnim);

		mainLayout = (LinearLayout)findViewById(R.id.mainLayout);
		ViewTreeObserver vto = mainLayout.getViewTreeObserver(); 
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener()
		{ 
	
	    	@Override 
	    	public void onGlobalLayout()
			{ 
	    	    mainLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this); 
				startBackgroundAnimation();

	    	} 
		});

	}

	public void startBackgroundAnimation()
	{
		Animation a = AnimationUtils.loadAnimation(this, R.anim.bg_anim_rotate_left);
		Animation b = AnimationUtils.loadAnimation(this, R.anim.bg_anim_rotate_right);
		Animation c = AnimationUtils.loadAnimation(this, R.anim.bg_anim_scale_smaller);
		Animation d = AnimationUtils.loadAnimation(this, R.anim.bg_anim_scale_bigger);
		Animation e = AnimationUtils.loadAnimation(this, R.anim.bg_anim_translate_rightup);

		AnimationSet set1 = new AnimationSet(false);
		set1.addAnimation(a);
		set1.addAnimation(e);
		set1.addAnimation(c);
		findViewById(R.id.aaa).startAnimation(set1);

		AnimationSet set2 = new AnimationSet(false);
		set2.addAnimation(b);
		set2.addAnimation(d);
		set2.addAnimation(e);
		findViewById(R.id.bbb).startAnimation(set2);
	}

	public void openUserMenu(View v)
	{
		intent = new Intent(this, UserMenuActivity.class);
		startActivity(intent);
		//v.startAnimation(btnAnim);	
        //intent.putExtra(EXTRA_MESSAGE, message);
        //this.startActivity(intent);
		//final Intent intent = new Intent(this, UserMenuActivity.class);

    }

	public void openNeurMenu(View v)
	{
		intent = new Intent(this, NeurMenuActivity.class);
		startActivity(intent);
		//v.startAnimation(btnAnim);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //this.startActivity(intent);
    }

	public void openNeurTable(View v)
	{
		intent = new Intent(this, NeuronGameActivity.class);
		startActivity(intent);
		//v.startAnimation(btnAnim);
        //intent.putExtra(EXTRA_MESSAGE, message);
        //this.startActivity(intent);
    }

}

