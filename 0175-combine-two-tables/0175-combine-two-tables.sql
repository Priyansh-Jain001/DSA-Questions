# Write your MySQL query statement below

SELECT Person.firstname, Person.lastName, Address.city, Address.state FROM Person LEFT JOIN Address ON Person.personID = Address.personID;