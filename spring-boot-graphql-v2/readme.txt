https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot
https://developer.okta.com/blog/2020/01/31/java-graphql
-------------------------------------------------------------------------------
Schema: http://localhost:9091/graphql/schema.json
-------------------------------------------------------------------------------
URL: http://localhost:9091/graphql
GraphQL:
{
    findContact(id: 94) {
        firstName
        lastName
        email
        phone
    }
}
-------------------------------------------------------------------------------
URL: http://localhost:9091/graphql
GraphQL:
{
    findContacts {
        firstName
        lastName
        email
        phone
    }
}
-------------------------------------------------------------------------------
URL: http://localhost:9091/graphql
GraphQL:
{
    findContact (id: 104) {
        firstName
        lastName
        email
        phone
        status {
            statusValue
        }
    }
}