package com.bergerkiller.bukkit.common.entity.type;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;

import com.bergerkiller.bukkit.common.entity.CommonEntity;
import com.bergerkiller.bukkit.common.utils.WorldUtil;

/**
 * A Common Entity implementation for Living Entities
 * 
 * @param <T> - type of Living Entity
 */
public class CommonLivingEntity<T extends LivingEntity> extends CommonEntity<T> {

	public CommonLivingEntity(T entity) {
		super(entity);
	}

	/**
	 * Gets the height of the living entity's eyes above its Location.
	 * 
	 * @return height of the living entity's eyes above its location
	 */
	public double getEyeHeight() {
		return entity.getEyeHeight();
	}

	/**
	 * Gets the height of the living entity's eyes above its Location.
	 * 
	 * @param ignoreSneaking
	 *            if set to true, the effects of sneaking will be ignored
	 * @return height of the living entity's eyes above its location
	 */
	public double getEyeHeight(boolean ignoreSneaking) {
		return entity.getEyeHeight(ignoreSneaking);
	}

	/**
	 * Get a Location detailing the current eye position of the living entity.
	 * 
	 * @return a location at the eyes of the living entity
	 */
	public Location getEyeLocation() {
		return entity.getEyeLocation();
	}

	/**
	 * Performs ray tracing from the head of this Entity towards where this Entity looks.
	 * The maximum interaction distance (5.0) is used.
	 * Unlike the default getTargetBlock, this method gets the actual highlighted block by this Living Entity.
	 * 
	 * @return the first Block hit, or null if none was found (AIR)
	 */
	public Block getTargetBlock() {
		return getTargetBlock(5.0);
	}

	/**
	 * Performs ray tracing from the head of this Entity towards where this Entity looks.
	 * Unlike the default getTargetBlock, this method gets the actual highlighted block by this Living Entity.
	 * 
	 * @param maxDistance to ray trace
	 * @return the first Block hit, or null if none was found (AIR)
	 */
	public Block getTargetBlock(double maxDistance) {
		return WorldUtil.rayTraceBlock(getEyeLocation(), maxDistance);
	}

	/**
	 * Gets the inventory with the equipment worn by the living entity.
	 * 
	 * @return the living entity's inventory
	 */
	public EntityEquipment getEquipment() {
		return entity.getEquipment();
	}

	/**
	 * Gets the current health level of this Living Entity
	 * 
	 * @return health
	 */
	public double getHealth() {
		return entity.getHealth();
	}

	/**
	 * Sets the current health level of this Living Entity
	 * 
	 * @param health to set to
	 */
	public void setHealth(double health) {
		entity.setHealth(health);
	}

	/**
	 * Damages this Entity, damage caused by an unknown source
	 * 
	 * @param damage dealt
	 */
	public void damage(double damage) {
		entity.damage(damage);
	}

	/**
	 * Damages this Entity, damage caused by another Entity
	 * 
	 * @param damage dealt
	 * @param damager that caused the damage
	 */
	public void damage(double damage, Entity damager) {
		entity.damage(damage, damager);
	}
}
