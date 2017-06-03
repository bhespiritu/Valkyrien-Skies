package ValkyrienWarfareControl.TileEntity;

import ValkyrienWarfareControl.GraphTheory.INodeProvider;
import ValkyrienWarfareControl.GraphTheory.Node;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class ThrustRelayTileEntity extends TileEntity implements INodeProvider{

	final Node tileNode;

	public ThrustRelayTileEntity(){
		tileNode = new Node(this);
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		SPacketUpdateTileEntity packet = new SPacketUpdateTileEntity(pos, 0, writeToNBT(new NBTTagCompound()));
		return packet;
	}

	@Override
	public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt) {
		readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		tileNode.readFromNBT(compound);
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		tileNode.writeToNBT(compound);
		return super.writeToNBT(compound);
	}

	@Override
	public Node getNode() {
		return tileNode;
	}

	@Override
    public void invalidate() {
//		System.out.println("Please RNGesus!");
		//The Node just got destroyed
        this.tileEntityInvalid = true;
        Node toInvalidate = getNode();

        toInvalidate.destroyNode();
    }

    /**
     * validates a tile entity
     */
	@Override
    public void validate() {
        this.tileEntityInvalid = false;
    }

}
