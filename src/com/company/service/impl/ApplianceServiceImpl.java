package com.company.service.impl;
import com.company.dao.ApplianceDAO;
import com.company.dao.DAOFactory;
import com.company.entity.Appliance;
import com.company.entity.criteria.Criteria;
import com.company.service.ApplianceService;
import com.company.service.validation.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ApplianceServiceImpl implements ApplianceService {

    /**
     * Finds all appliances that fit criteria.
     * @param criteria
     * @return list of found appliances
     */
    @Override
    public List<Appliance> find(Criteria criteria) {
        if (Validator.validCriteria(criteria)) {
            ApplianceDAO applianceDAO = DAOFactory.getInstance().getApplianceDAO();
            return applianceDAO.find(criteria);
        }
        else
            return null;
    }

    /**
     * Gets minimal appliances by criteria.
     *
     * @param comparator defines minimal value criteria
     * @return list of appliances with minimal criteria defined by comparator
     */
    @Override
    public List<Appliance> getMin(Comparator<Appliance> comparator) {
        DAOFactory factory = DAOFactory.getInstance();
        List<Appliance> appliances = factory.getApplianceDAO().parseAll();
        Appliance min = appliances.stream().min(comparator).orElse(null);
        if (min != null) {
            return appliances.stream()
                    .filter(p -> comparator.compare(p, min) == 0)
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    /**
     * Gets sorted by comparator appliances.
     *
     * @param comparator for sorting appliances
     * @return list of sorted by comparator appliances
     */
    @Override
    public List<Appliance> getSorted(Comparator<Appliance> comparator) {
        DAOFactory factory = DAOFactory.getInstance();
        List<Appliance> appliances = factory.getApplianceDAO().parseAll();
        appliances.sort(comparator);
        return appliances;
    }

    /**
     * Saves a list of appliances to a file.
     * @param appliances list of appliances to save
     */
    @Override
    public void save(List<Appliance> appliances) {
        DAOFactory factory = DAOFactory.getInstance();
        factory.getApplianceDAO().save(appliances);
    }

}