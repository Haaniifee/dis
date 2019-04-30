package de.manager.dao;

import de.manager.entity.Apartment;
import de.manager.entity.House;

public interface EstateDAO {

    void insertHouse(House house);

    void deleteHouse(int houseId);

    void updateHouse(House house);

    void insertApartment(Apartment apartment);

    void deleteApartment(int apartmentId);

    void updateApartment(Apartment apartment);

    boolean estateAgentMaintainHouse(int estateAgentId, int houseId);

    boolean estateAgentMaintainApartment(int estateAgentId, int apartmentId);

    House getHouse(int houseId, int estateAgentId);

    Apartment getApartment(int apartmentId, int estateAgentId);
}
