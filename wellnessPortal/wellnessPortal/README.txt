--Application design--
This application is designed to help a healthcare/insurance provider's customer  to access their information, update their personal information, see how long before their prescription refills and where they can pick them up.
It is designed to allow the customer to have ease of access to most of their medical information through the insurance company, and could be expanded to include the ability to find and schedule doctors appointments, contact a customer service representative from either their pharmacy or insurance company to get help changing information. 
Admin priviledges could also be added to allow for a customer service rep/pharmacist to add or change prescriptions from a remote site, as well as to assist the customer.

--Get the Application working--
In order to get this application working you'll need to have maven, import the files, create a database and update the database information within the application.properties file, use the SQL script contained within wellness_portal-dbscript in your mysql database.
The sql script allows you to import the original user with the username of theFuddo@yahoo.com and password of password123 to access the site. 
You are also able to register a new user immediatly but won't have access to the ability to add prescriptions as this feature has not been implemented yet.

--Difficulties--
Some struggles with this project included importing spring security to allow for user registration and log in as the bean configuration for Bcrypt created a cycle of calls. But this is fixed in the application.properties file by allowing for circular references be made. 
Another difficulty was have 2 ManyToMany relationships within the Customer table, as this does not allow for two EAGER call types making testing more difficult for the customers_prescriptions table.
Final blocker was Cascade types not being able to be called for ManyToOne relationships, thus all updates have to customer have to be from an already created Pharmacy or Insurance object, but this is as inteded and was an issue with my understanding of the relationship of the tables. 
