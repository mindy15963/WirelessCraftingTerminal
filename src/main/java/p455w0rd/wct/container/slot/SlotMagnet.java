package p455w0rd.wct.container.slot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import p455w0rd.wct.items.ItemMagnet;

public class SlotMagnet extends AppEngSlot {

	public SlotMagnet(IItemHandler inv, int xPos, int yPos) {
		super(inv, 0, xPos, yPos);
	}

	@Override
	public boolean isItemValid(ItemStack is) {
		return ((is != null) && (is.getItem() instanceof ItemMagnet));
	}

}
