<h1>Swagger API</h1>
<h5>I, Swagger</h5>
<h6>- Swagger là một công cụ và một hệ sinh thái giúp thiết kế,
xây dựng, và tài liệu hóa các API (Application Programming Interface).
Nó cung cấp một cách tiếp cận tự động hóa quy trình này, 
từ việc mô tả API đến việc tạo tài liệu API và thậm chí cả việc kiểm thử API.</h6>

<h5>II, Swagger bao gồm các thành phần chính sau:</h6>
1, Swagger Editor:
<h6>Một trình soạn thảo trực quan cho phép bạn mô tả API của mình bằng cách sử dụng JSON hoặc YAML. Nó cung cấp giao
diện đồ họa giúp bạn định nghĩa các đầu vào, đầu ra, các phương thức, các tham số và nhiều hơn nữa.</h6>
2, Swagger UI:
<h6>Giao diện người dùng dựa trên web cho phép bạn xem tài liệu API được tạo ra từ mã Swagger. Nó giúp người dùng cuối
dễ dàng hiểu cách sử dụng API.</h6>
3, Swagger Codegen:
<h6>Công cụ này có khả năng tạo mã nguồn tự động từ mô tả API của bạn. Nó hỗ trợ nhiều ngôn ngữ lập trình khác nhau và
giúp giảm bớt công việc lặp đi lặp lại khi triển khai API.</h6>
1, Swagger Inspector:
<h6>Công cụ này giúp bạn kiểm thử các API mà không cần phải viết mã.</h6>
1, Swagger Hub:
<h6>Một nền tảng trực tuyến cho phép đội ngũ phát triển, kiểm thử và quản lý API.</h6>

<h5>III, Cài đặt </h6>
1, thêm dependency sau vào tệp pom.xml
<h6>
<dependency>
<groupId>org.springdoc</groupId>
<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
<version>2.0.3</version>
</dependency><br>
</h6>

2, truy cập vào đường link sau để mở swagger UI
<h6>truy cập vào đường link sau( thay đổi host theo port của app):</h6>
http://localhost:8080/swagger-ui/index.html#/