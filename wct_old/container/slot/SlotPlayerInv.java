package p455w0rd.wct.container.slot;

import net.minecraftforge.items.IItemHandler;

// there is nothing special about this slot, its simply used to represent the
// players inventory, vs a container slot.

public class SlotPlayerInv extends AppEngSlot {

	public SlotPlayerInv(final IItemHandler par1iInventory, final int par2, final int par3, final int par4) {
		super(par1iInventory, par2, par3, par4);

		this.setPlayerSide(true);
	}
}
