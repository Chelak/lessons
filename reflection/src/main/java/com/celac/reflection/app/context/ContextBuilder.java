package com.celac.reflection.app.context;


import java.io.IOException;

import static com.celac.reflection.app.tools.PackageReaderUtil.getClassesFromPackage;

public class ContextBuilder {

    private static LocalContextContainer localContextContainer = new LocalContextContainer();

    public static LocalContextContainer loadApplication(String applicationPackage) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // Scan  application  packa
        final Class[] aplicationClasese = getClassesFromPackage(applicationPackage);
        for (Class clazz : aplicationClasese) {
            if (clazz.getInterfaces().length > 0) {
                localContextContainer.getContext().put(clazz.getSimpleName(), clazz.newInstance());
            }

        }

        return localContextContainer;
    }

}
