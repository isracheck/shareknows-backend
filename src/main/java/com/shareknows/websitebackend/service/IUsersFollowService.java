package com.shareknows.websitebackend.service;

import java.util.List;
import com.shareknows.websitebackend.entity.UsersFollow;

public interface IUsersFollowService {

	public List<UsersFollow> findAll();

	public void save(UsersFollow userFollow);

}
