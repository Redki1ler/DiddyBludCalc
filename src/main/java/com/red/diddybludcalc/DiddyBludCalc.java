package com.red.diddybludcalc;

import com.red.diddybludcalc.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiddyBludCalc implements ModInitializer {
	public static final String MOD_ID = "diddybludcalc";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}