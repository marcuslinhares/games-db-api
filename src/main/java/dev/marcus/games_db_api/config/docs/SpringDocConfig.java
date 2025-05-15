package dev.marcus.games_db_api.config.docs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Configuration
@OpenAPIDefinition
public class SpringDocConfig {
    @Value("${server.port}")
    private String serverPort;

    @Value("${production.url}")
    private String productionUrl;

    @Bean
    OpenAPI customOpenAPI() throws IOException {
        var key = "default";

        ApiResponse badRequest = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(key,
                                new Example().value(read("badRequestResponse")))))
                .description("BAD REQUEST");

        ApiResponse notFound = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(key,
                                new Example().value(read("notFoundResponse")))))
                .description("NOT FOUND");

        ApiResponse internalServerError = new ApiResponse().content(
                new Content().addMediaType(MediaType.APPLICATION_JSON_VALUE,
                        new io.swagger.v3.oas.models.media.MediaType().addExamples(key,
                                new Example().value(read("internalServerErrorResponse")))))
                .description("INTERNAL SERVER ERROR");

        var components = new Components();

        components.addResponses("badRequest", badRequest);
        components.addResponses("notFound", notFound);
        components.addResponses("internalServerError", internalServerError);

        var servers = new ArrayList<Server>();

        if (!this.productionUrl.equals("")) {
            servers.add(
                new Server().url(this.productionUrl + "/api").description("PRODUÇÂO")
            );
        }else{
            servers.add(
                new Server().url("http://localhost:" + serverPort + "/api").description("DESENVOLVIMENTO LOCALHOST")
            );
        }

        return new OpenAPI()
                .info(new Info()
                        .title("Games DB")
                        .description("Games DB - Api")
                        .version("v1"))
                .components(components)
                .servers(servers);
    }

    @Bean
    GroupedOpenApi producersGroup() {
        String[] paths = { "/**" };
        return GroupedOpenApi.builder().group("Geral").pathsToMatch(paths).build();
    }

    @Value("classpath:springdoc-responses/responses.json")
    private Resource jsonFile;

    private String read(String key) throws IOException {
        try (var inputStream = jsonFile.getInputStream()) {
            String content = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            return new JSONObject(content).get(key).toString();
        }
    }
}
