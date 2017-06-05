package com.chance;

/**
 * Created by Chance on 16/08/19.
 */
public class DoorStayOpen extends DoorState {
    @Override
    public void touch() {

    }

    public DoorStayOpen(Door2 door) {
        super(door);
    }

//    public DoorState touch() {
////        door.setState(door.CLOSING);
//        return DoorState.STAYOPEN;
//        // 以前是 door.setState(door.STAYOPEN);
//    }
}