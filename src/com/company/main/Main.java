package com.company.main;

import com.company.entity.Appliance;
import com.company.entity.criteria.Criteria;
import com.company.entity.criteria.SearchCriteria;
import com.company.service.ApplianceService;
import com.company.service.ServiceFactory;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Appliance> appliances;
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        Criteria kettleCriteria = new Criteria(SearchCriteria.Kettle.class.getSimpleName());
        appliances = service.find(kettleCriteria);
        if (appliances != null) {
            System.out.println("All kettles: ");
            PrintApplianceInfo.print(appliances);
        }

        Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        ovenCriteria.add("powerConsumption", 300);
        List<Appliance> ovens300 = service.find(ovenCriteria);
        if(ovens300 != null) {
            System.out.println("\nOvens with a capacity of 300:: ");
            PrintApplianceInfo.print(ovens300);
        }

        System.out.println();
        appliances = service.getMin(Comparator.comparing(Appliance::getPrice));
        System.out.println("Appliances with minimal price: ");
        PrintApplianceInfo.print(appliances);
    }

}
