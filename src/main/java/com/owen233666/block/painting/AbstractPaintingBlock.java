package com.owen233666.block.painting;

import com.owen233666.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public abstract class AbstractPaintingBlock extends HorizontalFacingBlock {

    public static final HashMap<Paintings, Item> PAINTINGS_ITEM_HASH_MAP = new HashMap<>();

    public static final HashMap<Item, Paintings> ITEM_PAINTINGS_HASH_MAP = new HashMap<>();

    protected AbstractPaintingBlock(Settings settings) {
        super(settings);
        this.setDefaultState(getDefaultState()
                .with(HorizontalFacingBlock.FACING, Direction.NORTH)
                .with(WIP, false));
    }

    public static final EnumProperty<Paintings> PAINTINGS = EnumProperty.of("painting", Paintings.class);
    public static final BooleanProperty WIP = BooleanProperty.of("wip");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING, PAINTINGS, WIP);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    public Paintings getPaintingsFromItem(Item item) {
        return ITEM_PAINTINGS_HASH_MAP.get(item) == null ? Paintings.NONE : ITEM_PAINTINGS_HASH_MAP.get(item);
    }

    public ItemStack getItemFromPaintings(Paintings paintings) {
        return PAINTINGS_ITEM_HASH_MAP.get(paintings) == null ? ItemStack.EMPTY : new ItemStack(PAINTINGS_ITEM_HASH_MAP.get(paintings), 1);
    }

    static {
        // Paintings -> Items 映射
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.ANGEL, ModItems.PAINTING_ANGEL);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.BEDROOM_BED, ModItems.PAINTING_BEDROOM_BED);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.BICHON, ModItems.PAINTING_BICHON);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.CAKE, ModItems.PAINTING_CAKE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.CAT_UNDER_A_TREE, ModItems.PAINTING_CAT_UNDER_A_TREE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.CHIME, ModItems.PAINTING_CHIME);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.CITY_NIGHT, ModItems.PAINTING_CITY_NIGHT);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.CLOVER, ModItems.PAINTING_CLOVER);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.COW, ModItems.PAINTING_COW);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.CRYSTAL_FAIRY, ModItems.PAINTING_CRYSTAL_FAIRY);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.DESSERT, ModItems.PAINTING_DESSERT);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.FLOWER_BASKET, ModItems.PAINTING_FLOWER_BASKET);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.FLOWERSEA_COTTAGE, ModItems.PAINTING_FLOWERSEA_COTTAGE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.FRIENDS_PARTY, ModItems.PAINTING_FRIENDS_PARTY);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.FRUITS_BASKET, ModItems.PAINTING_FRUITS_BASKET);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.GARDEN_ENTRANCE, ModItems.PAINTING_GARDEN_ENTRANCE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.GRAMOPHONE, ModItems.PAINTING_GRAMOPHONE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.GRAVEYARD, ModItems.PAINTING_GRAVEYARD);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.HARVEST, ModItems.PAINTING_HARVEST);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.ISLAND, ModItems.PAINTING_ISLAND);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.KITCHEN_SINK, ModItems.PAINTING_KITCHEN_SINK);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.KITE, ModItems.PAINTING_KITE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.LEMON_SLICE, ModItems.PAINTING_LEMON_SLICE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.MERMAID, ModItems.PAINTING_MERMAID);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.MILKYWAY, ModItems.PAINTING_MILKYWAY);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.NIGHT_CAMPFIRE, ModItems.PAINTING_NIGHT_CAMPFIRE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.PUMPKIN, ModItems.PAINTING_PUMPKIN);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.RAINBOW_UNICORN, ModItems.PAINTING_RAINBOW_UNICORN);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.RESTAURANT, ModItems.PAINTING_RESTAURANT);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.ROSE_SWING, ModItems.PAINTING_ROSE_SWING);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.SALTED_LEMON, ModItems.PAINTING_SALTED_LEMON);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.SCENERY, ModItems.PAINTING_SCENERY);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.SKETCH, ModItems.PAINTING_SKETCH);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.SNOW_HOUSE, ModItems.PAINTING_SNOW_HOUSE);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.STATIONARY_OBJECTS, ModItems.PAINTING_STATIONARY_OBJECTS);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.SUMPTUOUS_MEAL, ModItems.PAINTING_SUMPTUOUS_MEAL);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.SUNSET, ModItems.PAINTING_SUNSET);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.TEDDY_BEAR, ModItems.PAINTING_TEDDY_BEAR);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.TOYS, ModItems.PAINTING_TOYS);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.TULIP, ModItems.PAINTING_TULIP);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.URBAN_BEAUTY, ModItems.PAINTING_URBAN_BEAUTY);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.WAVES, ModItems.PAINTING_WAVES);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.WHEAT_FIELD, ModItems.PAINTING_WHEAT_FIELD);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.WILDFLOWER_PLAIN, ModItems.PAINTING_WILDFLOWER_PLAIN);
        PAINTINGS_ITEM_HASH_MAP.put(Paintings.WORLD_TREE, ModItems.PAINTING_WORLD_TREE);

        // Items -> Paintings 映射（反向）
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_ANGEL, Paintings.ANGEL);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_BEDROOM_BED, Paintings.BEDROOM_BED);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_BICHON, Paintings.BICHON);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_CAKE, Paintings.CAKE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_CAT_UNDER_A_TREE, Paintings.CAT_UNDER_A_TREE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_CHIME, Paintings.CHIME);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_CITY_NIGHT, Paintings.CITY_NIGHT);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_CLOVER, Paintings.CLOVER);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_COW, Paintings.COW);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_CRYSTAL_FAIRY, Paintings.CRYSTAL_FAIRY);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_DESSERT, Paintings.DESSERT);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_FLOWER_BASKET, Paintings.FLOWER_BASKET);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_FLOWERSEA_COTTAGE, Paintings.FLOWERSEA_COTTAGE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_FRIENDS_PARTY, Paintings.FRIENDS_PARTY);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_FRUITS_BASKET, Paintings.FRUITS_BASKET);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_GARDEN_ENTRANCE, Paintings.GARDEN_ENTRANCE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_GRAMOPHONE, Paintings.GRAMOPHONE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_GRAVEYARD, Paintings.GRAVEYARD);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_HARVEST, Paintings.HARVEST);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_ISLAND, Paintings.ISLAND);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_KITCHEN_SINK, Paintings.KITCHEN_SINK);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_KITE, Paintings.KITE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_LEMON_SLICE, Paintings.LEMON_SLICE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_MERMAID, Paintings.MERMAID);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_MILKYWAY, Paintings.MILKYWAY);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_NIGHT_CAMPFIRE, Paintings.NIGHT_CAMPFIRE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_PUMPKIN, Paintings.PUMPKIN);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_RAINBOW_UNICORN, Paintings.RAINBOW_UNICORN);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_RESTAURANT, Paintings.RESTAURANT);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_ROSE_SWING, Paintings.ROSE_SWING);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_SALTED_LEMON, Paintings.SALTED_LEMON);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_SCENERY, Paintings.SCENERY);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_SKETCH, Paintings.SKETCH);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_SNOW_HOUSE, Paintings.SNOW_HOUSE);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_STATIONARY_OBJECTS, Paintings.STATIONARY_OBJECTS);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_SUMPTUOUS_MEAL, Paintings.SUMPTUOUS_MEAL);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_SUNSET, Paintings.SUNSET);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_TEDDY_BEAR, Paintings.TEDDY_BEAR);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_TOYS, Paintings.TOYS);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_TULIP, Paintings.TULIP);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_URBAN_BEAUTY, Paintings.URBAN_BEAUTY);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_WAVES, Paintings.WAVES);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_WHEAT_FIELD, Paintings.WHEAT_FIELD);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_WILDFLOWER_PLAIN, Paintings.WILDFLOWER_PLAIN);
        ITEM_PAINTINGS_HASH_MAP.put(ModItems.PAINTING_WORLD_TREE, Paintings.WORLD_TREE);
    }
}
