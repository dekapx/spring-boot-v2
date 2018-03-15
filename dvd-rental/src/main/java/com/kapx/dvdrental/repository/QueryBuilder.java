package com.kapx.dvdrental.repository;

public class QueryBuilder {
    private static final String NAME = "NAME";
    private static final String AGE = "AGE";
    private static final String MARKS = "MARKS";

    public static void main(String[] args) {

    }

    private String getQuery(final String param) {
        final StringBuilder builder = new StringBuilder();
        builder.append("SELECT u FROM UserEntity u ");

        switch (param) {
            case NAME:
                builder.append("where name=" + NAME);
                break;
            case AGE:
                builder.append("where age=" + AGE);
                break;
            case MARKS:
                builder.append("where marks=" + MARKS);
                break;
            default:
                break;
        }

        return builder.toString();
    }
}
