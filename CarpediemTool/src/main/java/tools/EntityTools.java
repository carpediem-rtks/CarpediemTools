package tools;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class EntityTools {

	public static boolean isLivingEntity(Entity ent) {
		return ent instanceof LivingEntity && !(ent instanceof ArmorStand);
	}
}
