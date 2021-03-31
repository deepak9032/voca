Tech Stack : Java, SpringBoot initializer, SpringBoot web, Lombok (for annotations like getter/setter)

How to Run:
    1. Clone the repository and import in your IDE as springboot application. All the dependencies are included in pom.xml
    so no need to do anything else.

    2. Run the main method of VocaApplication class. It will start the application on internal tomcat at http://localhost:8080

    3. Run the rest api's of VocaController class from postman

    4. Adding the postman collection of Api's - voca.postman_collection.json in root folder.


 Key points:-

    1. Saving all the data in-memory.

    2. Wallets (map) maps phone number to wallet balance.

    3. Wallet is created with minimum required balance(X), have hard-coded it to Rs. 5000 for now.

    4. Throwing custom exceptions for edge-cases.

    5. Synchronized the code inside debit method to make it thread safe