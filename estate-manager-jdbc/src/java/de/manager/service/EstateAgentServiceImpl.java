package de.manager.service;

import de.manager.dao.EstateAgentDAO;
import de.manager.entity.EstateAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateAgentServiceImpl implements  EstateAgentService  {

    @Autowired
    EstateAgentDAO estateAgentDAO;

    @Override
    public int getEstateAgentId(String loginName) {
        return estateAgentDAO.getEstateAgentId(loginName);
    }

    @Override
    public void addEstateAgent(EstateAgent estateAgent) {
        estateAgentDAO.addEstateAgent(estateAgent);
    }

    @Override
    public void deleteEstateAgent(String loginName) {
        estateAgentDAO.deleteEstateAgent(loginName);
    }

    @Override
    public void updateEstateAgent(EstateAgent estateAgent) {
        estateAgentDAO.updateEstateAgent(estateAgent);
    }

    @Override
    public boolean existEstateAgent(String loginName, String loginPassword) {
        return estateAgentDAO.existEstateAgent(loginName, loginPassword);
    }
}
