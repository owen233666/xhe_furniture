package com.owen233666;

import com.owen233666.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class XheFurnitureDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

//		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModBlockLootTableProvider::new);
//		pack.addProvider(EaselPaintingModelProvider::new);
//		pack.addProvider(CanvasAndDrawingBoardPaintingWallModelProvider::new);
//		pack.addProvider(CanvasAndDrawingBoardPaintingCorner1ModelProvider::new);
//		pack.addProvider(CanvasAndDrawingBoardPaintingCorner2ModelProvider::new);
//		pack.addProvider(CanvasAndDrawingBoardPaintingCorner3ModelProvider::new);
//		pack.addProvider(PhotoPaperPaintingsAModelProvider::new);
//		pack.addProvider(PhotoPaperPaintingsBModelProvider::new);
//		pack.addProvider(PhotoPaperPaintingsCModelProvider::new);
//		pack.addProvider(GridShelfPhotoPaperPaintingsAModelProvider::new);
//		pack.addProvider(GridShelfPhotoPaperPaintingsBModelProvider::new);
//		pack.addProvider(GridShelfPhotoPaperPaintingsCModelProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
//		pack.addProvider(PaintingFramePaintingCorner1ModelProvider::new);
//		pack.addProvider(PaintingFramePaintingCorner2ModelProvider::new);
//		pack.addProvider(PaintingFramePaintingCorner3ModelProvider::new);
//		pack.addProvider(PaintingFramePaintingWallModelProvider::new);
		pack.addProvider(ModItemTagProvider::new);
	}
}
