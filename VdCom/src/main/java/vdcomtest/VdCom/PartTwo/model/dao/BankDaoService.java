package vdcomtest.VdCom.PartTwo.model.dao;

import vdcomtest.VdCom.PartTwo.model.EntityBank;

import java.util.List;
import java.util.UUID;

public interface BankDaoService {
    List<EntityBank> getAllBank();

    EntityBank getById(int bankid);

    boolean updateBank(int bankid, String name);

    boolean deleteBank(int bankid);

    boolean insertBank(String name);

}
