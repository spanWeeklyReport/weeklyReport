package com.evry.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.evry.dashboard.dao.UserInfoDAO;
import com.evry.dashboard.dto.UserInfoView;
import com.evry.dashboard.dto.mapper.UserInfoMapper;
import com.evry.dashboard.model.UserInfo;
import com.evry.dashboard.util.HttpSessionFactory;

import javax.servlet.http.HttpSession;

@ManagedBean(name = "userInfoService")
@SessionScoped
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoMapper mapper;
    private UserInfoDAO userInfoDAO;
    private boolean renderer;
    private boolean logout;

    public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    public void setMapper(UserInfoMapper mapper) {
        this.mapper = mapper;
    }

    public void addUser(UserInfoView userInfoView) {
        UserInfo obj = mapper.getMappedEntity(userInfoView);
        // userInfoDAO.add(obj);
    }

    public List < UserInfoView > getUsers() {
        List < UserInfo > userInfos = (List < UserInfo > ) userInfoDAO.getUsers();
        List < UserInfoView > userInfoViews = new ArrayList();
        for (UserInfo userInfo: userInfos)
            userInfoViews.add(mapper.getMappedView(userInfo));
        return userInfoViews;
    }

    public String isValid(UserInfoView userInfoView) {
        boolean result = userInfoDAO.isValid(mapper
            .getMappedEntity(userInfoView));

        if (result) {
            // get Http Session and store username
            HttpSession session = HttpSessionFactory.getSession();
            session.setAttribute("username", userInfoView.getUserName());
           // session.setAttribute(userId, userInfoView.ge);
            return "dashboard.xhtml";
        } else {

            FacesContext.getCurrentInstance().addMessage(
                "loginForm:submit",
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Invalid Login!", "Please Try Again!"));

            return "index.xhtml";
        }

    }

    public String logout() {
        renderer = false;
        logout = true;
        String abc = HttpSessionFactory.getUserName();
        System.out.println(abc);
        HttpSessionFactory.getSession().invalidate();
        System.out.println("successfully logout");;
        return "index.xhtml";
        
    }
}