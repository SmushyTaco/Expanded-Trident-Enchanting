package com.smushytaco.expanded_trident_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.registry.entry.RegistryEntry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.Set;
@Mixin(Enchantment.class)
public abstract class TridentModification {
    @ModifyReturnValue(method = "isAcceptableItem", at = @At("RETURN"))
    public boolean isAcceptableItem(boolean original, ItemStack stack) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.FIRE_ASPECT)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.KNOCKBACK)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.LOOTING)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseLootingOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.DENSITY)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseDensityOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.BREACH)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseBreachOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.WIND_BURST)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseWindBurstOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.SHARPNESS) || ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.SMITE) || ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.BANE_OF_ARTHROPODS)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseOtherWeaponEnchantmentTypesOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        }
        return original;
    }
    @ModifyReturnValue(method = "canBeCombined", at = @At("RETURN"))
    private static boolean hookCanBeCombined(boolean original, RegistryEntry<Enchantment> first, RegistryEntry<Enchantment> second) { return original || ExpandedTridentEnchanting.INSTANCE.getConfig().getImpalingAndOtherWeaponEnchantmentTypesCanBeMixed() && (ExpandedTridentEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.IMPALING, Enchantments.SMITE)) || ExpandedTridentEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.IMPALING, Enchantments.BANE_OF_ARTHROPODS)) || ExpandedTridentEnchanting.INSTANCE.canCombineEnchantments(first, second, Set.of(Enchantments.IMPALING, Enchantments.SHARPNESS))); }
}