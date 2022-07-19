package com.example.springboot.Controller;

import com.example.springboot.Service.DemoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class DemoController {
    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    final static String TAG = "DemoController";
    @PostMapping(path = "/addData")
    public ResponseEntity<Object> addData(@RequestParam String id, @RequestParam String name) {
        JSONObject entity = new JSONObject();
        entity.put("id", id);
        entity.put("name", name);
        demoService.updateData(id, name);
        return ResponseEntity.ok(entity);
    }

    @GetMapping("/getData")
    public ResponseEntity<Object> getData(@RequestParam String id) {
        JSONObject entity = new JSONObject();
        entity.put("id", id);
        entity.put("name", demoService.getData(id));
        return ResponseEntity.ok(entity);
    }
}
