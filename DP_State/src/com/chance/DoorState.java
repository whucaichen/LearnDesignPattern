package com.chance;

/**
 * Created by Chance on 16/08/19.
 */
public abstract class DoorState {
    public final int CLOSED = -1;
    public final int OPENING = -2;
    public final int OPEN = -3;
    public final int CLOSING = -4;
    public final int STAYOPEN = -5;

    protected Door2 door;

    public abstract void touch();

    public void complete() {
    }

    public void timeout() {
    }

    public String status() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf('.') + 1);
    }

    public DoorState(Door2 door) {
        this.door = door;
    }

}