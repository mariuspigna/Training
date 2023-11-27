## Training


    URL: http://localhost:8080/api/v1/training/student

# Test POST: 
{
"firstName": "toto",
"lastName": "tata",
"email": "toto@gmail.com",
"dob": "1981-11-24",
"furnitureList": [
        {
        "id":1,
        "name":"stylo",
        "quantity":"3",
        "price":2
        }
    ]
}
## Register
http://localhost:8080/api/v1/training/student/register
{
"firstname":"TOTO",
"lastname":"TITI",
"email":"email@emial.com",
"password":"12344",
"dob": "1981-11-24",
"fournitureList": [
{
"name":"stylo",
"quantity":"3",
"price":2
}
]
}
## Autenticate
http://localhost:8080/api/v1/training/student/authenticate
{
"email":"email@email.com",
"password":"12344"
}
### TODO
## - Add OneToMany

