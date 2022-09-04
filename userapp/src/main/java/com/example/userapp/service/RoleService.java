package com.example.userapp.service;

import com.example.userapp.entity.Role;

public interface RoleService {
	//Create
		public Role addRole(Role role);
		//Retrieve
		public Role getRoleById(Long id);
		
		//Update
		public Role updateRole(Role role);
		
		//Delete
		public void deleteRoleById(Long id);


}
