package me.resp.udonation.routebeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import me.resp.udonation.UdonationProperties;

@Configuration
public class ServerRouterConfig {

//   @Bean
//   public RouterFunction<ServerResponse> fileUpload(
//       Daos daos,
//       DcsPluginAppProperties appProperties,
//       FileUploadHandler fileUploadHandler,
//       ServerResponseUtil ru) {
//     return RouterFunctions.route(
//         RequestPredicates.POST(appProperties.getUris().uploadPath() + "/{name}"),
//         fileUploadHandler::receive);
//   }

//   @Bean
//   public RouterFunction<ServerResponse> fileUploadToGoogleDrive(
//       Daos daos,
//       DcsPluginAppProperties appProperties,
//       FileUploadToGoogleDriveHandler fileUploadHandler,
//       ServerResponseUtil ru) {
//     return RouterFunctions.route(
//         RequestPredicates.POST(appProperties.getUris().uploadToGoogleDrivePath()),
//         fileUploadHandler::receive);
//   }

//   @Bean
//   public RouterFunction<ServerResponse> pluginDevelop(
//       PluginDevelopHandler handler, DcsPluginAppProperties appProperties) {
//     return RouterFunctions.route()
//         .path(
//             appProperties.getUris().pluginDevelopPath(),
//             builder ->
//                 builder
//                     .GET("/manually-execute-instance/{instanceId}", handler::executeInstance)
//                     .GET("/what-send-to-plugin/{instanceId}", handler::viewSendToPlugin))
//         .build();
//   }

//   @Bean
//   public RouterFunction<ServerResponse> openids(
//       OpenidHandler handler, DcsPluginAppProperties appProperties) {
//     return RouterFunctions.route()
//         .path(
//             appProperties.getUris().dcsApiPrefix(),
//             builder -> builder.GET("/open_ids", handler::list))
//         .build();
//   }

//   @Bean
//   public RouterFunction<ServerResponse> kuduEndpoint(
//       GoogleSheetPluginHandler handler, DcsPluginAppProperties appProperties) {
//     return RouterFunctions.route()
//         .path(
//             appProperties.getUris().googleSheetPrefix(),
//             builder -> builder.POST("/sheet_plugin", handler::create))
//         .build();
//   }

  @Bean
  public RouterFunction<ServerResponse> startPage(UdonationProperties appProperties) {
    return RouterFunctions.route()
        .path(
            "/",
            builder ->
                builder.GET(
                    "/",
                    req ->
                        ServerResponse.ok()
                            .contentType(MediaType.TEXT_PLAIN)
                            .render("start")))
                            // .bodyValue("I'm here.")))
        .build();
  }

}
