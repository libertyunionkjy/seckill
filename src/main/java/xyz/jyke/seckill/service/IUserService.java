package xyz.jyke.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.vo.LoginVo;
import xyz.jyke.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junyu
 * @since 2021-10-26
 */
public interface IUserService extends IService<User> {
    /**
     * 登录
     * @param loginVo * @return
     * @param request
     * @param response
     */
    RespBean login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据cookie获取用户
     *
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    User getByUserTicket(String userTicket,HttpServletRequest request,HttpServletResponse response);

}
