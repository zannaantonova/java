package ee.bcs.java.controller;

import com.sun.source.tree.CaseTree;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController
public class EmployeeController {
    private List<ClietDyo> clients = new ArrayList();


    //20.01.21 > RequestBOdy >> saab mitu anda LIST + addAll
    //http://localhost:8080/client
    @PostMapping("client")
    public String createClient(@RequestBody List<ClietDyo> client) {
        //todo, lisa client listi uus klient
        clients.addAll(client);
        return "Klient on loodud";
    }

    /*//20.01.21 > RequestBOdy>>>üks korraga
    //http://localhost:8080/client
    @PostMapping("client")
    public String createClient(@RequestBody ClietDyo client) {
        //todo, lisa client listi uus klient
        clients.add(client);
        return "Klient on loodud";
    }
     */
    /*
    //20.01.21 > POST
    //http://localhost:8080/client?name=John&aadress=USA&age=99
    @PostMapping("client")
    public String createClient(@RequestParam("name") String name, @RequestParam("aadress") String aadress, @RequestParam("age") Integer age) {
        //todo, lisa client listi uus klient
        ClietDyo client = new ClietDyo();
        client.setName(name);
        client.setAadress(aadress);
        client.setAge(age);
        clients.add(client);
        return "Klient on loodud";
    }


     */
    /*
        //http://localhost:8080/client/createClient?name=John&aadress=USA&age=99
        @GetMapping("client/createClient")
    public String createClient(@RequestParam("name") String name, @RequestParam("aadress") String aadress, @RequestParam("age") Integer age) {
        //todo, lisa client listi uus klient
        ClietDyo client = new ClietDyo();
        client.setName(name);
        client.setAadress(aadress);
        client.setAge(age);
        clients.add(client);
        return "Klient on loodud";
    }
        */

    //20.10.2021 > GET
    // http://localhost:8080/client
    @GetMapping("client")
    //TODO tagasta klientide listi
    public List<ClietDyo> getAllClients() {
        return clients;
    }

    /*
    //http://localhost:8080/client/getAllClients
    @GetMapping("client/getAllClients")
    //TODO tagasta klientide listi
    public List<ClietDyo> getAllClients() {
        return clients;
    }
    */


    //20.10.2021 > GET
    // http://localhost:8080/client/1
    @GetMapping("client/{index}")
    public ClietDyo getClient(@PathVariable("index") Integer index) {
        //TODO tagasta üks klient
        return clients.get(index);

    }

    /*
    //http://localhost:8080/client/getClient/1
        @GetMapping("client/getClient/{index}")
    public ClietDyo getClient(@PathVariable("index") Integer index) {
        //TODO tagasta üks klient
        return clients.get(index);
    }
    */


    //20.10.2021 > Delete
    // http://localhost:8080/client/2
    @DeleteMapping("client/{index}")
    public String deleteClient(@PathVariable("index") int index) {
        //TODO eemalda clients listist indexiga i klient
        clients.remove(index);
        return "kustutatud";
    }

/*
    //http://localhost:8080/client/deleteClient/2
    @GetMapping("client/deleteClient/{index}")
    public String deleteClient(@PathVariable("index") Integer index) {
        //TODO eemalda clients listist indexiga i klient
        clients.remove(index);
        return "kustutatud";
    }

 */

    //Request body
    // http://localhost:8080/client/1?name=Kuku&aadress=USA&age=99
    @PutMapping ("client/{index}")
    public String updateClient(@PathVariable("index") Integer index, @RequestBody ClietDyo client) {
        //TODO kirjuta indeksiga i klient üle uute andmetega
        clients.set(index, client);
        return "uuendatud";

    }
    /*
    //20.10.2021 > PUT - kirjutab üle kõik andmed /PATCH - täiendab andmed
    // http://localhost:8080/client/1?name=Kuku&aadress=USA&age=99
    @PutMapping ("client/{index}")
    public String updateClient(@PathVariable("index") Integer index,@RequestParam("name") String name, @RequestParam("aadress") String aadress, @RequestParam("age") Integer age) {
        //TODO kirjuta indeksiga i klient üle uute andmetega
        ClietDyo client = clients.get(index);
        client.setAge(age);
        client.setName(name);
        client.setAadress(aadress);
        return "uuendatud";

    }
     */

    /*
    //http://localhost:8080/client/updateClient/1?name=Kuku&aadress=USA&age=99
    @GetMapping("client/updateClient/{index}")
    public String updateClient(@PathVariable("index") Integer index,@RequestParam("name") String name, @RequestParam("aadress") String aadress, @RequestParam("age") Integer age) {
        //TODO kirjuta indeksiga i klient üle uute andmetega

        //ClietDyo client = new ClietDyo();
        //client.setName(name);
        //client.setAadress(aadress);
        //client.setAge(age);
        //clients.set(index, client);

        ClietDyo client = clients.get(index);
        client.setAge(age);
        client.setName(name);
        client.setAadress(aadress);
        return "uuendatud";

    }

     */
}

