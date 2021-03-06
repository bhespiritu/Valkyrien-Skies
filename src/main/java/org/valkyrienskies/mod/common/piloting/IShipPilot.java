package org.valkyrienskies.mod.common.piloting;

import net.minecraft.util.math.BlockPos;
import org.valkyrienskies.mod.common.ships.ship_world.PhysicsObject;

/**
 * Todo: Convert to a forge capability.
 */
@Deprecated
public interface IShipPilot {

    PhysicsObject getPilotedShip();

    void setPilotedShip(PhysicsObject physicsObject);

    boolean isPilotingShip();

    boolean isPilotingATile();

    boolean isPiloting();

    BlockPos getPosBeingControlled();

    void setPosBeingControlled(BlockPos pos);

    ControllerInputType getControllerInputEnum();

    void setControllerInputEnum(ControllerInputType type);

    void stopPilotingEverything();
}
