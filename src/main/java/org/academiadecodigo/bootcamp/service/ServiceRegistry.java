package org.academiadecodigo.bootcamp.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    private static ServiceRegistry registry;
    private Map<String, Service> registryMap = new HashMap<>();

    private ServiceRegistry() {
    }

    public Service getService(String serviceName)  {
        return registryMap.get(serviceName);
    }

    public void registerService(Service service) {
        registryMap.put(service.getServiceName(), service);
    }

    public void unregisterService(String service) {
        registryMap.remove(service);
    }

    public void clear() {
        registryMap.clear();
    }

    public static ServiceRegistry getServiceRegistry() {

        if (registry == null) {
            registry = new ServiceRegistry();
        }

        return registry;

    }

}
