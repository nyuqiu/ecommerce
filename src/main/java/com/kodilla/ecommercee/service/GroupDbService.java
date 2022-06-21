package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupDbService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroupById(final Long id) {
        return groupRepository.findById(id);
    }

    public void deleteById(final Long id) {
        groupRepository.deleteById(id);
    }

    public Group saveGroup(final Group group) {
        return groupRepository.save(group);
    }

    public Optional<Group> getGroupByName(final String groupName) {
        return groupRepository.findByGroupName(groupName);
    }
}