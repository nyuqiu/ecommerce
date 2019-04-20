package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.controller.exception.GroupNotFoundException;
import com.kodilla.ecommercee.domain.dto.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    @Autowired
    private GroupDbService service;

    @Autowired
    private GroupMapper groupMapper;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(service.getAllGroups());
    }

    @GetMapping(value = "getGroup")
    GroupDto getGroup(@RequestParam("groupId") Long groupId) throws GroupNotFoundException{
        return groupMapper.mapToGroupDto(service.getGroupById(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(service.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @PostMapping(value = "createGroup")
    public void createGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupMapper.mapToGroup(groupDto));
    }
}