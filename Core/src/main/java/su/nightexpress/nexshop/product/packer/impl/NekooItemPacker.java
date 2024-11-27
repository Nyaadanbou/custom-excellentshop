package su.nightexpress.nexshop.product.packer.impl;

import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import su.nightexpress.nexshop.product.handler.impl.NekooItemHandler;
import su.nightexpress.nexshop.product.packer.AbstractPluginItemPacker;

import java.util.function.UnaryOperator;

public class NekooItemPacker extends AbstractPluginItemPacker<NekooItemHandler> {

    public NekooItemPacker(@NotNull final NekooItemHandler handler, @NotNull final String itemId, final int amount) {
        super(handler, itemId, amount);
    }

    @Override public @Nullable ItemStack createItem() {
        return this.handler.createItem(this.itemId);
    }

    @Override public @NotNull UnaryOperator<String> replacePlaceholders() {
        return UnaryOperator.identity();
    }
}
