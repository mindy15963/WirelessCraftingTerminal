/*
 * This file is part of Wireless Crafting Terminal. Copyright (c) 2017, p455w0rd
 * (aka TheRealp455w0rd), All rights reserved unless otherwise stated.
 *
 * Wireless Crafting Terminal is free software: you can redistribute it and/or
 * modify it under the terms of the MIT License.
 *
 * Wireless Crafting Terminal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for
 * more details.
 *
 * You should have received a copy of the MIT License along with Wireless
 * Crafting Terminal. If not, see <https://opensource.org/licenses/MIT>.
 */
package p455w0rd.wct.sync.packets;

import appeng.fluids.util.AEFluidStack;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.entity.player.EntityPlayer;
import p455w0rd.wct.container.ContainerWFT;
import p455w0rd.wct.sync.WCTPacket;
import p455w0rd.wct.sync.network.INetworkInfo;

/**
 * @author p455w0rd
 *
 */
public class PacketTargetFluidStack extends WCTPacket {
	private AEFluidStack stack;

	// automatic.
	public PacketTargetFluidStack(final ByteBuf stream) {
		try {
			if (stream.readableBytes() > 0) {
				stack = (AEFluidStack) AEFluidStack.fromPacket(stream);
			}
			else {
				stack = null;
			}
		}
		catch (Exception ex) {
			stack = null;
		}
	}

	// api
	public PacketTargetFluidStack(AEFluidStack stack) {

		this.stack = stack;

		final ByteBuf data = Unpooled.buffer();
		data.writeInt(getPacketID());
		if (stack != null) {
			try {
				stack.writeToPacket(data);
			}
			catch (Exception ex) {
			}
		}
		configureWrite(data);
	}

	@Override
	public void serverPacketData(final INetworkInfo manager, final WCTPacket packet, final EntityPlayer player) {
		if (player.openContainer instanceof ContainerWFT) {
			((ContainerWFT) player.openContainer).setTargetStack(stack);
		}
	}
}