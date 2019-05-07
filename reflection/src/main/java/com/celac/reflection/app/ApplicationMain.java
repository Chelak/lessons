package com.celac.reflection.app;

import com.celac.reflection.app.context.ContextBuilder;
import com.celac.reflection.app.context.LocalContextContainer;
import com.celac.reflection.app.service.LocalDemoService;

import java.io.IOException;

public class ApplicationMain {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        System.out.println("App start");
        final LocalContextContainer localContextContainer = ContextBuilder.loadApplication("com.celac.reflection.app");
        LocalDemoService localDemoService =  (LocalDemoService) localContextContainer.getContext().get("LocalDemoServiceImpl");
        System.out.println(localDemoService.getServiceMethod());
        System.out.println("App finish");
    }
}
