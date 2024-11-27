package su.nightexpress.nexshop.product.handler.impl;

import cc.mewcraft.wakame.api.NekooProvider;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.nexshop.ShopPlugin;
import su.nightexpress.nexshop.api.shop.packer.ItemPacker;
import su.nightexpress.nexshop.product.handler.AbstractPluginItemHandler;
import su.nightexpress.nexshop.product.packer.impl.NekooItemPacker;

public class NekooItemHandler extends AbstractPluginItemHandler {

    public NekooItemHandler(@NotNull final ShopPlugin plugin) {
        super(plugin);
    }

    @Override public @NotNull ItemPacker createPacker(@NotNull final String itemId, final int amount) {
        return new NekooItemPacker(this, itemId, amount);
    }

    @Override public @Nullable ItemStack createItem(@NotNull final String itemId) {
        var nekooApi = NekooProvider.get();
        var nekoItem = nekooApi.getItemRegistry().getOrNull(itemId);
        return nekoItem == null ? null : nekoItem.createItemStack();
    }

    @Override public @Nullable String getItemId(@NotNull final ItemStack itemStack) {
        var nekooApi = NekooProvider.get();
        var nekoItem = nekooApi.getItemRegistry().getOrNull(itemStack);
        return nekoItem == null ? null : nekoItem.getId().asString();
    }

    @Override public boolean isValidId(@NotNull final String itemId) {
        var nekooApi = NekooProvider.get();
        var nekoItem = nekooApi.getItemRegistry().getOrNull(itemId);
        return nekoItem != null;
    }

    @Override public boolean canHandle(@NotNull final ItemStack item) {
        var nekooApi = NekooProvider.get();
        var nekoItem = nekooApi.getItemRegistry().getOrNull(item);
        return nekoItem != null;
    }

    @Override public @NotNull String getName() {
        return "nekoo";
    }
}
