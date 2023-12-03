# Kharcha
Expense tracker application

Expense tracker app is serve api to store expenses for user. 
Logic for 
1. create user and 
2. register user in security context
3. login with valid user and creds
4. adding expense for logged in user
5. added update user and expense
6. added various expense retrieval api’s


We are creating expenses db with 2 tables user and expense.
Following is the db schema diag used for application.




Scope:- 
	Currently auth is working session based. Once user logged in creds are stored in session are being used for every next req. Once session is renewed user need to login again with creds; Also user login req can be easily fetched by malusers to login. Implementation of following soln is added security layer.
* Add jwt token for every new user and based auth with token vaerification is being performed

----------------------
Setting up cloud infra using terraform files.
Create docker image of application
Host service on azure webapp
