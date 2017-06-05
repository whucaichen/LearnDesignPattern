package com.chance;

import com.chance.Door2;
import com.chance.DoorState;

/**
 * Created by Chance on 16/08/19.
 */
class DoorClosed extends DoorState {
    public DoorClosed(Door2 door) {
        super(door);
    }

    @Override
    public void touch() {

    }
}
