package com.company.service;


import com.company.service.impl.ApplianceServiceImpl;

/**
 * Factory for creating ApplianceService.
 */
public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {}

    public ApplianceService getApplianceService() {

        return applianceService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

}