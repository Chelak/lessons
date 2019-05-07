package com.celac.reflection.app.context;

import java.util.HashMap;
import java.util.Map;

public class LocalContextContainer {

    private Map context = new HashMap<String, Object>();

    public Map getContext() {
        return context;
    }
}
