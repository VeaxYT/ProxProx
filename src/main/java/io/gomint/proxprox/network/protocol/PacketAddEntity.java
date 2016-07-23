/*
 * Copyright (c) 2016, GoMint, BlackyPaw and geNAZt
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.proxprox.network.protocol;

import io.gomint.jraknet.PacketBuffer;
import io.gomint.proxprox.network.Protocol;
import lombok.Getter;

/**
 * @author geNAZt
 * @version 1.0
 */
@Getter
public class PacketAddEntity extends Packet {

    private long entityId;

    /**
     * Constructor for implemented Packet AddEntity
     */
    public PacketAddEntity() {
        super( Protocol.ADD_ENTITY_PACKET );
    }

    @Override
    public void serialize( PacketBuffer buffer ) {

    }

    @Override
    public void deserialize( PacketBuffer buffer ) {
        this.entityId = buffer.readLong();
    }
}