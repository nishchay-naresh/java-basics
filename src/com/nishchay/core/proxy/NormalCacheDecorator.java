package com.nishchay.core.proxy;

import java.util.HashMap;
import java.util.Map;

public class NormalCacheDecorator implements IObject {

    private IObject original;
    private Map<String, Object> cacheData = new HashMap<>();

    public NormalCacheDecorator (IObject original) {

        this.original = original;
    }

    @Override
    public String getData () {
        Object data = cacheData.get("getData");
        if (data == null) {
            data = original.getData();
            cacheData.put("getData", data);

        }
        return (String) data;
    }
}