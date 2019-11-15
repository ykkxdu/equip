package com.bdi.lab.equip;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@RepositoryRestController
@RequestMapping("/equip")
public class EquipController {


    @GetMapping("/getTasks")
    public ResponseEntity getTasks(){
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity result=restTemplate.getForEntity("http://localhost:31380/task/getTasks",String.class,String.class);
        //ResponseEntity result=restTemplate.getForEntity("http://localhost:8000/task/getTasks",String.class,String.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getEquips")
    public ResponseEntity getEquips(){
        return ResponseEntity.ok(Utils.getJSON("mysql-army.json"));
    }

    @GetMapping("/getVersion")
    public ResponseEntity getVersion(){
        return ResponseEntity.ok("v2");
    }

}
