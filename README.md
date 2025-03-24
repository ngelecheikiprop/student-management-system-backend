
# Setting Up SQL Server with Docker on WSL  

This guide outlines how to set up an SQL Server instance using Docker on WSL and connect it using SQL Server Management Studio (SSMS).  

## 1. Pull the SQL Server Docker Image  

Run the following command to pull the latest Microsoft SQL Server Docker image:  

```sh
docker pull mcr.microsoft.com/mssql/server:latest
```

## 2. Run the SQL Server Container  

Since port `1433` is already in use on Windows, we map the container to port `1435` to avoid conflicts:  

```sh
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=StrongP@ssw0rd!' \
   -p 1435:1433 --name sqlserver -d \
   mcr.microsoft.com/mssql/server:latest
```

## 3. Install `sqlcmd` Tools  

To interact with the database using `sqlcmd`, enter the container’s Bash shell as the root user:  

```sh
docker exec -it --user root sqlserver /bin/bash
```

Then, install the necessary tools:  

```sh
apt-get update && apt-get install -y curl gnupg2
curl -sSL https://packages.microsoft.com/keys/microsoft.asc | apt-key add -
apt-get install -y software-properties-common
add-apt-repository "$(curl -s https://packages.microsoft.com/config/ubuntu/20.04/mssql-tools.list)"
apt-get update && apt-get install -y mssql-tools unixodbc-dev
```

## 4. Switch to the `mssql` User  

After installing the tools, switch to the SQL Server user:  

```sh
su -mssql
```

## 5. Create a Test Database  

Use `sqlcmd` to create a test database:  

```sql
CREATE DATABASE TestDB
GO
```

## 6. Connect via SQL Server Management Studio (SSMS)  

To connect using SSMS, use the following credentials:  

- **Server Name:** `localhost,1435`  
- **Authentication:** `SQL Server Authentication`  
- **Login:** `SA`  
- **Password:** `StrongP@ssw0rd!`  

After entering these details, you should connect successfully.  


