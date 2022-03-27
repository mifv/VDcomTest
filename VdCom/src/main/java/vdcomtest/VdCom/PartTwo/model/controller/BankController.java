package vdcomtest.VdCom.PartTwo.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vdcomtest.VdCom.PartTwo.model.EntityBank;
import vdcomtest.VdCom.PartTwo.model.service.BankService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/bank")
public class BankController {
    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/get")
    public String getAllBank() {
        String result = " ";
        List<EntityBank> list = bankService.getAllBank();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            EntityBank bank = (EntityBank) iterator.next();
            result+= bank.getBankid() + " , " + bank.getName() + " , ";
        }
        return result;
    }

    @DeleteMapping("/delete")
    public String deleteBank(@RequestParam(value = "bankid") int bankid) {
        if (bankService.deleteBank(bankid)) {
            return "Банк с id = " + bankid + " удален";
        } else {
            return "Банк с id = " + bankid + "не удален";
        }
    }

    @PostMapping("/update")
    public String updateBank(@RequestParam(value = "bankid") int bankid,
                             @RequestParam(value = "name") String name) {
        if (bankService.updateBank(bankid, name)) {
            return "Банк с id = " + bankid + " обновлён";
        } else {
            return "Банк с id = " + bankid + "не обновлён";
        }
    }

    @PostMapping("/add")
    public String addBank(@RequestParam(value = "name") String name) {
        if (bankService.insertBank(name)) {
            return "Банк добавлен";
        } else {
            return "Банк не добавлен";
        }
    }

    @GetMapping("/load")
    public void loadCsvFile(@RequestParam(defaultValue = "BankListFile.csv") String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] array = line.split("-,-");
                bankService.insertBank(array[0], array[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
