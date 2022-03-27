package vdcomtest.VdCom.PartTwo.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import vdcomtest.VdCom.PartTwo.model.EntityBank;

import java.sql.ResultSet;
import java.sql.SQLException;


public class BankRowMapper implements RowMapper<EntityBank> {
    @Override
    public EntityBank mapRow(ResultSet rs, int rowNum) throws SQLException {
        EntityBank bank = new EntityBank();
        bank.setBankid(rs.getInt("BANK_ID"));
        bank.setName(rs.getString("BANK_NAME"));
        return bank;
    }
}
