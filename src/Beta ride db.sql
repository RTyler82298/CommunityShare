Create Table Rides
(RideId int Primary Key,
LeavingFrom Varchar(50),
GoingTo Varchar(50),
UserName Varchar(30),
Community Varchar(30),
Gender varchar(20) not null Check(Gender In('Male', 'Female', 'Mixed'))
 --, passangerAvalable int
);
ALTER TABLE Rides  
WITH NOCHECK ADD  CONSTRAINT FK_Rides_Users
FOREIGN KEY(UserName)
REFERENCES Users (UserName)
ON UPDATE CASCADE;

ALTER TABLE rides
ADD passangerAvalable int;
-- or you can add it to the inital making of the table
