/*
 * XHeYa's Furniture (xhe_furniture) - All Rights Reserved
 *
 * Copyright (C) 2026 owen233666, XHeYa_3u3
 */
package com.owen233666.platform;

import com.owen233666.XheFurniture;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

/**
 * Platform-neutral entry point for registering game content.
 *
 * <h2>Why construction must be deferred on Forge</h2>
 * Forge and NeoForge freeze their registries before mod construction finishes, and building an
 * {@link Item} or {@link Block} reaches into the registry immediately ({@code Item}'s constructor
 * calls {@code createIntrusiveHolder}). Creating the instance during mod construction therefore dies
 * with {@code IllegalStateException: Registry is already frozen}. Fabric has no such restriction,
 * but the shared code has to work everywhere, so every object is created lazily through a
 * {@link Supplier} and published as a {@link Holder} - the same contract {@code DeferredRegister}
 * provides.
 *
 * <p>Two APIs live here for now:
 * <ul>
 *   <li>{@link #block}, {@link #item}, ... - the deferred API used by the mod's registry classes.
 *       They hand back a {@link Holder}, so call sites read {@code ModBlocks.FOO.get()}.</li>
 *   <li>the older {@code offer}-based methods below - kept only until those registry classes are
 *       migrated, then deleted.</li>
 * </ul>
 */
public final class Registrar {
	private Registrar() {
	}

	/** Platform-neutral lazy reference to a registered object, mirroring {@code DeferredHolder}. */
	public interface Holder<T> {
		T get();
	}

	// --------------------------------------------------------- deferred registration

	//#if NEOFORGE
	private static final java.util.Map<ResourceKey<? extends Registry<?>>, net.neoforged.neoforge.registries.DeferredRegister<?>> DEFERRED = new java.util.LinkedHashMap<>();

	/** NeoForge does not attach deferred registers by itself, so the mod bus is wired up here. */
	public static void attachToBus(net.neoforged.bus.api.IEventBus bus) {
		for (net.neoforged.neoforge.registries.DeferredRegister<?> register : DEFERRED.values()) {
			register.register(bus);
		}
	}
	//#endif
	//#if FORGE
	//$$ private static final java.util.Map<ResourceKey<? extends Registry<?>>, net.minecraftforge.registries.DeferredRegister<?>> DEFERRED = new java.util.LinkedHashMap<>();
//$$
//$$ public static void attachToBus(net.minecraftforge.eventbus.api.IEventBus bus) {
//$$ 	for (net.minecraftforge.registries.DeferredRegister<?> register : DEFERRED.values()) {
//$$ 		register.register(bus);
//$$ 	}
//$$ }
	//#endif

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static <T> Holder<T> defer(ResourceKey<? extends Registry<?>> key, ResourceLocation id, Supplier<T> factory) {
		//#if NEOFORGE
		net.neoforged.neoforge.registries.DeferredRegister register = DEFERRED.computeIfAbsent(
				key,
				k -> net.neoforged.neoforge.registries.DeferredRegister.create((ResourceKey) k, XheFurniture.MOD_ID)
		);
		net.neoforged.neoforge.registries.DeferredHolder holder = (net.neoforged.neoforge.registries.DeferredHolder) register.register(id.getPath(), factory);
		return () -> (T) holder.get();
		//#endif
		//#if FORGE
		//$$ net.minecraftforge.registries.DeferredRegister register = DEFERRED.computeIfAbsent(
		//$$ 		key,
		//$$ 		k -> net.minecraftforge.registries.DeferredRegister.create((ResourceKey) k, XheFurniture.MOD_ID)
		//$$ );
		//$$ net.minecraftforge.registries.RegistryObject holder = (net.minecraftforge.registries.RegistryObject) register.register(id.getPath(), factory);
		//$$ return () -> (T) holder.get();
		//#endif
		//#if FABRIC || MERGED
		//$$ // Fabric has no deferred registry. Build the value now, publish it immediately and hand
		//$$ // back a holder that just returns it; the ordering is fixed by class initialisation,
		//$$ // which is what this mod relied on before.
		//$$ T value = factory.get();
		//$$ Registry<?> registry = BuiltInRegistries.REGISTRY.get(key.location());
		//$$ Registry.register((Registry) registry, id, value);
		//$$ return () -> value;
		//#endif
	}

	/**
	 * Builds a {@link BlockItem} and wires it into vanilla's {@code Item.BY_BLOCK} map.
	 *
	 * <p>Vanilla only ever populates that map from {@code Items.registerItem}, which calls
	 * {@code blockItem.registerBlocks(Item.BY_BLOCK, item)} before putting the item in the
	 * registry. We register through the loaders' registries directly, so we bypass that helper
	 * and {@code Block#asItem()} would otherwise fall back to {@code Items.AIR} for every block
	 * this mod adds -- verified identical on 1.20.1 and 1.21.1.
	 *
	 * <p>The consequence is NOT cosmetic: {@code new ItemStack(someBlock)} then yields an empty
	 * stack with count 0. Fabric tolerates that silently, which is why it went unnoticed, but
	 * NeoForge's creative-tab build hook rejects any stack whose count is not 1, so the client
	 * crashed the moment the creative inventory was opened.
	 */
	private static BlockItem newBlockItem(Block block) {
		BlockItem item = new BlockItem(block, new Item.Properties());
		item.registerBlocks(Item.BY_BLOCK, item);
		return item;
	}

	public static Holder<Block> block(ResourceLocation id, Supplier<Block> factory) {
		Holder<Block> block = defer(Registries.BLOCK, id, factory);
		defer(Registries.ITEM, id, () -> newBlockItem(block.get()));
		return block;
	}

	public static Holder<Block> blockWithoutItem(ResourceLocation id, Supplier<Block> factory) {
		return defer(Registries.BLOCK, id, factory);
	}

	public static Holder<Item> item(ResourceLocation id, Supplier<Item> factory) {
		return defer(Registries.ITEM, id, factory);
	}

	public static <T extends BlockEntity> Holder<BlockEntityType<T>> blockEntity(ResourceLocation id, Supplier<BlockEntityType<T>> factory) {
		return defer(Registries.BLOCK_ENTITY_TYPE, id, factory);
	}

	public static <T extends AbstractContainerMenu> Holder<MenuType<T>> menu(ResourceLocation id, Supplier<MenuType<T>> factory) {
		return defer(Registries.MENU, id, factory);
	}

	public static <T extends AbstractContainerMenu> Holder<MenuType<T>> simpleMenu(ResourceLocation id, java.util.function.BiFunction<Integer, net.minecraft.world.entity.player.Inventory, T> factory) {
				// MenuType.MenuSupplier is package-private on plain Fabric (NeoForge widens it with an access
		// transformer), so the factory is kept as a plain BiFunction instead of naming that type.
		return menu(id, () -> new MenuType<>(factory::apply, FeatureFlags.VANILLA_SET));
	}

	public static Holder<CreativeModeTab> creativeTab(ResourceLocation id, Supplier<CreativeModeTab> factory) {
		return defer(Registries.CREATIVE_MODE_TAB, id, factory);
	}

	// ------------------------------------------- legacy eager/queued API (being replaced)

	private static final List<Pending> PENDING = new ArrayList<>();

	private record Pending(ResourceKey<? extends Registry<?>> key, ResourceLocation id, Object value) {
	}

	private static <T> T offer(ResourceKey<? extends Registry<?>> key, ResourceLocation id, T value) {
		//#if FORGE_LIKE
		PENDING.add(new Pending(key, id, value));
		return value;
		//#else
		//$$ Registry<?> registry = BuiltInRegistries.REGISTRY.get(key.location());
		//$$ registerInto(cast(registry), id, value);
		//$$ return value;
		//#endif
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private static void registerInto(Registry registry, ResourceLocation id, Object value) {
		Registry.register(registry, id, value);
	}

	@SuppressWarnings("unchecked")
	private static <T> Registry<T> cast(Registry<?> registry) {
		return (Registry<T>) registry;
	}

	public static Block legacyBlock(ResourceLocation id, Block block) {
		// The block itself is a plain data object and stays eager; its BlockItem is an Item and
		// must be created inside the register event on Forge, so only that part is deferred.
		defer(Registries.ITEM, id, () -> newBlockItem(block));
		return offer(Registries.BLOCK, id, block);
	}

	public static Block legacyBlockWithoutItem(ResourceLocation id, Block block) {
		return offer(Registries.BLOCK, id, block);
	}

	public static Item legacyBlockItem(ResourceLocation id, Block block) {
		return offer(Registries.ITEM, id, newBlockItem(block));
	}

	public static Item legacyItem(ResourceLocation id, Item item) {
		return offer(Registries.ITEM, id, item);
	}

	public static <T extends BlockEntity> BlockEntityType<T> legacyBlockEntity(ResourceLocation id, BlockEntityType<T> type) {
		return offer(Registries.BLOCK_ENTITY_TYPE, id, type);
	}

	public static <T extends AbstractContainerMenu> MenuType<T> legacyMenu(ResourceLocation id, MenuType<T> type) {
		return offer(Registries.MENU, id, type);
	}

	public static <T extends AbstractContainerMenu> MenuType<T> legacySimpleMenu(ResourceLocation id, java.util.function.BiFunction<Integer, net.minecraft.world.entity.player.Inventory, T> factory) {
		return legacyMenu(id, new MenuType<>(factory::apply, FeatureFlags.VANILLA_SET));
	}

	public static CreativeModeTab legacyCreativeTab(ResourceLocation id, CreativeModeTab tab) {
		return offer(Registries.CREATIVE_MODE_TAB, id, tab);
	}

	/**
	 * Flushes the legacy {@code offer} queue for one registry. Called from the loader's register
	 * event; a no-op on platforms that register immediately.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static void flush(ResourceKey<? extends Registry<?>> key) {
		//#if FORGE_LIKE
		Registry<?> registry = BuiltInRegistries.REGISTRY.get(key.location());
		if (registry == null) {
			return;
		}
		Iterator<Pending> iterator = PENDING.iterator();
		while (iterator.hasNext()) {
			Pending pending = iterator.next();
			if (pending.key().equals(key)) {
				registerInto((Registry) registry, pending.id(), pending.value());
				iterator.remove();
			}
		}
		//#endif
	}
}
