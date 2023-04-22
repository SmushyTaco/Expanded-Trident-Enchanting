package com.smushytaco.expanded_trident_enchanting.mixins;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(Enchantment.class)
@SuppressWarnings("ConstantConditions")
public abstract class TridentModification {
    @Shadow
    @Final
    public EnchantmentTarget target;
    @Inject(method = "isAcceptableItem", at = @At("HEAD"), cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        Enchantment enchantment = (Enchantment) (Object) this;
        if (enchantment instanceof FireAspectEnchantment) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseFireAspectOnTrident() || !(stack.getItem() instanceof TridentItem)) return;
            cir.setReturnValue(true);
        } else if (enchantment instanceof KnockbackEnchantment) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseKnockbackOnTrident() || !(stack.getItem() instanceof TridentItem)) return;
            cir.setReturnValue(true);
        }  else if (enchantment instanceof LuckEnchantment) {
            if (!ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseLootingOnTrident() || target != EnchantmentTarget.WEAPON || !(stack.getItem() instanceof TridentItem)) return;
            cir.setReturnValue(true);
        }
    }
}