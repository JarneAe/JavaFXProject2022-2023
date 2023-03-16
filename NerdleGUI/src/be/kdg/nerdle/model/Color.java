package be.kdg.nerdle.model;

public enum Color {
    GREEN, PURPLE, BLACK, CLEAR;

    public String translateColorToHex() {
        switch (this) {
            case CLEAR -> {
                return "#8e8c8c";

            }
            case GREEN -> {
                return "#30b052";

            }

            case BLACK -> {
                return "#000000";

            }

            case PURPLE -> {
               return "#Ad187b";

            }

            default -> { // this should theoretically never happen? but if it does it'll go red which is very spooky
                return "#FF0000";
                // if this happens, panic.
            }
        }
    }

    // overview hovering
    public String translateColorToLighterHex() {
        switch (this) {
            case CLEAR -> {
                return "#ccc8c8";

            }
            case GREEN -> {
                return "#3ce669";
            }

            case BLACK -> {
                return "#1e1e1e";

            }

            case PURPLE -> {
                return "#D01d94";

            }

            default -> {
                return "#FF0000";
                // see comment on default on last method.
            }
        }
    }
}
