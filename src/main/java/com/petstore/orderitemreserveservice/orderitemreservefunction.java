package com.petstore.orderitemreserveservice;

import java.util.*;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import com.petstore.orderitemreserveservice.model.OrderItems;

/**
 * Azure Functions with HTTP Trigger.
 */
public class orderitemreservefunction {
    /**
     * This function listens at endpoint "/api/orderitemreservefunction". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/orderitemreservefunction
     * 2. curl {your host}/api/orderitemreservefunction?name=HTTP%20Query
     */
    @FunctionName("orderitemreservefunction")
    public HttpResponseMessage run(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<OrderItems>> request,
            final ExecutionContext context,
            @BlobOutput(name = "outputBlob", path = "{containerName}/{sessionId}.json", connection = "AzureWebJobsStorage")
            OutputBinding<OrderItems> outputBlob,
            @BindingName("containerName") String containerName,
            @BindingName("sessionId") String sessionId){
        context.getLogger().info("Java HTTP trigger processed a request.");

        Optional<OrderItems> body = request.getBody();
        if (body.isPresent()) {
            OrderItems orderItems = body.get();
            context.getLogger().info("Order Items Retrieved for sessionId: " + sessionId + " are: " + orderItems);
            outputBlob.setValue(orderItems);
            context.getLogger().info("Response from Blob Storage : " + outputBlob.getValue());
            return request.createResponseBuilder(HttpStatus.OK).body(orderItems)
                    .header("content-type", "application/json")
                    .build();
        } else {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Order Items data missing").build();
        }


    }
}
