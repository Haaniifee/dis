package de.manager.service;

import de.manager.dao.EstateDAO;
import de.manager.entity.Apartment;
import de.manager.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateDAO estateDAO;

    @Override
    public void insertHouse(House house) {
        estateDAO.insertHouse(house);
    }

    @Override
    public void deleteHouse(int houseId) {
        estateDAO.deleteHouse(houseId);
    }

    @Override
    public void updateHouse(House house) {
        estateDAO.updateHouse(house);
    }

    @Override
    public void insertApartment(Apartment apartment) {
        estateDAO.insertApartment(apartment);
    }

    @Override
    public void deleteApartment(int apartmentId) {
        estateDAO.deleteApartment(apartmentId);
    }

    @Override
    public void updateApartment(Apartment apartment) {
        estateDAO.updateApartment(apartment);
    }

    @Override
    public boolean estateAgentMaintainHouse(int estateAgentId, int houseId) {
        return estateDAO.estateAgentMaintainHouse(estateAgentId, houseId);
    }

    @Override
    public boolean estateAgentMaintainApartment(int estateAgentId, int apartmentId) {
        return estateDAO.estateAgentMaintainApartment(estateAgentId, apartmentId);
    }

    @Override
    public House getHouse(int houseId, int estateAgentId) {
        return estateDAO.getHouse(houseId, estateAgentId);
    }

    @Override
    public Apartment getApartment(int apartmentId, int estateAgentId) {
        return estateDAO.getApartment(apartmentId, estateAgentId);
    }
}
