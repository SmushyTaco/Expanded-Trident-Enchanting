package com.smushytaco.expanded_trident_enchanting
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents
import net.minecraft.enchantment.Enchantment
import net.minecraft.registry.DynamicRegistryManager
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.entry.RegistryEntry
import kotlin.jvm.optionals.getOrNull
object ExpandedTridentEnchanting : ModInitializer {
    const val MOD_ID = "expanded_trident_enchanting"
    val config = ModConfig.createAndLoad()
    private var dynamicRegistryManager: DynamicRegistryManager? = null
    override fun onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register { server -> dynamicRegistryManager = server.registryManager }
    }
    fun isSameEnchantment(enchantment: Enchantment, enchantmentRegistryKey: RegistryKey<Enchantment>) = dynamicRegistryManager?.getOptional(RegistryKeys.ENCHANTMENT)?.getOrNull()?.getEntry(enchantment)?.matchesKey(enchantmentRegistryKey) ?: false
    fun canCombineEnchantments(first: RegistryEntry<Enchantment>, second: RegistryEntry<Enchantment>, enchantments: Set<RegistryKey<Enchantment>>) = enchantments.any { first.matchesKey(it) } && enchantments.any { second.matchesKey(it) } && !first.matchesKey(second.key.getOrNull())
}