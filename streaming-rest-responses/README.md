# download-using-streaming-response-body
An example for streaming large files in chunks using StreamingResponseBody in Spring MVC

Ensure the following folder structure exists locally (in user.home directory):  

![README](https://github.com/excelsiorsoft/spring-boot-experiments/blob/master/streaming-rest-responses/README_images/README.png)

Start the server:

![README1](https://github.com/excelsiorsoft/spring-boot-experiments/blob/master/streaming-rest-responses/README_images/README1.png)

Hit the `api/download endpoint, credentials are **admin/admin**:

![README2](https://github.com/excelsiorsoft/spring-boot-experiments/blob/master/streaming-rest-responses/README_images/README2.png)

Credentials are configured in `application.yml`:

![README4](https://github.com/excelsiorsoft/spring-boot-experiments/blob/master/streaming-rest-responses/README_images/README4.png)

Observe the downloaded resource in the browser/filesystem:

![README3](https://github.com/excelsiorsoft/spring-boot-experiments/blob/master/streaming-rest-responses/README_images/README3.png)

Related Blog: https://techshard.com/2019/06/30/streaming-data-with-spring-boot-restful-web-service/
