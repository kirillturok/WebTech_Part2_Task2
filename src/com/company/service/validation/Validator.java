package com.company.service.validation;


import com.company.entity.criteria.Criteria;
import com.company.entity.criteria.SearchCriteria;

import java.util.Arrays;
import java.util.Set;

/**
 * Class for criteria validation.
 */
public class Validator {

    public static boolean validCriteria(Criteria criteria){
        return switch (criteria.getGroupSearchName()){
            case "Kettle" -> doesCriteriaExists(criteria, SearchCriteria.Kettle.class);
            case "Laptop" -> doesCriteriaExists(criteria, SearchCriteria.Laptop.class);
            case "Oven" -> doesCriteriaExists(criteria, SearchCriteria.Oven.class);
            case "Refrigerator" -> doesCriteriaExists(criteria, SearchCriteria.Refrigerator.class);
            case "Speakers" -> doesCriteriaExists(criteria, SearchCriteria.Speakers.class);
            case "TabletPC" -> doesCriteriaExists(criteria, SearchCriteria.TabletPC.class);
            case "VacuumCleaner" -> doesCriteriaExists(criteria, SearchCriteria.VacuumCleaner.class);
            default -> false;
        };
    }

    /**
     * Compares criteria to search criteria available for an appliance.
     * @param criteria criteria to search for
     * @param e all search criteria available for an appliance
     * @return true if appliance has all of criteria
     */
    private static boolean doesCriteriaExists(Criteria criteria, Class<? extends Enum<?>> e){
        Set<String> properties = criteria.getCriteria().keySet();
        String[] arr = Arrays.stream(e.getEnumConstants()).map(Enum::toString).toArray(String[]::new);
        return Arrays.asList(arr).containsAll(properties);
    }

}
