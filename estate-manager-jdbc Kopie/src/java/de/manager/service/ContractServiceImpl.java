package de.manager.service;

import de.manager.dao.ContractDAO;
import de.manager.entity.Person;
import de.manager.entity.PurchaseContract;
import de.manager.entity.TenancyContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements  ContractService{

    @Autowired
    ContractDAO contractDAO;

    @Override
    public void insertPerson(Person person) {
        contractDAO.insertPerson(person);
    }

    @Override
    public boolean personExist(Person person) {
        return contractDAO.personExist(person);
    }

    @Override
    public void createPurchaseContract(PurchaseContract purchaseContract) {
        contractDAO.createPurchaseContract(purchaseContract);
    }

    @Override
    public void createTenancyContract(TenancyContract tenancyContract) {
        contractDAO.createTenancyContract(tenancyContract);
    }

    @Override
    public boolean purchaseContractExist(int personId, int houseId, String contractNumber) {
        return contractDAO.purchaseContractExist(personId, houseId, contractNumber);
    }

    @Override
    public boolean tenancyContractExist(int personId, int apartmentId, String contractNumber) {
        return contractDAO.tenancyContractExist(personId, apartmentId, contractNumber);
    }

    @Override
    public List<PurchaseContract> getAllPurchaseContracts() {
        return contractDAO.getAllPurchaseContracts();
    }

    @Override
    public List<TenancyContract> getAllTenancyContracts() {
        return contractDAO.getAllTenancyContracts();
    }
}
