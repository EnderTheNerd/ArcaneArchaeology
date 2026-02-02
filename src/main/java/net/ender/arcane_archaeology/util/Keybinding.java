package net.ender.arcane_archaeology.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class Keybinding {
    public static final String KEY_CATEGORY_ARCANE_ARCHAEOLOGY = "key.category.arcane_archaeology";
    public static final String KEY_CAST = "key.arcane_archaeology.cast";

    public static final KeyMapping SPELL_KEY =  new KeyMapping(KEY_CAST, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_ARCANE_ARCHAEOLOGY);
}
