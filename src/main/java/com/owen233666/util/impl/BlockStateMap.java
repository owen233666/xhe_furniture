package com.owen233666.util.impl;

import com.owen233666.block.painting.Paintings;
import net.minecraft.item.Item;
import net.minecraft.util.StringIdentifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class BlockStateMap<E extends Enum<E> & StringIdentifiable, I extends Item> implements Map<E, I> {

    private final Map<E, I> enumToItem;

    private final Map<I, E> itemToEnum;

    private final Class<E> enumClass;

    public BlockStateMap(@NotNull Class<E> enumClass) {
        this.enumClass = Objects.requireNonNull(enumClass, "enumClass cannot be null");
        this.enumToItem = new HashMap<>();
        this.itemToEnum = new HashMap<>();
    }

    @NotNull
    public static <E extends Enum<E> & StringIdentifiable, I extends Item>
    BlockStateMap<E, I> create(@NotNull Class<E> enumClass) {
        return new BlockStateMap<>(enumClass);
    }

    @NotNull
    public static <E extends Enum<E> & StringIdentifiable, I extends Item>
    BlockStateMap<E, I> fromMap(@NotNull Class<E> enumClass,
                                @NotNull Map<? extends E, ? extends I> map) {
        BlockStateMap<E, I> blockStateMap = new BlockStateMap<>(enumClass);
        blockStateMap.putAll(map);
        return blockStateMap;
    }

    @Override
    public int size() {
        return enumToItem.size();
    }

    @Override
    public boolean isEmpty() {
        return enumToItem.isEmpty();
    }

    @Override
    public boolean containsKey(@Nullable Object key) {
        return enumToItem.containsKey(key);
    }

    @Override
    public boolean containsValue(@Nullable Object value) {
        return enumToItem.containsValue(value);
    }

    @Override
    @SuppressWarnings("unchecked")
    @Nullable
    public I get(@Nullable Object key) {
        if (key == null || !enumClass.isInstance(key)) {
            return null;
        }
        return enumToItem.get(key);
    }

    @Override
    @Nullable
    public I put(@NotNull E key, @NotNull I value) {
        Objects.requireNonNull(key, "Key cannot be null");
        Objects.requireNonNull(value, "Value cannot be null");

        I oldValue = enumToItem.get(key);
        if (oldValue != null) {
            itemToEnum.remove(oldValue);
        }

        E existingEnum = itemToEnum.get(value);
        if (existingEnum != null && !existingEnum.equals(key)) {
            throw new IllegalArgumentException(
                    String.format("Item %s is already mapped to enum %s", value, existingEnum)
            );
        }

        enumToItem.put(key, value);
        itemToEnum.put(value, key);

        return oldValue;
    }

    @Override
    @Nullable
    public I remove(@Nullable Object key) {
        if (key == null || !enumClass.isInstance(key)) {
            return null;
        }

        I removedValue = enumToItem.remove(key);
        if (removedValue != null) {
            itemToEnum.remove(removedValue);
        }
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends E, ? extends I> map) {
        Objects.requireNonNull(map, "Map cannot be null");

        for (Map.Entry<? extends E, ? extends I> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        enumToItem.clear();
        itemToEnum.clear();
    }

    @Override
    @NotNull
    public Set<E> keySet() {
        return Collections.unmodifiableSet(enumToItem.keySet());
    }

    @Override
    @NotNull
    @SuppressWarnings("unchecked")
    public Collection<I> values() {
        return Collections.unmodifiableCollection((Collection<I>) enumToItem.values());
    }

    @Override
    @NotNull
    @SuppressWarnings("unchecked")
    public Set<Entry<E, I>> entrySet() {
        return Collections.unmodifiableSet((Set<Entry<E, I>>) (Set<?>) enumToItem.entrySet());
    }

//    @Nullable
//    public E getByItem(@NotNull I item) {
//        Objects.requireNonNull(item, "Item cannot be null");
//        return itemToEnum.get(item) == null ? Paintings.NONE : itemToEnum.get(item);
//    }

    @NotNull
    public E getByItemOrDefault(@NotNull I item, @NotNull E defaultValue) {
        Objects.requireNonNull(item, "Item cannot be null");
        Objects.requireNonNull(defaultValue, "Default value cannot be null");

        E result = itemToEnum.get(item);
        return result != null ? result : defaultValue;
    }

    @Nullable
    public I getByName(@NotNull String name) {
        Objects.requireNonNull(name, "Name cannot be null");

        try {
            E enumValue = Enum.valueOf(enumClass, name.toUpperCase());
            return enumToItem.get(enumValue);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @Nullable
    public I getByIdentifier(@NotNull String identifier) {
        Objects.requireNonNull(identifier, "Identifier cannot be null");

        for (E enumValue : enumToItem.keySet()) {
            if (enumValue.asString().equals(identifier)) {
                return enumToItem.get(enumValue);
            }
        }
        return null;
    }

    public boolean containsItem(@NotNull I item) {
        Objects.requireNonNull(item, "Item cannot be null");
        return itemToEnum.containsKey(item);
    }

    @Nullable
    public E removeByItem(@NotNull I item) {
        Objects.requireNonNull(item, "Item cannot be null");

        E removedEnum = itemToEnum.remove(item);
        if (removedEnum != null) {
            enumToItem.remove(removedEnum);
        }
        return removedEnum;
    }

    @NotNull
    public Map<I, E> getReverseMap() {
        return Collections.unmodifiableMap(itemToEnum);
    }

    @NotNull
    public Map<I, E> copyReverseMap() {
        return new HashMap<>(itemToEnum);
    }

    @NotNull
    public Map<I, E> reversed() {
        return Collections.unmodifiableMap(itemToEnum);
    }

    @NotNull
    public Map<I, E> copyReversed() {
        return new HashMap<>(itemToEnum);
    }

    @NotNull
    public Set<E> getRegisteredEnums() {
        return keySet();
    }

    @NotNull
    public Set<I> getRegisteredItems() {
        return Collections.unmodifiableSet(itemToEnum.keySet());
    }

    @NotNull
    public Class<E> getEnumClass() {
        return enumClass;
    }

    public int putAllIgnoreDuplicates(@NotNull Map<? extends E, ? extends I> map) {
        Objects.requireNonNull(map, "Map cannot be null");

        int addedCount = 0;
        for (Map.Entry<? extends E, ? extends I> entry : map.entrySet()) {
            try {
                put(entry.getKey(), entry.getValue());
                addedCount++;
            } catch (IllegalArgumentException e) {
                // 忽略重复的 Item 映射，继续处理下一个
            }
        }
        return addedCount;
    }

    public int putAllOverwriteDuplicates(@NotNull Map<? extends E, ? extends I> map) {
        Objects.requireNonNull(map, "Map cannot be null");

        int overwrittenCount = 0;
        for (Map.Entry<? extends E, ? extends I> entry : map.entrySet()) {
            I oldValue = enumToItem.get(entry.getKey());
            if (oldValue != null) {
                itemToEnum.remove(oldValue);
                overwrittenCount++;
            }

            // 检查新值是否已经映射到其他枚举
            E existingEnum = itemToEnum.get(entry.getValue());
            if (existingEnum != null) {
                enumToItem.remove(existingEnum);
                overwrittenCount++;
            }

            // 添加新的映射
            enumToItem.put(entry.getKey(), entry.getValue());
            itemToEnum.put(entry.getValue(), entry.getKey());
        }
        return overwrittenCount;
    }


    @Override
    public boolean equals(@Nullable Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        BlockStateMap<?, ?> that = (BlockStateMap<?, ?>) obj;

        return enumToItem.equals(that.enumToItem);
    }

    @Override
    public int hashCode() {
        return enumToItem.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "BlockStateMap{" +
                "enumClass=" + enumClass.getSimpleName() +
                ", size=" + size() +
                '}';
    }


    public static class Builder<E extends Enum<E> & StringIdentifiable, I extends Item> {
        private final BlockStateMap<E, I> map;

        private Builder(@NotNull Class<E> enumClass) {
            this.map = new BlockStateMap<>(enumClass);
        }

        /**
         * 开始构建
         * @param enumClass 枚举类型的 Class 对象
         * @return 构建器实例
         */
        @NotNull
        public static <E extends Enum<E> & StringIdentifiable, I extends Item>
        Builder<E, I> builder(@NotNull Class<E> enumClass) {
            return new Builder<>(enumClass);
        }

        /**
         * 添加映射
         * @param key 枚举值
         * @param value Item
         * @return 当前构建器
         */
        @NotNull
        public Builder<E, I> put(@NotNull E key, @NotNull I value) {
            map.put(key, value);
            return this;
        }

        /**
         * 批量添加映射
         * @param mappings 映射集合
         * @return 当前构建器
         */
        @NotNull
        public Builder<E, I> putAll(@NotNull Map<? extends E, ? extends I> mappings) {
            map.putAll(mappings);
            return this;
        }

        /**
         * 构建 BlockStateMap
         * @return 构建完成的 BlockStateMap
         */
        @NotNull
        public BlockStateMap<E, I> build() {
            return map;
        }
    }
}