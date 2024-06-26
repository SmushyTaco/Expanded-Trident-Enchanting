package com.smushytaco.expanded_trident_enchanting.mixins;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
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
        }  else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.LOOTING)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseLootingOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        } else if (ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.SHARPNESS) || ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.SMITE) || ExpandedTridentEnchanting.INSTANCE.isSameEnchantment(enchantment, Enchantments.BANE_OF_ARTHROPODS)) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseOtherWeaponEnchantmentTypesOnTrident() || !(stack.getItem() instanceof TridentItem)) return original;
            return true;
        }
        return original;
    }
}