package vdcomtest.VdCom.PartTwo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vdcomtest.VdCom.PartTwo.model.EntityBank;
import vdcomtest.VdCom.PartTwo.model.dao.BankDaoService;

import java.util.List;

@Service
public class BankServiceImplements implements BankService {
    BankDaoService bankDaoService;

    public BankServiceImplements(@Autowired BankDaoService bankDaoService) {
        this.bankDaoService = bankDaoService;
    }

    @Override
    public List<EntityBank> getAllBank() {
        return bankDaoService.getAllBank();
    }

    @Override
    public boolean updateBank(int bankid, String name) {
        return bankDaoService.updateBank(bankid, name);
    }

    @Override
    public boolean deleteBank(int bankid) {
        return bankDaoService.deleteBank(bankid);
    }

    @Override
    public boolean insertBank(String name1) {
        return bankDaoService.insertBank(name1);
    }

    @Override
    public void insertBank(String s1, String s) {

    }


}










