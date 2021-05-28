package com.smushytaco.expanded_trident_enchanting.configuration_support
import com.smushytaco.expanded_trident_enchanting.ExpandedTridentEnchanting
import me.shedaniel.autoconfig.ConfigData
import me.shedaniel.autoconfig.annotation.Config
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment
@Config(name = ExpandedTridentEnchanting.MOD_ID)
class ModConfiguration: ConfigData {
    @Comment("Default value is yes. If set to yes you'll be able to use Fire Aspect on a trident. If set to no you won't be able to.")
    val canUseFireAspectOnTrident = true
    @Comment("Default value is yes. If set to yes you'll be able to use Knockback on a trident. If set to no you won't be able to.")
    val canUseKnockbackOnTrident = true
    @Comment("Default value is yes. If set to yes you'll be able to use Looting on a trident. If set to no you won't be able to.")
    val canUseLootingOnTrident = true
    @Comment("Default value is yes. If set to yes you'll be able to use all other weapon enchantment types on a trident. If set to no you won't be able to.")
    val canUseOtherWeaponEnchantmentTypesOnTrident = true
}