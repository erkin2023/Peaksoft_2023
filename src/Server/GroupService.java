package Server;

import model.Group;

import java.util.List;

public interface GroupService {
    void AddNewGroup(Group groups);
    void GetGroupByName(String nameGroup);
    void UpdateGroupName (String nameGroup);
    void GetAllGroups() ;
    void AddNewStudentToGroup(String nameGroup);
    void DeleteGroup (String nameGroup);
}
