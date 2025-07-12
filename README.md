# Just some exercise for java

Use the `rest-client` plugin in visual studio code for easy testing, ref: https://marketplace.visualstudio.com/items?itemName=humao.rest-client

## test-postcomments
This exercise mainly leverage below endpoints:
- https://jsonplaceholder.typicode.com/users
- https://jsonplaceholder.typicode.com/posts
- https://jsonplaceholder.typicode.com/comments

The exercise is aim at learning Spring Boot with persistent data:
1. Learn how to call API via RestTemplate, Provide an api to call the users endpoint and return as json
2. Learn how spring operate database, Save the above output into database
3. Learn how spring handle table join, Provide the second api to call the posts endpoint and save it as database, handle the table join issue
4. Call the comments api and save into database, handle the table join issue
5. Leverage @value to read parameters from config
6. Learn customize bean to reduce duplicated coding like building URL
7. Learn how to update data in spring
8. Learn exception handling with RestControllerAdvice