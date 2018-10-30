import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class ItemFrameUtil {

	public static ItemFrame createFrameOnBlock(Player player,Block block)
	{
		BlockFace face = ItemUtil.getNewCardinalDirection(player);
		try {
			ItemFrame i = null;
			Block b = block.getRelative(face);
			i = block.getWorld().spawn(b.getLocation(), ItemFrame.class);
			i.setFacingDirection(face, false);
			return i;
		}
		catch(Exception e) {

		}
		return null;
	}

	private static BlockFace getNewCardinalDirection(Player p)
	{
		double rotation = (p.getLocation().getYaw() ) % 360;
		if (rotation < 0) {rotation += 360.0;}
		if (0 <= rotation && rotation < 22.5){return BlockFace.NORTH;}
		else if (22.5 <= rotation && rotation < 67.5) {return BlockFace.NORTH_EAST;}
		else if (67.5 <= rotation && rotation < 112.5) {return BlockFace.EAST;}
		else if (112.5 <= rotation && rotation < 157.5) {return BlockFace.SOUTH_EAST;}
		else if (157.5 <= rotation && rotation < 202.5) {return BlockFace.SOUTH;}
		else if (202.5 <= rotation && rotation < 247.5) {return BlockFace.SOUTH_WEST;}
		else if (247.5 <= rotation && rotation < 292.5) {return BlockFace.WEST;}
		else if (292.5 <= rotation && rotation < 337.5) {return BlockFace.NORTH_WEST;}
		else if (337.5 <= rotation && rotation < 360.0) {return BlockFace.NORTH;}
		else {return null;}
	}

}
