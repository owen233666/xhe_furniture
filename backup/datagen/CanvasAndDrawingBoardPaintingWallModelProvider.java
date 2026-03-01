package com.owen233666.datagen;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.DataWriter;
import net.minecraft.util.Util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CanvasAndDrawingBoardPaintingWallModelProvider implements DataProvider {
    public static final List<String> IMAGE_NAMES = List.of(
            "angel",
            "bedroom_bed",
            "berry_bush",
            "bichon",
            "cake",
            "cat_under_a_tree",
            "chime",
            "city_night",
            "clover",
            "cow",
            "crystal_fairy",
            "dessert",
            "flower_basket",
            "flowersea_cottage",
            "friends_party",
            "fruits_basket",
            "garden_entrance",
            "gramophone",
            "graveyard",
            "harvest",
            "island",
            "kitchen_sink",
            "kite",
            "lemon_slice",
            "mermaid",
            "milkyway",
            "night_campfire",
            "pumpkin",
            "rainbow_unicorn",
            "restaurant",
            "rose_swing",
            "salted_lemon",
            "scenery",
            "sketch",
            "snow_house",
            "stationary_objects",
            "sumptuous_meal",
            "sunset",
            "teddy_bear",
            "toys",
            "tulip",
            "urban_beauty",
            "waves",
            "wheat_field",
            "wildflower_plain",
            "world_tree"
    );

    private final FabricDataOutput output;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public CanvasAndDrawingBoardPaintingWallModelProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Path basePath = output.getPath().resolve("assets/xhe_furniture/models/block/paintings/canvas/wall");
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (String name : IMAGE_NAMES) {
            Path filePath = basePath.resolve(name + ".json");

            // 构建 JSON 内容
            JsonObject root = new JsonObject();
            root.addProperty("parent", "xhe_furniture:block/parent/painting_wall");

            JsonObject textures = new JsonObject();
            textures.addProperty("1", "xhe_furniture:item/paintings/" + name);
            textures.addProperty("particle", "xhe_furniture:item/paintings/" + name);
            root.add("textures", textures);

            byte[] jsonBytes = gson.toJson(root).getBytes(StandardCharsets.UTF_8);
            HashCode hashCode = Hashing.sha256().hashBytes(jsonBytes);

            futures.add(CompletableFuture.runAsync(() -> {
                try {
                    writer.write(filePath, jsonBytes, hashCode);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to write painting model: " + filePath, e);
                }
            }, Util.getMainWorkerExecutor()));
        }

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }

    @Override
    public String getName() {
        return "Painting Models Wall (Canvas and Drawing Board)";
    }
}
