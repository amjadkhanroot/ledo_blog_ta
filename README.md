# lendo_blog_ta    ----Blog App for demo----

    ----Develped by Spring boot 2.6.6----

##How to run the app:

- on root dir run `docker-compose up --build`* and you're ready to go!<br>
- Backend API running on port: `8081`<br>
- Database on port: `3307`<br>

######*You must have docker-compose install.

##How to use the app:
- First call "insert-random-users" endpoints to get random users, all have same password which is "password".<br>
- Take a username and login to get the access token.
- Next call "insert-random-posts"  endpoints using the access token to get random posts.
- Lastly call "insert-random-comments" endpoints using the access token to get random comments.<br>
- And consume the restApi.

###Postman Collection:
`https://www.getpostman.com/collections/a79141aa06fafeae8a40`

    
    Thanks & regards 
    Amjad!
