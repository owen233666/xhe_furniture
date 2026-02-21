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

import static com.owen233666.datagen.CanvasAndDrawingBoardPaintingWallModelProvider.IMAGE_NAMES;

public class PhotoPaperPaintingsBModelProvider implements DataProvider {
    private final FabricDataOutput output;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public PhotoPaperPaintingsBModelProvider(FabricDataOutput output) {
        this.output = output;
    }

    @Override
    public CompletableFuture<?> run(DataWriter writer) {
        Path basePath = output.getPath().resolve("assets/xhe_furniture/models/block/paintings/photo_paper_b");
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (String name : IMAGE_NAMES) {
            Path filePath = basePath.resolve(name + ".json");

            // 构建 JSON 内容
            JsonObject root = new JsonObject();
            root.addProperty("parent", "xhe_furniture:block/parent/photo_painting_b");

            JsonObject textures = new JsonObject();
            textures.addProperty("5", "xhe_furniture:item/paintings/" + name);
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
        return "Photo Paper Paintings Type B";
    }
}
