# DTO

DTO is a data transfer pattern used to share data between client and server.
used to reduce remote calls from client to server
like to get org,dept,employee data client will have to make 3 separate API call but with DTO what we can do is just create a separate api which will return all these 3 data in single API. thus reducing the API calls from 3 to 1.
server can send only required data and not whole entity 

Disadvantages of using entity directly to transfer data from jpa db to client
1. transferring sensitive information like entity might have field like password so it will get transfeered to client if we use the entity directly in controller response.


Convert entity to dto - 3rd party lib is used since there will belarge number of user entities and dtos so we need to use the mapper 3rd party libraries and not create it manually
- use model mapper library
- map struct library - code generated library generate code based on annotation at compile time


# API request Validation

- Java Bean Validation API , this is just a specification
- Hibernate Validator - refrence impl of validation API, this is implementation
- use @Valid annotation on controller
- customize the validation error by extending global excdption to response entity exception handler class. override handleMethodArgumentValid method
@NotNull
@Size - used for string,array,collection,map
@Min
@max
@email
@NotEmpty
@NotBlank - not null or whitespace
  
# Swagger UI

http://localhost:8080/swagger-ui/index.html