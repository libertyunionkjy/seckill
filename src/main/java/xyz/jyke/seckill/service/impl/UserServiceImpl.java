package xyz.jyke.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.jyke.seckill.exception.GlobalException;
import xyz.jyke.seckill.mapper.UserMapper;
import xyz.jyke.seckill.pojo.User;
import xyz.jyke.seckill.service.IUserService;
import xyz.jyke.seckill.utils.CookieUtil;
import xyz.jyke.seckill.utils.MD5Util;
import xyz.jyke.seckill.utils.UUIDUtil;
import xyz.jyke.seckill.vo.LoginVo;
import xyz.jyke.seckill.vo.RespBean;
import xyz.jyke.seckill.vo.RespBeanEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author junyu
 * @since 2021-10-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登陆逻辑实现
     *
     * @param loginVo  * @return
     * @param request
     * @param response
     * @return
     */
    @Override
    public RespBean login(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
       /* //判断是否为空
        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
        }
        //校验手机号
        if (!ValidatorUtil.isMobile(mobile)){
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }*/

        //根据手机号获取用户
        User user = userMapper.selectById(mobile);
        if (null == user) {
            //return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }


        //校验密码
        String s = MD5Util.formPassToDBPass(password, user.getSlat());//用户输入的密码
        if (!s.equals(user.getPassword())) {
            //return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
        }
        //生成cookie
        String ticket = UUIDUtil.uuid();

        //key是cookie的值，value是用户对象，在这一步我们在服务端保存了用户信息，使用session
        //request.getSession().setAttribute(ticket, user);

        //使用redis来保存用户信息
        redisTemplate.opsForValue().set("user:" + ticket, user);

        //reponse中加上了cookie，这一步我们在客户端保存了cookie
        CookieUtil.setCookie(request, response, "userTicket", ticket);
        return RespBean.success(ticket);
    }

    /**
     * 根据cookie获取用户
     *
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    @Override
    public User getByUserTicket(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        User user = (User) redisTemplate.opsForValue().get("user:" + userTicket);
        //更新cookie，为了安全考虑
        if (user != null) {
            CookieUtil.setCookie(request, response, "userTicket", userTicket);
        }
        return user;
    }
}
