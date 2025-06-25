# School Medical Management System

Dự án quản lý y tế trường học được xây dựng với Spring Boot và Thymeleaf.

## 🚀 Bắt đầu nhanh

### Yêu cầu hệ thống

* Java Development Kit (JDK) 17 hoặc mới hơn
* Apache Maven 3.6.3 hoặc mới hơn
* SQL Server 2017 trở lên (hoặc Docker SQL Server image)

### Cài đặt Cơ sở dữ liệu

1.  **Cài đặt SQL Server:** Đảm bảo bạn đã cài đặt SQL Server cục bộ.
2.  **Tạo Database:** Tạo một database mới, ví dụ: `school_med_db`.
3.  **Tạo người dùng DB:** Tạo một người dùng SQL Server và cấp quyền truy cập vào `school_med_db`.
4.  **Chạy Script Schema (Tùy chọn):** Nếu `spring.jpa.hibernate.ddl-auto` được đặt là `none`, bạn cần chạy script DDL để tạo bảng:
    ```sql
    -- File: database/schema.sql
    CREATE TABLE users (...);
    CREATE TABLE students (...);
    -- v.v.
    ```
5.  **Chèn dữ liệu mẫu (Tùy chọn):** Để có dữ liệu ban đầu, chạy script DML:
    ```sql
    -- File: database/data.sql
    INSERT INTO users (username, password, role) VALUES ('admin', 'password', 'ADMIN');
    INSERT INTO students (student_id, full_name, ...) VALUES ('HS001', N'Nguyễn Văn A', ...);
    ```

### Cấu hình Dự án

1.  **Clone Repository:**
    ```bash
    git clone [https://github.com/your-username/school-medical-system.git](https://github.com/your-username/school-medical-system.git)
    cd school-medical-system
    ```
2.  **Cập nhật `application.properties`:**
    Mở file `src/main/resources/application.properties` và cập nhật thông tin kết nối cơ sở dữ liệu của bạn:
    ```properties
    spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=school_med_db;encrypt=true;trustServerCertificate=true
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    # Có thể đặt ddl-auto là update cho môi trường dev ban đầu, sau này chuyển thành none
    spring.jpa.hibernate.ddl-auto=update
    ```

### 🏃 Cách chạy ứng dụng

1.  **Mở Terminal** tại thư mục gốc của dự án (nơi có file `pom.xml`).
2.  **Chạy lệnh Maven:**
    ```bash
    mvn clean install -DskipTests spring-boot:run
    ```
3.  **Truy cập ứng dụng:**
    Mở trình duyệt web của bạn và truy cập: [http://localhost:8080](http://localhost:8080)
    Để đăng nhập, truy cập: [http://localhost:8080/login](http://localhost:8080/login)
    * Tài khoản Admin mặc định: `username=admin`, `password=password` (nếu bạn đã thêm vào `data.sql`).

## 🛠️ Công nghệ sử dụng

* Spring Boot
* Spring Data JPA / Hibernate
* Thymeleaf
* Bootstrap 5
* SQL Server

## 🐛 Khắc phục sự cố

* **Lỗi kết nối DB:** Kiểm tra lại `spring.datasource.url`, `username`, `password` trong `application.properties`. Đảm bảo SQL Server đang chạy và có thể truy cập từ máy của bạn.
* **Cổng đã bị sử dụng:** Nếu cổng 8080 đã được dùng, bạn có thể thay đổi trong `application.properties` bằng cách thêm `server.port=8081`.
* **Lỗi biên dịch:** Chạy `mvn clean install` để đảm bảo tất cả dependencies đã được tải xuống và không có lỗi mã nguồn.
