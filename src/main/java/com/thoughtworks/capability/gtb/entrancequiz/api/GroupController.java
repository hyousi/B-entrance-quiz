package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.repository.GroupRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:1234")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/api/groups")
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @PutMapping("/api/groups/{id}")
    public ResponseEntity updateGroup(@PathVariable String id, @RequestBody Group group) {
        Group target = groupRepository.findGroupById(Integer.parseInt(id));

        if (target != null) {
            if (groupRepository.findGroupByName(group.getName()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("名称冲突!");
            }

            target.setName(group.getName());
            return ResponseEntity.ok("修改成功!");
        } else {
            return ResponseEntity.badRequest().body("参数错误！");
        }
    }
}
