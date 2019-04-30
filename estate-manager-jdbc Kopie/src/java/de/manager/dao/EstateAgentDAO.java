package de.manager.dao;

import de.manager.entity.EstateAgent;

public interface EstateAgentDAO {

    int getEstateAgentId(String loginName);

    void addEstateAgent(EstateAgent estateAgent);

    void deleteEstateAgent(String loginName);

    void updateEstateAgent(EstateAgent estateAgent);

    boolean existEstateAgent(String loginName, String loginPassword);
}
