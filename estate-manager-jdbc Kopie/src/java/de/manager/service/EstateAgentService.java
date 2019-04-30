package de.manager.service;

import de.manager.entity.EstateAgent;
import de.manager.entity.House;

public interface EstateAgentService {

    int getEstateAgentId(String loginName);

    void addEstateAgent(EstateAgent estateAgent);

    void deleteEstateAgent(String loginName);

    void updateEstateAgent(EstateAgent estateAgent);

    boolean existEstateAgent(String loginName, String loginPassword);
}
