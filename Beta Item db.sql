Create Table Items
(ItemsId int Primary Key,
UserName Varchar(30),
Community Varchar(30),
Condition varchar(20) not null Check(Condition In('Perfect', 'Good', 'Ok', 'Damaged')),
PrimaryContact varchar(20) not null
);
ALTER TABLE Items  
WITH NOCHECK ADD  CONSTRAINT FK_Items_Users
FOREIGN KEY(UserName)
REFERENCES Users (UserName)
ON UPDATE CASCADE;
