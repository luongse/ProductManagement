USE [master]
GO
/****** Object:  Database [ItemManagement]    Script Date: 10/13/2020 9:54:57 AM ******/
CREATE DATABASE [ItemManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ItemManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.LUONGND\MSSQL\DATA\ItemManagement.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ItemManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.LUONGND\MSSQL\DATA\ItemManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ItemManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ItemManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ItemManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ItemManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ItemManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ItemManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ItemManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ItemManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ItemManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ItemManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ItemManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ItemManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ItemManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ItemManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ItemManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ItemManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ItemManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ItemManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ItemManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ItemManagement] SET  MULTI_USER 
GO
ALTER DATABASE [ItemManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ItemManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ItemManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ItemManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ItemManagement] SET DELAYED_DURABILITY = DISABLED 
GO
USE [ItemManagement]
GO
/****** Object:  Table [dbo].[tblItems]    Script Date: 10/13/2020 9:54:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblItems](
	[itemCode] [varchar](10) NOT NULL,
	[itemName] [nvarchar](50) NULL,
	[unit] [varchar](50) NULL,
	[price] [float] NULL,
	[supplying] [bit] NULL,
	[supCode] [varchar](15) NULL,
 CONSTRAINT [PK__tblItems__A22D0FD19EB8902A] PRIMARY KEY CLUSTERED 
(
	[itemCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblSuppliers]    Script Date: 10/13/2020 9:54:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblSuppliers](
	[supCode] [varchar](15) NOT NULL,
	[supName] [nvarchar](50) NULL,
	[address] [nvarchar](50) NULL,
	[collaborating] [bit] NULL,
 CONSTRAINT [PK__tblSuppl__8599381D68217DF7] PRIMARY KEY CLUSTERED 
(
	[supCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 10/13/2020 9:54:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'234', N'1', N'1', 1, 1, N'acer')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'acer', N'acer nitro5', N'2132', 12321, 1, N'acer')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'acer7', N'acer nitro', N'2132', 123213, 1, N'acer')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'dd', N'131', N'1312', 1321, 0, N'acer')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'sua hop', N'sua hop nho', N'23', 1200, 1, N'suadac')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'sua hop be', N'sua hop', N'123', 4563345, 0, N'suadac')
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'2', N'23456', N'2', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'acer', N'Prdator triton mnk', N'12312', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'dd', N'12', N'1312', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'dd1', N'll', N'aa', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'orange', N'Cam sanh2', N'129 Le Duc Tho', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'suadac', N'Sua Dac Ong tho', N'123 Le Duc Tho', 0)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'hoang', N'Tran Gia Hoang', N'12322', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'liem', N'Tran Cong Liem', N'1231', 0)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'luong', N'NgoDucLuong', N'123', 0)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'minh', N'Nguyen Hoang Minh', N'123', 0)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'thuan', N'Le Hoang Thuan', N'12345', 1)
ALTER TABLE [dbo].[tblItems]  WITH CHECK ADD  CONSTRAINT [FK_tblItems_tblSuppliers] FOREIGN KEY([supCode])
REFERENCES [dbo].[tblSuppliers] ([supCode])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[tblItems] CHECK CONSTRAINT [FK_tblItems_tblSuppliers]
GO
USE [master]
GO
ALTER DATABASE [ItemManagement] SET  READ_WRITE 
GO
