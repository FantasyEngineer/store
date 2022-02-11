package com.cy.store.contrller;


import com.cy.store.contrller.ex.FileEmptyException;
import com.cy.store.contrller.ex.FileOutOfSizeException;
import com.cy.store.contrller.ex.FileTypeException;
import com.cy.store.contrller.ex.FileUploadException;
import com.cy.store.entity.JsonResult;
import com.cy.store.entity.User;
import com.cy.store.services.IUserService;
import org.apache.ibatis.javassist.bytecode.analysis.MultiType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author jimmy
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<User>().success(user);
    }

    @RequestMapping("login")
    public JsonResult<User> login(User user, HttpSession session) {
        User user1 = iUserService.login(user);
        //登录之后将部分数据存入到session中。
        session.setAttribute("uid", user1.getUid());
        session.setAttribute("username", user1.getUsername());

        return new JsonResult<User>().success(user1);
    }

    /**
     * 修改密码，根据uid进行修改
     *
     * @param oldPassword      老密码
     * @param newPassword      新密码
     * @param newPasswordAgain 再一次新密码
     * @return 是否成功
     */
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(HttpSession session, String oldPassword, String newPassword, String newPasswordAgain) {
        Integer uid = getUidFromSession(session);
        iUserService.changePassword(uid, oldPassword, newPassword, newPasswordAgain);
        return new JsonResult<Void>().success();
    }

    @RequestMapping("findUserByUid")
    public JsonResult<User> findUserByUid(HttpSession session) {
        User user = iUserService.findUserByUid(getUidFromSession(session));
        return new JsonResult<User>().success(user);
    }

    @RequestMapping("updateUserinfo")
    public JsonResult<Void> updateUserinfo(HttpSession session, User user) {
        Integer uid = getUidFromSession(session);
        user.setUid(uid);
        iUserService.updateUserInfo(user);
        return new JsonResult<Void>().success();
    }

    //设置上传文件的最大值
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /**
     * 设置上传文件的类型
     */
    public static final List<String> AVATAR_TYPE = Arrays.asList("image/jpeg", "image/jpg", "image/png", "image/bmp", "image/gif");


    /**
     * 保存头像
     *
     * @param session
     * @param file
     * @return
     */
    @RequestMapping("saveAvatar")
    public JsonResult<Void> saveAvatar(HttpSession session, @RequestParam("file") MultipartFile file) {
        //文件为空
        if (file.isEmpty()) {
            throw new FileEmptyException();
        }

        //文件超出大小
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileOutOfSizeException();
        }

        //文件后缀是否匹配
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException();
        }

        //保存的父目录
        String parent = session.getServletContext().getRealPath("upload");
        File fileDir = new File(parent);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //获取到文件后缀,（测试通过，获取成功）
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        //将文件名重新命名，防止重复,使用uuid
        String fileName = UUID.randomUUID().toString().toUpperCase() + suffix;

        File dest = new File(fileDir, fileName);

        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileUploadException("文件传输异常");
        }

        Integer uid = getUidFromSession(session);

        String avatar = "/upload/" + fileName;
        iUserService.saveAvatar(uid, avatar);
        //完整的地址是没有用的
        System.out.println(dest.getAbsolutePath());

        //浏览器查看路径下的图片http://localhost:8080/upload/5320997E-85CA-4FCE-9976-4B2D01DA1863.jpg
        return new JsonResult<String>().success(avatar);
    }

}
