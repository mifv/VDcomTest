package vdcomtest.VdCom.PartTwo.model.service;

import vdcomtest.VdCom.PartTwo.model.EntityBank;

import java.util.List;


public interface BankService {

    List<EntityBank> getAllBank();
    boolean updateBank(int bankid, String name);
    boolean deleteBank(int bankid );
    boolean insertBank(String name);


    void insertBank(String s1, String s);
}
