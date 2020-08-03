package com.dekapx.springboot.core.command;

public enum CommandType {
    SAVE_COMMAND {
        public String toString() {
            return getTypeName(SaveCommand.class);
        }
    },
    UPDATE_COMMAND {
        public String toString() {
            return getTypeName(UpdateCommand.class);
        }
    },
    DELETE_COMMAND {
        public String toString() {
            return getTypeName(DeleteCommand.class);
        }
    };

    private static <T> String getTypeName(final Class<T> clazz) {
        return clazz.getTypeName();
    }
}
