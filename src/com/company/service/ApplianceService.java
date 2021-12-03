package com.company.service;

import com.company.entity.Appliance;
import com.company.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

/**
 * Interface for appliance services.
 */
public interface ApplianceService {

    /**
     * Finds all appliances that fit criteria.
     * @param criteria
     * @return list of found appliances
     */
    List<Appliance> find(Criteria criteria);

    /**
     * Gets minimal appliances by criteria.
     *
     * @param comparator defines minimal value criteria
     * @return list of appliances with minimal criteria defined by comparator
     */
    List<Appliance> getMin(Comparator<Appliance> comparator);

    /**
     * Gets sorted by comparator appliances.
     *
     * @param comparator for sorting appliances
     * @return list of sorted by comparator appliances
     */
    List<Appliance> getSorted(Comparator<Appliance> comparator);

    /**
     * Saves a list of appliances to a file.
     * @param appliances list of appliances to save
     */
    void save(List<Appliance> appliances);

}
