/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.shatteredpixel.shatteredpixeldungeon;

import com.shatteredpixel.shatteredpixeldungeon.custom.utils.CustomGameSettings;
import com.watabou.utils.Bundle;

public class Statistics {
	
	public static int goldCollected;
	public static int deepestFloor;
	public static int enemiesSlain;
	public static int foodEaten;
	public static int itemsCrafted;
	public static int piranhasKilled;
	public static int ankhsUsed;
	
	//used for hero unlock badges
	public static int upgradesUsed;
	public static int sneakAttacks;
	public static int thrownAssists;

	public static int spawnersAlive;
	
	public static float duration;
	
	public static boolean qualifiedForNoKilling = false;
	public static boolean completedWithNoKilling = false;
	
	public static boolean amuletObtained = false;
	
	public static void reset() {
		
		goldCollected	= 0;
		deepestFloor	= 0;
		enemiesSlain	= 0;
		foodEaten		= 0;
		itemsCrafted    = 0;
		piranhasKilled	= 0;
		ankhsUsed		= 0;
		
		upgradesUsed    = 0;
		sneakAttacks    = 0;
		thrownAssists   = 0;

		spawnersAlive   = 0;
		
		duration	= 0;
		
		qualifiedForNoKilling = false;
		
		amuletObtained = false;

		resetCustom();
		
	}
	
	private static final String GOLD		= "score";
	private static final String DEEPEST		= "maxDepth";
	private static final String SLAIN		= "enemiesSlain";
	private static final String FOOD		= "foodEaten";
	private static final String ALCHEMY		= "potionsCooked";
	private static final String PIRANHAS	= "priranhas";
	private static final String ANKHS		= "ankhsUsed";
	
	private static final String UPGRADES	= "upgradesUsed";
	private static final String SNEAKS		= "sneakAttacks";
	private static final String THROWN		= "thrownAssists";

	private static final String SPAWNERS	= "spawnersAlive";
	
	private static final String DURATION	= "duration";

	private static final String NO_KILLING_QUALIFIED	= "qualifiedForNoKilling";
	
	private static final String AMULET		= "amuletObtained";
	
	public static void storeInBundle( Bundle bundle ) {
		bundle.put( GOLD,		goldCollected );
		bundle.put( DEEPEST,	deepestFloor );
		bundle.put( SLAIN,		enemiesSlain );
		bundle.put( FOOD,		foodEaten );
		bundle.put( ALCHEMY,    itemsCrafted );
		bundle.put( PIRANHAS,	piranhasKilled );
		bundle.put( ANKHS,		ankhsUsed );
		
		bundle.put( UPGRADES,   upgradesUsed );
		bundle.put( SNEAKS,		sneakAttacks );
		bundle.put( THROWN,		thrownAssists );

		bundle.put( SPAWNERS,	spawnersAlive );
		
		bundle.put( DURATION,	duration );

		bundle.put(NO_KILLING_QUALIFIED, qualifiedForNoKilling);
		
		bundle.put( AMULET,		amuletObtained );

		storeCustom(bundle);
	}
	
	public static void restoreFromBundle( Bundle bundle ) {
		goldCollected	= bundle.getInt( GOLD );
		deepestFloor	= bundle.getInt( DEEPEST );
		enemiesSlain	= bundle.getInt( SLAIN );
		foodEaten		= bundle.getInt( FOOD );
		itemsCrafted    = bundle.getInt( ALCHEMY );
		piranhasKilled	= bundle.getInt( PIRANHAS );
		ankhsUsed		= bundle.getInt( ANKHS );
		
		upgradesUsed    = bundle.getInt( UPGRADES );
		sneakAttacks    = bundle.getInt( SNEAKS );
		thrownAssists   = bundle.getInt( THROWN );

		spawnersAlive   = bundle.getInt( SPAWNERS );
		
		duration		= bundle.getFloat( DURATION );

		qualifiedForNoKilling = bundle.getBoolean( NO_KILLING_QUALIFIED );
		
		amuletObtained	= bundle.getBoolean( AMULET );

		restoreCustom(bundle);
	}
	
	public static void preview( GamesInProgress.Info info, Bundle bundle ){
		info.goldCollected  = bundle.getInt( GOLD );
		info.maxDepth       = bundle.getInt( DEEPEST );
	}



	public static int boss_enhance = 0;
	public static int elite_enemies = 0;

	public static boolean isCustomSeed = false;
	//Directly add float time will cause accuracy lose and stop timing if time is long enough
	//so use long to record seconds, float to count sub-seconds.
	public static long real_seconds = 0;
	public static float second_elapsed = 0;


	private static void resetCustom(){
		boss_enhance = 0;
		elite_enemies = 0;
		second_elapsed = 0f;
		real_seconds = 0;
		//Dungeon has been inited, so write directly.
		isCustomSeed = !CustomGameSettings.getSeedString().equals("");
	}

	private static void storeCustom(Bundle b){
		b.put("boss_enhance", boss_enhance);
		b.put("elite_enemies", elite_enemies);
		b.put("real_time_passed", second_elapsed);
		b.put("is_custom_seed", isCustomSeed);
		b.put("real_seconds_passed", real_seconds);
	}

	private static void restoreCustom(Bundle b){
		boss_enhance = b.getInt("boss_enhance");
		elite_enemies = b.getInt("elite_enemies");
		second_elapsed = b.getFloat("real_time_passed");
		isCustomSeed = b.getBoolean("is_custom_seed");
		real_seconds = b.getLong("real_seconds_passed");
	}

}
