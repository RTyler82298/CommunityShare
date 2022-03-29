USE [Users2]
GO

/****** Object:  Table [dbo].[BetaRide3]    Script Date: 3/29/2022 2:17:43 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

Create Table[dbo].[Users](
	[UserID] varchar(25) Primary Key,
	Password varchar(25),
	Email varchar(30),
	Phone varchar(20),
	MemberOf varchar(35),
	ContactMethod varchar(20) not null Check(ContactMethod In('Email', 'Phone', 'Do not contact'))
)ON [PRIMARY] 
GO


/* Not sure if it would work with the way I wrote it as varchar
alter table dbo.Users
add constraint UQ_Phone unique (Phone)


alter table Users
add constraint CC_Phone  check
(
    Phone not like '%[^0-9]%'and 
    ((Phone like '03%' and len(Phone) = 11) or 
    (Phone not like '_3%' and len(Phone) = 10))
)*/

CREATE TABLE [dbo].[Communities](
	[CommunityID] [int] IDENTITY(1,1) NOT NULL,
	[CommunityName] [varchar](35) NOT NULL Unique,
	Admin varchar(25)
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[Rides](
	[RideID] [int] IDENTITY(1,1) NOT NULL,
	[LeavingFrom] [varchar](50) NOT NULL,
	[GoingTo] [varchar](50) NOT NULL,
	[Eta] [smalldatetime] NOT NULL,
	[UserName] [varchar](35) NOT NULL,
	[ContactMethod] [varchar](30) NOT NULL,
	[PassangerAvailable] [int] NOT NULL,
	Gender varchar(20) not null Check(Gender In('Male', 'Female', 'Mixed')),
	[CommunityID] [int] NOT NULL
) ON [PRIMARY] 
GO

CREATE TABLE [dbo].[Items](
	[itemID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](35) NOT NULL,
	[ContactMethod] [varchar](30) NOT NULL,
	Condition varchar(20) not null Check(Condition In('Perfect', 'Great', 'Good', 'Ok', 'Acceptable', 'Broken' )),
	[CommunityID] [int] NOT NULL,
	[Description] [varchar](256)
) ON [PRIMARY] 
GO







