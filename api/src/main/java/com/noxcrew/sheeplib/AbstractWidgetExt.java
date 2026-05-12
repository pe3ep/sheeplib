package com.noxcrew.sheeplib;

/**
 * An extension to {@link net.minecraft.client.gui.components.AbstractWidget} to allow for hovering to be disabled.
 */
public interface AbstractWidgetExt {
    /**
     * Returns whether this widget can be hovered over.
     */
    default boolean sheeplib$isHoverable() {
        throw new AssertionError("Implemented in Mixin");
    }

    /**
     * Sets whether this widget can be hovered over.
     */
    default void sheeplib$setHoverable(boolean hoverable) {
        throw new AssertionError("Implemented in Mixin");
    }
}
