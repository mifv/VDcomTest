package vdcomtest.VdCom.PartTwo.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import vdcomtest.VdCom.PartTwo.model.EntityBank;
import vdcomtest.VdCom.PartTwo.model.mapper.BankRowMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BankDaoServiceImplements implements BankDaoService {
    private NamedParameterJdbcTemplate template;

    public BankDaoServiceImplements(@Autowired NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<EntityBank> getAllBank() {
        return template.query("SELECT*FROM BANK", new BankRowMapper());
    }

    @Override
    public EntityBank getById(int bankid) {
        final String sqlQuery = "SELECT * FROM BANK WHERE bankid :bankid";
        Map<String, Integer> map = new HashMap<>();
        map.put("id", bankid);
        return template.queryForObject(sqlQuery, map, new BankRowMapper());
    }

    @Override
    public boolean updateBank(int bankid, String name) {
        final String sqlQuery = "Update BANK set name=:BANK_NAME bankid =:bankid";
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return template.execute(sqlQuery, map, preparedStatement -> preparedStatement.executeUpdate() > 0);


    }

    @Override
    public boolean deleteBank(int bankid) {
        final String sqlQuery = "DELETE FROM BANK WHERE bankid=:bankid";
        Map<String, Integer> map = new HashMap<>();
        map.put("id", bankid);
        return template.execute(sqlQuery, map, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public boolean insertBank(String name) {
        final String sqlQuery = "INSERT INTO BANK (BANK_NAME) VALUES"+"(:name);";

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        return template.execute(sqlQuery, map, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }
}
