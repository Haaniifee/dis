package de.manager.dao;

import de.manager.entity.Person;
import de.manager.entity.PurchaseContract;
import de.manager.entity.TenancyContract;

import java.util.List;

public interface ContractDAO {

    void insertPerson(Person person);

    boolean personExist(Person person);

    void createPurchaseContract(PurchaseContract purchaseContract);

    void createTenancyContract(TenancyContract tenancyContract);

    boolean purchaseContractExist(int personId, int houseId, String contractNumber);

    boolean tenancyContractExist(int personId, int apartmentId, String contractNumber);

    List<PurchaseContract> getAllPurchaseContracts();

    List<TenancyContract> getAllTenancyContracts();
}
