package com.company.entity.criteria;
import java.util.HashMap;
import java.util.Map;

/**
 * Class containing search criteria
 */
public class Criteria {

    private String groupSearchName;
    private Map<String, Object> criteria = new HashMap<String, Object>();

    /**
     * @param groupSearchName name for search group
     */
    public Criteria(String groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    /**
     * @return group search name
     */
    public String getGroupSearchName() {
        return groupSearchName;
    }

    /**
     * Add criteria for search
     *
     * @param searchCriteria criteria to add
     * @param value value of criteria
     */
    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    /**
     * @return current criteria
     */
    public Map<String, Object> getCriteria() {
        return criteria;
    }

}
