package com.cab.booking.instruction;

public enum Command {
    EXIT("exit"),
    REGISTER_DRIVER("register_driver"),
    REGISTER_USER("register_user"),
    SWITCH_ON_CAB("switch_on_cab"),
    SWITCH_OFF_CAB("switch_off_cab"),
    PRINT_ALL_RIDES("print_all_rides"),
    BOOK_CAB("book_cab");

    private String command;
    private Command(String command) {
        this.command = command;
    }
    @Override
    public String toString(){
        return command;
    }
}
