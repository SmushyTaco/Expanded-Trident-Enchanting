package com.smushytaco.expanded_trident_enchanting.mixins;
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.LuckEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import org.spongepowered.asm.mixin.Mixin;
@Mixin(value = LuckEnchantment.class, priority = 1001)
public abstract class TridentsCanHaveLooting extends Enchantment {
    protected TridentsCanHaveLooting(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }
    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if (type != EnchantmentTarget.WEAPON || !ExpandedTridentEnchanting.INSTANCE.getConfig().getCanUseLootingOnTrident()) return super.isAcceptableItem(stack);
        return stack.getItem() instanceof TridentItem || super.isAcceptableItem(stack);
    }
}