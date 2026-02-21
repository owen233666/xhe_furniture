package com.owen233666.datagen;

import com.google.common.hash.Hashing;
import com.google.common.hash.HashCode;
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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class EaselPaintingModelProvider implements DataProvider {

    public static final List<String> IMAGE_NAMES = List.of(
            "angel",
            "angel_a",
            "bedroom_bed",
            "bedroom_bed_a",
            "berry_bush",
            "berry_bush_a",
            "bichon",
            "bichon_a",
            "cake",
            "cake_a",
            "cat_under_a_tree",
            "cat_under_a_tree_a",
            "chime",
            "chime_a",
            "city_night",
            "city_night_a",
            "clover",
            "clover_a",
            "cow",
            "cow_a",
            "crystal_fairy",
            "crystal_fairy_a",
            "dessert",
            "dessert_a",
            "flower_basket",
            "flower_basket_a",
            "flowersea_cottage",
            "flowersea_cottage_a",
            "friends_party",
            "friends_party_a",
            "fruits_basket",
            "fruits_basket_a",
            "garden_entrance",
            "garden_entrance_a",
            "gramophone",
            "gramophone_a",
            "graveyard",
            "graveyard_a",
            "harvest",
            "harvest_a",
            "island",
            "island_a",
            "kitchen_sink",
            "kitchen_sink_a",
            "kite",
            "kite_a",
            "lemon_slice",
            "lemon_slice_a",
            "mermaid",
            "mermaid_a",
            "milkyway",
            "milkyway_a",
            "night_campfire",
            "night_campfire_a",
            "pumpkin",
            "pumpkin_a",
            "rainbow_unicorn",
            "rainbow_unicorn_a",
            "restaurant",
            "restaurant_a",
            "rose_swing",
            "rose_swing_a",
            "salted_lemon",
            "salted_lemon_a",
            "scenery",
            "scenery_a",
            "sketch",
            "sketch_a",
            "snow_house",
            "snow_house_a",
            "stationary_objects",
            "stationary_objects_a",
            "sumptuous_meal",
            "sumptuous_meal_a",
            "sunset",
            "sunset_a",
            "teddy_bear",
            "teddy_bear_a",
            "toys",
            "toys_a",
            "tulip",
            "tulip_a",
            "urban_beauty",
            "urban_beauty_a",
            "waves",
            "waves_a",
            "wheat_field",
            "wheat_field_a",
            "wildflower_plain",
            "wildflower_plain_a",
            "world_tree",
            "world_tree_a"
    );

    private final FabricDataOutput output;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public EaselPaintingModelProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Path basePath = output.getPath().resolve("assets/xhe_furniture/models/block/paintings/easel");
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (String name : IMAGE_NAMES) {
            Path filePath = basePath.resolve(name + ".json");

            // 构建 JSON 内容
            JsonObject root = new JsonObject();
            root.addProperty("parent", "xhe_furniture:block/parent/easel_painting");

            JsonObject textures = new JsonObject();
            textures.addProperty("2", "xhe_furniture:item/paintings/" + name);
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
        return "Painting Models (Easel)";
    }
}