package com.dehbi.springsoap;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        UsersPort proxy =new UsersPortService().getUsersPortSoap11();
        GetUserRequest userRequest = new GetUserRequest();
        userRequest.code=2;
        GetUserResponse userResponse = proxy.getUser(userRequest);
        User u = userResponse.getUser();
        System.out.println(u.getName());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println("------------Roles-----------");
        GetRolesRequest RoleRequest = new GetRolesRequest();
        RoleRequest.code=1;
        GetRolesResponse RolesResponse = proxy.getRoles(RoleRequest);
        List<Role> list = RolesResponse.getRoles();
        for (Role r : list) System.out.println(r.getId()+" "+r.getName());
    }
}
