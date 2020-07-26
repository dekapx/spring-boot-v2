package com.dekapx.springapp.common;

public enum CommandType {
    SAVE_COMMAND {
        public String toString() {
            return "com.dekapx.springapp.command.SaveCommand";
        }
    },
    UPDATE_COMMAND {
        public String toString() {
            return "com.dekapx.springapp.command.UpdateCommand";
        }
    },
    DELETE_COMMAND {
        public String toString() {
            return "com.dekapx.springapp.command.DeleteCommand";
        }
    };
}
